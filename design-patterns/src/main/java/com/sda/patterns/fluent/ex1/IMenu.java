package com.sda.patterns.fluent.ex1;

public interface IMenu {
    IMenu order(int index);

    IMenu eat();

    IMenu pay();

    IItem get(int index);
}
