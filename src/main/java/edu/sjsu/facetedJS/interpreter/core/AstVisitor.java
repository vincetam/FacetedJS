package edu.sjsu.facetedJS.interpreter.core;

import java.util.ArrayList;
import java.util.List;

import edu.sjsu.facetedJS.interpreter.parser.FacetedJavaScriptBaseVisitor;
import edu.sjsu.facetedJS.interpreter.parser.FacetedJavaScriptParser;

/*
 *  AST builder for evaluation purpose
 */

public class AstVisitor extends FacetedJavaScriptBaseVisitor<Element>{
	
	@Override
	public Statement visitProg(FacetedJavaScriptParser.ProgContext ctx) {
		List<Statement> stmts = new ArrayList<Statement>();
		for (int i=0; i<ctx.stat().size(); i++) {
			Statement exp = (Statement) visit(ctx.stat(i));
			if (exp != null) stmts.add(exp);
		}
		return listToSeqExp(stmts);
	}
	
	@Override
	public Statement visitPrintExpr(FacetedJavaScriptParser.PrintExprContext ctx) {
		Expression exp = (Expression) visit(ctx.expr());
		return new SystemLogExpr(exp);
	}
	
	@Override
	public Statement visitReturnExpr(FacetedJavaScriptParser.ReturnExprContext ctx) {
		Expression exp = (Expression) visit(ctx.expr());
		return new ReturnExpr(exp);
	}
	
	@Override
	public Statement visitBareExpr(FacetedJavaScriptParser.BareExprContext ctx) {
		return new Expr((Expression) visit(ctx.expr()));
	}
	
	@Override
	public Statement visitNamedFunction(FacetedJavaScriptParser.NamedFunctionContext ctx) {
		String funcName = ctx.ID().getText();
		List<String> params = new ArrayList<String>();
		for (int i=1; i<ctx.params().getChildCount()-1; i+=2) {
			params.add(ctx.params().getChild(i).getText());
		}
		List<Statement> exprList = new ArrayList<Statement>();
		for (int i=0; i<ctx.stat().size(); i++) {
			Statement exp = (Statement) visit(ctx.stat(i));
			exprList.add(exp);
		}
		Statement body = listToSeqExp(exprList);
		return new NamedFunctionExpr(funcName, params, body);
	}
	
	@Override
	public Statement visitIfThenElse(FacetedJavaScriptParser.IfThenElseContext ctx) {
		Expression cond = (Expression) visit(ctx.expr());
		Statement thn = (Statement) visit(ctx.block(0));
		Statement els = (Statement) visit(ctx.block(1));
		return new IfExpr(cond, thn, els);
	}
	
	@Override
	public Statement visitIfThen(FacetedJavaScriptParser.IfThenContext ctx) {
		Expression cond = (Expression) visit(ctx.expr());
		Statement thn = (Statement) visit(ctx.block());
		return new IfExpr(cond, thn, null);
	}
	
	@Override
	public Statement visitWhile(FacetedJavaScriptParser.WhileContext ctx) {
		Expression cond = (Expression) visit(ctx.expr());
		Statement body = (Statement) visit(ctx.block());
		return new WhileExpr(cond, body);
	}
	
	@Override
	public Statement visitDoWhile(FacetedJavaScriptParser.DoWhileContext ctx) {
		Expression cond = (Expression) visit(ctx.expr());
		Statement body = (Statement) visit(ctx.block());
		return new DoWhileExpr(cond, body);
	}

	@Override
	public Statement visitFor(FacetedJavaScriptParser.ForContext ctx) {
		Expression init = (Expression) visit(ctx.expr(0));
		Expression cond = (Expression) visit(ctx.expr(1));
		Expression inc = (Expression) visit(ctx.expr(2));
		Statement body = (Statement) visit(ctx.block());
		return new ForExpr(init, cond, inc, body);
	}
	
	@Override
	public Expression visitPlusMinusSign(FacetedJavaScriptParser.PlusMinusSignContext ctx) {
		Expression e = (Expression) visit(ctx.expr());
		return binOpExpHelper(ctx.op.getType(), e, null);
	}
	
