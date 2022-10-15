package ru.javawebinar.topjava.util;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.model.UserMealWithExcess;

public class MealsUtil {

    private static final Integer CALORIES_LIMIT = 2000;

    public static List<UserMealWithExcess> getMealsWithExcessFiltered(List<UserMeal> userMeals, LocalTime startTime, LocalTime endTime) {
        Map<LocalDate, Integer> caloriesSumByDate = userMeals.stream()
                .collect(Collectors.groupingBy(UserMeal::getDate, Collectors.summingInt(UserMeal::getCalories)));

        return userMeals.stream()
                .filter(meal -> TimeUtil.isBetweenHalfOpen(meal.getTime(), startTime, endTime))
                .map(meal -> createUserMealWithExcess(meal, caloriesSumByDate.get(meal.getDate()) > CALORIES_LIMIT))
                .collect(Collectors.toList());
    }

    public static List<UserMealWithExcess> getMealsWithExcess(Collection<UserMeal> userMeals) {
        Map<LocalDate, Integer> caloriesSumByDate = userMeals.stream()
                .collect(Collectors.groupingBy(UserMeal::getDate, Collectors.summingInt(UserMeal::getCalories)));

        return userMeals.stream()
                .map(meal -> createUserMealWithExcess(meal, caloriesSumByDate.get(meal.getDate()) > CALORIES_LIMIT))
                .collect(Collectors.toList());
    }

    private static UserMealWithExcess createUserMealWithExcess(UserMeal userMeal, boolean excess) {
        return new UserMealWithExcess(userMeal.getId(), userMeal.getDateTime(), userMeal.getDescription(), userMeal.getCalories(), excess);
    }
}
