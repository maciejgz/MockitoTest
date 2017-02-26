package pl.mg.mockito.repository;

import java.util.Random;

import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

    
    public int getIntRepository(){
        Random random = new Random();
        return random.nextInt(200) + 201;
    }
}
