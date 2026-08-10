package RegistrationSystem.service;

import RegistrationSystem.model.User;
import java.util.List;
import static RegistrationSystem.repository.UserRepository.users;

public class UserService
{
    public boolean save(String name, String email, int age)
    {
        if (age < 0 || age > 120) { return false; }

        User user = new User(name, email, age);
        users.add(user);

        return true;
    }

    public List<User> getUsers() {
        return users;
    }
}