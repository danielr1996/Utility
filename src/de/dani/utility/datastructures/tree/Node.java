package de.dani.utility.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class Node {
	private Object dt;
	private List<Node> childNodes;
	
	public Node(){
		childNodes = new ArrayList<Node>();	
	}
	
	public Node(Object dt){
		this.dt = dt;
		childNodes = new ArrayList<Node>();	
	}
	
	public Object getData() {
		return dt;
	}
	public void setData(Object dt) {
		this.dt = dt;
	}
	public List<Node> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<Node> childNodes) {
		this.childNodes = childNodes;
	}
	
	public void addChild(Node node){
		childNodes.add(node);
	}

	@Override
	public String toString() {
		return dt.toString();
	}
	
	public int size(){
		return childNodes.size();
	}
	
	public boolean isLeaf(){
		return !(childNodes.size() > 0);
	}
	
	public Node getChild(int i){
		return childNodes.get(i);
	}
	
	public void print(int n){
		for(int i = 0; i < n; i++){
			System.out.print("  ");
		}
		if(dt!=null)
		System.out.println(dt.toString());
		else
		System.out.println("a");
		if(childNodes.size() > 0){
			for(Node node : childNodes){
				node.print(n+1);
			}
		}
	}
}

