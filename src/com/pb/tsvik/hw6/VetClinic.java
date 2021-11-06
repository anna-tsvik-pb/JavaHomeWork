package com.pb.tsvik.hw6;

import java.lang.reflect.Constructor;

public class VetClinic {

    public static Object Animal;

    public static void main(String[] args) throws Exception {

        Dog dog1 = new Dog("собака","мясо","будка","Бобик","питбуль");
        Dog dog2 = new Dog("собака","кости","кровать","Шарик","йорк");

        Cat cat1 = new Cat("кошка","рыбки","батарея","рыжая","большая");
        Cat cat2 = new Cat("кот","мышей","улица","черный","маленький");

        Horse horse1 = new Horse("жеребец","сено","загон","вороной",3);
        Horse horse2 = new Horse("кобыла","трава","стойло","гнедой",2);


        Animal[] animals = new Animal[] {dog1, dog2, cat1, cat2, horse1, horse2};

        Class Clazz = Class.forName("com.pb.tsvik.hw6.Veterinarian");

        Constructor constr = Clazz.getConstructor(new Class[] {});
        Object obj = constr.newInstance();

        if (obj instanceof Veterinarian) {
        for (Animal anim: animals) {
            ((Veterinarian) obj).treatAnimal(anim);

            }
        }
    }
}
