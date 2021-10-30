package com.glasiem.app;

import com.glasiem.main.GrammarLexer;
import com.glasiem.main.GrammarParser;
import com.glasiem.main.ThrowingErrorListener;
import com.glasiem.main.VisitorClass;
import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.HashSet;

public class Evaluate {

    public static String link(String expression, HashSet<String> set, Object[][] otherSide) throws Exception {
        char c;
        String temp = "";
        int i = 0;
        do{
            c = expression.charAt(i);
            if (c == '#') {
                String cell = "#" + expression.charAt(i + 1) + expression.charAt(i + 2);
                if (!set.contains(cell)) {
                    set.add(cell);
                    int row = Character.getNumericValue(expression.charAt(i + 2)) - 1;
                    int column = (expression.charAt(i + 1) - 'A');
                    String toEvaluate = link((String) otherSide[row][column], set, otherSide);
                    temp += evaluate(toEvaluate);
                    i += 3;
                    set.remove(cell);
                }
                else
                {
                    temp = "ERROR";
                    return temp;
                }
            }
            else
            {
                temp += c;
                i++;
            }
        }
        while(i < expression.length());
        return temp;
    }


    public static double evaluate(String expression) {
        GrammarLexer lexer = new GrammarLexer(new ANTLRInputStream(expression));
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ThrowingErrorListener());
        CommonTokenStream tokenStream = new CommonTokenStream(lexer);
        GrammarParser parser = new GrammarParser(tokenStream);
        ParseTree tree = parser.expression();
        VisitorClass visitor = new VisitorClass();
        return visitor.visit(tree);
    }
}
