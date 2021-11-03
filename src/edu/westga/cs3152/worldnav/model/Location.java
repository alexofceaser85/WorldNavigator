package edu.westga.cs3152.worldnav.model;

/**
 * The Class Location
 * 
 * @author CS3152
 * @version Fall 2021
 */
public class Location {
	private String name;
	private String description;
	
	/**
	 * Instantiates a new location
	 * 
	 * @pre name != null AND !name.isEmpty() AND description != null AND !description.isEmpty()
	 * @post getName().equals(name) AND getDescription().equals(description)
	 * @param name the name of the location
	 * @param description a description of the location
	 */
	public Location(String name, String description) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty");
		}
		if (description == null) {
			throw new IllegalArgumentException("description cannot be null");
		}
		if (description.isEmpty()) {
			throw new IllegalArgumentException("desription cannot be empty");
		}
		this.name  = name;
		this.description = description;
	}
	
	/**
	 * Gets the name
	 *
	 * @pre none
	 * @post none
	 * @return the name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * Gets the description
	 *
	 * @pre none
	 * @post none
	 * @return the name
	 */
	public String getDescription() {
		return this.description;
	}
	
	@Override
	public int hashCode() {
		return this.name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		Location other = (Location) obj;
		return this.name.equals(other.name);
	}
	
}
