package ru.javawebinar.topjava.service;

import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractUserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService service;
}
