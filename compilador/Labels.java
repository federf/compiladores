/* 
  Clase que almacena un entero y a partir
  de este genera un string distinto cada vez
  que se llama a su unico metodo.
  
*/

public class Labels {
	private static int l = 0;

	public static String getLabel() {
		return "Label "+(++l);
	}
} 