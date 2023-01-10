package org.fpm.di.example;

import org.fpm.di.Container;
import org.fpm.di.Environment;
import org.fpm.di.example.Class.*;
import org.fpm.di.example.Class.System;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertSame;

public class Example {

    private Container container;

    @Before
    public void setUp() {
        Environment env = new DummyEnvironment();
        container = env.configure(new MyConfiguration());
    }

    @Test
    public void shouldInjectSingleton() {
        assertSame(container.getComponent(MySingleton.class), container.getComponent(MySingleton.class));
    }

    @Test
    public void shouldInjectPrototype() {
        assertNotSame(container.getComponent(MyPrototype.class), container.getComponent(MyPrototype.class));
    }

    @Test
    public void shouldBuildInjectionGraph() {
        /*
        binder.bind(A.class, B.class);
        binder.bind(B.class, new B());
        */
        final B bAsSingleton = container.getComponent(B.class);
        assertSame(container.getComponent(A.class), bAsSingleton);
        assertSame(container.getComponent(B.class), bAsSingleton);
    }

    @Test
    public void shouldBuildInjectDependencies() {
        final UseA hasADependency = container.getComponent(UseA.class);
        assertSame(hasADependency.getDependency(), container.getComponent(B.class));
    }
    @Test
    public void test1() {
        final Computer computer=container.getComponent(Computer.class);
        final Periphery periphery=container.getComponent(Periphery.class);
        final CPU cpu=container.getComponent(CPU.class);
        final SSD ssd=container.getComponent(SSD.class);
        assertSame(computer,container.getComponent(Computer.class));
        assertSame(periphery,container.getComponent(Periphery.class));
        assertSame(ssd,container.getComponent(SSD.class));
        assertSame(container.getComponent(Motherboard.class),container.getComponent(Motherboard.class));
        assertSame(cpu,container.getComponent(CPU.class));
    }
    @Test
    public void test2(){
        final Computer computer=container.getComponent(Computer.class);
        final CPU cpu=container.getComponent(CPU.class);
        assertSame(computer.getSsd(),container.getComponent(SSD.class));
        assertSame(computer.getHdd(),container.getComponent(HDD.class));
        assertSame(computer.getPowerBlock(),container.getComponent(PowerBlock.class));
        assertSame(computer.getMotherboard().getCpu(),cpu);
        assertSame(computer.getMotherboard().getRam(),container.getComponent(RAM.class));
        assertSame(computer.getMotherboard().getGpu(),container.getComponent(GPU.class));
        assertSame(computer.getSsd().getSystem(),container.getComponent(System.class));
    }
    @Test
    public void test3(){
        final Periphery periphery=container.getComponent(Periphery.class);
        final HeadSet headSet=container.getComponent(HeadSet.class);
        final Microphone microphone=container.getComponent(Microphone.class);
        assertSame(headSet,container.getComponent(Periphery.class));
        assertSame(microphone,container.getComponent(HeadSet.class));
        assertSame(periphery,container.getComponent(Microphone.class));
    }
    @Test
    public void test4(){
        final Computer computer=container.getComponent(Computer.class);
        final Periphery periphery=container.getComponent(Periphery.class);
        final HeadSet headSet=container.getComponent(HeadSet.class);
        final Cooler cooler=container.getComponent(Cooler.class);
        final SomeFiles files=container.getComponent(SomeFiles.class);
        assertNotSame(cooler,container.getComponent(Cooler.class));
        assertNotSame(computer.getMotherboard().getCpu().getCooler(),container.getComponent(Cooler.class));
        assertNotSame(computer.getMotherboard().getCpu().getCooler(),computer.getMotherboard().getGpu().getCooler());
        assertNotSame(container.getComponent(SomeFiles.class),files);
        assertNotSame(computer.getSsd().getSystem().getFiles(),container.getComponent(SomeFiles.class));
        assertNotSame(computer.getHdd().getSomeFiles(),container.getComponent(SomeFiles.class));
        assertNotSame(computer.getSsd().getSystem().getFiles(),computer.getHdd().getSomeFiles());



    }
}
