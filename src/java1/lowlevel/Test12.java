package java1.lowlevel;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class Test12 {
    private final int a = 10;

    public static void main(String[] args) {
        Child child = new Child();
        System.out.println(child.getAge());
        System.out.println(child.getName());

    }


    static class Parent {
        private String name= "Rakesh";

        public String getName(){
            return name;
        }

        public void setName(String name){
            this.name = name;
        }
    }

    static class Child extends Parent {
        private int age = 12;
        public int getAge(){
            return age;
        }
    }
}
