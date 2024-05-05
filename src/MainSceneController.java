import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.util.*;
import algorithm.*;
import misc.FileHandler;

public class MainSceneController implements Initializable{

    @FXML
    private ChoiceBox<String> algoTypeChoiceBox;

    private String[] algos = {"UCS", "Greedy BFS", "A*"};

    @FXML
    private Label titleLabel;

    @FXML
    private Label resultLabel;

    @FXML
    private Button searchButton;

    @FXML
    private TextField tfEnd;

    @FXML
    private TextField tfStart;

    @FXML
    void search(ActionEvent event) throws Exception {
        try {
            FileHandler fh = new FileHandler();
            Set<String> dict = fh.readDict("src/dictionary/dictionary.txt");
            Stage mainWindow = (Stage) titleLabel.getScene().getWindow();
            String start_word = tfStart.getText();
            String end_word = tfEnd.getText();
            String algorithm = algoTypeChoiceBox.getValue();
            if (algorithm == "UCS") {
                UCS algo = new UCS(start_word, end_word, dict);
                resultLabel.setText(algo.getResult());
            } else if (algorithm == "A*") {
                AStar algo = new AStar(start_word, end_word, dict);
                resultLabel.setText(algo.getResult());
            } else {
                GBFS algo = new GBFS(start_word, end_word, dict);
                resultLabel.setText(algo.getResult());
            }
        } catch (Exception e) {
            resultLabel.setText(e.getMessage());
        }
    }

    @Override
    public void initialize(URL arg0, ResourceBundle arg1) {
        algoTypeChoiceBox.getItems().addAll(algos);
    }
}
