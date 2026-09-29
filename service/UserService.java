package service;

import repository.UserRepository;

import java.util.List;

public class UserService
{
    private final UserRepository userRepository = new UserRepository();

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

    public boolean updateUser(int id, String name, String email, int age)
    {
        if (!ageValidate(age)) { return false; }

        return userRepository.updateUser(id, name, email, age);
    }

    public boolean deleteUser(int id)
    {
        return userRepository.deleteUser(id);
    }

    public List<UserRepository.UserData> searchUsersByName(String term)
    {
        if (term == null || term.isBlank()) { return List.of(); }

        return userRepository.searchByName(term.trim());
    }
}
