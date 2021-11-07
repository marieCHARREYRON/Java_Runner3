
import javafx.application.Application;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;

public class Main extends Application {
    @Override
public void start(Stage primaryStage) throws Exception{

        primaryStage.setTitle("Hello world");
        GameScene theGameScene = new GameScene(new Group(), 600, 400,true);
        primaryStage.setScene(theGameScene);
        primaryStage.show();

        }


        public static void main(String[] args) {
        launch(args);
        }
}

