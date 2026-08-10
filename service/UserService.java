package RegistrationSystem.service;

public class UserService
{
    public boolean ageValidate(int age)
    {
        if (age < 0 || age > 120) { return false; }

        return true;
    }
}