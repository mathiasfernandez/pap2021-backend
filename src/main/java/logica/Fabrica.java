package logica;

import interfaces.*;


public class Fabrica {
	private static Fabrica instancia = null;
	
	private Fabrica(){}
	
	public static Fabrica getInstancia() {
		if (instancia == null)
			instancia = new Fabrica();
		return instancia;
	}
	
	public IcEspectaculo getIControladorEspectaculo() {
		return new CEspectaculo();
	}
	
	public IcPaquete getIControladorPaquete() {
		return new CPaquete();
	}
	
	public IcPlataforma getIControladorPlataforma() {
		return new CPlataforma();
	}
	
	public IcRegistro getIControladorRegistro() {
		return new CRegistro();
	}
	
	public IcUsuario getIControladorUsuario() {
		return new CUsuario();
	}

	
	public IcTest getIControladorTest() {
		return new CTest();
	}
}


