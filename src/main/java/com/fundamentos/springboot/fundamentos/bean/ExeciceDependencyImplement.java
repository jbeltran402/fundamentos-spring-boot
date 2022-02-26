package com.fundamentos.springboot.fundamentos.bean;

public class ExeciceDependencyImplement implements ExerciceDependency{
    @Override
    public String Name(String name) {
        return " Mr."+ name;
    }
}
