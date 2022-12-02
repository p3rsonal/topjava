package ru.javawebinar.topjava.web.formatters;

import java.time.LocalTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

public class LocalTimeFormatAnnotationFormatterFactory implements AnnotationFormatterFactory<LocalTimeFormat> {

    @Override
    public Set<Class<?>> getFieldTypes() {
        return new HashSet<>(List.of(LocalTime.class));
    }

    @Override
    public Printer<?> getPrinter(LocalTimeFormat annotation, Class<?> fieldType) {
        return getLocalTimeFormatter(annotation, fieldType);
    }

    @Override
    public Parser<?> getParser(LocalTimeFormat annotation, Class<?> fieldType) {
        return getLocalTimeFormatter(annotation, fieldType);
    }

    private LocalTimeFormatter getLocalTimeFormatter(LocalTimeFormat annotation, Class<?> fieldType) {
        LocalTimeFormatter formatter = new LocalTimeFormatter();
        return formatter;
    }
}
