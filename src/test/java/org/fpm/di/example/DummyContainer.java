package org.fpm.di.example;

import org.fpm.di.Container;

import javax.inject.Inject;
import javax.inject.Singleton;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class DummyContainer implements Container {
    private final DummyBinder binder;
    public DummyContainer(DummyBinder binder){
        this.binder=binder;
    }

    @Override
    public <T> T getComponent(Class<T> clazz) {
        if (binder.Implement.containsKey(clazz)) {
            T component = getComponent((Class<T>) binder.Implement.get(clazz));
            return component;
        }
        if (binder.Instance.containsKey(clazz)) {
            T component = (T) binder.Instance.get(clazz);
            return component;
        }
        try{
            T a=null;
            for(Constructor<?> i: clazz.getConstructors()){
                if(i.isAnnotationPresent(Inject.class)){
                    Object[] num =new Object[i.getParameterCount()];
                    for(int j=0;j<i.getParameterCount();j++){
                        num[j]=getComponent(i.getParameters()[j].getType());
                    }
                    a= (T) i.newInstance(num);
                }
            }
            if (a==null) a = clazz.newInstance();
            if (clazz.isAnnotationPresent(Singleton.class)) binder.bind(clazz, a);
            return a;
        }catch (IllegalAccessException| InvocationTargetException|InstantiationException e){
            throw new RuntimeException();
        }
    }
}
