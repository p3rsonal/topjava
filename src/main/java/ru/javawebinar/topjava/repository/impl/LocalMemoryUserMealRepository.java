package ru.javawebinar.topjava.repository.impl;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.Collection;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import ru.javawebinar.topjava.model.UserMeal;
import ru.javawebinar.topjava.repository.UserMealRepository;

public class LocalMemoryUserMealRepository implements UserMealRepository {

    private final Map<Integer, UserMeal>  repository = new ConcurrentHashMap<>();
    private final AtomicInteger counter = new AtomicInteger();

    {
        save(new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 10, 0), "Breakfast", 500));
        save(new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 13, 0), "Lunch", 1000));
        save(new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 30, 20, 0), "Dinner", 500));
        save(new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 0, 0), "Snack", 100));
        save(new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 10, 0), "Breakfast", 1000));
        save(new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 13, 0), "Lunch", 500));
        save(new UserMeal(LocalDateTime.of(2020, Month.JANUARY, 31, 20, 0), "Dinner", 410));
    }

    @Override
    public UserMeal save(UserMeal userMeal) {
        if (userMeal.isNew()) {
            userMeal.setId(counter.incrementAndGet());
        }
        return repository.put(userMeal.getId(), userMeal);
    }

    @Override
    public void delete(int id) {
        repository.remove(id);
    }

    @Override
    public UserMeal get(int id) {
        return repository.get(id);
    }

    @Override
    public Collection<UserMeal> getAll() {
        return repository.values();
    }
}
