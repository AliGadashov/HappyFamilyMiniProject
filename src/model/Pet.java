package model;

import enums.Species;

import java.util.Arrays;
import java.util.Objects;

public class Pet {

    private Species species;
    private String nickname;
    private int age;
    private int trickLevel;
    private String[] habits;

//  Methods

    public void eat() {
        System.out.println("I am eating.");
    }

    public void respond() {
        System.out.printf("Hello, owner. I am - %s. I miss you!\n", nickname);
    }

    public void foul() {
        System.out.println("I need to cover it up.");
    }

//  Getters and Setters

    public String[] getHabits() {
        return habits;
    }

    public void setHabits(String[] habits) {
        this.habits = habits;
    }

    public int getTrickLevel() {
        return trickLevel;
    }

    public void setTrickLevel(int trickLevel) {
        this.trickLevel = trickLevel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Species getSpecies() {
        return species;
    }

    public void setSpecies(Species species) {
        this.species = species;
    }

    //  Constructors

    public Pet() {}

    public Pet(Species species, String nickname) {
        this.species = species;
        this.nickname = nickname;
    }

    public Pet(Species species, String nickname, int age, int trickLevel, String[] habits) {
        this.species = species;
        this.nickname = nickname;
        this.age = age;
        this.trickLevel = trickLevel;
        this.habits = habits;
    }

//  Overrides

    @Override
    public String toString() {
        return species + "{nickname='" + nickname + "', age=" + age +
                ", trickLevel=" + trickLevel + ", habits=" +
                (habits != null ? String.join(", ", habits) : "No habits") + "}";
    }


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Pet pet = (Pet) o;
        return age == pet.age && trickLevel == pet.trickLevel && Objects.equals(species, pet.species) && Objects.equals(nickname, pet.nickname) && Objects.deepEquals(habits, pet.habits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(species, nickname, age, trickLevel, Arrays.hashCode(habits));
    }



}
