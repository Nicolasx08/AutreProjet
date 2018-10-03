import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Main extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) {
        Menu fichier = new Menu("Fichiers");
        Menu action = new Menu("Actions");
        Menu charger = new Menu("Charger une image");

        Image image = new Image("default.jpg");
        Image image1 = new Image("image1.jpg");
        Image image2 = new Image("image2.jpg");
        Image image3 = new Image("image3.jpg");

        ImageView imageViewDefault = new ImageView(image);
        imageViewDefault.setFitWidth(500);
        imageViewDefault.setFitHeight(500);
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitHeight(500);
        imageView1.setFitWidth(500);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(500);
        imageView2.setFitHeight(500);
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitHeight(500);
        imageView3.setFitWidth(500);

        MenuItem reinitialise = new MenuItem("Réinitialiser");
        action.getItems().add(reinitialise);

        MenuBar mb = new MenuBar(fichier,action);


        stage.setMaximized(true);
        BorderPane root = new BorderPane();
        root.setTop(mb);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
