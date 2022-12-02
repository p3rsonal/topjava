package ru.javawebinar.topjava.web.formatters;

import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDate;
import static ru.javawebinar.topjava.util.DateTimeUtil.parseLocalDateToString;

import java.text.ParseException;
import java.time.LocalDate;
import java.util.Locale;
import org.springframework.format.Formatter;

public class LocalDateFormatter implements Formatter<LocalDate> {

    @Override
    public LocalDate parse(String text, Locale locale) throws ParseException {
        return parseLocalDate(text);
    }

    @Override
    public String print(LocalDate object, Locale locale) {
        return parseLocalDateToString(object);
    }
}
