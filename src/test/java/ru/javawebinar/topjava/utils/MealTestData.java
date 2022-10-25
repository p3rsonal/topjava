package ru.javawebinar.topjava.utils;

import static org.assertj.core.api.Assertions.assertThat;
import static ru.javawebinar.topjava.utils.CommonTestData.ADMIN_DINNER_ID;
import static ru.javawebinar.topjava.utils.CommonTestData.ADMIN_LUNCH_ID;
import static ru.javawebinar.topjava.utils.CommonTestData.USER_BREAKFAST_ID;

import java.time.LocalDateTime;
import ru.javawebinar.topjava.model.Meal;

public class MealTestData {

    public static final Meal userBreakfast = new Meal(USER_BREAKFAST_ID, LocalDateTime.of(2022, 10, 23, 8, 0), "Завтрак", 500);
    public static final Meal adminLunch = new Meal(ADMIN_LUNCH_ID, LocalDateTime.of(2022, 10, 23, 14, 0), "Обед", 1000);
    public static final Meal adminDinner = new Meal(ADMIN_DINNER_ID, LocalDateTime.of(2022, 10, 24, 20, 0), "Ужин", 790);

    public static Meal getNew() {
        return new Meal(null, LocalDateTime.of(2022, 10, 23, 22, 0), "meal", 750);
    }

    public static Meal getUpdated() {
        Meal updated = new Meal(userBreakfast);
        updated.setDateTime(LocalDateTime.of(2022, 10, 24, 15, 0));
        updated.setDescription("new description");
        updated.setCalories(900);
        return updated;
    }
}
