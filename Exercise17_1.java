package com.example.demo18.Exercise17_;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.Random;

public class Exercise17_1 {
    public static void main(String[] args) {
        String[] packageParts = Exercise17_1.class.getPackage().getName().split("\\.");

        File file = new File("C:\\Users\\Alikhan\\IdeaProjects\\demo18\\src\\main\\java\\com\\example\\demo18\\Exercise17_\\ggo.txt");
        PrintWriter printWriter = null;
        try {
            if (file.exists()) {
                printWriter = new PrintWriter(new FileOutputStream(new File("C:\\Users\\Alikhan\\IdeaProjects\\demo18\\src\\main\\java\\com\\example\\demo18\\Exercise17_\\ggo.txt"), false));
            } else {
                printWriter = new PrintWriter(file);
            }
            System.out.println("Starting write out random Integer to: " + file.getAbsolutePath());
            StringBuilder sb = new StringBuilder();
            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                int num = random.nextInt(100);
                sb.append(num).append(" ");
            }
            printWriter.write(sb.toString());
            printWriter.close();
            System.out.println("Write out completed successfully.");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("FileNotFoundException occurred.");
        }


    }
}
