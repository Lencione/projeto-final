package br.com.finalproject.Services;

import br.com.finalproject.Entities.User;
import br.com.finalproject.Repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public User registerUser(User user){

        if(userRepository.findByEmail(user.getEmail()) != null){
            throw new RuntimeException("E-mail already registered!");
        }

        return userRepository.save(user);
    }

    public User findByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public User findById(long id){
        User user = userRepository.getUserById(id);

        if(user == null){
            throw new RuntimeException("User not found!");
        }
        return user;
    }
}
