/*AQUI PUEDEN IR LOS IMPORTS */
%%
%{
/*CODIGO USUARIO*/
/*Pequeña funcion para imprimir en pantalla*/

public void imprime(String foo){
System.out.println(foo);
}
%}
%class Yylex
%cup
%public
%full
%standalone
%char
%line
%eofval{
System.out.println("FIN DEL ARCHIVO");
break;
%eofval}
int=[+-][0-9]
id=[a-zA-Z][a-zA-Z0-9]*
string=["][a-zA-z0-9]*["]
real=[+-][0-9]+[.][0-9]+


%%
"+" {imprime("suma");}
"-" {imprime("resta");}
"*" {imprime("multiplicacion");}
"/" {imprime("division");}
"=" {imprime("asignacion");}
"+=" {imprime("incremento");}
"-=" {imprime("decremento");}
"==" {imprime("igualdadLogica");}
"boolean" {imprime("boolean");}
"break" {imprime("break");}
"class" {imprime("class");}
"continue" {imprime("continue");}
"else" {imprime("else");}
"false" {imprime("false");}
"float" {imprime("float");}
"for" {imprime("for");}
"if" {imprime("if");}
"int" {imprime("int");}
"return" {imprime("return");}
"true" {imprime("true");}
"void" {imprime("void");}
"while" {imprime("while");}


"//" {imprime("//");}

({int})+  {imprime("int");}

{id} {imprime("Identificador");}


(" ") {imprime("espacio");}

[\t\r\n\f] {}

. {System.out.println("error");}

