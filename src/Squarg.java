import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Squarg extends Application {
        public Squarg() {
        }

        public void start(Stage primaryStage) {
            try {
                FXMLLoader loader = new FXMLLoader();
                BorderPane root = (BorderPane)loader.load(this.getClass().getResource("SquargInterface.fxml").openStream());
                primaryStage.setScene(new Scene(root));
                primaryStage.show();
            } catch (Exception var4) {
                var4.printStackTrace();
                System.exit(1);
            }

        }

        public static void main(String[] args) {
            launch(args);
        }
    }


