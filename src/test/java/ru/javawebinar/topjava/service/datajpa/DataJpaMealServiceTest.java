package ru.javawebinar.topjava.service.datajpa;

import static ru.javawebinar.topjava.Profiles.DATAJPA;

import org.springframework.test.context.ActiveProfiles;
import ru.javawebinar.topjava.service.AbstractMealServiceTest;

@ActiveProfiles(DATAJPA)
public class DataJpaMealServiceTest extends AbstractMealServiceTest {
}
