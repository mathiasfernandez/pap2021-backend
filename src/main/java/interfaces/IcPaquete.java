package interfaces;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import datatypes.DtPaquete;
import logica.Espectaculo;

public interface IcPaquete {
	public void confirmarAltaPaquete();
	public DtPaquete seleccionarPaquete(String nombre);
	public ArrayList<String> listarPaquetes();
	public ArrayList<String> listarPlataformas();
	public ArrayList<String> listaEspectaculosNOPAQUETE(String plataforma, String paquete);
	public void agregarEspectaculoAPaquete(String paquete, String Espectaculo);
	public void agregarPaquete(String nombrePac, String descripcion, Date fInicio, Date fFinal, Integer descuento, Date fechaDeAlta,List<Espectaculo> espectaculos);
	public boolean ExistePaquete(String nombre);
	public DtPaquete infoPaquete(String nombre);
}
