/*
Proyecto: Proyecto Compiladores 2014
Autores: Federico Franco, Bruno Isoardi
Funcionalidad: Clase que implementa un analizador lexico
*/
/*AQUI PUEDEN IR LOS IMPORTS */

import java_cup.runtime.Symbol;
%%
%state COMENTARIOSIMPLE
%state COMENTARIOMULTIPLE

%eofval{
 return new Symbol(sym.EOF, new String("Fin Del Archivo"));
%eofval}
%unicode
%line
%public
%cup
%class Yylex
int=[0-9]+
id=[a-zA-Z][a-zA-Z0-9_]*
string=[^"\""]
float=[0-9]+[.][0-9]+


%%
<YYINITIAL>{

    "//" {yybegin(COMENTARIOSIMPLE);}
    "/*" {yybegin(COMENTARIOMULTIPLE);}
    ">" {return new Symbol(sym.MAYOR, yychar, yyline, yytext());}
    "<" {return new Symbol(sym.MENOR, yychar, yyline, yytext());}
    "<=" {return new Symbol(sym.MENOR_IGUAL, yychar, yyline, yytext());}
    ">=" {return new Symbol(sym.MAYOR_IGUAL, yychar, yyline, yytext());}
    "+" {return new Symbol(sym.SUMA, yychar, yyline, yytext());}
    "-" {return new Symbol(sym.RESTA, yychar, yyline, yytext());}
    "*" {return new Symbol(sym.MULTIPLICACION, yychar, yyline, yytext());}
    "/" {return new Symbol(sym.DIVISION, yychar, yyline, yytext());}
    "%" {return new Symbol(sym.PORCENTAJE, yychar, yyline, yytext());}
    "=" {return new Symbol(sym.ASIGNACION, yychar, yyline, yytext());}
    "+=" {return new Symbol(sym.INCREMENTO, yychar, yyline, yytext());}
    "-=" {return new Symbol(sym.DECREMENTO, yychar, yyline, yytext());}
    "==" {return new Symbol(sym.IGUALDAD_LOGICA, yychar, yyline, yytext());}
    "!=" {return new Symbol(sym.DIFERENCIA_LOGICA, yychar, yyline, yytext());}

    "boolean" {return new Symbol(sym.BOOLEAN, yychar, yyline, yytext());}
    "break" {return new Symbol(sym.BREAK, yychar, yyline, yytext());}
    "class" {return new Symbol(sym.CLASS, yychar, yyline, yytext());}
    "continue" {return new Symbol(sym.CONTINUE, yychar, yyline, yytext());}
    "else" {return new Symbol(sym.ELSE, yychar, yyline, yytext());}
    "false" {return new Symbol(sym.FALSE, yychar, yyline, yytext());}
    "float" {return new Symbol(sym.FLOAT, yychar, yyline, yytext());}
    "for" {return new Symbol(sym.FOR, yychar, yyline, yytext());}
    "if" {return new Symbol(sym.IF, yychar, yyline, yytext());}
    "int" {return new Symbol(sym.INT, yychar, yyline, yytext());}
    "return" {return new Symbol(sym.RETURN, yychar, yyline, yytext());}
    "true" {return new Symbol(sym.TRUE, yychar, yyline, yytext());}
    "void" {return new Symbol(sym.VOID, yychar, yyline, yytext());}
    "while" {return new Symbol(sym.WHILE, yychar, yyline, yytext());}

    "," {return new Symbol(sym.COMA, yychar, yyline, yytext());}
    ";" {return new Symbol(sym.PUNTO_Y_COMA, yychar, yyline, yytext());}
    "{" {return new Symbol(sym.LLAVE_IZQ, yychar, yyline, yytext());}
    "}" {return new Symbol(sym.LLAVE_DER, yychar, yyline, yytext());}
    "(" {return new Symbol(sym.PARENTESIS_IZQ, yychar, yyline, yytext());}
    ")" {return new Symbol(sym.PARENTESIS_DER, yychar, yyline, yytext());}
    "[" {return new Symbol(sym.CORCHETE_IZQ, yychar, yyline, yytext());}
    "]" {return new Symbol(sym.CORCHETE_DER, yychar, yyline, yytext());}
    "externinvk" {return new Symbol(sym.EXTERNINVK, yychar, yyline, yytext());}
    "!" {return new Symbol(sym.ADMIRACION, yychar, yyline, yytext());}

    "&&" {return new Symbol(sym.CONJUNCION, yychar, yyline, yytext());}
    "||" {return new Symbol(sym.DISYUNCION, yychar, yyline, yytext());}
    
    [\t\r\n\f] {}

    {id} {return new Symbol(sym.ID, yychar, yyline, yytext());}
    {int} {return new Symbol(sym.INT_LITERAL, yychar, yyline, yytext());}
    {float} {return new Symbol(sym.FLOAT_LITERAL, yychar, yyline, yytext());}
    "\""{string}*"\"" {return new Symbol(sym.STRING_LITERAL, yychar, yyline, yytext());}

    " " {} /*espacio vacio*/

    . {System.out.println("error: "+yychar +" "+ yyline +" "+ yytext());}
}

<COMENTARIOSIMPLE>{
    [\n] {yybegin(YYINITIAL);}
    . {}
}

<COMENTARIOMULTIPLE>{
    "*/" {yybegin(YYINITIAL);}
    [\t\r\n\f] {}
    . {}
}
