/*Es tracta de que creeu un editor de textos bàsic:
- Per implementar l'àrea d'edició podeu usar el control TextArea

- Creareu els següents menús i elements de menú:
    Fitxer: Sortir
    Editar: Copiar, Tallar, Enganxar, Desfer
    Opcions: Font, Tamany
    Ajuda: Sobre l'Editor

- Per sortir de l'aplicació podeu cridar a Platform.exit();
- Per implementar les accions del menú Editar podeu usar diferents mètodes de la classe TextArea
- Per implementar les accions del menú Opcions podeu usar diferents mètodes de la classe TextArea. Les opcions Font i Tamany són submenús (poseu-hi 3 opcions a cada un).
- Afegir a l'editor una barra d'eines usant l'element ToolBar. Crear tres botons a la barra d'eines: tallar, copiar i enganxar.

- Deshabilitar les opcions copiar i enganxar del menú Editar quan no hi hagi cap text seleccionat. Això ho podrem controlar quan es desplegui el menú per exemple.
- La opció "Sobre l'Editor" del menú Ajuda ha de mostrar un diàleg modal amb informació sobre l'aplicació. Useu la classe Alert per crear-lo.
- Modifiqueu els menú Opcions per a que els items siguin amb checkbox i aparegui marcada la font i tamany actuals. Useu CheckMenuItem.


- Creeu un menú contextual amb les opcions del menú Editar. Useu ContextMenu.


Afegeix a l'editor de text que hem fet a classe les següents funcionalitats:

    -Obrir un fitxer i carregar-ne el seu contingut.
    -Guardar el text editat a un fitxer.
    -El nom del fitxer que s'està editant ha d'aparèixer al títol de la finestra de l'editor.

Useu la classe FileChooser per a crear els diàlegs dels fitxers.

Per accedir, llegir i escriure als fitxers recordeu les classes usades treballades a 1er (File, FileReader, FileWriter)

Entregueu el link al vostre repositori GitHub que contingui l'aplicació.

*/

package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Fitxer nou");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
        primaryStage.getIcons().add(new Image("icon.png"));

    }

    public static void main(String[] args) {
        launch(args);
    }
}
