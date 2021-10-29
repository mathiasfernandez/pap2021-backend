package interfaces;
import exepciones.PlataformaRepetidaExepcion;
import logica.Plataforma;


public interface IcPlataforma {
	public String[] getPlataformas();
	public void confirmarAltaPlataforma(String nombre, String desc, String url) throws PlataformaRepetidaExepcion;
	public boolean existePlataforma(String nombre);
	public Plataforma buscarPlataforma(String nombre);
}
