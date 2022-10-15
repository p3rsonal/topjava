package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class UserMealWithExcess {

    private Integer id;

    private final LocalDateTime dateTime;

    private final String description;

    private final int calories;

    private final boolean excess;

    public UserMealWithExcess(Integer id, LocalDateTime dateTime, String description, int calories, boolean excess) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
        this.excess = excess;
    }

    public UserMealWithExcess(LocalDateTime dateTime, String description, int calories, boolean excess) {
        this(null, dateTime, description, calories, excess);
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public boolean isExcess() {
        return excess;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserMealWithExcess)) {
            return false;
        }
        UserMealWithExcess that = (UserMealWithExcess) o;
        return getCalories() == that.getCalories() && isExcess() == that.isExcess() && Objects.equals(getId(), that.getId())
            && Objects.equals(getDateTime(), that.getDateTime()) && Objects.equals(getDescription(), that.getDescription());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateTime(), getDescription(), getCalories(), isExcess());
    }

    @Override
    public String toString() {
        return "MealWithExcess{" +
            "id=" + id +
            ", dateTime=" + dateTime +
            ", description='" + description + '\'' +
            ", calories=" + calories +
            ", excess=" + excess +
            '}';
    }
}
