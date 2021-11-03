package edu.westga.cs3152.worldnav.controller;

import java.io.IOException;
import java.util.zip.DataFormatException;

import edu.westga.cs3152.worldnav.datatier.WorldReader;
import edu.westga.cs3152.worldnav.model.Location;
import edu.westga.cs3152.worldnav.model.Node;
import edu.westga.cs3152.worldnav.model.World;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

/**
 * The Class WorldController.
 * 
 * @author CS3152
 * @version Fall 2021
 */
public class WorldController {

	@FXML
	private Label worldNameLabel;

	@FXML
	private VBox buttonVBox;

	@FXML
	private TextFlow descriptionTextFlow;

	private World world;
	private Node<Location> currentNode;

	private String filename;

	/**
	 * Instantiates a new world controller
	 */
	public WorldController() {
		this.filename = "House.txt";
		try {
			this.world = (new WorldReader()).loadWorld(this.filename);
		} catch (IOException | DataFormatException exc) {
			this.world = new World("Oops!");
			System.err.println("Could not load world from file " + this.filename);
		}
	}

	@FXML
	void initialize() {
		this.worldNameLabel.setText(this.world.getName());
		this.updateCurrentLocation(this.world.getStartNode());
	}

	private void updateButtons() {
		this.buttonVBox.getChildren().clear();
		for (Node<Location> location : this.world.getAdjacentLocations(this.currentNode)) {
			PortalButton button = new PortalButton(location);
			this.buttonVBox.getChildren().add(button);
		}
	}

	private void updateCurrentLocation(Node<Location> location) {
		Text descriptionText = new Text();
		descriptionText.setWrappingWidth(500);
		descriptionText.setFont(new Font(16));
		this.descriptionTextFlow.getChildren().clear();
		this.descriptionTextFlow.getChildren().add(descriptionText);
		if (location == null) {
			descriptionText.setText("The world could not be loaded from file.");
		} else {
			this.currentNode = location;
			descriptionText.setText(this.currentNode.getValue().getDescription());
			this.updateButtons();
		}
	}

	private final class PortalButton extends Button {
		private Node<Location> location;

		private PortalButton(Node<Location> location) {
			this.setMinWidth(250);
			this.setFont(Font.font(16));
			this.location = location;
			this.setText(location.getValue().getName());
			this.setOnAction(event -> {
				WorldController.this.updateCurrentLocation(this.location);
			});
		}
	}
}