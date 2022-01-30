package com.fundamentos.springboot.fundamentos.configuration;

import com.fundamentos.springboot.fundamentos.bean.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyConfigurationBean {
    @Bean
    public MyBean beanOperation(){
        return new MyBean2Implement();
    }

    @Bean
    public MyOperation beanOperationSum(){
        return new MyOperationImplement();
    }

    @Bean
    public MyBeanWithDependency beanOperationSumReturnWithDependency(MyOperation myOperation){
        return new MyBeanWithDependencyImplement(myOperation);
    }

    @Bean
    public ExerciceDependency beanSaludo(){
        return new ExeciceDependencyImplement();
    }

    @Bean
    public ExercicePrintWithDependencyImplement exerciceDependencyprint(ExerciceDependency exerciceDependency){
        return new ExercicePrintWithDependencyImplement(exerciceDependency);
    }
}
