package org.fpm.di.example.Class;

import javax.inject.Singleton;
import javax.inject.Inject;

@Singleton
public class Motherboard {
    private final CPU cpu;
    private final GPU gpu;
    private final RAM ram;
    @Inject
    public Motherboard(CPU cpu,GPU gpu,RAM ram){
        this.cpu=cpu;
        this.gpu=gpu;
        this.ram=ram;
    }
    public CPU getCpu(){return cpu;}
    public GPU getGpu(){return gpu;}
    public RAM getRam(){return ram;}
}
