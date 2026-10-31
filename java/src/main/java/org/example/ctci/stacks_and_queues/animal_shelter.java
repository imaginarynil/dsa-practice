package org.example.ctci.stacks_and_queues;

import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Queue;

public class animal_shelter {
    void solve() {
        var s = new AnimalShelter_Solution();
        s.enqueue(s.createDog("dog 1"));
        s.enqueue(s.createCat("cat 1"));
        s.enqueue(s.createDog("dog 2"));
        s.enqueue(s.createCat("cat 2"));
        var a1 = s.dequeueCats();
        var a2 = s.dequeueDogs();
        var a3 = s.dequeueAny();
    }

    void main() {
        solve();
    }

    enum AnimalType {
        CAT, DOG
    }

    class Animal {
        public AnimalType type;
        String name;

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
            while (it.hasNext()) {
                Animal a = it.next();
                if (a.type == animalType) {
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

    class AnimalShelter_Solution {
        private final Queue<Dog> dogs = new LinkedList<>();
        private final Queue<Cat> cats = new LinkedList<>();
        private int order = 0;

        public void enqueue(Animal a) {
            a.setOrder(this.order);
            this.order += 1;
            if (a instanceof Dog) {
                this.dogs.add((Dog) a);
            } else if (a instanceof Cat) {
                this.cats.add((Cat) a);
            }
        }

        public Animal dequeueAny() {
            if (this.dogs.size() == 0) {
                return this.dequeueCats();
            }
            if (this.cats.size() == 0) {
                return this.dequeueDogs();
            }
            Dog dog = this.dogs.peek();
            Cat cat = this.cats.peek();
            if (dog.isOlder(cat)) {
                return this.dequeueDogs();
            } else {
                return this.dequeueDogs();
            }
        }

        public Dog dequeueDogs() {
            return this.dogs.remove();
        }

        public Cat dequeueCats() {
            return this.cats.remove();
        }

        public Dog createDog(String name) {
            return new Dog(name);
        }

        public Cat createCat(String name) {
            return new Cat(name);
        }

        abstract class Animal {
            protected String name;
            private int order;

            public Animal(String name) {
                this.name = name;
            }

            public int getOrder() {
                return order;
            }

            public void setOrder(int order) {
                this.order = order;
            }

            public boolean isOlder(Animal a) {
                return this.order < a.getOrder();
            }
        }

        class Dog extends Animal {
            public Dog(String name) {
                super(name);
            }
        }

        class Cat extends Animal {
            public Cat(String name) {
                super(name);
            }
        }
    }
}
