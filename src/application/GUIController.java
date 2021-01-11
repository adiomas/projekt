package application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.net.URL;

import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Toggle;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

public class GUIController implements Initializable {

	@FXML
	private AnchorPane guiHome;
	
	@FXML
	private AnchorPane emoticonsAnchor;

	@FXML
	private Button closeButton;

	@FXML
	private Button minimizeButton;

	@FXML
	private Button expandButton;

	@FXML
	private Button fileChooseButton;
	
	
	private ToggleGroup toggleGroup;
	
	@FXML 
	private ToggleButton angryToggleButton;
	
	@FXML 
	private ToggleButton happyToggleButton;
	
	@FXML 
	private ToggleButton surpriseToggleButton;
	
	@FXML 
	private ToggleButton sadnessToggleButton;
	
	@FXML 
	private Button executeButton;
	
	@FXML
	private HBox imageBox;
	
	@FXML 
	private ImageView uploadeImage;
	
	@FXML
	private HBox Image1Box;
	
	@FXML 
	private ImageView finalImage;
	
	@FXML
	private Label checkEmotionLabel;
	
	
	
	List<String> lstFile;

	@FXML
	public void closeApp() {
		Platform.exit();
		System.exit(0);
	}

	@FXML
	public void singlefileChooser(ActionEvent event) {
		FileChooser fc = new FileChooser();
		fc.getExtensionFilters().add(new ExtensionFilter("Photo files", lstFile));
		File f = fc.showOpenDialog(null);

		if (f != null) {
			finalImage.setVisible(false);
			imageBox.setVisible(true);
			System.out.println("Selected file: " + f.getAbsolutePath());
			Image image = new Image(f.toURI().toString());
			uploadeImage.setImage(image);
			emoticonsAnchor.setVisible(true);
		}
	}
		

	@FXML
	public void executeAction(ActionEvent action)
    {
		ToggleButton b = (ToggleButton) this.toggleGroup.getSelectedToggle();
		
		if(b == null) {
			checkEmotionLabel.setVisible(true);
			finalImage.setVisible(false);
		} else {
		finalImage.setVisible(true);
		checkEmotionLabel.setVisible(false);
		System.out.println(b.getId());
		System.out.println(this.toggleGroup.getSelectedToggle().toString());
		
		File f = new File("/Users/adioma/eclipse-workspace/projekt/resources/angry.png");
		Image image1 = new Image(f.toURI().toString());
		finalImage.setImage(image1);
		}
    }

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		lstFile = new ArrayList<>();
		lstFile.add("*.gif");
		lstFile.add("*.jpg");
		lstFile.add("*.jpeg");
		lstFile.add("*.png");
		
		toggleGroup = new ToggleGroup();
		angryToggleButton.setToggleGroup(toggleGroup);
		happyToggleButton.setToggleGroup(toggleGroup);
		surpriseToggleButton.setToggleGroup(toggleGroup);
		sadnessToggleButton.setToggleGroup(toggleGroup);
	}

}