	@Override
	public Expression visitPreIncDec(FacetedJavaScriptParser.PreIncDecContext ctx) {
		Expression varExpr = (Expression) visit(ctx.expr());
		int op = ctx.op.getType();
		if (op == FacetedJavaScriptParser.DEC) {
			return new IncDecExpr(varExpr, Operator.DEC, false);
		}
		return new IncDecExpr(varExpr, Operator.INC, false);
	}
	
	@Override
	public Expression visitPostIncDec(FacetedJavaScriptParser.PostIncDecContext ctx) {
		Expression varExpr = (Expression) visit(ctx.expr());
		int op = ctx.op.getType();
		if (op == FacetedJavaScriptParser.DEC) {
			return new IncDecExpr(varExpr, Operator.DEC, true);
		}
		return new IncDecExpr(varExpr, Operator.INC, true);
	}

	@Override
	public Expression visitMulDivMod(FacetedJavaScriptParser.MulDivModContext ctx) {
		Expression lhs = (Expression) visit(ctx.expr(0));
		Expression rhs = (Expression) visit(ctx.expr(1));
		return binOpExpHelper(ctx.op.getType(), lhs, rhs);
	}
	
	@Override
	public Expression visitAddSub(FacetedJavaScriptParser.AddSubContext ctx) {
		Expression lhs = (Expression) visit(ctx.expr(0));
		Expression rhs = (Expression) visit(ctx.expr(1));
		return binOpExpHelper(ctx.op.getType(), lhs, rhs);
	}
	
	@Override
	public Expression visitComparison(FacetedJavaScriptParser.ComparisonContext ctx) {
		Expression lhs = (Expression) visit(ctx.expr(0));
		Expression rhs = (Expression) visit(ctx.expr(1));
		return binOpExpHelper(ctx.op.getType(), lhs, rhs);
	}
	
	@Override
	public Expression visitLogicComparison(FacetedJavaScriptParser.LogicComparisonContext ctx) {
		Expression lhs = (Expression) visit(ctx.expr(0));
		Expression rhs = (Expression) visit(ctx.expr(1));
		return binOpExpHelper(ctx.op.getType(), lhs, rhs);
	}
	
	/**
	 * Converts binops from parser to binops from  interpreter,
	 * and then build a BinOpExpr.
	 */
	private Expression binOpExpHelper(int type, Expression lhs, Expression rhs) {
		Operator op = null;
		switch (type) {
		case FacetedJavaScriptParser.ADD:
			op = Operator.ADD;
			break;
		case FacetedJavaScriptParser.SUB:
			op = Operator.SUB;
			break;
		case FacetedJavaScriptParser.MUL:
			op = Operator.MUL;
			break;
		case FacetedJavaScriptParser.DIV:
			op = Operator.DIV;
			break;
		case FacetedJavaScriptParser.MOD:
			op = Operator.MOD;
			break;
		case FacetedJavaScriptParser.LT:
			op = Operator.LT;
			break;
		case FacetedJavaScriptParser.LE:
			op = Operator.LE;
			break;
		case FacetedJavaScriptParser.GT:
			op = Operator.GT;
			break;
		case FacetedJavaScriptParser.GE:
			op = Operator.GE;
			break;
		case FacetedJavaScriptParser.EQ:
			op = Operator.EQ;
			break;
		case FacetedJavaScriptParser.NEQ:
			op = Operator.NEQ;
			break;
		case FacetedJavaScriptParser.S_EQ:
			op = Operator.S_EQ;
			break;
		case FacetedJavaScriptParser.S_NEQ:
			op = Operator.S_NEQ;
			break;
		case FacetedJavaScriptParser.AND:
			op = Operator.AND;
			break;
		case FacetedJavaScriptParser.OR:
			op = Operator.OR;
			break;
		}
		if (rhs == null){			
			return new UnaOpExpr(op, lhs);
		}
		return new BinOpExpr(op, lhs, rhs);
	}
	
	@Override
	public Expression visitObjInstant(FacetedJavaScriptParser.ObjInstantContext ctx) {
		Expression f = (Expression) visit(ctx.expr());
		return new ObjectInstantExpr(f);
	}
	
	@Override
	public Expression visitFunctionApp(FacetedJavaScriptParser.FunctionAppContext ctx) {
		Expression f = (Expression) visit(ctx.expr());
		List<Expression> args = new ArrayList<Expression>();
		for (int i=1; i<ctx.args().getChildCount()-1; i+=2) {
			Expression arg = (Expression) visit(ctx.args().getChild(i));
			args.add(arg);
		}
		return new FunctionAppExpr(f, args);
	}
	
