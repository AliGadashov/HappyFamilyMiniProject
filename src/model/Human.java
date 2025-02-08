package model;

import enums.DayOfWeek;

import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.Random;

public class Human {

    private String name;
    private String surname;
    private int year;
    private int iq;
    private Pet pet;
    private Human mother;
    private Human father;
    private Map<DayOfWeek, String> schedule;
    private Family family;

//  Methods

    public void describeFavorite() {
        System.out.println(name + " loves reading.");
    }

    public void greetPet() {
        System.out.printf("Hello, %s\n", pet != null ? pet.getNickname() : "no pet");
    }

    public void describePet() {
        if (pet != null) {
            String slyness = pet.getTrickLevel() > 50 ? "very sly" : "almost not sly";
            System.out.printf("I have a %s, it is %d years old, and it is %s.\n", pet.getSpecies(), pet.getAge(), slyness);
        } else {
            System.out.println("I have no pet.");
        }
    }

    public void feedPet(boolean isTimeForFeeding) {
        if (pet == null) {
            System.out.println("You don't have a pet to feed!");
            return;
        }

        if (isTimeForFeeding || pet.getTrickLevel() > new Random().nextInt(101)) {
            System.out.println("Hm... I will feed " + name + "'s " + pet.getSpecies());
        } else {
            System.out.println("I think " + name + "'s " + pet.getSpecies() + " is not hungry.");
        }
    }

//  Getters and Setters

    public Map<DayOfWeek, String> getSchedule() {
        return schedule;
    }

    public void setSchedule(Map<DayOfWeek, String> schedule) {
        this.schedule = schedule;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

    public int getIq() {
        return iq;
    }

    public void setIq(int iq) {
        this.iq = iq;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Family getFamily() {
        return family;
    }

    public void setFamily(Family family) {
        this.family = family;
    }

//  Constructors

    public Human() {}

    public Human(String name, String surname, int year) {
        this(name, surname, year, 0, null, null, null, null, null);
    }

    public Human(String name, String surname, int year, int iq, Pet pet, Human mother, Human father, Map<DayOfWeek, String> schedule, Family family) {
        this.name = name;
        this.surname = surname;
        this.year = year;
        this.iq = iq;
        this.pet = pet;
        this.mother = mother;
        this.father = father;
        this.schedule = schedule;
        this.family = family;
    }

//  Overrides

    @Override
    public String toString() {
        return "---------------\n" +
                "Name: " + name + " " + surname + "\n" +
                "Year: " + year + "\n" +
                "IQ: " + iq + "\n" +
                "Mother: " + (mother != null ? mother.getName() : "N/A") + "\n" +
                "Father: " + (father != null ? father.getName() : "N/A") + "\n" +
                "Pet: " + (pet != null ? pet.getNickname() : "No pet") + "\n" +
                "Schedule: " + (schedule != null ? schedule.toString() : "No schedule") + "\n" +
                "---------------";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Human human = (Human) o;
        return year == human.year && iq == human.iq && Objects.equals(name, human.name) && Objects.equals(surname, human.surname) && Objects.equals(pet, human.pet) && Objects.equals(mother, human.mother) && Objects.equals(father, human.father) && Objects.equals(schedule, human.schedule) && Objects.equals(family, human.family);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, year, iq, pet, mother, father, schedule, family);
    }
}
