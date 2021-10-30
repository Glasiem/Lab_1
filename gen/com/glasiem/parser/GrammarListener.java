// Generated from F:/IdeaProjects/Lab1/src/main/java/com/glasiem/parser\Grammar.g4 by ANTLR 4.9.1
package com.glasiem.parser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GrammarParser}.
 */
public interface GrammarListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code MultiplicativeExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterMultiplicativeExpr(GrammarParser.MultiplicativeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code MultiplicativeExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitMultiplicativeExpr(GrammarParser.MultiplicativeExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ExponentialExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExponentialExpr(GrammarParser.ExponentialExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ExponentialExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExponentialExpr(GrammarParser.ExponentialExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AdditiveExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAdditiveExpr(GrammarParser.AdditiveExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AdditiveExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAdditiveExpr(GrammarParser.AdditiveExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNumberExpr(GrammarParser.NumberExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code NumberExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNumberExpr(GrammarParser.NumberExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IncreaseExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterIncreaseExpr(GrammarParser.IncreaseExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IncreaseExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitIncreaseExpr(GrammarParser.IncreaseExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterParenthesizedExpr(GrammarParser.ParenthesizedExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ParenthesizedExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitParenthesizedExpr(GrammarParser.ParenthesizedExprContext ctx);
	/**
	 * Enter a parse tree produced by the {@code ComparativeExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterComparativeExpr(GrammarParser.ComparativeExprContext ctx);
	/**
	 * Exit a parse tree produced by the {@code ComparativeExpr}
	 * labeled alternative in {@link GrammarParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitComparativeExpr(GrammarParser.ComparativeExprContext ctx);
}