package com.example.prtinterfaz3;

import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private TextField nombre;
    @FXML
    private TextField apellidos;
    @FXML
    private TextField edad;
    @FXML
    private Button boton;
    @FXML
    private TableView<Personas> tabla;
    @FXML
    private TableColumn tNombre;
    @FXML
    private TableColumn tApellidos;
    @FXML
    private TableColumn tEdad;

    private ObservableList <Personas> persona;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
            persona = FXCollections.observableArrayList();

            this.tNombre.setCellValueFactory(new PropertyValueFactory("nombre"));
            this.tApellidos.setCellValueFactory(new PropertyValueFactory("apellidos"));
            this.tEdad.setCellValueFactory(new PropertyValueFactory("edad"));
    }

    @FXML
    private void meterPersona(ActionEvent event){
        try{
            String name = this.nombre.getText();
            String surname = this.apellidos.getText();
            int age = Integer.parseInt(this.edad.getText());

            Personas p = new Personas(name,surname,age);

            if(!this.persona.contains(p)){
                this.persona.add(p);
                this.tabla.setItems(persona);
            }else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La persona existe");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("Formato incorrecto");
            alert.showAndWait();
        }
    }
}