package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository
{
    public record UserData(String name, String email, int age) { }

    private final ArrayList<User> users = new ArrayList<>();

    public List<UserData> getUsers()
    {
        return users.stream()
                .map(user -> new UserData(user.name(), user.email(), user.age()))
                .toList();
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