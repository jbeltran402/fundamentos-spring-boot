package com.fundamentos.springboot.fundamentos.bean;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency{

    Log LOGGER = LogFactory.getLog(MyBeanWithDependencyImplement.class);

    private MyOperation myOperation;

    public MyBeanWithDependencyImplement(MyOperation myOperation) {
        this.myOperation = myOperation;
    }

    @Override
    public void printWhithDependency() {
        LOGGER.info("Se Esta Generando la operacion en el metodo printWhithDependency");
        int number = 10;
        LOGGER.debug("El prametro enviado en la dependencia operacion es :"+number);
        System.out.println("Hola desde la implementacion de un bean con dependencia \n" +
                "Este el es resultado de la suma : "+ myOperation.sum(number));
    }
}
