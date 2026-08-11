package ru.netolog.collections;

public class NotRegisteredException extends RuntimeException{
    public NotRegisteredException(String name) {
        super("Игрок с именем " + name + " не найден");
    }
}
