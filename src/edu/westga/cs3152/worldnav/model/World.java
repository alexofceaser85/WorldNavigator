package edu.westga.cs3152.worldnav.model;

import java.util.Collection;

/**
 * The Class World
 * 
 * @author CS3152
 * @version Fall 2021
 */
public class World {
	private Digraph<Location> worldGraph;
	private String name;
	private Node<Location> startNode;

	/**
	 * Instantiates a new world
	 * 
	 * @pre none
	 * @post getName() == null AND getStartNode() == null
	 */
	public World() {
		this.name = null;
		this.worldGraph = new Digraph<Location>();
		this.startNode = null;
	}
	
	/**
	 * Instantiates a new world
	 * 
	 * @pre name != null AND !name.isEmpty()
	 * @post getName().equals(name)
	 * @param name the name of the world
	 */
	public World(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty");
		}
		this.name = name;
		this.worldGraph = new Digraph<Location>();
		this.startNode = null;
	}

	/**
	 * Gets the name
	 *
	 * @pre none
	 * @post none
	 * @return the name of this world
	 */
	public String getName() {
		return this.name;
	}

	/**
	 * Gets the start node
	 *
	 * @pre none
	 * @post none
	 * @return the node with the start location
	 */
	public Node<Location> getStartNode() {
		return this.startNode;
	}

	/**
	 * Gets the graph representing the world
	 *
	 * @pre none
	 * @post none
	 * @return the graph representing the world
	 */
	public Digraph<Location> getWorldGraph() {
		return this.worldGraph;
	}

	/**
	 * Gets the list of nodes that can be reached by the specified node through an
	 * edge
	 *
	 * @pre none
	 * @post none
	 * @param node whose adjacent nodes is to be determined
	 * @return the collection with all end nodes of outgoing edges from the
	 *         specified node
	 */
	public Collection<Node<Location>> getAdjacentLocations(Node<Location> node) {
		return this.worldGraph.getAdjacentNodes(node);
	}

	/**
	 * Sets the name
	 *
	 * @pre name != null AND !name.isEmpty()
	 * @post getName().equals(name)
	 * @param name the name of the world
	 */
	public void setName(String name) {
		if (name == null) {
			throw new IllegalArgumentException("name cannot be null");
		}
		if (name.isEmpty()) {
			throw new IllegalArgumentException("name cannot be empty");
		}
		this.name = name;
	}

	/**
	 * Sets the start node to the node with the specified location name
	 *
	 * @pre locationName != null AND (there exists a node v such that
	 *      this.worldGraph.getNodes().contains(v) and
	 *      locationName.equals(v.getValue().getName())
	 * @post getStartNode().equals(node)
	 * @param locationName the name of the location serving as start node
	 */
	public void setStartNode(String locationName) {
		if (locationName == null) {
			throw new IllegalArgumentException("node cannot be null");
		}
		Node<Location> node = this.getNode(locationName);
		if (node == null) {
			throw new IllegalArgumentException("the specified location must exist in this world");
		}
		this.startNode = node;
	}

	/**
	 * Gets the nodes with the specified location name
	 * 
	 * @param locationName the name of the location
	 * @return the node with the specified location name
	 */
	public Node<Location> getNode(String locationName) {
		for (Node<Location> node : this.worldGraph.getNodes()) {
			if (locationName.equals(node.getValue().getName())) {
				return node;
			}
		}
		return null;
	}
}
