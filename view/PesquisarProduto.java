package view;

import controller.CaixaController;
import controller.PesquisarClienteController;
import controller.PesquisarProdutoController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class PesquisarProduto extends Application {

    CaixaController caixaController = new CaixaController();

    public PesquisarProduto(CaixaController caixaController) {
        this.caixaController = caixaController;
    }

    private final String title = "Pesquisar Produto";

    private static Stage window;

    private void setWindow(Stage window) {
        this.window = window;
    }

    public static Stage getWindow() {
        return window;
    }

    @Override
    public void start(Stage stage) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("fxml/pesquisar_produto.fxml"));
            Parent root = fxmlLoader.load();
            PesquisarProdutoController pesquisarProdutoController = fxmlLoader.getController();
            pesquisarProdutoController.setCaixaController(this.caixaController);
            Scene scene = new Scene(root);

            setWindow(stage);
            stage.setScene(scene);
            stage.initStyle(StageStyle.DECORATED);
            stage.initModality(Modality.NONE);
            stage.initOwner(Caixa.getWindow());
            stage.setTitle(title);
            stage.setResizable(false);
            stage.show();
        }
        catch (IOException ex) {
            System.err.println(String.format("ERRO (%s): ", title));
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}