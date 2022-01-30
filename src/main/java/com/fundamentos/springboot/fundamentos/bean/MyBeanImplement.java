package com.fundamentos.springboot.fundamentos.bean;

import org.springframework.context.annotation.Configuration;
public class MyBeanImplement implements MyBean{
    @Override
    public void print() {
        System.out.println("Creacion de mi propia dependencia(Bean)");
    }
}
