package ru.javawebinar.topjava.repository;

import java.util.Collection;
import ru.javawebinar.topjava.model.UserMeal;

public interface UserMealRepository {

    UserMeal save(UserMeal userMeal);

    void delete(int id);

    UserMeal get(int id);

    Collection<UserMeal> getAll();

}
