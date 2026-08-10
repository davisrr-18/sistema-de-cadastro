package RegistrationSystem.repository;

import RegistrationSystem.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository
{
    private final ArrayList<User> users = new ArrayList<>();

    public List<User> getUsers()
    {
        return users;
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public void saveUsers(String name, String email, int age)
    {
        User user = new User(name, email, age);
        addUser(user);
    }
}