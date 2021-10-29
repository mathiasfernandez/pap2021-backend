package interfaces;
import java.util.*;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;
import exepciones.UsuarioRepetidoExepcion;
import logica.Artista;
import logica.Usuario;
import logica.UsuariosSeguidos;
import logica.UsuariosSeguidosID;

public interface IcUsuario {
	
	public void confirmarAltaUsuario(DtUsuario us) throws UsuarioRepetidoExepcion;
	public List<DtUsuario> getUsuarios();
	public String[] getArtistas();
	public String[] listarUsuarios();
	public Artista getArtista(String nickname);
	public DtUsuario getDtUsuario(String nickname);
	public String[] obtenerEspectadores();
	public boolean validarIngreso(String user, String contra);
	public void seguirUsuario(String seguidor, String usuarioSeguido);
	public void dejarDeSeguirUsuario(String seguidor, String usuarioSeguido);
	public void cargarImagenUrl(String us, String imagen);
	public boolean yaLoSigo(String seguidor, String seguido);
	/*
	public DtArtista getDtArtista(String nickname);
	public DtEspectador getDtEspectador(String nickname);
	*/
	void actualizarUsuario(DtUsuario us);
	String[] usuariosSeguidos(String nickname);
	String[] usuariosMeSiguen(String nickname);
}
