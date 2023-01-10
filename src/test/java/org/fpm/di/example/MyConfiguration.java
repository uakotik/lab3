package org.fpm.di.example;

import org.fpm.di.Binder;
import org.fpm.di.Configuration;
import org.fpm.di.example.Class.*;
import org.fpm.di.example.Class.System;

public class MyConfiguration implements Configuration {
    @Override
    public void configure(Binder binder) {
        binder.bind(MySingleton.class);
        binder.bind(MyPrototype.class);

        binder.bind(UseA.class);

        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());

        binder.bind(Computer.class);
        binder.bind(Periphery.class,HeadSet.class);
        binder.bind(HeadSet.class, Microphone.class);
    }
}
