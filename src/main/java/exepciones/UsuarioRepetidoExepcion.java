package exepciones;

public class UsuarioRepetidoExepcion extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UsuarioRepetidoExepcion(String string) {
		super(string);
	}

}
