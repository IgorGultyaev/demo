package com.example.demo;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import org.springframework.util.ReflectionUtils;

import java.lang.reflect.Array;
import java.util.Arrays;

@Component
public class InjectSomeBeanPostProcessor implements BeanPostProcessor {
    public InjectSomeBeanPostProcessor() {
    }


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Arrays.stream(bean.getClass().getDeclaredFields())
                .filter(f -> f.getAnnotation(InjectSome.class) != null)
                .forEach(field -> {
                    field.setAccessible(true);
                    ReflectionUtils.setField(field, bean, field.getAnnotation(InjectSome.class).value());
                });

        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }
}
