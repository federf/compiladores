/*AQUI PUEDEN IR LOS IMPORTS */

import java_cup.runtime.Symbol;
%%

%{
/*CODIGO USUARIO*/
%}
%class Yylex
%cup
%public
%full
%standalone
%char
%line
%eofval{
 return new Symbol(sym.EOF, new String("Fin Del Archivo"));
%eofval}
int=[-]?[0-9]+
id=[a-zA-Z][a-zA-Z0-9]*
string=["][!#$%&'()*+,-./0-9:;<=>?@A-Z\_`a-z{|}~]*["]
float=[-]?[0-9]+[.][0-9]+


%%
">" {return new Symbol(sym.mayor, yychar, yyline, yytext());}
"<" {return new Symbol(sym.menor, yychar, yyline, yytext());}
"<=" {return new Symbol(sym.menor_igual, yychar, yyline, yytext());}
">=" {return new Symbol(sym.mayor_igual, yychar, yyline, yytext());}
"+" {return new Symbol(sym.suma, yychar, yyline, yytext());}
"-" {return new Symbol(sym.resta, yychar, yyline, yytext());}
"*" {return new Symbol(sym.multiplicacion, yychar, yyline, yytext());}
"/" {return new Symbol(sym.division, yychar, yyline, yytext());}
"%" {return new Symbol(sym.porcentaje, yychar, yyline, yytext());}
"=" {return new Symbol(sym.asignacion, yychar, yyline, yytext());}
"+=" {return new Symbol(sym.incremento, yychar, yyline, yytext());}
"-=" {return new Symbol(sym.decremento, yychar, yyline, yytext());}
"==" {return new Symbol(sym.igualdad_logica, yychar, yyline, yytext());}
"!=" {return new Symbol(sym.diferencia_logica, yychar, yyline, yytext());}

"boolean" {return new Symbol(sym.boolean, yychar, yyline, yytext());}
"break" {return new Symbol(sym.break, yychar, yyline, yytext());}
"class" {return new Symbol(sym.class, yychar, yyline, yytext());}
"continue" {return new Symbol(sym.continue, yychar, yyline, yytext());}
"else" {return new Symbol(sym.else, yychar, yyline, yytext());}
"false" {return new Symbol(sym.false, yychar, yyline, yytext());}
"float" {return new Symbol(sym.float, yychar, yyline, yytext());}
"for" {return new Symbol(sym.for, yychar, yyline, yytext());}
"if" {return new Symbol(sym.if, yychar, yyline, yytext());}
"int" {return new Symbol(sym.int, yychar, yyline, yytext());}
"return" {return new Symbol(sym.return, yychar, yyline, yytext());}
"true" {return new Symbol(sym.true, yychar, yyline, yytext());}
"void" {return new Symbol(sym.void, yychar, yyline, yytext());}
"while" {return new Symbol(sym.while, yychar, yyline, yytext());}

"," {return new Symbol(sym.coma, yychar, yyline, yytext());}
";" {return new Symbol(sym.punto_y_coma, yychar, yyline, yytext());}
"{" {return new Symbol(sym.llave_izq, yychar, yyline, yytext());}
"}" {return new Symbol(sym.llave_der, yychar, yyline, yytext());}
"(" {return new Symbol(sym.parentesis_izq, yychar, yyline, yytext());}
")" {return new Symbol(sym.parentesis_der, yychar, yyline, yytext());}
"[" {return new Symbol(sym.corchete_izq, yychar, yyline, yytext());}
"]" {return new Symbol(sym.corchete_der, yychar, yyline, yytext());}
"externalinvk" {return new Symbol(sym.externalinvk, yychar, yyline, yytext());}
"!" {return new Symbol(sym.admiracion, yychar, yyline, yytext());}

"&&" {return new Symbol(sym.conjuncion, yychar, yyline, yytext());}
"||" {return new Symbol(sym.disyuncion, yychar, yyline, yytext());}


"//" {return new Symbol(sym.comentario_simple, yychar, yyline, yytext());}

{id} {return new Symbol(sym.id, yychar, yyline, yytext());}
{int} {return new Symbol(sym.int_literal, yychar, yyline, yytext());}
{float} {return new Symbol(sym.float_literal, yychar, yyline, yytext());}
{string} {return new Symbol(sym.string_literal, yychar, yyline, yytext());}


(" ") {return new Symbol(sym.espacio, yychar, yyline, yytext());}

[\t\r\n\f] {}

. {System.out.println("error");}

