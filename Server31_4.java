package com.example.demo18.Exercise31_4;

import java.io.*;
import java.net.*;
import java.util.Date;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

public class Server31_4 extends Application {
    private TextArea ta = new TextArea();
    private int threadNo = 0;
    @Override
    public void start(Stage primaryStage) {
        Scene scene = new Scene(new ScrollPane(ta), 450, 200);
        primaryStage.setTitle("Exercise31_04Sever"); 
        primaryStage.setScene(scene); 
        primaryStage.show(); 

        new Thread(() -> {
            try {
                ServerSocket serverSocket = new ServerSocket(8000);
                ta.appendText("Exercise31_04Sever started at " + new Date() + '\n');
                while (true) {
                    Socket socket = serverSocket.accept();
                    Platform.runLater(e -> {
                        ta.appendText("Starting thread " + threadNo++ + '\n');
                        InetAddress inetAddress = socket.getInetAddress();
                        ta.appendText("Client IP /" +
                                inetAddress.getHostAddress() + '\n');});
                    new Thread(new HandleAClient(socket)).start();
                }
            }
            catch(IOException ex) {
                System.err.println(ex);
            }
        }).start();
    }
    class HandleAClient implements Runnable {
        private Socket socket;
        public void run() {
            try {
                DataOutputStream outputToClient = new DataOutputStream(
                        socket.getOutputStream());
                outputToClient.writeUTF("You are visitor " + threadNo);
            }
            catch (IOException ex) {
                ex.printStackTrace();
            }
        }
        
    }
}