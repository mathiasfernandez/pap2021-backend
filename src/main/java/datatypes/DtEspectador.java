package datatypes;

import java.util.Date;
import java.util.List;

import logica.Espectador;
import logica.ManejadorUsuario;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtEspectador extends DtUsuario{
	
	public DtEspectador(String nickname, String nombre, String apellido, String correo, Date fNac, String contra,String imagen) {
		super(nickname,nombre,apellido,correo,fNac,contra,imagen);
	}

}
