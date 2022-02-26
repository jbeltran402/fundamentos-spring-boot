package com.fundamentos.springboot.fundamentos.bean;


import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;

public class ExercicePrintWithDependencyImplement implements ExercicePrintWithDependency {

    private UserPojo userPojo;
    private final Log LOGGER = LogFactory.getLog(ExercicePrintWithDependencyImplement.class);
    private ExerciceDependency exerciceDependency;

    public ExercicePrintWithDependencyImplement(ExerciceDependency exerciceDependency, UserPojo userPojo) {
        this.exerciceDependency = exerciceDependency;
        this.userPojo = userPojo;
    }

    @Override
    public void PrintExerciceDependency() {
        try{
            System.out.println("Bien venido estimado "+exerciceDependency.Name(userPojo.getNombre()));
            LOGGER.debug("El nombre de usurio es "+userPojo.getNombre());
        }catch (Exception e){
            LOGGER.error("Error en ->" + e + "\nLa variable ful Name tiene el valor: "+ userPojo.getNombre());
        }finally {
            LOGGER.info("Sobrecargando Dependencia");
        }

    }
}
