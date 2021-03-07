package com.bynder.sdk.repository.Impl;

import com.bynder.sdk.entities.PhotosEntity;
import com.bynder.sdk.exception.DataDuplicationException;
import com.bynder.sdk.repository.PhotosRepository;
import org.springframework.stereotype.Repository;
import java.util.*;
import java.util.concurrent.locks.StampedLock;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * * ===== Database information ==============
 * <p>
 * This AccountDaoImpl class is used to provide account details and IO operation
 * against data. For the simplicity of task as it mentioned in requirement II i
 * am not using any database instead of that i am using map, in future we can
 * replace that structure with actual database
 * </p>
 * ========= Thread safety information =======
 * <p>
 * To make it thread-safe we will use synchronization as we are using Map, and
 * that will be updated, with requests. we have to make our data synchronize for
 * the sake of multiple requests (threads) safety, in the case of database we
 * have isolation to prevent our database
 * </p>
 * <p>
 * Synchronization can be acquired on method level (Coarse grain locking
 * mechanism) but this will make our method slow as no thread else can enter to
 * other methods (in database term we can say highest level of isolation) we
 * will use fine grain locking mechanism separately for read mechanism and
 * writing mechanism
 * </p>
 * <p>
 * I am using java 1.8 StampedLock @see {@link StampedLock} <br>
 * <strong> Reason of using StampedLock is one of its feature optimistic locking
 * in this lock as per documentation said, we do not need to apply full-fledged
 * read lock every time, some time lock is not held by any write operation, we
 * use tryOptimisticRead to check if the lock is hold by write operation and
 * then check result with validate method. </strong> <br>
 * Java 1.8 StampedLock is much more efficient and fast as compared to
 * ReentrantLock specially optimistic locking which make synchronization
 * overhead very slow. You can also use ReentrantLock but it very slow as
 * compared to new java 1.8 stamped lock
 * </p>
 *
 * @author AQIB JAVED
 * @version 1.0
 * @since 07/03/2021
 */
@Repository
public class InMemoryPhotosRepository implements PhotosRepository {
    private final StampedLock stampedLock = new StampedLock();
    private final Map<String, PhotosEntity> data = new HashMap<>();

    @Override
    public List<PhotosEntity> getAll() {
        // return zero if it acquire by a write lock (exclusive locked)
        long stamp = stampedLock.tryOptimisticRead();
        // Synchronization overhead is very low if validate() succeeds
        // Always return true if stamp is non zero (as not acquired by write lock)
        if (stampedLock.validate(stamp))
            return getPhotosAsList();
        stamp = stampedLock.readLock();
        try {
            return getPhotosAsList();
        } finally {
            stampedLock.unlockRead(stamp);
        }
    }

    private List<PhotosEntity> getPhotosAsList() {
        return new ArrayList<>(data.values());
    }

    @Override
    public void addAll(List<PhotosEntity> photos) {
        // Acquire a write lock
        long stamp = stampedLock.writeLock();
        try {
            data.putAll(photos.stream().collect(Collectors.toMap(
                    PhotosEntity::getId, Function.identity()
            )));
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    @Override
    public void add(PhotosEntity photo) {
        // Acquire a write lock
        long stamp = stampedLock.writeLock();
        if(data.containsKey(photo.getId())) {
            throw new DataDuplicationException("Photo already exists against id [" + photo.getId() + "]");
        }
        try {
            data.put(photo.getId(), photo);
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }

    @Override
    public void deleteAll() {
        // Acquire a write lock
        long stamp = stampedLock.writeLock();
        try {
            data.clear();
        } finally {
            stampedLock.unlockWrite(stamp);
        }
    }
}
