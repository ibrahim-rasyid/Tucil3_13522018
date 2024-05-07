import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;


public class Main extends Application {
    @Override
    public void start(Stage primary_stage) throws Exception {
        try {
            AnchorPane root = (AnchorPane) FXMLLoader.load(getClass().getResource("Main.fxml"));
            Scene scene = new Scene(root);
            primary_stage.setTitle("WORD LADDER MAXXER");
            primary_stage.setScene(scene);
            primary_stage.show();
        } catch (Exception e) {
            System.out.println(e.getMessage() + e.getClass().getName());
        }
    }

    public static void main(String[] args) throws IOException {
        launch(args);
    }
}