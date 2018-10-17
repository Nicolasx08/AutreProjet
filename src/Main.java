import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.effect.ColorAdjust;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.concurrent.atomic.AtomicInteger;

public class Main extends Application {
    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage stage) {
        Label texte = new Label("Bienvenu  dans le modificateur d'image.");

        Menu fichier = new Menu("Fichiers");
        Menu fichier1 = new Menu("Fichiers");
        Menu action = new Menu("Actions");
        Menu action1 = new Menu("Actions");
        Menu charger = new Menu("Charger une image");
        Menu charger1 = new Menu("Charger une image");

        Image image = new Image("default.jpg");
        Image image1 = new Image("image1.jpg");
        Image image11 = new Image("image1.jpg");
        Image image2 = new Image("image2.jpg");
        Image image22 = new Image("image2.jpg");
        Image image3 = new Image("image3.jpg");
        Image image33 = new Image("image3.jpg");

        ImageView imageview =new ImageView(image);
        imageview.setFitWidth(500);
        imageview.setPreserveRatio(true);

        MenuItem reinitialise = new MenuItem("Réinitialiser");
        MenuItem reinitialise1 = new MenuItem("Réinitialiser");
        MenuItem photo1 = new MenuItem("Image #1");
        MenuItem photo11 = new MenuItem("Image #1");
        MenuItem photo2 = new MenuItem("Image #2");
        MenuItem photo22 = new MenuItem("Image #2");
        MenuItem photo3 = new MenuItem("Image #3");
        MenuItem photo33 = new MenuItem("Image #3");

        charger.getItems().addAll(photo1,photo2,photo3);
        charger1.getItems().addAll(photo11,photo22,photo33);
        fichier.getItems().add(charger);
        fichier1.getItems().add(charger1);
        action.getItems().add(reinitialise);
        action1.getItems().add(reinitialise1);

        MenuBar mb = new MenuBar(fichier,action);


        Label lumiere= new Label("Luminosité");
        Slider luminosite = new Slider(-1,1,0);
        Tooltip tp = new Tooltip("Rend l'image plus clair ou plus sombre");
        luminosite.setTooltip(tp);
        luminosite.setMaxWidth(140);
        Label contraste = new Label("Contraste");
        Tooltip tp1 = new Tooltip("Diminue ou augmente la différence entre les couleurs");
        Slider con = new Slider(-1,1,0);
        con.setTooltip(tp1);
        con.setMaxWidth(140);
        Label teinte = new Label("Teinte");
        Slider teint = new Slider(-1,1,0);
        Tooltip tp2 = new Tooltip("Change la teinte (couleur) de l'image");
        teint.setTooltip(tp2);
        teint.setMaxWidth(140);
        Label saturation = new Label("Saturation");
        Slider satu = new Slider(-1,1,0);
        Tooltip tp3= new Tooltip("Diminue ou augmente l'intensité des couleurs");
        satu.setTooltip(tp3);
        satu.setMaxWidth(140);
        VBox vb = new VBox(lumiere,luminosite,contraste,con,teinte,teint,saturation,satu);
        vb.setAlignment(Pos.CENTER);

        AtomicInteger chiffre= new AtomicInteger();
        chiffre.set(0);
        photo1.setOnAction((event)->{
            chiffre.set(1);
            imageview.setImage(image1);
            texte.setText("image 1 chargée");
        });
        photo2.setOnAction((event)->{
            chiffre.set(2);
            imageview.setImage(image2);
            texte.setText("image 2 chargée");
        });
        photo3.setOnAction((event)->{
            chiffre.set(3);
            imageview.setImage(image3);
            texte.setText("image 3 chargée");
        });
        photo11.setOnAction((event)->{
            chiffre.set(1);
            imageview.setImage(image1);
            texte.setText("image 1 chargée");
        });
        photo22.setOnAction((event)->{
            chiffre.set(2);
            imageview.setImage(image2);
            texte.setText("image 2 chargée");
        });
        photo33.setOnAction((event)->{
            chiffre.set(3);
            imageview.setImage(image3);
            texte.setText("image 3 chargée");
        });
        ColorAdjust coloradjust = new ColorAdjust();
         luminosite.valueProperty().addListener(ov->{
             coloradjust.setBrightness(luminosite.getValue());
             imageview.setEffect(coloradjust);
         });
         con.valueProperty().addListener(ov->{
             coloradjust.setContrast(con.getValue());
             imageview.setEffect(coloradjust);
         });
         teint.valueProperty().addListener(ov->{
             coloradjust.setHue(teint.getValue());
             imageview.setEffect(coloradjust);
         });
         satu.valueProperty().addListener(ov->{
             coloradjust.setSaturation(satu.getValue());
             imageview.setEffect(coloradjust);
         });
         reinitialise.setOnAction((event)->{
             luminosite.setValue(0);
             con.setValue(0);
             teint.setValue(0);
             satu.setValue(0);
             texte.setText("Réinitialisation des ajustement de couleur");
         });
        reinitialise1.setOnAction((event)->{
            luminosite.setValue(0);
            con.setValue(0);
            teint.setValue(0);
            satu.setValue(0);
            texte.setText("Réinitialisation des ajustement de couleur");
        });
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root);
         ContextMenu ct = new ContextMenu(fichier1,action1);
        scene.setOnContextMenuRequested(event -> ct.show(stage, event.getScreenX(), event.getScreenY()));


        HBox hb = new HBox(imageview,vb);
        hb.setAlignment(Pos.CENTER);
        hb.setSpacing(10);
        stage.setMaximized(true);

        root.setTop(mb);
        root.setCenter(hb);
        root.setBottom(texte);
        stage.setScene(scene);
        stage.show();
    }

}
