package de.dani.utility.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

public class Node <T>{
	private T t;
	private List<Node<T>> childNodes;
	
	public Node(){
		childNodes = new ArrayList<Node<T>>();	
	}
	
	public Node(T t){
		this.t = t;
		childNodes = new ArrayList<Node<T>>();	
	}
	
	public T getData() {
		return t;
	}
	public void setData(T t) {
		this.t = t;
	}
	public List<Node<T>> getChildNodes() {
		return childNodes;
	}
	public void setChildNodes(List<Node<T>> childNodes) {
		this.childNodes = childNodes;
	}
	
	public void addChild(Node<T> node){
		childNodes.add(node);
	}

	@Override
	public String toString() {
		return t.toString();
	}
	
	public int size(){
		return childNodes.size();
	}
	
	public boolean isLeaf(){
		return !(childNodes.size() > 0);
	}
	
	public Node<T> getChild(int i){
		return childNodes.get(i);
	}
	
	public void print(int n){
		for(int i = 0; i < n; i++){
			System.out.print("  ");
		}
		if(t!=null)
		System.out.println(t.toString());
		else
		System.out.println("a");
		if(childNodes.size() > 0){
			for(Node<T> node : childNodes){
				node.print(n+1);
			}
		}
	}
}

