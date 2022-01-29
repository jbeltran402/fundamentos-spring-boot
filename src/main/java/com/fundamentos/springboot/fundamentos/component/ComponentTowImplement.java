package com.fundamentos.springboot.fundamentos.component;

import org.springframework.stereotype.Component;

@Component
public class ComponentTowImplement implements ComponentDependency{

    @Override
    public void HolaMundo() {
        System.out.println("Hola mundo, Este el el componente 2");
    }
}
