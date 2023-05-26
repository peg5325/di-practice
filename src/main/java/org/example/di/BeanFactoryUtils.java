package org.example.di;

import org.example.annotation.Inject;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Constructor;
import java.util.Set;

public class BeanFactoryUtils {
    public static Constructor<?> getInjectedConstructor(Class<?> clazz) {
        Set<Constructor> injectConstructors = ReflectionUtils.getAllConstructors(clazz, ReflectionUtils.withAnnotation(Inject.class));// Inject Annotation이 붙은 생성자만 가지고옴.
        if (injectConstructors.isEmpty()) {
            return null;
        }
        return injectConstructors.iterator().next();
    }
}
