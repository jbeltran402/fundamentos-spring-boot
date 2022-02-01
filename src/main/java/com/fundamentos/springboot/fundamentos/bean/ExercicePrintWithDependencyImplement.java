package com.fundamentos.springboot.fundamentos.bean;

public class ExercicePrintWithDependencyImplement implements ExercicePrintWithDependency {

    private ExerciceDependency exerciceDependency;

    public ExercicePrintWithDependencyImplement(ExerciceDependency exerciceDependency) {
        this.exerciceDependency = exerciceDependency;
    }

    @Override
    public void PrintExerciceDependency() {
        String name = "Juan David";
        System.out.println("Bien venido estimado"+exerciceDependency.Name(name));
    }
}
