package com.unsplash.sdk.unit.dto.response;

import com.openpojo.reflection.PojoClass;
import com.openpojo.reflection.impl.PojoClassFactory;
import com.openpojo.validation.Validator;
import com.openpojo.validation.ValidatorBuilder;
import com.openpojo.validation.rule.impl.GetterMustExistRule;
import com.openpojo.validation.rule.impl.SetterMustExistRule;
import com.openpojo.validation.test.impl.GetterTester;
import com.openpojo.validation.test.impl.SetterTester;
import com.unsplash.sdk.dto.response.CollectionResponse;
import org.junit.jupiter.api.Test;

public class CollectionResponseUnitTest {
    @Test
    public void collectionResponseTest() {
        PojoClass pojoClass = PojoClassFactory.getPojoClass(CollectionResponse.class);
        Validator validator = ValidatorBuilder.create()
                .with(new SetterMustExistRule())
                .with(new GetterMustExistRule())
                .with(new GetterTester())
                .with(new SetterTester())
                .build();
        validator.validate(pojoClass);
    }
}
