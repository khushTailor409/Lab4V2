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
    public static double MEALS_REIMBURSE = 37.00;
    public static double PARKING_REIMBURSE = 10.00;
    public static double TAXI_REIMBURSE = 20.00;
    public static double LODGING_REIMBURSE = 95.00;
    public static double MILES_REIMBURSE = 0.27;        
          
            
            
    @Override
    public void start(Stage stage) {
        TextField numDays = new TextField();
        TextField amountAirfare = new TextField();
        TextField amountCarFees = new TextField();
        TextField numberMilesDriven = new TextField();
        TextField parkingFees = new TextField();
        TextField amountTaxiFees = new TextField();
        TextField registrationFees = new TextField();
        TextField conferenceFees = new TextField();
        TextField lodgingCharge = new TextField();
        
        Double days = Double.valueOf(numDays.getText());
        Double airfare = Double.valueOf(amountAirfare.getText());
        Double carFees = Double.valueOf(amountCarFees.getText());
        Double milesDriven = Double.valueOf(numberMilesDriven.getText());
        Double parkFees = Double.valueOf(parkingFees.getText());
        Double taxiFees = Double.valueOf(amountTaxiFees.getText());
        Double regFees = Double.valueOf(registrationFees.getText());
        Double confFees = Double.valueOf(conferenceFees.getText());
        Double lodgeCharge = Double.valueOf(lodgingCharge.getText());
        
        Double parkingFeesReimburse = (parkFees < PARKING_REIMBURSE)? PARKING_REIMBURSE - parkFees : PARKING_REIMBURSE;
        Double taxiFeesReimburse = (taxiFees < TAXI_REIMBURSE)? TAXI_REIMBURSE - taxiFees : TAXI_REIMBURSE;
        Double lodgingChargesReimburse = (lodgeCharge < LODGING_REIMBURSE)? LODGING_REIMBURSE - lodgeCharge : LODGING_REIMBURSE;
        Double totalReimburse = (MEALS_REIMBURSE * days) + (MILES_REIMBURSE * milesDriven) + lodgingChargesReimburse + taxiFeesReimburse + parkingFeesReimburse;
        
        Double totalExpenses = airfare + carFees + parkFees + taxiFees + regFees + (lodgeCharge * days);
        
        Double excessExpenses = totalExpenses - totalReimburse;
        
        Double amountSaved = totalReimburse; 
        

        Label dayLabel = new Label("Enter number of day on trip");
        Label airFareLabel = new Label("Enter amount of aifare");
        Label carRentalLabel = new Label("Enter car rental fees");
        Label milesLabel = new Label("Enter number of miles Driven");
        Label parkingLabel = new Label("Enter parking fees amount");
        Label taxiLabel = new Label("Enter taxi Charge");
        Label conferenceLabel = new Label("Enter conference or seminar fees");
        Label lodgingLabel = new Label("Enter lodgin charge per night");
    


    }


    public static void main(String[] args) {
        launch();
    }

}