package de.dani.utility.datastructures.tree;

public class Tree<T> extends Node<T>{
	public Tree(T t){
		super(t);
	}
	
	public Tree(){}
	
	@Override
	public String toString() {
		return "Arbeitsagentur";
	}

	public void print() {
		super.print(0);
	}
}

