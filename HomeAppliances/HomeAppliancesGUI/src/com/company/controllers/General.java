package com.company.controllers;

import com.company.model.ParametersType;
import com.company.model.Taskable;
import com.company.model.homeelectricalappliances.HomeElectricalAppliances;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyCodeCombination;
import javafx.scene.input.KeyCombination;
import javafx.stage.Stage;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class General {

    List<HomeElectricalAppliances> appliances;
    Taskable model;

    //region field


    @FXML
    private TableColumn<?, ?> stateCol;

    @FXML
    private TableView<HomeElectricalAppliances> appliancesTable;

    @FXML
    private MenuItem voltageSortBt;

    @FXML
    private MenuItem powerSortBt;

    @FXML
    private MenuItem countrySortBt;

    @FXML
    private MenuItem dateSortBt;

    @FXML
    private MenuItem findPowerBt;

    @FXML
    private MenuItem findVoltageBt;

    @FXML
    private MenuItem findCountrybt;

    @FXML
    private MenuItem quitBt;

    @FXML
    private MenuItem undoBt;

    @FXML
    private MenuItem aboutBt;

    @FXML
    private MenuItem updateBt;

    @FXML
    private TableColumn<?, ?> nameCol;

    @FXML
    private TableColumn<?, ?> descriptionCol;

    @FXML
    private TableColumn<?, ?> powerCol;

    @FXML
    private TableColumn<?, ?> voltageCol;

    @FXML
    private TableColumn<?, ?> efficiencyCol;

    @FXML
    private TableColumn<?, ?> dateCol;

    @FXML
    private TableColumn<?, ?> sizeTypeCol;

    @FXML
    private TableColumn<?, ?> guarantyCol;

    @FXML
    private TableColumn<?, ?> countryCol;

    @FXML
    private Label infoLb;


    //endregion

    public void init(Taskable taskable) {
        model = taskable;
        initTable();

        updateAction();
        addKeyListener();
    }

    @FXML
    void aboutAction() {
        AboutController.invoke((Stage) infoLb.getScene().getWindow());
    }

    @FXML
    void undoAction() {
        updateRepresentation(appliances, "Consumed power:  " + model.countConsumedPower(appliances));
    }

    @FXML
    void findAction(ActionEvent event) {
        MenuItem source = (MenuItem) event.getSource();
        TextInputDialog textInputDialog = new TextInputDialog("");
        textInputDialog.setContentText("Filter");
        textInputDialog.setHeaderText("Enter your filter");
        Optional<String> s = textInputDialog.showAndWait();

        if (s.isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "You should enter your filter");
            alert.show();
            return;
        }
        String filter = s.get();
        List<HomeElectricalAppliances> list = null;
        String label = "";

        if (findCountrybt == source) {
            list = model.findWithCountry(appliances, filter);
            label = "Selected by country: " + filter;
            updateRepresentation(list, label);
            return;
        }

        if (!isInteger(filter)) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "It should be a digit");
            alert.show();
            return;
        }
        int f = Integer.parseInt(filter);

        if (findPowerBt == source) {
            list = model.findWithPower(appliances, f);
            label = "Selected by power: " + filter;
        }
        if (findVoltageBt == source) {
            list = model.findWithVoltage(appliances, f);
            label = "Selected by voltage: " + filter;
        }

        updateRepresentation(list, label);
    }

    @FXML
    void sortAction(ActionEvent event) {
        MenuItem source = (MenuItem) event.getSource();
        ParametersType type = null;
        if (countrySortBt == source) {
            type = ParametersType.COUNTRY;
        }
        if (dateSortBt == source) {
            type = ParametersType.DATE;
        }
        if (powerSortBt == source) {
            type = ParametersType.POWER;
        }
        if (voltageSortBt == source) {
            type = ParametersType.VOLTAGE;
        }

        updateTable(model.sortBy(appliances, type));
    }

    @FXML
    void quitAction() {
        infoLb.getScene().getWindow().hide();
    }

    @FXML
    void updateAction() {
        appliances = model.createAppliance();
        updateTable(appliances);
        long power = model.countConsumedPower(appliances);
        setInfoLabelText("Consumed power:  " + power);
    }

    private boolean isInteger(String string) {
        try {
            Integer.parseInt(string);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }

    private void updateRepresentation(List<HomeElectricalAppliances> list, String labelText) {
        updateTable(list);
        setInfoLabelText(labelText);
    }

    private void initTable() {
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        descriptionCol.setCellValueFactory(new PropertyValueFactory<>("description"));
        powerCol.setCellValueFactory(new PropertyValueFactory<>("power"));
        voltageCol.setCellValueFactory(new PropertyValueFactory<>("voltage"));
        stateCol.setCellValueFactory(new PropertyValueFactory<>("stateProvider"));
        efficiencyCol.setCellValueFactory(new PropertyValueFactory<>("efficiencyClass"));
        dateCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        sizeTypeCol.setCellValueFactory(new PropertyValueFactory<>("sizeType"));
        guarantyCol.setCellValueFactory(new PropertyValueFactory<>("guarantyPeriod"));
        countryCol.setCellValueFactory(new PropertyValueFactory<>("country"));
    }

    private void updateTable(List<HomeElectricalAppliances> appliances) {
        ObservableList<HomeElectricalAppliances> list = getTableValues(appliances);
        appliancesTable.setItems(list);
    }

    private ObservableList<HomeElectricalAppliances> getTableValues(List<HomeElectricalAppliances> appliances) {
        return appliances.stream()
                .collect(Collectors.toCollection(FXCollections::observableArrayList));
    }

    private void setInfoLabelText(String text) {
        infoLb.setText(text);
    }

    private void addKeyListener() {
        KeyCombination ctrlZ = new KeyCodeCombination(KeyCode.Z, KeyCodeCombination.CONTROL_DOWN);
        KeyCombination ctrlU = new KeyCodeCombination(KeyCode.U, KeyCodeCombination.CONTROL_DOWN);
        KeyCombination f1 = new KeyCodeCombination(KeyCode.F1);

        updateBt.setAccelerator(ctrlU);
        undoBt.setAccelerator(ctrlZ);
        aboutBt.setAccelerator(f1);
    }
}