	@Override
	public Expression visitCreateLabel(FacetedJavaScriptParser.CreateLabelContext ctx) {
		return new LabelExpr();
	}
	
	@Override
	public Expression visitSetSecurity(FacetedJavaScriptParser.SetSecurityContext ctx) {
		Expression k = (Expression) visit(ctx.expr(0));
		Expression hi = (Expression) visit(ctx.expr(1));
		Expression lo = ctx.expr(2) != null ? (Expression) visit(ctx.expr(2)) : new ValueExpr(new UndefinedVal());
		return new SetSecurityExpr(k, hi, lo);
	}
	
	@Override
	public Expression visitDefcExpr(FacetedJavaScriptParser.DefcExprContext ctx) {
		Expression k = (Expression) visit(ctx.expr(0));
		Expression hi = (Expression) visit(ctx.expr(1));
		return new DefacetExpr(k, hi);
	}
	
	@Override
	public Statement visitWriteChl(FacetedJavaScriptParser.WriteChlContext ctx) {
		Expression labels = (Expression) visit(ctx.expr(0));
		Expression msg = (Expression) visit(ctx.expr(1));
		return new writeChannelExpr(labels, msg);
	}
	
	@Override
	public Statement visitAlert(FacetedJavaScriptParser.AlertContext ctx) {
		Expression msg = (Expression) visit(ctx.expr());
		return new AlertExpr(msg);
	}
	
	@Override
	public Statement visitWinOpen(FacetedJavaScriptParser.WinOpenContext ctx) {
		Expression url = (Expression) visit(ctx.expr());
		return new WinOpenExpr(url);
	}
	
	@Override
	public Expression visitAnonFunction(FacetedJavaScriptParser.AnonFunctionContext ctx) {
		List<String> params = new ArrayList<String>();
		for (int i=1; i<ctx.params().getChildCount()-1; i+=2) {
			params.add(ctx.params().getChild(i).getText());
		}
		List<Statement> exprList = new ArrayList<Statement>();
		for (int i=0; i<ctx.stat().size(); i++) {
			Statement exp = (Statement) visit(ctx.stat(i));
			exprList.add(exp);
		}
		Statement body = listToSeqExp(exprList);
		return new FunctionExpr(params, body);
	}
	
	@Override
	public Expression visitLocalAssign(FacetedJavaScriptParser.LocalAssignContext ctx) {
		String id = ctx.ID().getText();
		Expression exp = (Expression) visit(ctx.expr());
		Operator op = getAssignmentType(ctx.op.getType());
		return new VarDeclExpr(id, op, exp);
	}
	
	@Override
	public Expression visitGlobalAssign(FacetedJavaScriptParser.GlobalAssignContext ctx) {
		Expression varExpr = (Expression) visit(ctx.expr(0));
		Expression exp = (Expression) visit(ctx.expr(1));
		Operator op = getAssignmentType(ctx.op.getType());
		return new AssignExpr(varExpr, op, exp);
	}
	
	private Operator getAssignmentType(int type) {
		Operator op = null;
		switch (type) {
		case FacetedJavaScriptParser.ASSIGN_REG:
			op = Operator.ASSIGN_REG;
			break;
		case FacetedJavaScriptParser.ASSIGN_ADD:
			op = Operator.ASSIGN_ADD;
			break;
		case FacetedJavaScriptParser.ASSIGN_SUB:
			op = Operator.ASSIGN_SUB;
			break;
		case FacetedJavaScriptParser.ASSIGN_MUL:
			op = Operator.ASSIGN_MUL;
			break;
		case FacetedJavaScriptParser.ASSIGN_DIV:
			op = Operator.ASSIGN_DIV;
			break;
		}
		return op;
	}

	@Override
	public Expression visitInt(FacetedJavaScriptParser.IntContext ctx) {
		long val = Long.valueOf(ctx.INT().getText());
		return new ValueExpr(new IntVal(val));
	}
	
	@Override
	public Expression visitBool(FacetedJavaScriptParser.BoolContext ctx) {
		boolean val = Boolean.valueOf(ctx.BOOL().getText());
		return new ValueExpr(new BoolVal(val));
	}
	
