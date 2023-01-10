package org.fpm.di.example.Class;

import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
public class SSD {
    private final System system;

    @Inject
    public SSD(System system){
        this.system  = system;
    }
    public System getSystem(){return system;}

}
