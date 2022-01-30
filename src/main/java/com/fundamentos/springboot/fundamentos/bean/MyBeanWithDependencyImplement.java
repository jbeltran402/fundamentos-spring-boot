package com.fundamentos.springboot.fundamentos.bean;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWhithDependency() {
        int number = 10;
        System.out.println("Hola desde la implementacion de un bean con dependencia \n" +
                "Este el es resultado de la suma : "+ myOperation.sum(number));
    }
}
