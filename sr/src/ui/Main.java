package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import model.CheVuelos;

import java.io.IOException;

public class Main extends Application {

    private CheVuelosGUI cheVuelosGui;
    private CheVuelos cheVuelos;

    public Main()throws ClassNotFoundException, IOException {
        cheVuelos = new CheVuelos();
        cheVuelosGui = new CheVuelosGUI();
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazCiudades.fxml"));

        fxmlLoader.setController(cheVuelosGui);
        Parent root= fxmlLoader.load();

    }
}
