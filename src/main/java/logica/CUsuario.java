package logica;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.swing.JOptionPane;


import conexion.Conexion;
import datatypes.DtUsuario;
import datatypes.DtArtista;
import datatypes.DtEspectador;
import exepciones.FuncionYaExisteExcepcion;
import exepciones.UsuarioRepetidoExepcion;
import logica.ManejadorUsuario;
import interfaces.IcUsuario;
import org.apache.commons.codec.digest.DigestUtils;
public class CUsuario implements IcUsuario {

	@Override
	public void confirmarAltaUsuario(DtUsuario us) throws UsuarioRepetidoExepcion {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
			if (mU.ExisteUsuarioNickName(us.getNickname()))
						throw new UsuarioRepetidoExepcion("Ya existe un usuario con el nickname " + us.getNickname());
			else if (mU.ExisteUsuarioCorreo(us.getCorreo()))
				throw new UsuarioRepetidoExepcion("Ya existe un usuario con el correo " + us.getCorreo());
			else {
				Usuario nuevoUsuario = null;
				String encriptMD5 = DigestUtils.md5Hex(us.getContrasena());
				if (us instanceof DtArtista)
					nuevoUsuario= new Artista(us.getNickname(),us.getNombre(),us.getApellido(),us.getCorreo(),us.getfNac(),((DtArtista) us).getDescripcion(),((DtArtista) us).getBibliografia(),((DtArtista) us).getSitio_web(),null,encriptMD5 ,us.getImagen());
				if (us instanceof DtEspectador)
					nuevoUsuario= new Espectador (us.getNickname(),us.getNombre(),us.getApellido(),us.getCorreo(),us.getfNac(), encriptMD5, us.getImagen());
				mU.agregarUsuario(nuevoUsuario);
				}
			}

	@Override
	public List<DtUsuario> getUsuarios() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public String[] usuariosSeguidos(String nickname) {
		
		ArrayList<String> usuarios;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia(); // obtener el manejador para leer los items
		usuarios = mU.usuariosSeguidos(nickname);
		String [] usuario_ret = new String [usuarios.size()];
		int i = 0;
		for(String u:usuarios) {
			usuario_ret[i] = u;
			i++;
		}
		return usuario_ret;		
		
	}
	
	public String[] getArtistas() {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia(); // obtener el manejador para leer los items
		List<Artista> artistas = mU.getArtistas();	// listar los usuarios existentes en el manejador
		
		String[] retorno = new String[artistas.size()];
		int i=0;
		for(Artista a:artistas) {
			retorno[i] = a.getNickname();
			i++;
		}
		
		return retorno;
	}

	@Override
	public String[] listarUsuarios() {
		ArrayList<String> usuarios;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia(); // obtener el manejador para leer los items
		usuarios = mU.obtenerUsuarios();
		String [] usuario_ret = new String [usuarios.size()];
		int i = 0;
		for(String u:usuarios) {
			usuario_ret[i] = u;
			i++;
		}
		return usuario_ret;		
	}
	
	
	public Artista getArtista(String nickname) {
		Artista art = null;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		List<Artista> auxiliar = mU.getArtistas();
		for(Artista u: auxiliar) {
			if(u.getNickname().equals(nickname)) {
				art = u;
			}
		}
		return art;
	}

	public String[] obtenerEspectadores(){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		String[] retorno = mU.obtenerEspectadores();
		return retorno;
	}
	
	@Override
	public DtUsuario getDtUsuario(String nickname) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		DtUsuario u = mU.buscarDtUsuario(nickname);
		return u;
	}
	
	@Override
	public void actualizarUsuario(DtUsuario us) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		mU.actualizarUsuario(us);
	}
	
	public boolean validarIngreso(String user, String contra) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		boolean retorno = mU.validarLogin(user, contra);
		return retorno;
	}
	
	public void seguirUsuario(String seguidor, String usuarioSeguido)
	{
		UsuariosSeguidosID id = new UsuariosSeguidosID();
		id.setSeguidor(seguidor);
		id.setUsuarioSeguido(usuarioSeguido);
		UsuariosSeguidos us = new UsuariosSeguidos();
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario seguidor1 = mU.buscarUsuario(id.getSeguidor());
		us.setSeguidor(seguidor1);
		Usuario usuarioSeguido1 = mU.buscarUsuario(id.getUsuarioSeguido());
		us.setUsuarioSeguido(usuarioSeguido1);
		mU.seguirUsuario(us);
	}
	
	public void dejarDeSeguirUsuario(String seguidor, String usuarioSeguido) {
		UsuariosSeguidosID id = new UsuariosSeguidosID();
		id.setSeguidor(seguidor);
		id.setUsuarioSeguido(usuarioSeguido);
		
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		
		UsuariosSeguidos us = new UsuariosSeguidos();
		
		Usuario seguidor1 = mU.buscarUsuario(id.getSeguidor());
		us.setSeguidor(seguidor1);
		
		Usuario usuarioSeguido1 = mU.buscarUsuario(id.getUsuarioSeguido());
		us.setUsuarioSeguido(usuarioSeguido1);
		
		mU.dejarDeSeguirUsuasrio(us);
	}

	public void cargarImagenUrl(String us, String imagen){
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();
		Usuario user = mU.buscarUsuario(us);
		mU.agregarImagenUser(user, imagen);
	}

	@Override
	public String[] usuariosMeSiguen(String nickname) {
		ArrayList<String> usuarios;
		ManejadorUsuario mU = ManejadorUsuario.getInstancia(); // obtener el manejador para leer los items
		usuarios = mU.usuarioMeSiguen(nickname);
		String [] usuario_ret = new String [usuarios.size()];
		int i = 0;
		for(String u:usuarios) {
			usuario_ret[i] = u;
			i++;
		}
		return usuario_ret;		
	}

	public boolean yaLoSigo(String seguidor, String seguido) {
		ManejadorUsuario mU = ManejadorUsuario.getInstancia();	
		return mU.yaLoSigo(seguidor, seguido);
		
	}
}
