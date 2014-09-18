package ir;

import ir.ast.*;

// Abstract visitor
public interface ASTVisitor<T> {
// visit statements
	T visit(AssignStmt stmt);
	T visit(ReturnStmt stmt);
	T visit(IfStmt stmt);
	
// visit expressions
	T visit(BinOpExpr expr);;
	
// visit literals	
	T visit(IntLiteral lit);
    T visit(BoolLiteral bool);
    T visit(FloatLiteral flo);
    T visit(StringLiteral str);
    T visit(ArrayLiteral arr);

// visit locations	
	T visit(VarLocation loc);
// visit block	
	T visit(Block block);
// visit Loops
    T visit(ForStmt forStmt);
    T visit(WhileStmt whileStmt);
    T visit(LoopStmt loop);
// visit break
    T visit(BreakStmt breakStmt);
// visit continue
    T visit(ContinueStmt cont);
// visit operacion unaria
    T visit(UnaryOpExpr op);
// visit methodCall
    T visit(MethodCallStmt met);
    T visit(ExternInvkExpr eie);
}
