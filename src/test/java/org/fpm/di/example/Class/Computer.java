package org.fpm.di.example.Class;

import javax.inject.Inject;
import javax.inject.Singleton;
@Singleton
public class Computer {
    private final Motherboard motherboard;
    private final HDD hdd;
    private final SSD ssd;
    private final PowerBlock powerBlock;
    @Inject
    public Computer(Motherboard motherboard,HDD hdd,SSD ssd,PowerBlock powerBlock){
        this.motherboard= motherboard;
        this.hdd= hdd;
        this.ssd= ssd;
        this.powerBlock=powerBlock;
    }
    public Motherboard getMotherboard(){return motherboard;}
    public HDD getHdd(){return hdd;}
    public SSD getSsd(){return ssd;}
    public PowerBlock getPowerBlock(){return powerBlock;}
}
