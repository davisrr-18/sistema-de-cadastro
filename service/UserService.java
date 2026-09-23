package service;

import repository.UserRepository;

import java.util.List;

public class UserService
{
    UserRepository userRepository = new UserRepository();

    public boolean ageValidate(int age)
    {
        return age >= 0 && age <= 120;
    }

    public boolean registerUser(String name, String email, int age)
    {
        if (!ageValidate(age)) { return false; }

        userRepository.saveUsers(name, email, age);
        return true;
    }

    public List<UserRepository.UserData> getAllUsers()
    {
        return userRepository.getUsers();
    }
}