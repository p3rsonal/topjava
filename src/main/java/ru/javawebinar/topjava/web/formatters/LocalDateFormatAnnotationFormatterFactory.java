package ru.javawebinar.topjava.web.formatters;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class LocalDateFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<LocalDateFormat> {

    @Override
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<>(List.of(LocalDate.class));
    }

    @Override
    public Printer<?> getPrinter(LocalDateFormat annotation, Class<?> fieldType) {
        return getLocalDateFormatter(annotation, fieldType);
    }

    @Override
    public Parser<?> getParser(LocalDateFormat annotation, Class<?> fieldType) {
        return getLocalDateFormatter(annotation, fieldType);
    }

    private LocalDateFormatter getLocalDateFormatter(LocalDateFormat annotation, Class<?> fieldType) {
        LocalDateFormatter formatter = new LocalDateFormatter();
        return formatter;
    }
}
