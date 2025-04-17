package ru.job4j.sobes;

public class MyClass implements First, Second {
    public static void main(String[] args) {
        MyClass myClass = new MyClass();
        System.out.println(myClass.example());
    }

    @Override
    public String example() {
        return Second.super.example();
    }
}