	@Override
	public Expression visitString(FacetedJavaScriptParser.StringContext ctx) {
		String val = String.valueOf(ctx.STRING().getText());
		return new ValueExpr(new StringVal(stripString(val)));
	}
	
	
	@Override
	public Expression visitNull(FacetedJavaScriptParser.NullContext ctx) {
		return new ValueExpr(new NullVal());
	}
	
	@Override
	public Expression visitUndefined(FacetedJavaScriptParser.UndefinedContext ctx) {
		return new ValueExpr(new UndefinedVal());
	}
	
	@Override
	public Expression visitArrayExpr(FacetedJavaScriptParser.ArrayExprContext ctx) {
		ArrayExpr aryExpr = new ArrayExpr();
		for (int i=1; i < ctx.array().getChildCount()-1; i+=2) {
			Expression e = (Expression) visit(ctx.array().getChild(i));
			aryExpr.addElem(e);
		}
		return aryExpr;
	}
	
	@Override
	public Expression visitObjectExpr(FacetedJavaScriptParser.ObjectExprContext ctx) {
		ObjectExpr objExpr = new ObjectExpr();
		for (int i=1; i < ctx.object().getChildCount()-1; i+=2) {
			FacetedJavaScriptParser.KeyPairContext pair;
			pair = (FacetedJavaScriptParser.KeyPairContext) ctx.object().getChild(i);
			String propId = pair.ID().getText();
			Expression expr = (Expression) visit(pair.expr());
			objExpr.set(propId, expr);
		}
		return objExpr;
	}
	
	@Override
	public Expression visitBktExpr(FacetedJavaScriptParser.BktExprContext ctx) {
		Expression ref = (Expression) visit(ctx.expr(0));
		Expression propExpr = (Expression) visit(ctx.expr(1));
		return new BracketExpr(ref, propExpr);
	}
	
	@Override
	public Expression visitDotExpr(FacetedJavaScriptParser.DotExprContext ctx) {
		Expression ref = (Expression) visit(ctx.expr());
		String propID = ctx.ID().getText();
		return new DotExpr(ref, propID);
	}
	
	@Override
	public Expression visitPushExpr(FacetedJavaScriptParser.PushExprContext ctx) {
		Expression ref = (Expression) visit(ctx.expr(0));
		Expression elem = (Expression) visit(ctx.expr(1));
		return new PushExpr(ref, elem);
	}
	
	@Override
	public Expression visitGetLengthExpr(FacetedJavaScriptParser.GetLengthExprContext ctx) {
		Expression ref = (Expression) visit(ctx.expr());
		return new GetLengthExpr(ref);
	}
	
	@Override
	public Expression visitMD5Expr(FacetedJavaScriptParser.MD5ExprContext ctx) {
		Expression expr = (Expression) visit(ctx.expr());
		return new HashExpr(expr);
	}
	
	@Override
	public Expression visitId(FacetedJavaScriptParser.IdContext ctx) {
		String id = ctx.ID().getText();
		return new VarExpr(id);
	}

	@Override
	public Expression visitParens(FacetedJavaScriptParser.ParensContext ctx) {
		return (Expression) visit(ctx.expr());
	}
	
	@Override
	public Statement visitFullBlock(FacetedJavaScriptParser.FullBlockContext ctx) {
		List<Statement> stmts = new ArrayList<Statement>();
		for (int i=1; i<ctx.getChildCount()-1; i++) {
			Statement exp = (Statement) visit(ctx.getChild(i));
			stmts.add(exp);
		}
		return listToSeqExp(stmts);
	}
	
	/**
	 * Remove quote from string
	 */
	private String stripString(String str){
		return str.substring(1, str.length() - 1);
	}
	/**
	 * Converts a list of expressions to one sequence expression,
	 * if the list contained more than one expression.
	 */
	private Statement listToSeqExp(List<Statement> stmts) {
		if (stmts.isEmpty()) {
			return new Expr(new ValueExpr(new UndefinedVal()));
		}
		Statement exp = stmts.get(0);
		for (int i=1; i<stmts.size(); i++) {
			exp = new SeqExpr(exp, stmts.get(i));
		}
		return exp;
	}

	@Override
	public Statement visitSimpBlock(FacetedJavaScriptParser.SimpBlockContext ctx) {
		return (Statement) visit(ctx.stat());
	}
}
