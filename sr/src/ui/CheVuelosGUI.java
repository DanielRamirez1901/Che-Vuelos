package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
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
}
