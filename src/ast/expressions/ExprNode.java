package ast.expressions;

import ast.Node;
import ast.PrimitiveType;

/*
 * need to add 	| actual_type
 * | function_call_for_expr
 * | list_element_call
 */
public abstract class ExprNode extends Node {
	public PrimitiveType nodeType = null;
	
} 

