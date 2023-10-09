package userInterface;
import javafx.application.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class UserInterface extends Application
{
	public static void main(String areg[])
	{
		launch(areg);
	}

	@Override
	public void start(Stage areg) throws Exception {
		// TODO Auto-generated method stub
		//areg.show();
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));
		Scene scene = new Scene(root);
		areg.setTitle("Rental Property");
		areg.setScene(scene);
		areg.show();
	}
}
