package com.company;

import java.util.List;

public interface ISomeInterface {

    private List<Integer> privateMethod(){
        List<Integer>someList = List.of(-2,5,2,4,-5);
        return someList;
    };

    default void defaultMethod(){
        System.out.println(privateMethod().stream().filter(y -> y > 0).findFirst().get());
    }
}
