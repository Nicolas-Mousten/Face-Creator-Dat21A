package com.example.face_creator;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.shape.ArcType;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Random;

public class HelloApplication extends Application {
    static int width = 600;
    static int height = 600;
    static Canvas canvas = new Canvas(width, height);
    static GraphicsContext gc = canvas.getGraphicsContext2D();


    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));

        Group root = new Group();
        Scene scene = new Scene(root, width, height);
        stage.setTitle("Face");
        stage.setScene(scene);

        gc.clearRect(0, 0, width, height);
        root.getChildren().add(canvas);

        drawPrimitiveFace();

        stage.show();
    }

    public static void drawPrimitiveFace() {
        Random random = new Random();
        boolean rand1 = random.nextBoolean();
        boolean rand2 = random.nextBoolean();
        boolean rand3 = random.nextBoolean();
        boolean suprise = rand1;
        boolean funny = rand2;
        boolean evil = rand3;
        drawShape();
        if (suprise == false) {
            drawMouth1();
        } else if (suprise == true) {
            drawMouth2(50);
        }

        if (funny == true) {
            googlyEyes();
        } else if (funny == false) {
            drawEyes();
        }
        if (evil == false) {
            nose();
        }
        else if(evil ==true){
            voldyNose();
        }
        hair();//already random
        eyeBrows();
        beard1();
    }
    public static void drawShape() {
        gc.strokeOval(150, 150, 300, 300);
    }

    public static void drawMouth1() {
        gc.strokeArc(200, 330, 200, 50, -20, -160, ArcType.OPEN);
        gc.strokeArc(200, 350, 200, 50, -0, -180, ArcType.OPEN);
        gc.strokeArc(200, 340, 196, 50, -0, -180, ArcType.OPEN);
        gc.strokeLine(200, 358, 200, 378);
        gc.strokeLine(395, 365, 400, 378);
    }
    public static void drawMouth2(int mouthSize){
        gc.setFill(Color.BLACK);
        gc.fillOval(280,370,mouthSize,mouthSize);
        }

    public static void googlyEyes(){
        gc.fillOval(220,210,20,20);
        gc.fillOval(380,230,20,20);
        gc.strokeOval(210,210,50,50);
        gc.strokeOval(350,210,50,50);
    }

    public static void drawEyes() {
        gc.setFill(Color.BLACK);
        gc.fillOval(220,220,20,20);
        gc.fillOval(360,220,20,20);
        gc.translate(215, 205);
        gc.rotate(30);
        gc.strokeOval(0,0,50,25);
        gc.rotate(-30);
        gc.translate(-215, -205);
        gc.translate(345, 230);
        gc.rotate(-30);
        gc.strokeOval(0,0,50,25);
        gc.rotate(30);
        gc.translate(-345, -230);
    }
    public static void nose(){
        gc.strokeArc(309,275+10,50,50,135,90, ArcType.OPEN);
        gc.strokeArc(250,275+10,50,50,315,90, ArcType.OPEN);
        gc.strokeArc(292,310+10,25,25,160,225,ArcType.OPEN);
        gc.fillOval(294,320+10,7,7);
        gc.fillOval(308,320+10,7,7);
    }
    public static void voldyNose(){
        gc.fillOval(294,320+10,7,7);
        gc.fillOval(308,320+10,7,7);
    }

    public static void hair() {
        Random random = new Random();
        for (int i = 0; i < 250; i = 2 + i) {
            int rand = random.nextInt(200 - 150) + 150;
            int yMax = rand - 15;
            int yMin = rand + 15;
            gc.strokeLine(175 + i, yMax, 175 + i, yMin);
        }
    }
    public static void eyeBrows(){
            for(int i = 0; i<75; i++){
                gc.strokeLine(210+i,200+(i/2), 190+i, 180+(i/2));
                gc.strokeLine(320+i,237.5-(i/2), 340+i, 217.5-(i/2));
            }
        }

    public static void beard1(){
        Random random = new Random();
        for(int x = 0; x<150;x = x+2){
            int rand = random.nextInt(500 - 470)+470;
            double quarterBeard = (Math.pow(x,2))/180;
            gc.strokeLine(300+x,450-quarterBeard,300+x,rand-quarterBeard);
            gc.strokeLine(300-x,450-quarterBeard,300-x,rand-quarterBeard);
        }
    }

    public static void beard2() {
        Random random = new Random();
        for (int x = 0; x < 150; x = x + 2) {
            int rand = random.nextInt(500 - 470) + 470;
            double quarterBeard = (Math.pow(x, 2)) / 180;
            gc.strokeLine(300 + x, 450 - quarterBeard, 300 + x, rand - quarterBeard);
            gc.strokeLine(300 - x, 450 - quarterBeard, 300 - x, rand - quarterBeard);
        }
    }


    public static void main(String[] args) {
        launch();
    }

}