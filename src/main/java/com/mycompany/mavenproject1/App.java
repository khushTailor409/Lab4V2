package org.khush.stageexplorer;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


/**
 * JavaFX App
 */
public class HelloApplication extends Application {
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

        Label dayLabel = new Label("Enter number of day on trip");
        Label airFareLabel = new Label("Enter amount of aifare");
        Label carRentalLabel = new Label("Enter car rental fees");
        Label milesLabel = new Label("Enter number of miles Driven");
        Label parkingLabel = new Label("Enter parking fees amount");
        Label taxiLabel = new Label("Enter taxi Charge");
        Label registrationLabel = new Label("Enter registration fees");
        Label conferenceLabel = new Label("Enter conference or seminar fees");
        Label lodgingLabel = new Label("Enter lodgin charge per night");
        Button btnCalculate = new Button("Calculate Result");
        Label label = new Label();

            btnCalculate.setOnAction(e -> {
                try {


                    Double days = Double.valueOf(numDays.getText());
                    Double airfare = Double.valueOf(amountAirfare.getText());
                    Double carFees = Double.valueOf(amountCarFees.getText());
                    Double milesDriven = Double.valueOf(numberMilesDriven.getText());
                    Double parkFees = Double.valueOf(parkingFees.getText());
                    Double taxiFees = Double.valueOf(amountTaxiFees.getText());
                    Double regFees = Double.valueOf(registrationFees.getText());
                    Double confFees = Double.valueOf(conferenceFees.getText());
                    Double lodgeCharge = Double.valueOf(lodgingCharge.getText());

                    Double parkingFeesReimburse = (parkFees < PARKING_REIMBURSE) ? PARKING_REIMBURSE - parkFees : PARKING_REIMBURSE;
                    Double taxiFeesReimburse = (taxiFees < TAXI_REIMBURSE) ? TAXI_REIMBURSE - taxiFees : TAXI_REIMBURSE;
                    Double lodgingChargesReimburse = (lodgeCharge < LODGING_REIMBURSE) ? LODGING_REIMBURSE - lodgeCharge : LODGING_REIMBURSE;
                    Double totalReimburse = (MEALS_REIMBURSE * days) + (MILES_REIMBURSE * milesDriven) + lodgingChargesReimburse + taxiFeesReimburse + parkingFeesReimburse;

                    Double totalExpenses = airfare + carFees + parkFees + taxiFees + regFees + confFees + (lodgeCharge * days);

                    Double excessExpenses = totalExpenses - totalReimburse;

                    Double amountSaved = totalReimburse;


                    if (totalExpenses == 0) {
                        totalReimburse = 0.0;
                        amountSaved = 0.0;

                    }
                    label.setText(String.format("Total Reimbursement: $%.2f%nExcess Expenses: $%.2f%nAmount Saved: $%.2f", totalReimburse, excessExpenses, amountSaved));
                } catch (NumberFormatException ex) {
                    label.setText("Please enter valid numbers in all fields.");
                }

            });
    GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(10));
        gridPane.setVgap(10);
        gridPane.setHgap(10);
    BorderPane root = new BorderPane();
        root.setPadding(new Insets(20));

    GridPane grid = new GridPane();
        grid.setPadding(new Insets(10));
        grid.setVgap(10);
        grid.setHgap(10);
        grid.setAlignment(Pos.CENTER);

        grid.add(dayLabel, 0, 0);
        grid.add(numDays, 1, 0);

        grid.add(airFareLabel, 0, 1);
        grid.add(amountAirfare, 1, 1);

        grid.add(carRentalLabel, 0, 2);
        grid.add(amountCarFees, 1, 2);

        grid.add(milesLabel, 0, 3);
        grid.add(numberMilesDriven, 1, 3);

        grid.add(parkingLabel, 0, 4);
        grid.add(parkingFees, 1, 4);

        grid.add(taxiLabel, 0, 5);
        grid.add(amountTaxiFees, 1, 5);

        grid.add(registrationLabel, 0, 6);
        grid.add(registrationFees, 1, 6);

        grid.add(conferenceLabel, 0, 7);
        grid.add(conferenceFees, 1, 7);

        grid.add(lodgingLabel, 0, 8);
        grid.add(lodgingCharge, 1, 8);

    HBox buttonBox = new HBox(10);
        buttonBox.setAlignment(Pos.CENTER);
        buttonBox.getChildren().addAll(btnCalculate);

        grid.add(buttonBox, 0, 9);

        grid.add(label,0, 10);


        root.setCenter(grid);

        root.setStyle(
                "-fx-background-color: black;" +
                        "-fx-padding: 20;" +
                        "-fx-border-style: solid;" +
                        "-fx-border-width: 2;" +
                        "-fx-border-radius: 10;" +
                        "-fx-border-color: grey;"
        );
        dayLabel.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;");
        airFareLabel.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;");
        carRentalLabel.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;");
        milesLabel.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;");
        parkingLabel.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;");
        taxiLabel.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;");
        registrationLabel.setStyle("-fx-font-weight: bold;" + "-fx-text-fill: white;" );
        conferenceLabel.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;");
        lodgingLabel.setStyle("-fx-font-weight: bold;"+"-fx-text-fill: white;");
        label.setStyle("-fx-font-weight: bold; -fx-text-fill: white;");

    Scene scene = new Scene(root, 640, 550);
        stage.setTitle("Business Expense Calculator");
        stage.setScene(scene);
        stage.show();
}

public static void main(String[] args) {
    launch();
}

}
