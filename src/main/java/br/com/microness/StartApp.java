package br.com.microness;

import br.com.microness.model.User;
import br.com.microness.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StartApp implements CommandLineRunner {
    @Autowired
    private UserRepository repository;

    @Override
    public void run(String... args) throws Exception {

        //List<User> users = repository.filtrarPorNome("Marcos");
       // for(User u: users){
        //    System.out.println(u);
       // }

        insertUser();


    }

    public void insertUser(){
        User user = new User();

        user.setName("Pedro");
        user.setUsername("Nick");
        user.setPassword("123456");

        repository.save(user);

        for(User u: repository.findAll()){
            System.out.println(u);
        }
    }


}
