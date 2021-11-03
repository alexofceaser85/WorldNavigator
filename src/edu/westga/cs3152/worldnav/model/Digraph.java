package edu.westga.cs3152.worldnav.model;

import java.util.ArrayList;
import java.util.Collection;
/**
 * The Class Digraph
 * 
 * @param <T> the type of a node value
 * 
 * @author CS3152
 * @version Fall 2021
 */
public class Digraph<T> {

	private Collection<Node<T>> nodes;
	
	/**
	 * Creates a new Digraph
	 * 
	 * @precondition none
	 * @postcondition this.nodes == new ArrayList<Node<T>>
	 */
	public Digraph() {
		this.nodes = new ArrayList<Node<T>>();
	}
	
	/**
	 * Gets the nodes
	 *
	 * @pre none
	 * @post none
	 * @return a collection containing all nodes of this digraph
	 */
	public Collection<Node<T>> getNodes() {
		return this.nodes;
	}

	/**
	 * Gets the list of nodes that can be reached from the specified node through an
	 * edge
	 *
	 * @pre none
	 * @post none
	 * @param node whose adjacent nodes is to be determined
	 * @return a collection containing all end nodes of outgoing edges from the
	 *         specified node
	 */
	public Collection<Node<T>> getAdjacentNodes(Node<T> node) {
		Collection<Node<T>> adjacentNodes = new ArrayList<Node<T>>();
		
		for (T adjacentLocation : node.getAdjacentNodes()) {
			for (Node<T> currentNode : this.nodes) {
				if (currentNode.getValue().equals(adjacentLocation)) {
					adjacentNodes.add(currentNode);
				}
			}
		}
		
		return adjacentNodes;
	}
	
	/**
	 * Adds a node
	 * 
	 * @precondition nodeToAdd != null
	 * @postcondition this.nodes.length == this.nodes.length@prev + 1
	 * @param nodeToAdd the node to add
	 */
	public void addNode(Node<T> nodeToAdd) {
		if (nodeToAdd == null) {
			throw new IllegalArgumentException("Cannot add a null node");
		}
		this.nodes.add(nodeToAdd);
	}
}
