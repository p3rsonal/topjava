package ru.javawebinar.topjava.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertThrows;
import static ru.javawebinar.topjava.utils.CommonTestData.ADMIN_ID;
import static ru.javawebinar.topjava.utils.CommonTestData.ADMIN_LUNCH_ID;
import static ru.javawebinar.topjava.utils.CommonTestData.USER_BREAKFAST_ID;
import static ru.javawebinar.topjava.utils.CommonTestData.USER_ID;
import static ru.javawebinar.topjava.utils.MealTestData.getNew;
import static ru.javawebinar.topjava.utils.MealTestData.getUpdated;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.bridge.SLF4JBridgeHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlConfig;
import org.springframework.test.context.junit4.SpringRunner;
import ru.javawebinar.topjava.model.Meal;
import ru.javawebinar.topjava.util.exception.NotFoundException;
import ru.javawebinar.topjava.utils.MealTestData;

@ContextConfiguration({"classpath:spring/spring-app.xml"})
@RunWith(SpringRunner.class)
@Sql(scripts = "classpath:db/populateDB.sql", config = @SqlConfig(encoding = "UTF-8"))
public class MealServiceTest {

    static {
        // Only for postgres driver logging
        // It uses java.util.logging and logged via jul-to-slf4j bridge
        SLF4JBridgeHandler.install();
    }

    @Autowired
    private MealService service;

    @Test
    public void get() {
        Meal meal = service.get(USER_BREAKFAST_ID, USER_ID);
        assertThat(meal).usingRecursiveComparison().isEqualTo(MealTestData.userBreakfast);
    }

    @Test
    public void delete() {
        service.delete(USER_BREAKFAST_ID, USER_ID);
        assertThrows(NotFoundException.class, () -> service.get(USER_BREAKFAST_ID, USER_ID));
    }

    @Test
    public void getBetweenInclusive() {
        List<Meal> meals = service.getBetweenInclusive(LocalDate.of(2022, 10, 24), LocalDate.of(2022, 10, 24), ADMIN_ID);
        assertThat(meals).usingRecursiveComparison().isEqualTo(Collections.singletonList(MealTestData.adminDinner));
    }

    @Test
    public void getAll() {
        List<Meal> all = service.getAll(USER_ID);
        assertThat(all).usingRecursiveComparison().isEqualTo(Collections.singletonList(MealTestData.userBreakfast));
    }

    @Test
    public void update() {
        Meal updated = getUpdated();
        service.update(updated, USER_ID);
        assertThat(service.get(USER_BREAKFAST_ID, USER_ID)).usingRecursiveComparison().isEqualTo(getUpdated());
    }

    @Test
    public void create() {
        Meal created = service.create(getNew(), USER_ID);
        Integer newId = created.getId();
        Meal newMeal = getNew();
        newMeal.setId(newId);
        assertThat(created).usingRecursiveComparison().isEqualTo(newMeal);
        assertThat(service.get(newId, USER_ID)).usingRecursiveComparison().isEqualTo(newMeal);
    }

    @Test
    public void getNotFound() {
        assertThrows(NotFoundException.class, () -> service.get(ADMIN_LUNCH_ID, USER_ID));
    }

    @Test
    public void deletedNotFound() {
        assertThrows(NotFoundException.class, () -> service.delete(ADMIN_LUNCH_ID, USER_ID));
    }

    @Test
    public void updateNotFound() {
        assertThrows(NotFoundException.class, () -> service.update(MealTestData.adminDinner, USER_ID));
    }

    @Test
    public void duplicateDateTimeCreate() {
        Meal meal = new Meal(MealTestData.userBreakfast);
        meal.setId(null);
        assertThrows(DataAccessException.class, () ->
            service.create(meal, USER_ID));
    }
}