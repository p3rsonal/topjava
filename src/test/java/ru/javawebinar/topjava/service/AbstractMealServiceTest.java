package ru.javawebinar.topjava.service;

import static ru.javawebinar.topjava.MealTestData.MEAL1_ID;
import static ru.javawebinar.topjava.UserTestData.USER_ID;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractMealServiceTest extends AbstractServiceTest {

    @Autowired
    private MealService service;

    @Test
    public void delete() {
        service.delete(MEAL1_ID, USER_ID);
    }
}
