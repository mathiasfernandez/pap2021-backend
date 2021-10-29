package exepciones;

public class FuncionYaExisteExcepcion extends Exception {

	private static final long serialVersionUID = 1L;
	
	public FuncionYaExisteExcepcion(String string) {
		super(string);
	}
	
}
