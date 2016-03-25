// Generated from src/main/java/edu/sjsu/facetedJS/interpreter/parser/FacetedJavaScript.g4 by ANTLR 4.5.1

    package edu.sjsu.facetedJS.interpreter.parser;

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link FacetedJavaScriptParser}.
 */
public interface FacetedJavaScriptListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link FacetedJavaScriptParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(FacetedJavaScriptParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacetedJavaScriptParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(FacetedJavaScriptParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bareExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBareExpr(FacetedJavaScriptParser.BareExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bareExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBareExpr(FacetedJavaScriptParser.BareExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code namedFunction}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterNamedFunction(FacetedJavaScriptParser.NamedFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code namedFunction}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitNamedFunction(FacetedJavaScriptParser.NamedFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfThenElse(FacetedJavaScriptParser.IfThenElseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifThenElse}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfThenElse(FacetedJavaScriptParser.IfThenElseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ifThen}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterIfThen(FacetedJavaScriptParser.IfThenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ifThen}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitIfThen(FacetedJavaScriptParser.IfThenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code while}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWhile(FacetedJavaScriptParser.WhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code while}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWhile(FacetedJavaScriptParser.WhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code doWhile}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterDoWhile(FacetedJavaScriptParser.DoWhileContext ctx);
	/**
	 * Exit a parse tree produced by the {@code doWhile}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitDoWhile(FacetedJavaScriptParser.DoWhileContext ctx);
	/**
	 * Enter a parse tree produced by the {@code for}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterFor(FacetedJavaScriptParser.ForContext ctx);
	/**
	 * Exit a parse tree produced by the {@code for}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitFor(FacetedJavaScriptParser.ForContext ctx);
	/**
	 * Enter a parse tree produced by the {@code writeChl}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWriteChl(FacetedJavaScriptParser.WriteChlContext ctx);
	/**
	 * Exit a parse tree produced by the {@code writeChl}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWriteChl(FacetedJavaScriptParser.WriteChlContext ctx);
	/**
	 * Enter a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterPrintExpr(FacetedJavaScriptParser.PrintExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code printExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitPrintExpr(FacetedJavaScriptParser.PrintExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code alert}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterAlert(FacetedJavaScriptParser.AlertContext ctx);
	/**
	 * Exit a parse tree produced by the {@code alert}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitAlert(FacetedJavaScriptParser.AlertContext ctx);
	/**
	 * Enter a parse tree produced by the {@code winOpen}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterWinOpen(FacetedJavaScriptParser.WinOpenContext ctx);
	/**
	 * Exit a parse tree produced by the {@code winOpen}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitWinOpen(FacetedJavaScriptParser.WinOpenContext ctx);
	/**
	 * Enter a parse tree produced by the {@code returnExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterReturnExpr(FacetedJavaScriptParser.ReturnExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code returnExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitReturnExpr(FacetedJavaScriptParser.ReturnExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code blank}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void enterBlank(FacetedJavaScriptParser.BlankContext ctx);
	/**
	 * Exit a parse tree produced by the {@code blank}
	 * labeled alternative in {@link FacetedJavaScriptParser#stat}.
	 * @param ctx the parse tree
	 */
	void exitBlank(FacetedJavaScriptParser.BlankContext ctx);
	/**
	 * Enter a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterParens(FacetedJavaScriptParser.ParensContext ctx);
	/**
	 * Exit a parse tree produced by the {@code parens}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitParens(FacetedJavaScriptParser.ParensContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PostIncDec}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPostIncDec(FacetedJavaScriptParser.PostIncDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PostIncDec}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPostIncDec(FacetedJavaScriptParser.PostIncDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBool(FacetedJavaScriptParser.BoolContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bool}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBool(FacetedJavaScriptParser.BoolContext ctx);
	/**
	 * Enter a parse tree produced by the {@code string}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterString(FacetedJavaScriptParser.StringContext ctx);
	/**
	 * Exit a parse tree produced by the {@code string}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitString(FacetedJavaScriptParser.StringContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LocalAssign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLocalAssign(FacetedJavaScriptParser.LocalAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LocalAssign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLocalAssign(FacetedJavaScriptParser.LocalAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MD5Expr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMD5Expr(FacetedJavaScriptParser.MD5ExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MD5Expr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMD5Expr(FacetedJavaScriptParser.MD5ExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code undefined}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterUndefined(FacetedJavaScriptParser.UndefinedContext ctx);
	/**
	 * Exit a parse tree produced by the {@code undefined}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitUndefined(FacetedJavaScriptParser.UndefinedContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CreateLabel}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterCreateLabel(FacetedJavaScriptParser.CreateLabelContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CreateLabel}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitCreateLabel(FacetedJavaScriptParser.CreateLabelContext ctx);
	/**
	 * Enter a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterMulDivMod(FacetedJavaScriptParser.MulDivModContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MulDivMod}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitMulDivMod(FacetedJavaScriptParser.MulDivModContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjectExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterObjectExpr(FacetedJavaScriptParser.ObjectExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjectExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitObjectExpr(FacetedJavaScriptParser.ObjectExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterComparison(FacetedJavaScriptParser.ComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Comparison}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitComparison(FacetedJavaScriptParser.ComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GetLengthExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGetLengthExpr(FacetedJavaScriptParser.GetLengthExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GetLengthExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGetLengthExpr(FacetedJavaScriptParser.GetLengthExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PlusMinusSign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPlusMinusSign(FacetedJavaScriptParser.PlusMinusSignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PlusMinusSign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPlusMinusSign(FacetedJavaScriptParser.PlusMinusSignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code id}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterId(FacetedJavaScriptParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by the {@code id}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitId(FacetedJavaScriptParser.IdContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PushExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPushExpr(FacetedJavaScriptParser.PushExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PushExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPushExpr(FacetedJavaScriptParser.PushExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GlobalAssign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterGlobalAssign(FacetedJavaScriptParser.GlobalAssignContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GlobalAssign}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitGlobalAssign(FacetedJavaScriptParser.GlobalAssignContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAddSub(FacetedJavaScriptParser.AddSubContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AddSub}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAddSub(FacetedJavaScriptParser.AddSubContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DotExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDotExpr(FacetedJavaScriptParser.DotExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DotExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDotExpr(FacetedJavaScriptParser.DotExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code PreIncDec}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterPreIncDec(FacetedJavaScriptParser.PreIncDecContext ctx);
	/**
	 * Exit a parse tree produced by the {@code PreIncDec}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitPreIncDec(FacetedJavaScriptParser.PreIncDecContext ctx);
	/**
	 * Enter a parse tree produced by the {@code SetSecurity}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterSetSecurity(FacetedJavaScriptParser.SetSecurityContext ctx);
	/**
	 * Exit a parse tree produced by the {@code SetSecurity}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitSetSecurity(FacetedJavaScriptParser.SetSecurityContext ctx);
	/**
	 * Enter a parse tree produced by the {@code FunctionApp}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterFunctionApp(FacetedJavaScriptParser.FunctionAppContext ctx);
	/**
	 * Exit a parse tree produced by the {@code FunctionApp}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitFunctionApp(FacetedJavaScriptParser.FunctionAppContext ctx);
	/**
	 * Enter a parse tree produced by the {@code int}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterInt(FacetedJavaScriptParser.IntContext ctx);
	/**
	 * Exit a parse tree produced by the {@code int}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitInt(FacetedJavaScriptParser.IntContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterArrayExpr(FacetedJavaScriptParser.ArrayExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ArrayExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitArrayExpr(FacetedJavaScriptParser.ArrayExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code DefcExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterDefcExpr(FacetedJavaScriptParser.DefcExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code DefcExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitDefcExpr(FacetedJavaScriptParser.DefcExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code null}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterNull(FacetedJavaScriptParser.NullContext ctx);
	/**
	 * Exit a parse tree produced by the {@code null}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitNull(FacetedJavaScriptParser.NullContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ObjInstant}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterObjInstant(FacetedJavaScriptParser.ObjInstantContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ObjInstant}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitObjInstant(FacetedJavaScriptParser.ObjInstantContext ctx);
	/**
	 * Enter a parse tree produced by the {@code BktExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterBktExpr(FacetedJavaScriptParser.BktExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code BktExpr}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitBktExpr(FacetedJavaScriptParser.BktExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LogicComparison}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterLogicComparison(FacetedJavaScriptParser.LogicComparisonContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LogicComparison}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitLogicComparison(FacetedJavaScriptParser.LogicComparisonContext ctx);
	/**
	 * Enter a parse tree produced by the {@code anonFunction}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterAnonFunction(FacetedJavaScriptParser.AnonFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code anonFunction}
	 * labeled alternative in {@link FacetedJavaScriptParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitAnonFunction(FacetedJavaScriptParser.AnonFunctionContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacetedJavaScriptParser#perms}.
	 * @param ctx the parse tree
	 */
	void enterPerms(FacetedJavaScriptParser.PermsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacetedJavaScriptParser#perms}.
	 * @param ctx the parse tree
	 */
	void exitPerms(FacetedJavaScriptParser.PermsContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullBlock}
	 * labeled alternative in {@link FacetedJavaScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterFullBlock(FacetedJavaScriptParser.FullBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullBlock}
	 * labeled alternative in {@link FacetedJavaScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitFullBlock(FacetedJavaScriptParser.FullBlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code simpBlock}
	 * labeled alternative in {@link FacetedJavaScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void enterSimpBlock(FacetedJavaScriptParser.SimpBlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code simpBlock}
	 * labeled alternative in {@link FacetedJavaScriptParser#block}.
	 * @param ctx the parse tree
	 */
	void exitSimpBlock(FacetedJavaScriptParser.SimpBlockContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacetedJavaScriptParser#params}.
	 * @param ctx the parse tree
	 */
	void enterParams(FacetedJavaScriptParser.ParamsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacetedJavaScriptParser#params}.
	 * @param ctx the parse tree
	 */
	void exitParams(FacetedJavaScriptParser.ParamsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacetedJavaScriptParser#args}.
	 * @param ctx the parse tree
	 */
	void enterArgs(FacetedJavaScriptParser.ArgsContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacetedJavaScriptParser#args}.
	 * @param ctx the parse tree
	 */
	void exitArgs(FacetedJavaScriptParser.ArgsContext ctx);
	/**
	 * Enter a parse tree produced by {@link FacetedJavaScriptParser#array}.
	 * @param ctx the parse tree
	 */
	void enterArray(FacetedJavaScriptParser.ArrayContext ctx);
	/**
	 * Exit a parse tree produced by {@link FacetedJavaScriptParser#array}.
	 * @param ctx the parse tree
	 */
	void exitArray(FacetedJavaScriptParser.ArrayContext ctx);
	/**
	 * Enter a parse tree produced by the {@code fullObj}
	 * labeled alternative in {@link FacetedJavaScriptParser#object}.
	 * @param ctx the parse tree
	 */
	void enterFullObj(FacetedJavaScriptParser.FullObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code fullObj}
	 * labeled alternative in {@link FacetedJavaScriptParser#object}.
	 * @param ctx the parse tree
	 */
	void exitFullObj(FacetedJavaScriptParser.FullObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code emptObj}
	 * labeled alternative in {@link FacetedJavaScriptParser#object}.
	 * @param ctx the parse tree
	 */
	void enterEmptObj(FacetedJavaScriptParser.EmptObjContext ctx);
	/**
	 * Exit a parse tree produced by the {@code emptObj}
	 * labeled alternative in {@link FacetedJavaScriptParser#object}.
	 * @param ctx the parse tree
	 */
	void exitEmptObj(FacetedJavaScriptParser.EmptObjContext ctx);
	/**
	 * Enter a parse tree produced by the {@code keyPair}
	 * labeled alternative in {@link FacetedJavaScriptParser#pair}.
	 * @param ctx the parse tree
	 */
	void enterKeyPair(FacetedJavaScriptParser.KeyPairContext ctx);
	/**
	 * Exit a parse tree produced by the {@code keyPair}
	 * labeled alternative in {@link FacetedJavaScriptParser#pair}.
	 * @param ctx the parse tree
	 */
	void exitKeyPair(FacetedJavaScriptParser.KeyPairContext ctx);
}