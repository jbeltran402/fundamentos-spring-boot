package com.fundamentos.springboot.fundamentos.bean;

public class MyBean2Implement implements MyBean{
    @Override
    public void print() {
        System.out.println("Creacion de mi propia dependencia(Bean) 2");
    }
}
