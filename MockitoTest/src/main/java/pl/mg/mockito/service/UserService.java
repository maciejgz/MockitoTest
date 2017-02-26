package pl.mg.mockito.service;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pl.mg.mockito.repository.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;
    

    public int getUniqueInt() throws NullPointerException {
        Random random = new Random();
        return random.nextInt(200);
    }
    
    public String stringTestMethod(String param) {
        return null;
    }
}
