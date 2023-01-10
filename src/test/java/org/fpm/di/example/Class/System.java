package org.fpm.di.example.Class;

import javax.inject.Singleton;
import javax.inject.Inject;

@Singleton
public class System {
    private final SomeFiles files;
    @Inject
    public System(SomeFiles files){
        this.files=files;
    }
    public SomeFiles getFiles(){return files;}
}
