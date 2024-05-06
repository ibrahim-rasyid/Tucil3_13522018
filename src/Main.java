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
        /* Code of CLI */
        // FileHandler fh = new FileHandler();
        // Set<String> dict = fh.readDict("src/dictionary/dictionary.txt");
        // InputHandler ih = new InputHandler();
        // String[] words = ih.getWords(dict);
        // String start_word = words[0].toUpperCase();
        // String end_word = words[1].toUpperCase();
        // dict = fh.trimDict(dict, start_word.length());
        // Integer type = ih.getAlgoType();
        // try {
        //     if (type == 1) {
        //         UCS search = new UCS(start_word, end_word, dict);
        //         search.showResult();
        //     } else if (type == 2) {
        //         GBFS search = new GBFS(start_word, end_word, dict);
        //         search.showResult();
        //     } else {
        //         AStar search = new AStar(start_word, end_word, dict);
        //         search.showResult();
        //     }
        // } catch (Exception e) {

        // }
        launch(args);
    }
}
