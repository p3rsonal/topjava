package ru.javawebinar.topjava.utils;

import static ru.javawebinar.topjava.model.AbstractBaseEntity.START_SEQ;

public class CommonTestData {

    public static final int USER_ID = START_SEQ;
    public static final int ADMIN_ID = START_SEQ + 1;
    public static final int GUEST_ID = START_SEQ + 2;

    public static final int USER_BREAKFAST_ID = START_SEQ + 3;
    public static final int ADMIN_LUNCH_ID = START_SEQ + 4;
    public static final int ADMIN_DINNER_ID = START_SEQ + 5;
    public static final int NOT_FOUND = 10;

}
