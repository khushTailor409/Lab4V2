package com.mycompany.mavenproject1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class App extends Application {

    @Override
    public void start(Stage stage) {
        TextField numDays = new TextField();
        TextField amountAirfare = new TextField();
        TextField amountCarFees = new TextField();
        TextField numberMilesDriven = new TextField();
        TextField amountTaxiFees = new TextField();
        TextField registrationFees = new TextField();
        TextField lodgingCharge = new TextField();
        
        Double days = Double.valueOf(numDays.getText());
        Double airfare = Double.valueOf(amountAirfare.getText());
        Double carFees = Double.valueOf(amountCarFees.getText());
        Double milesDriven = Double.valueOf(numberMilesDriven.getText());
        Double taxiFees = Double.valueOf(amountTaxiFees.getText());
        Double regFees = Double.valueOf(registrationFees.getText());
        Double lodgeCharge = Double.valueOf(lodgingCharge.getText());
        
                
                
                }

    public static void main(String[] args) {
        launch();
    }

}