javac *.java
jflex Lexer.lex
java java_cup.Main parser.cup
javac -d . parser.java sym.java Yylex.java
javac Compilador.java
