package ast;


public abstract class Node {
	public Node left = null, right = null;
	public abstract Object accept(Visitor v);
}

