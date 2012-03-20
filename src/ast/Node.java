package ast;

import visitor.Visitor;


public abstract class Node {
	public Node left = null, right = null;
	public String nodeType = null;
	public abstract Object accept(Visitor v);
}

