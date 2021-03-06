package com.sda.patterns.design.creational.singleton.ex_singleton;

public class DemoSingleton {

    public static void main(String[] args) {
        Database database = Database.getDatabaseInstance();
        database.connect();
        database.query();
        database.disconnect();
    }
}
