package com.example.demo18.Exercise17_;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;

public class Exercise17_2 {
    public static void main(String[] args) {
        String[] packageParts = Exercise17_1.class.getPackage().getName().split("\\.");

        try (FileOutputStream fileOutputStream = new FileOutputStream(new File("C:\\Users\\Alikhan\\IdeaProjects\\demo18\\src\\main\\java\\com\\example\\demo18\\Exercise17_\\gogog.dat"), true)) {

            Random random = new Random();



            for (int i = 0; i < 100; i++) {
                int num = random.nextInt(100);
                fileOutputStream.write(num);
            }

        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException occurred.");
        }

    }
}
