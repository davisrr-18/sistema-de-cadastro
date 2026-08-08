package RegistrationSystem.service;

import RegistrationSystem.model.User;
import java.util.List;
import static RegistrationSystem.repository.UserRepository.users;

public class UserService
{
    public void save(String name, String email, int age)
    {
        User user = new User(name, email, age);
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public void ageValidate(int age)
    {
        if (age < 0)
        {
            System.out.println("Invalid age");
        }
    }
}