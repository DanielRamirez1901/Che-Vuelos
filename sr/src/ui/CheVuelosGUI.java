package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import model.CheVuelos;

import java.io.IOException;

public class CheVuelosGUI {
    private CheVuelos cheVuelos;

    @FXML
    private BorderPane pane;

    public CheVuelosGUI(CheVuelos controller){
        cheVuelos = controller;
    }

    @FXML
    public void loadInterfazCiudades(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazCiudades.fxml"));
        fxmlLoader.setController(this);
        Parent login1 = fxmlLoader.load();
        pane.setCenter(login1);
        Stage st = (Stage) login1.getScene().getWindow();
        st.setWidth(1000);
        st.setHeight(638);

    }

    @FXML
    public void loadInterfazInicial(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazInicial2.fxml"));
        fxmlLoader.setController(this);
        Parent login1 = fxmlLoader.load();
        pane.setCenter(login1);
        Stage st = (Stage) login1.getScene().getWindow();
        st.setWidth(1000);
        st.setHeight(638);

    }

    @FXML
    public void loadInterfazCali(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazCali.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Informacion de ciudad");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/ImagesInterfaces/icono.jpg"));
        form.showAndWait();

    }

    @FXML
    public void loadInterfazMedellin(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazMedellin.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Informacion de ciudad");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/ImagesInterfaces/icono.jpg"));
        form.showAndWait();

    }

    @FXML
    public void loadInterfazPasto(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazPasto.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Informacion de ciudad");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/ImagesInterfaces/icono.jpg"));
        form.showAndWait();

    }

    @FXML
    public void loadInterfazBogota(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazBogota.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Informacion de ciudad");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/ImagesInterfaces/icono.jpg"));
        form.showAndWait();

    }

    @FXML
    public void loadInterfazTolima(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazTolima.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Informacion de ciudad");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/ImagesInterfaces/icono.jpg"));
        form.showAndWait();

    }

    @FXML
    public void loadSelectorCiudades(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazSelectorCiudades.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Seleccion de ciudades");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/ImagesInterfaces/icono.jpg"));
        form.showAndWait();

    }

    @FXML
    public void loadInterfazVariasCiudades(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazVariasCiudades.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Seleccion de ciudades");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/ImagesInterfaces/icono.jpg"));
        form.showAndWait();

    }

    @FXML
    public void loadInterfazCreditos(ActionEvent event) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("InterfazCreditos.fxml"));
        fxmlLoader.setController(this);
        Parent root = fxmlLoader.load();
        Scene scene = new Scene(root, null);
        Stage form = new Stage();
        form.initModality(Modality.APPLICATION_MODAL);
        form.setTitle("Seleccion de ciudades");
        form.setScene(scene);
        form.setResizable(false);
        form.getIcons().add(new Image("/ui/ImagesInterfaces/icono.jpg"));
        form.showAndWait();

    }

}
