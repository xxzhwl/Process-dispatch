package com;
public class Pcb {
	String name;
	int runTime;
	int prior;
	String state;
	int runedTime;
	int waitPoint;
	int waitTime;
	int waitedTime;
	public Pcb(){}
	@Override
	public String toString(){
        return name+"\t"+runTime+"\t"+prior+"\t"+state+"\t"+runedTime+"\t"+waitPoint+"\t"+waitTime+"\t"+waitedTime;
	}
}
