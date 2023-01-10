package org.fpm.di.example.Class;

import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class GPU {
    private final Cooler cooler;
    @Inject
    public GPU(Cooler cooler){
        this.cooler=cooler;
    }
    public Cooler getCooler(){return cooler;}
}
