package de.dani.utility.datastructures.tree;

public class Tree extends Node{
	public Tree(Object dt){
		super(dt);
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

