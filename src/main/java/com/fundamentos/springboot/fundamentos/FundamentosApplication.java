package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.*;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

	private ComponentDependency componentDependency;
	private MyBean myBean;
	private MyBeanWithDependency myBeanWithDependency;
	private ExercicePrintWithDependencyImplement exercicePrintWithDependencyImplement;

	public FundamentosApplication(@Qualifier("componentTowImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, ExercicePrintWithDependencyImplement exercicePrintWithDependencyImplement){
		this.componentDependency = componentDependency;
		this.myBean = myBean;
		this.myBeanWithDependency = myBeanWithDependency;
		this.exercicePrintWithDependencyImplement = exercicePrintWithDependencyImplement;
	}

	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		componentDependency.HolaMundo();
		myBean.print();
		myBeanWithDependency.printWhithDependency();
		exercicePrintWithDependencyImplement.PrintExerciceDependency();
	}
}
