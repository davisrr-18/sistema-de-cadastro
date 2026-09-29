package repository;

import model.User;

import java.util.ArrayList;
import java.util.List;

public class UserRepository
{
    public record UserData(int id, String name, String email, int age) { }

    private final ArrayList<User> users = new ArrayList<>();
    private int nextId = 1;

    private UserData toUserData(User user)
    {
        return new UserData(user.id(), user.name(), user.email(), user.age());
    }

    public List<UserData> getUsers()
    {
        return users.stream()
                .map(this::toUserData)
                .toList();
    }

    public void addUser(User user)
    {
        users.add(user);
    }

    public void saveUsers(String name, String email, int age)
    {
        User user = new User(nextId++, name, email, age);
        addUser(user);
    }

    public boolean updateUser(int id, String name, String email, int age)
    {
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).id() == id)
            {
                users.set(i, new User(id, name, email, age));
                return true;
            }
        }

        return false;
    }

    public boolean deleteUser(int id)
    {
        return users.removeIf(user -> user.id() == id);
    }

    public List<UserData> searchByName(String term)
    {
        String lowerTerm = term.toLowerCase();

        return users.stream()
                .filter(user -> user.name().toLowerCase().contains(lowerTerm))
                .map(this::toUserData)
                .toList();
    }
}
