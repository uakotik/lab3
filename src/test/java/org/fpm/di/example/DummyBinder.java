package org.fpm.di.example;

import org.fpm.di.Binder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DummyBinder implements Binder {
    List<Class<?>> list=new ArrayList<>();
    HashMap<Class<?>,Object> Implement = new HashMap<>();
    HashMap<Class<?>,Object> Instance = new HashMap<>();

    @Override
    public <T> void bind(Class<T> clazz) {
        list.add(clazz);
    }

    @Override
    public <T> void bind(Class<T> clazz, Class<? extends T> implementation) {
        Implement.put(clazz,implementation);
    }

    @Override
    public <T> void bind(Class<T> clazz, T instance) {
        Instance.put(clazz,instance);
    }
}
