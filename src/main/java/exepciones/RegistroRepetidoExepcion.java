package exepciones;

public class RegistroRepetidoExepcion extends Exception {

	private static final long serialVersionUID = 1L;
	
	public RegistroRepetidoExepcion(String string) {
		super(string);
	}
}
