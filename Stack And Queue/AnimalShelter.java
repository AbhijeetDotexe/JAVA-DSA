package com.company;

import java.util.LinkedList;

abstract class Animal{
    private int order;
    protected String name;

    public Animal(String n){
        name = n;

    }
    public abstract String name();

    public void SetOrder(int ord){
        order = ord;
    }
    public int getOrder(){
        return order;
    }

    public boolean isOlderThan(Animal a){
        return this.order < a.getOrder();
    }
}

class Cat extends Animal {
    public Cat(String n) {
        super(n);
    }
    public String name() {
        return ("Cat: "+name );
    }
}

class  Dog extends Animal{
    public Dog(String n){
        super(n);
    }
    public String name(){
        return ("Dog: "+name);
    }
}
class AnimalQueue{
    LinkedList<Dog> dogs = new LinkedList<Dog>();
    LinkedList<Cat> cats = new LinkedList<Cat>();
    private int order = 0;

    public void enQueue(Animal a){
        a.SetOrder(order);
        order++;
        if (a instanceof Dog){
            dogs.addLast((Dog) a);
        }else if(a instanceof Cat){
            cats.addLast((Cat) a);
        }

    }
    public int size(){
        return dogs.size()+cats.size();
    }

    public Dog DequeueDogs(){
        return dogs.poll();
    }

    public Dog peekDogs(){
        return dogs.peek();
    }

    public Cat DequeueCats(){
        return cats.poll();
    }
    public Cat peekCats(){
        return cats.peek();
    }

    public Animal DequeueAny(){
        if (dogs.size() == 0){
            return DequeueCats();
        }else if (cats.size() == 0){
            return DequeueDogs();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)){
            return dogs.poll();
        }else {
            return cats.poll();
        }
    }

    public Animal peek(){
        if (dogs.size() == 0){
            return cats.peek();
        }else if (cats.size() == 0){
            return dogs.peek();
        }
        Dog dog = dogs.peek();
        Cat cat = cats.peek();

        if (dog.isOlderThan(cat)){
            return dogs.peek();
        }else {
            return cats.peek();
        }
    }
}

public class AnimalShelter {
    public static void main(String[] args) {
        AnimalQueue animal = new AnimalQueue();
        animal.enQueue(new Cat("kiki"));
        animal.enQueue(new Cat("kat"));
        animal.enQueue(new Dog("Karl"));
        animal.enQueue(new Dog("Timmy"));
        animal.enQueue(new Dog("Tom"));
        System.out.println(animal.DequeueAny().name());
        System.out.println(animal.DequeueAny().name());
        System.out.println(animal.DequeueAny().name());
        System.out.println(animal.DequeueAny().name());
        System.out.println(animal.DequeueAny().name());

    }
}
