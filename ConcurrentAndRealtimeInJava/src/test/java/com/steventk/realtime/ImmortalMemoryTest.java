package com.steventk.realtime;

import javax.realtime.ImmortalMemory;

public class ImmortalMemoryTest {
    
    public static void main(String[] args) throws Exception{
        Student s = (Student) ImmortalMemory.instance().newInstance(Student.class);
        s.name = "Steven Liu";
        s.age = 28;
        System.out.println("Immortal memory consumed: " + ImmortalMemory.instance().memoryConsumed() + " bytes.");
        Runnable d = new Dummy();
        ImmortalMemory.instance().enter(d);
        System.out.println("Immortal memory consumed: " + ImmortalMemory.instance().memoryConsumed() + " bytes.");
    }

    static class Dummy implements Runnable{
        @Override
        public void run() {
            String immortalStrVal =
                    "I am immortal!!";
            System.out.println("Current thread: " + Thread.currentThread().getClass().getName());
            System.out.println("Immortal string value: " + immortalStrVal);
        }
    }
    
    public static class Student{
        String name;
        Integer age;
    }
}


