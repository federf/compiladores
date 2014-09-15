
/*
 * Proyecto: Proyecto Compiladores 2014
 * Autores: Federico Franco, Bruno Isoardi
 *
 */
import java.io.*;
import java_cup.runtime.*; 

/**
 *
 * @author fede
 */
public class Compilador {

    /**
     * @param args the command line
     * arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Reader file;
        try {          
            file=new FileReader(args[0]);
            Yylex y= new Yylex(file);
            parser p = new parser(y);
            p.parse();
        }
        catch(Exception e) { System.out.println("ocurrio un error: "+e.getMessage());}
    }
    
}
