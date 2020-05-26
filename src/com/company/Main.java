package com.company;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {

        ///Zadanie 1
        SomeClassImplementingInterface test = new SomeClassImplementingInterface();
        test.defaultMethod();

        ///Zadanie 2
        var x = 1;
        var y = 3;
        var z = 512;
        var q = -12;
        var p = -50;
        List<Integer> integers = new ArrayList<Integer>();
        integers.add(x);
        integers.add(y);
        integers.add(z);
        integers.add(q);
        integers.add(p);
        integers = Collections.unmodifiableList(integers);
        integers.stream().filter(i -> i > 0);
//        integers.add(500); //Spowoduje java.lang.UnsupportedOperationException

        ///Zadanie 3
        System.out.println(" ".isEmpty());             //false
        System.out.println(" ".isBlank());             //true
        System.out.println("AB\nAB\nAB".lines());      //java.util.stream.ReferencePipeline$Head@615fc7f7
        System.out.println(" DB ".lines());            //java.util.stream.ReferencePipeline$Head@3b6eb2ec
        System.out.println(" DB ".stripLeading());     //DB
        System.out.println(" DB ".stripTrailing());    // DB
        System.out.println("==".repeat(5));            //==========

        ///Zadanie 4
        File file1 = new File("file1.txt");
        if (file1.createNewFile()) {
            System.out.println("Utworzono plik file1.txt");
        } else System.out.println("Plik file1.txt jest juz utworzony");
        File file2 = new File("file2.txt");
        if (file2.createNewFile()) {
            System.out.println("Utworzono plik file2.txt");
        } else System.out.println("Plik file2.txt jest juz utworzony");

        Path filePath1 = Paths.get(file1.getAbsolutePath());
        Path filePath2 = Paths.get(file2.getAbsolutePath());

        Files.writeString(filePath1, "Ten sam napis");
        Files.writeString(filePath2, "Ten sam napis");

        System.out.println(Files.mismatch(filePath1, filePath2));  //Zwraca -1, ponieważ oba pliki mają taką samą zawartość

        Files.writeString(filePath1, "Ten sam napis");
        Files.writeString(filePath2, "Jakis inny napis");

        System.out.println(Files.mismatch(filePath1, filePath2));  //Zwraca 0, ponieważ pliki różnią się zawartością
    }
}
