package com.def.controller;

import com.def.model.User;
import com.def.repository.UserRepository;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;

@Component
public class SignInStageController {

    @Autowired
    UserRepository userRepository;

    ObservableList<User> list = FXCollections.observableArrayList();

    @FXML
    private TextField loginField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Button SignInCloseButton;

    @FXML
    private Label status;

    @FXML
    void SignInButton(ActionEvent event) throws IOException {
        for (User user : list){
            if (loginField.getText().equals(user.getLogin()) && passwordField.getText().equals(user.getPassword())){
                Parent root;
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/stages/MainStage.fxml"));
                root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("TaskManager");
                stage.setScene(new Scene(root));
                stage.show();
                SignInCloseButton.getScene().getWindow().hide();
            }else {
                status.setText("Wrong!");
            }
        }
    }

    @FXML
    void initialize() {
        list.addAll(userRepository.findAll());
    }
}
