// Generated from src/main/java/edu/sjsu/facetedJS/interpreter/parser/FacetedJavaScript.g4 by ANTLR 4.5.1

    package edu.sjsu.facetedJS.interpreter.parser;

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link FacetedJavaScriptParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface FacetedJavaScriptVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link FacetedJavaScriptParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(FacetedJavaScriptParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bareExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBareExpr(FacetedJavaScriptParser.BareExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code namedFunction}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNamedFunction(FacetedJavaScriptParser.NamedFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThenElse(FacetedJavaScriptParser.IfThenElseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ifThen}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfThen(FacetedJavaScriptParser.IfThenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code while}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhile(FacetedJavaScriptParser.WhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code doWhile}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDoWhile(FacetedJavaScriptParser.DoWhileContext ctx);
	/**
	 * Visit a parse tree produced by the {@code for}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFor(FacetedJavaScriptParser.ForContext ctx);
	/**
	 * Visit a parse tree produced by the {@code writeChl}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWriteChl(FacetedJavaScriptParser.WriteChlContext ctx);
	/**
	 * Visit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrintExpr(FacetedJavaScriptParser.PrintExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code alert}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAlert(FacetedJavaScriptParser.AlertContext ctx);
	/**
	 * Visit a parse tree produced by the {@code winOpen}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWinOpen(FacetedJavaScriptParser.WinOpenContext ctx);
	/**
	 * Visit a parse tree produced by the {@code returnExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReturnExpr(FacetedJavaScriptParser.ReturnExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlank(FacetedJavaScriptParser.BlankContext ctx);
	/**
	 * Visit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParens(FacetedJavaScriptParser.ParensContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PostIncDec}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostIncDec(FacetedJavaScriptParser.PostIncDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool(FacetedJavaScriptParser.BoolContext ctx);
	/**
	 * Visit a parse tree produced by the {@code string}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitString(FacetedJavaScriptParser.StringContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LocalAssign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLocalAssign(FacetedJavaScriptParser.LocalAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MD5Expr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMD5Expr(FacetedJavaScriptParser.MD5ExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code undefined}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUndefined(FacetedJavaScriptParser.UndefinedContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CreateLabel}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCreateLabel(FacetedJavaScriptParser.CreateLabelContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMulDivMod(FacetedJavaScriptParser.MulDivModContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjectExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjectExpr(FacetedJavaScriptParser.ObjectExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(FacetedJavaScriptParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GetLengthExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetLengthExpr(FacetedJavaScriptParser.GetLengthExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlusMinusSign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusMinusSign(FacetedJavaScriptParser.PlusMinusSignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code id}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(FacetedJavaScriptParser.IdContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PushExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPushExpr(FacetedJavaScriptParser.PushExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GlobalAssign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGlobalAssign(FacetedJavaScriptParser.GlobalAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAddSub(FacetedJavaScriptParser.AddSubContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DotExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDotExpr(FacetedJavaScriptParser.DotExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PreIncDec}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPreIncDec(FacetedJavaScriptParser.PreIncDecContext ctx);
	/**
	 * Visit a parse tree produced by the {@code SetSecurity}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetSecurity(FacetedJavaScriptParser.SetSecurityContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionApp}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionApp(FacetedJavaScriptParser.FunctionAppContext ctx);
	/**
	 * Visit a parse tree produced by the {@code int}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInt(FacetedJavaScriptParser.IntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArrayExpr(FacetedJavaScriptParser.ArrayExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DefcExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDefcExpr(FacetedJavaScriptParser.DefcExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code null}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNull(FacetedJavaScriptParser.NullContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ObjInstant}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitObjInstant(FacetedJavaScriptParser.ObjInstantContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BktExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBktExpr(FacetedJavaScriptParser.BktExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicComparison}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicComparison(FacetedJavaScriptParser.LogicComparisonContext ctx);
	/**
	 * Visit a parse tree produced by the {@code anonFunction}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonFunction(FacetedJavaScriptParser.AnonFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacetedJavaScriptParser#perms}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPerms(FacetedJavaScriptParser.PermsContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullBlock}
	 * labeled alternative in {@link FacetedJavaScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullBlock(FacetedJavaScriptParser.FullBlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code simpBlock}
	 * labeled alternative in {@link FacetedJavaScriptParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpBlock(FacetedJavaScriptParser.SimpBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacetedJavaScriptParser#params}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParams(FacetedJavaScriptParser.ParamsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacetedJavaScriptParser#args}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgs(FacetedJavaScriptParser.ArgsContext ctx);
	/**
	 * Visit a parse tree produced by {@link FacetedJavaScriptParser#array}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArray(FacetedJavaScriptParser.ArrayContext ctx);
	/**
	 * Visit a parse tree produced by the {@code fullObj}
	 * labeled alternative in {@link FacetedJavaScriptParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFullObj(FacetedJavaScriptParser.FullObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code emptObj}
	 * labeled alternative in {@link FacetedJavaScriptParser#object}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEmptObj(FacetedJavaScriptParser.EmptObjContext ctx);
	/**
	 * Visit a parse tree produced by the {@code keyPair}
	 * labeled alternative in {@link FacetedJavaScriptParser#pair}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitKeyPair(FacetedJavaScriptParser.KeyPairContext ctx);
}