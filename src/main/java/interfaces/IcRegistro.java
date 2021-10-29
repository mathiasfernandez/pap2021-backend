package interfaces;


import datatypes.ModoCanje;
import java.util.Date;
import java.util.List;

import datatypes.DtFuncion;
import datatypes.DtRegistro;
import logica.Espectaculo;

public interface IcRegistro {

	public List<DtFuncion> listarFuncionesEspectaculo(Espectaculo espectaculo);
	public List<DtRegistro> listarRegistros();
	public void canjearRegistro(DtRegistro registro);
	public void confirmarRegistro();
	public void confirmarRegistro(String espectador, String funcion,Date fechaAlta,ModoCanje canje);
}
