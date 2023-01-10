package org.fpm.di.example.Class;

import javax.inject.Singleton;
import javax.inject.Inject;
@Singleton
public class HDD {
    private final SomeFiles files;
    @Inject
    public HDD(SomeFiles files){
        this.files = files;
    }
    public SomeFiles getSomeFiles(){return files;}
}
