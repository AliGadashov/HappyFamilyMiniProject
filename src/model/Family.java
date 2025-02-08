package model;

import java.util.Arrays;
import java.util.Objects;

public class Family {

    private Human mother;
    private Human father;
    private Human[] children;
    private Pet pet;

    static {
        System.out.println("Family class is being loaded");
    }

    {
        System.out.println("A new Family object is created");
    }


//  Methods

    public void addChild(Human child) {
        Human[] newChildren = Arrays.copyOf(children, children.length + 1);
        newChildren[children.length] = child;
        child.setFamily(this);
        this.children = newChildren;
    }

    public void deleteChild(int index) {
        if (index < 0 || index >= children.length) return;

        Human[] newChildren = new Human[children.length - 1];
        for (int i = 0, j = 0; i < children.length; i++) {
            if (i != index) {
                newChildren[j++] = children[i];
            }
        }
        this.children = newChildren;
    }

    public int countFamily() {
        return 2 + children.length;
    }

//  Getters and Setters

    public Human getMother() {
        return mother;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getFather() {
        return father;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human[] getChildren() {
        return children;
    }

    public void setChildren(Human[] children) {
        this.children = children;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }

//  Constructors

    public Family(Human mother, Human father) {
        this.mother = mother;
        this.father = father;
        this.children = new Human[0];
        this.mother.setFamily(this);
        this.father.setFamily(this);
    }

    public Family(Human mother, Human father, Human[] children, Pet pet) {
        this.mother = mother;
        this.father = father;
        this.children = children;
        this.pet = pet;
    }

//  Overrides

    @Override
    public String toString() {
        return "---------------\n" +
                "\nMother: " + getMother() +
                "\nFather: " + getFather() +
                "\nPet: " + getPet() +
                "\nChildren: " + Arrays.toString(getChildren()) +
                "\n---------------";
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Family family = (Family) o;
        return Objects.equals(mother, family.mother) && Objects.equals(father, family.father) && Objects.deepEquals(children, family.children) && Objects.equals(pet, family.pet);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mother, father, Arrays.hashCode(children), pet);
    }

}
