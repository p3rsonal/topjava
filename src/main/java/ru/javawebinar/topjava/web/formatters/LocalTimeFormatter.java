package ru.javawebinar.topjava.web.formatters;

import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTime;
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalTimeToString;

import java.text.ParseException;
import java.time.LocalTime;
import java.util.Locale;
import org.springframework.format.Formatter;

public class LocalTimeFormatter implements Formatter<LocalTime> {

    @Override
    public LocalTime parse(String text, Locale locale) throws ParseException {
        return parseLocalTime(text);
    }

    @Override
    public String print(LocalTime object, Locale locale) {
        return parseLocalTimeToString(object);
    }
}
