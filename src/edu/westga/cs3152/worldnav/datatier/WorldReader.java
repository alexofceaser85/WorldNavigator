package edu.westga.cs3152.worldnav.datatier;

import java.io.File;
import java.io.IOException;
import java.util.Collection;
import java.util.Scanner;
import java.util.zip.DataFormatException;

import edu.westga.cs3152.worldnav.model.Location;
import edu.westga.cs3152.worldnav.model.Node;
import edu.westga.cs3152.worldnav.model.World;

/**
 * The Class WorldReader
 * 
 * Provides the functionality to read a world from a file. The file format is as
 * follows:
 * 
 * {name of world} 
 * {name of location 1} 
 * {description of location 1} 
 * {comma separated list of names of locations that can be reached from location 1}
 * {name of location 2}
 * {description of location 2}
 * {comma separated list of names of locations that can be reached from location 2} 
 * ... 
 * {name of location k}
 * {description of location k} 
 * {comma separated list of names of locations that can be reached from location k}
 * 
 * Each pair of curly braces {...} represents one line in the file. The name of
 * a location may contain any characters except for the comma. The start
 * location is the first location listed in the file. If no location can be
 * reached from a location, the line {comma separated list of names ...} is an
 * empty line.
 * 
 * @author CS3152
 * @version Fall 2021
 */
public class WorldReader {

	/**
	 * Instantiates a new WorldReader
	 */
	public WorldReader() {
	}

	/**
	 * Load a world from file and returns the World object as specified in the file
	 * 
	 * @pre filename != null AND !filename.isEmpty()
	 * @post none
	 * @param filename the name of the file with the world
	 * @return the sample graph
	 * @throws IOException if the specified file could not be read
	 * @throws DataFormatException if the format of the specified file is incorrect
	 */
	public World loadWorld(String filename) throws IOException, DataFormatException {
		World world;
		File worldFile = new File(filename);
		Scanner worldFileScanner = new Scanner(worldFile);
		
		boolean isStartNode = true;
		
		if (worldFileScanner.hasNextLine()) {
			world = new World(worldFileScanner.nextLine());
		} else {
			worldFileScanner.close();
			return null;
		}
		
		while (worldFileScanner.hasNextLine()) {
			String worldLocationName = worldFileScanner.nextLine();
			String worldLocationDescription = worldFileScanner.nextLine();
			String[] adjacentLocationNames = worldFileScanner.nextLine().split(",");
			
			Location worldLocation = new Location(worldLocationName, worldLocationDescription);
			Location[] adjacentLocations = new Location[adjacentLocationNames.length];
			
			int locationIndex = 0;
			for (String locationName : adjacentLocationNames) {
				if (!locationName.isBlank()) {
					adjacentLocations[locationIndex] = new Location(locationName, " ");
					locationIndex++;
				}
			}
			
			world.getWorldGraph().addNode(new Node<Location>(worldLocation, adjacentLocations));
			
			if (isStartNode) {
				world.setStartNode(worldLocationName);
				isStartNode = false;
			}
		}
		
		worldFileScanner.close();
		return world;
	}
}
