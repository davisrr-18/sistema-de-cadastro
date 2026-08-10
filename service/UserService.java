package RegistrationSystem.service;

import RegistrationSystem.model.User;
import RegistrationSystem.repository.UserRepository;

import java.util.List;

public class UserService
{
    UserRepository userRepository = new UserRepository();

    public boolean ageValidate(int age)
    {
        if (age < 0 || age > 120) { return false; }

        return true;
    }

    public boolean registerUser(String name, String email, int age)
    {
        if (!ageValidate(age)) { return false; }

        userRepository.saveUsers(name, email, age);
        return true;
    }

    public List<User> getAllUsers()
    {
        return userRepository.getUsers();
    }
}