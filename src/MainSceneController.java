import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.util.*;
import algorithm.*;
import misc.FileHandler;

public class MainSceneController {

    @FXML
    private Label titleLabel;

    @FXML
    private ImageView imageView;
    private Image image = new Image(getClass().getResourceAsStream("mewing-mew.png"));

    @FXML
    private Label resultLabel;

    @FXML
    private RadioButton rbUCS, rbGBFS, rbAStar;
    private ToggleGroup algo;

    @FXML
    private Button searchButton;

    @FXML
    private TextArea taResult;

    @FXML
    private TextField tfEnd;

    @FXML
    private TextField tfStart;

    @FXML
    void displayImage() {
        imageView.setImage(image);
    }

    @FXML
    void setToggle() {
        rbUCS.setToggleGroup(algo);
        rbGBFS.setToggleGroup(algo);
        rbAStar.setToggleGroup(algo);
    }
    
    @FXML
    void search(ActionEvent event) throws Exception {
        resultLabel.setWrapText(true);
        try {
            FileHandler fh = new FileHandler();
            Set<String> dict = fh.readDict("src/dictionary/dictionary.txt");
            Stage mainWindow = (Stage) titleLabel.getScene().getWindow();
            String start_word = tfStart.getText();
            String end_word = tfEnd.getText();
            if (rbUCS.isSelected()) {
                UCS algoUCS = new UCS(start_word, end_word, dict);
                resultLabel.setText(algoUCS.getResult());
            } 
            if (rbAStar.isSelected()) {
                AStar algoAStar = new AStar(start_word, end_word, dict);
                resultLabel.setText(algoAStar.getResult());
            } 
            if (rbGBFS.isSelected()) {
                GBFS algoGBFS = new GBFS(start_word, end_word, dict);
                resultLabel.setText(algoGBFS.getResult());
            }
        } catch (Exception e) {
            resultLabel.setText(e.getMessage());
        }
    }
}
