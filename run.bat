@echo off
javac --module-path "C:\Program Files\Java\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -d bin -cp src src/Main.java src/MainSceneController.java
java --module-path "C:\Program Files\Java\javafx-sdk-22.0.1\lib" --add-modules javafx.controls,javafx.fxml -cp bin Main