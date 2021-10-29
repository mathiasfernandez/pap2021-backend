package logica;
import datatypes.ModoCanje;
import java.util.Date;
import java.util.List;

import datatypes.DtFuncion;
import datatypes.DtRegistro;
import interfaces.IcRegistro;

public class CRegistro implements IcRegistro {

	@Override
	public List<DtFuncion> listarFuncionesEspectaculo(Espectaculo espectaculo) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public List<DtRegistro> listarRegistros() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void canjearRegistro(DtRegistro registro) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void confirmarRegistro() {
		// TODO Auto-generated method stub
		
	}
	
	public void confirmarRegistro(String espectador, String funcion,Date fechaAlta,ModoCanje mc) {
		RegistroID idreg = new RegistroID();
		idreg.setEspectador(espectador);
		idreg.setFuncion(funcion);
		ManejadorRegistro mR = ManejadorRegistro.getInstancia();
		mR.confirmarRegistro(idreg, fechaAlta,mc);
	}

}
