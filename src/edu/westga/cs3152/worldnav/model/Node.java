package edu.westga.cs3152.worldnav.model;

import java.util.Collection;

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
 	
 	public Node(T value, T[] adjacentNodes) {
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
	
	public T[] getAdjacentNodes() {
		return this.adjacentNodes;
	}
}
