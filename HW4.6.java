package com.company;

public class Person {

    private String name;
    private String surname;
    private int age;
    private int height;
    private int weight;

    public Person(String name, String surname, int age, int height, int weight) {
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.height = height;
        this.weight = weight;
    }

    public static void main(String[] args) {
        Person somePerson = new Person.Builder()
                .withName("Aleksandra")
                .withSurname("Ponochovna")
                .withAge(20)
                .withHeight(165)
                .withWeight(55)
                .build();
    }

    public static class Builder {
        private Person newPerson;

        public Builder() {
            newPerson = new Person("al", "pon", 55, 44, 33);
        }

        public Builder withName(String name) {
            newPerson.name = name;
            return this;
        }

        public Builder withSurname(String surname) {
            newPerson.surname = surname;
            return this;
        }

        public Builder withAge(int age) {
            newPerson.age = age;
            return this;
        }

        public Builder withHeight(int height) {
            newPerson.height = height;
            return this;
        }

        public Builder withWeight(int weight) {
            newPerson.weight = weight;
            return this;
        }

        public Person build() {
            return newPerson;
        }
    }
}
