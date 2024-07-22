package Belajar_Spring_Boot.Spring_Boot_RestFull.service;

import Belajar_Spring_Boot.Spring_Boot_RestFull.entity.User;
import Belajar_Spring_Boot.Spring_Boot_RestFull.exception.ApiException;
import Belajar_Spring_Boot.Spring_Boot_RestFull.model.RegisterUserRequest;
import Belajar_Spring_Boot.Spring_Boot_RestFull.repository.UserRepository;
import Belajar_Spring_Boot.Spring_Boot_RestFull.security.BCrypt;
import jakarta.persistence.SecondaryTable;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private Validator validator;

    public void register(RegisterUserRequest request) {
        Set<ConstraintViolation<RegisterUserRequest>> constraintViolations = validator.validate(request);

        if (constraintViolations.size() != 0) {
            throw new ConstraintViolationException(constraintViolations);
        }

        if (userRepository.existsById(request.getUsername())) {
            throw new ApiException("Username already registerd");
        }

        User user = new User();
        user.setUsername(request.getUsername()));
        user.setPassword(BCrypt.hashpw(request.getPassword(), BCrypt.gensalt()));
        user.setName(request.getName());

        userRepository.save(user);
    }
}
