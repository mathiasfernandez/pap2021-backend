package exepciones;

public class CargaDePaqueteErronea extends Exception {
	private static final long serialVersionUID = 1L;
	
	public CargaDePaqueteErronea(String string) {
		super(string);
	}
}
