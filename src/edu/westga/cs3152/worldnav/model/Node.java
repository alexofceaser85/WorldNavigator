package edu.westga.cs3152.worldnav.model;

/**
 * The Class Node
 * 
 * @param <T> the type of a node value
 * 
 * @author CS3152
 * @version Fall 2021
 */
public class Node<T> {
 	private T value;
 	private T[] adjacentNodes;
 	
 	/**
 	 * Creates a new node
 	 * 
 	 * @precondition value != null && adjacentNodes != null
 	 * @postcondition: this.value == value && this.adjacentNodes == adjacentNodes
 	 * @param value the node value
 	 * @param adjacentNodes the nodes adjacent to the node
 	 */
 	public Node(T value, T[] adjacentNodes) {
 		if (value == null) {
 			throw new IllegalArgumentException("Cannot create a new node with a null value");
 		}
 		if (adjacentNodes == null) {
 			throw new IllegalArgumentException("Cannot create a new node with a null adjacent nodes");
 		}
 		
 		this.value = value;
 		this.adjacentNodes = adjacentNodes;
 	}
 	
	/**
	 * Gets the value of this node
	 *
	 * @pre none
	 * @post none
	 * @return the value of this node
	 */
	public T getValue() {
		return this.value;
	}
	
	/**
	 * Gets the adjacent nodes
	 * 
	 * @precondition none
	 * @postcondition none
	 * @return the adjacent nodes
	 */
	public T[] getAdjacentNodes() {
		return this.adjacentNodes;
	}
}
