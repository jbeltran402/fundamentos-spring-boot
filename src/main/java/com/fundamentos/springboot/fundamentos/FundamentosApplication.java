package com.fundamentos.springboot.fundamentos;

import com.fundamentos.springboot.fundamentos.bean.MyBean;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithDependency;
import com.fundamentos.springboot.fundamentos.bean.MyBeanWithProperties;
import com.fundamentos.springboot.fundamentos.component.ComponentDependency;
import com.fundamentos.springboot.fundamentos.entity.User;
import com.fundamentos.springboot.fundamentos.pojo.UserPojo;
import com.fundamentos.springboot.fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {

    private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    private ComponentDependency componentDependency;
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
    private MyBeanWithProperties myBeanWithProperties;
    private UserPojo userPojo;
    private UserRepository userRepository;

    public FundamentosApplication(@Qualifier("componentTowImplement") ComponentDependency componentDependency, MyBean myBean, MyBeanWithDependency myBeanWithDependency, MyBeanWithProperties myBeanWithProperties, UserPojo userPojo, UserRepository userRepository) {
        this.componentDependency = componentDependency;
        this.myBean = myBean;
        this.myBeanWithDependency = myBeanWithDependency;
        this.myBeanWithProperties = myBeanWithProperties;
        this.userPojo = userPojo;
        this.userRepository = userRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(FundamentosApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        try{
            EjemplosAnteriores();
            SaveUsersInDataBase();
            getInformationJpqlFromUser();
            LOGGER.info("-> Corriendo correctamente <-");
        }catch (Exception e){
            LOGGER.error("ERROR en run -> "+ Arrays.toString(e.getStackTrace()));
        }
    }

    private void getInformationJpqlFromUser() {
        try {
            LOGGER.info("Usuario -> " + userRepository.findByUserEmail("juan@email.com")
                    .orElseThrow(() -> new RuntimeException("-> Usuario No Encontrado")));
            LOGGER.info("Email + Nombre ->" + userRepository.findByEmailAndName("sebastian", "n@email.com")
                    .orElseThrow(() -> new RuntimeException("-> usuario no encontrado por nombre y Email")));
        } catch (Exception e) {
            LOGGER.error(e.getMessage());
        }
        userRepository.findAndSort("M", Sort.by("id").descending()).forEach(user -> LOGGER.info("Usuario con el metodo Sort(Ordenar) " + user));
        userRepository.findByName("Maria").forEach(user -> LOGGER.info("Usuario capturado con Query Method " + user));
        userRepository.findByNameLike("%he%").forEach(user -> LOGGER.info("Usuarios encontrados con Like "+ user));
        userRepository.findByNameOrEmail("henry", null).forEach(user -> LOGGER.info("Usuario encontrado por nombre o Email "+user));
        userRepository.findBybirthDayBetween(LocalDate.of(2021, 1, 1), LocalDate.of(2021 , 9, 3)).
                forEach(user -> LOGGER.info("Usuario con intevalo de fechas "+ user));
    }


    private void SaveUsersInDataBase(){
        User user1 = new User("juan","juan@email.com", LocalDate.of(2000,2,2));
        User user2 = new User("henry","henry@email.com", LocalDate.of(2000,3,2));
        User user3 = new User("camilo","camilo@email.com", LocalDate.of(1999,4,2));
        User user4 = new User("luisa","luisa@email.com", LocalDate.of(2001,5,2));
        User user5 = new User("Maria","maria@email.com", LocalDate.of(1998,6,2));
        User user6 = new User("hernando","hernando@email.com", LocalDate.of(2002,7,2));
        User user7 = new User("sebastian","sebastian@email.com", LocalDate.of(1975,8,2));
        User user8 = new User("danna","danna@email.com", LocalDate.of(1980,9,2));
        User user9 = new User("gabriela","gabriela@email.com", LocalDate.of(2000,10,2));
        User user10 = new User("antonia","antonia@email.com", LocalDate.of(2001,11,2));
        User user11 = new User("John", "john@domain.com", LocalDate.of(2021, 3, 13));
        User user12 = new User("Marco", "marco@domain.com", LocalDate.of(2021, 12, 8));
        User user13 = new User("Daniela", "daniela@domain.com", LocalDate.of(2021, 9, 8));
        User user14 = new User("Marisol", "marisol@domain.com", LocalDate.of(2021, 6, 18));
        User user15 = new User("Karen", "karen@domain.com", LocalDate.of(2021, 1, 1));
        User user16 = new User("Carlos", "carlos@domain.com", LocalDate.of(2021, 7, 7));
        User user17 = new User("Enrique", "enrique@domain.com", LocalDate.of(2021, 11, 12));
        User user18 = new User("Luis", "luis@domain.com", LocalDate.of(2021, 2, 27));
        User user19 = new User("Paola", "paola@domain.com", LocalDate.of(2021, 4, 10));

        List<User> list = Arrays.asList(user1,user2,user3,user4,user5,user6,user7,user8,user9,user10,user11,user12,user13,user14,user15,user16,user17,user18,user19);
        list.forEach(userRepository::save);
    }

    public void EjemplosAnteriores(){
        componentDependency.HolaMundo();
        myBean.print();
        myBeanWithDependency.printWhithDependency();
        System.out.println(myBeanWithProperties.function());
        System.out.println(userPojo.getEmail());
        try {
            int VariableError = 10 / 0;
            LOGGER.debug("El resultado es :" + VariableError);
        } catch (Exception e) {
            LOGGER.error("Esto es un error en la suma, se esta dividiendo por cero " + e.getStackTrace());
        }
    }
}
