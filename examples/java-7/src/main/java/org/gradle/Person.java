package org.gradle;

import org.apache.commons.collections.list.GrowthList;

public class Person {
    private final String name;

    public Person(String name) {
        this.name = name;
        Character.isAlphabetic(42);
        new GrowthList();
    }

    /**
    * will use java.lang.Character.isAlphabetic(int)
    */
    public String getName() {
        return name;
    }
}