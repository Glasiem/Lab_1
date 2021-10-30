package com.glasiem.main;

public class VisitorClass extends GrammarBaseVisitor<Double>{
    @Override
    public Double visitMultiplicativeExpr(GrammarParser.MultiplicativeExprContext ctx) {
        double left = super.visit(ctx.expression(0));
        double right = super.visit(ctx.expression(1));
        if (ctx.operatorToken.getType()==GrammarLexer.MULTIPLY)
            return left*right;
        else return left/right;
    }

    @Override
    public Double visitExponentialExpr(GrammarParser.ExponentialExprContext ctx) {
        double left = super.visit(ctx.expression(0));
        double right = super.visit(ctx.expression(1));
        return Math.pow(left, right);
    }

    @Override
    public Double visitAdditiveExpr(GrammarParser.AdditiveExprContext ctx) {
        double left = visit(ctx.expression(0));
        double right = visit(ctx.expression(1));
        if (ctx.operatorToken.getType()==GrammarLexer.ADD)
            return left+right;
        else return left-right;
    }

    @Override
    public Double visitNumberExpr(GrammarParser.NumberExprContext ctx) {
        return Double.parseDouble(ctx.getText());
    }

    @Override
    public Double visitParenthesizedExpr(GrammarParser.ParenthesizedExprContext ctx) {
        return visit(ctx.expression());
    }

    @Override
    public Double visitComparativeExpr(GrammarParser.ComparativeExprContext ctx) {
        double left = visit(ctx.expression(0));
        double right = visit(ctx.expression(1));
        if (ctx.operatorToken.getType()==GrammarLexer.MAX)
            return Math.max(left, right);
        else return Math.min(left, right);
    }


    @Override
    public Double visitIncreaseExpr(GrammarParser.IncreaseExprContext ctx) {
        double expr = visit(ctx.expression());
        if (ctx.operatorToken.getType()==GrammarLexer.INC)
            return expr + 1;
        else return expr - 1;
    }
}
