package ui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import model.CheVuelos;

import java.io.IOException;

public class Main extends Application {

    private CheVuelosGUI cheVuelosGui;
    private CheVuelos cheVuelos;

    public Main()throws ClassNotFoundException, IOException {
        cheVuelos = new CheVuelos();
        cheVuelosGui = new CheVuelosGUI(cheVuelos);
    }

    public static void main(String[] args) {
        launch(args);

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazInicial.fxml"));

        fxmlLoader.setController(cheVuelosGui);
        Parent root= fxmlLoader.load();
        Scene scene = new Scene(root, 1000, 600);
        Image icon= new Image("/ui/ImagesInterfaces/icono.jpg");
        primaryStage.getIcons().add(icon);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Che Vuelos");
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}
