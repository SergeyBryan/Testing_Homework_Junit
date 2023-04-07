package com.example.testing_homework_junit.services;


public class User {

    private String login;
    private String email;

    public User(String login, String email) {
        this.setLogin(login);
        this.setEmail(email);
        if (getLogin().equalsIgnoreCase(getEmail())) {
            throw new IllegalArgumentException("Логин и Email равны. Одинаковый логин и Email недопустим");
        }
    }

    public User() {

    }

    public String getLogin() {
        return login;
    }

    public String getEmail() {
        return email;
    }

    public void setLogin(String login) {
        if (login.isBlank() || login.isEmpty() || login == null) {
            throw new IllegalArgumentException("Пустой логин недопустим");
        } else {
            if (login.equalsIgnoreCase(email)) {
                throw new IllegalArgumentException("Логин не может быть равен email");
            } else {
                this.login = login.toLowerCase();
            }
        }
    }

    public void setEmail(String email) {
        if (!email.contains(".") || !email.contains("@")) {
            throw new IllegalArgumentException("Не верный Email. Email Должен содержать знак @ и .");
        } else {
            this.email = email.toLowerCase();
        }
    }
}