package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.*;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import java.awt.*;
import java.io.*;

public class Controller extends Component {

    RadioMenuItem tmn;
    RadioMenuItem fnt;


    int size =13;
    String fuente = "Serif";

    @FXML private TextArea seleccion;
    @FXML private MenuItem mnCopiar;
    @FXML private MenuItem mnTallar;
    @FXML private MenuItem mnCopiar1;
    @FXML private MenuItem mnTallar1;
    @FXML private Button btTallar;
    @FXML private Button btCopiar;
    @FXML private Button btEnganxar;


    public void sortir(ActionEvent actionEvent) {
        Platform.exit();
    }

    public void copiar(ActionEvent actionEvent) {
        seleccion.copy();
    }

    public void enganxar(ActionEvent actionEvent) {
        seleccion.paste();
    }

    public void desfer(ActionEvent actionEvent) {
        seleccion.undo();
    }

    public void tallar(ActionEvent actionEvent) {
        seleccion.cut();
    }

    public void cambFuente(ActionEvent event) {

        fnt = (RadioMenuItem) event.getSource();
        fuente = fnt.getText();
        seleccion.setFont((Font.font (fuente, size)));

    }

    public void initialize() {
        btCopiar.setGraphic(new ImageView("copiar.png"));
        btTallar.setGraphic(new ImageView("tallar.png"));
        btEnganxar.setGraphic(new ImageView("enganxar.png"));

    }

    public void cambTama(ActionEvent event) {

        tmn =(RadioMenuItem) event.getSource();
        size = Integer.parseInt(tmn.getText());
        seleccion.setFont((Font.font (fuente, size)));

    }

    public void ajuda(ActionEvent actionEvent) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sobre l'editor: ");
        alert.setHeaderText("Editor de text 1.0");
        alert.setContentText("Fet Per Cristian Jimenez per al M07 de DAM");
        alert.showAndWait();
    }

    public void obrir(ActionEvent actionEvent) throws Exception {

        Stage stage = (Stage)seleccion.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Escull fitxer: ");

        File archivo =  fc.showOpenDialog(stage);
        String nombre="";

        if (archivo != null){

            FileReader fich = new FileReader(archivo);
            BufferedReader buff = new BufferedReader(fich);
            nombre=archivo.getName();

            try {

                String cadena;
                String documento="";
                stage.setTitle(nombre);
                while((cadena = buff.readLine())!=null) {
                    documento = (documento + cadena+"\n");
                }
                seleccion.setText(documento);
                buff.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void guardar(ActionEvent actionEvent) {

        Stage stage = (Stage)seleccion.getScene().getWindow();
        FileChooser fc = new FileChooser();
        fc.setTitle("Guarda el fitxer: ");
        File savedFile = fc.showSaveDialog(stage);
        String nombre="";

        if (savedFile != null) {

            try {
                nombre=savedFile.getName();
                stage.setTitle(nombre);
                String txt = seleccion.getText();
                savedFile.createNewFile();
                FileWriter writer = new FileWriter(savedFile);
                writer.write(txt);
                writer.close();
            }
            catch(IOException e) {

            }
        }
    }

    public void editar(Event event) {

        if (seleccion.selectedTextProperty().getValue().length()>0){

            mnCopiar.setDisable(false);
            mnTallar.setDisable(false);
            mnCopiar1.setDisable(false);
            mnTallar1.setDisable(false);
            btTallar.setDisable(false);
            btCopiar.setDisable(false);

        }
        else {

            mnCopiar.setDisable(true);
            mnTallar.setDisable(true);
            mnCopiar1.setDisable(true);
            mnTallar1.setDisable(true);
            btTallar.setDisable(true);
            btCopiar.setDisable(true);

        }
    }
}
