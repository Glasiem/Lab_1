grammar Grammar;

expression :
LPAREN expression RPAREN #ParenthesizedExpr
| operatorToken=(INC | DEC) expression #IncreaseExpr
| expression EXPONENT expression #ExponentialExpr
| expression operatorToken=(MULTIPLY | DIVIDE) expression #MultiplicativeExpr
| expression operatorToken=(ADD | SUBTRACT) expression #AdditiveExpr
| operatorToken=(MAX | MIN) LPAREN expression COMA expression RPAREN #ComparativeExpr
| NUMBER #NumberExpr
;


NUMBER : INT ('.' INT)?;

INT : ('0'..'9')+;

INC : 'inc';
DEC : 'dec';
MAX : 'max';
MIN : 'min';
COMA: ',';
EXPONENT : '^';
MULTIPLY : '*';
DIVIDE : '/';
SUBTRACT : '-';
ADD : '+';
LPAREN : '(';
RPAREN : ')';

WS : [ \t\r\n] -> channel(HIDDEN);