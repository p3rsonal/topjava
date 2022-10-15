package ru.javawebinar.topjava.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Objects;

public class UserMeal {

    private Integer id;

    private LocalDateTime dateTime;

    private String description;

    private Integer calories;

    public UserMeal(Integer id, LocalDateTime dateTime, String description, int calories) {
        this.id = id;
        this.dateTime = dateTime;
        this.description = description;
        this.calories = calories;
    }

    public UserMeal(LocalDateTime dateTime, String description, int calories) {
        this(null, dateTime, description, calories);
    }

    public Integer getId() {
        return id;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getDescription() {
        return description;
    }

    public int getCalories() {
        return calories;
    }

    public LocalDate getDate() {
        return dateTime.toLocalDate();
    }

    public LocalTime getTime() {
        return dateTime.toLocalTime();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCalories(Integer calories) {
        this.calories = calories;
    }

    public boolean isNew() {
        return id == null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof UserMeal)) {
            return false;
        }
        UserMeal userMeal = (UserMeal) o;
        return Objects.equals(getId(), userMeal.getId()) && Objects.equals(getDateTime(), userMeal.getDateTime()) && Objects.equals(
            getDescription(), userMeal.getDescription()) && Objects.equals(getCalories(), userMeal.getCalories());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getDateTime(), getDescription(), getCalories());
    }

    @Override
    public String toString() {
        return "Meal{" +
            "id=" + id +
            ", dateTime=" + dateTime +
            ", description='" + description + '\'' +
            ", calories=" + calories +
            '}';
    }
}
