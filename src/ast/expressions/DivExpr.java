
   package ast.expressions; 

import ast.Visitor;

   public class DivExpr extends ExprNode {
   	public DivExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
   	public Object accept(Visitor v) { return v.visit(this); }
   }