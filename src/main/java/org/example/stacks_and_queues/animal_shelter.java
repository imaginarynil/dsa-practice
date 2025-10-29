package org.example.stacks_and_queues;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

enum AnimalType {
    CAT, DOG
}

class Animal {
    String name;
    public AnimalType type;

    public Animal(String name, AnimalType type) {
        this.name = name;
        this.type = type;
    }
}

class Shelter {
    LinkedList<Animal> queue;

    public Shelter() {
        this.queue = new LinkedList<>();
    }

    public void enqueue(Animal animal) {
        this.queue.add(animal);
    }

    public Animal dequeueAny() {
        return this.queue.remove();
    }

    public Animal dequeueByType(AnimalType animalType) {
        ListIterator<Animal> it = this.queue.listIterator();
        while(it.hasNext()) {
            Animal a = it.next();
            if(a.type == animalType) {
                this.queue.remove(a);
                return a;
            }
        }
        return null;
    }

    public Animal dequeueCat() {
        return this.dequeueByType(AnimalType.CAT);
    }

    public Animal dequeueDog() {
        return this.dequeueByType(AnimalType.DOG);
    }
}

public class animal_shelter {
    static void solve(){
        var s = new Shelter();
        s.enqueue(new Animal("Dog A", AnimalType.DOG));
        s.enqueue(new Animal("Dog B", AnimalType.DOG));
        s.enqueue(new Animal("Cat A", AnimalType.CAT));
        Animal cat = s.dequeueCat();
        Animal dog = s.dequeueDog();
    }

    static void main(){
        solve();
    }
}
