import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
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
        imageViewDefault.setPreserveRatio(true);
        ImageView imageView1 = new ImageView(image1);
        imageView1.setFitWidth(500);
        imageView1.setPreserveRatio(true);
        ImageView imageView2 = new ImageView(image2);
        imageView2.setFitWidth(500);
        imageView2.setPreserveRatio(true);
        ImageView imageView3 = new ImageView(image3);
        imageView3.setFitWidth(500);
        imageView3.setPreserveRatio(true);

        MenuItem reinitialise = new MenuItem("Réinitialiser");
        MenuItem photo1 = new MenuItem("Image #1");
        MenuItem photo2 = new MenuItem("Image #2");
        MenuItem photo3 = new MenuItem("Image #3");

        charger.getItems().addAll(photo1,photo2,photo3);
        fichier.getItems().add(charger);
        action.getItems().add(reinitialise);

        MenuBar mb = new MenuBar(fichier,action);


        Label lumiere= new Label("Luminosité");
        Slider luminosite = new Slider(-1,1,0);
        luminosite.setMaxWidth(140);
        Label contraste = new Label("Contraste");
        Slider con = new Slider(-1,1,0);
        con.setMaxWidth(140);
        Label teinte = new Label("Teinte");
        Slider teint = new Slider(-1,1,0);
        teint.setMaxWidth(140);
        Label saturation = new Label("Saturation");
        Slider satu = new Slider(-1,1,0);
        satu.setMaxWidth(140);
        VBox vb = new VBox(lumiere,luminosite,contraste,con,teinte,teint,saturation,satu);
        vb.setAlignment(Pos.CENTER);


        HBox hb = new HBox(imageViewDefault,vb);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);

        Label texte = new Label("Bienvenu  dans le modificateur d'image.");


        stage.setMaximized(true);
        BorderPane root = new BorderPane();
        root.setTop(mb);
        root.setCenter(hb);
        root.setBottom(texte);
        stage.setScene(new Scene(root));
        stage.show();
    }
}
