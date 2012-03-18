
   package ast.expressions; 

import ast.Visitor;

   public class AndExpr extends ExprNode {
   	public AndExpr(ExprNode l, ExprNode r) { left = l ; right = r; }
   	public Object accept(Visitor v) { return v.visit(this); }
   }