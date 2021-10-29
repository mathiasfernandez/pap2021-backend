package presentacion;

import java.awt.Color;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IcUsuario;
import javax.swing.JTextField;

import org.apache.commons.codec.digest.DigestUtils;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class ModificarUsuarioJFrame extends JInternalFrame{
	
	private static final long serialVersionUID = 1L;
	private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";

    private final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    
	private IcUsuario iconU;
	private JComboBox<String> comboBoxUsuario;
	private JTextField tNickname;
	private JTextField tNombre;
	private JTextField tApellido;
	private JTextField tcorreo;
	private JTextField tSitioWeb;
	private JTextField tBibliografia;
	private JTextField tDescripcion;
	private DtUsuario prueba;
	private JLabel lNickname;
	private JLabel lNombre;
	private JLabel lApellido;
	private JLabel lcorreo;
	private JLabel lSitioWeb; 
	private JLabel lBibliografia;
	private JLabel lDescripcion;
	private JLabel lfechaNac;
	private JCalendar fechaNac;
	private JButton BCancelar;
	private JButton BActualizar;
	private JLabel lcontra;
	private JLabel lcontrav;
	private JPasswordField textContra;
	private JPasswordField textContraV;
	
	public ModificarUsuarioJFrame(IcUsuario iconU) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.iconU = iconU;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Modificar Usuario");
		setBounds(100, 100, 635, 533);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Usuarios:");
		lblNewLabel.setBounds(12, 30, 70, 15);
		getContentPane().add(lblNewLabel);
		
		comboBoxUsuario = new JComboBox();
		comboBoxUsuario.setBounds(121, 25, 156, 24);
		getContentPane().add(comboBoxUsuario);
		
		lNickname = new JLabel("Nickname");
		lNickname.setBounds(12, 64, 105, 14);
		getContentPane().add(lNickname);
		
		tNickname = new JTextField();
		tNickname.setColumns(10);
		tNickname.setBounds(121, 61, 156, 20);
		getContentPane().add(tNickname);
		
		lNombre= new JLabel("Nombre");
		lNombre.setBounds(12, 100, 91, 14);
		getContentPane().add(lNombre);
		
		tNombre = new JTextField();
		tNombre.setColumns(10);
		tNombre.setBounds(121, 97, 156, 20);
		getContentPane().add(tNombre);
		
		lApellido= new JLabel("Apellido");
		lApellido.setBounds(12, 136, 115, 14);
		getContentPane().add(lApellido);
		
		tApellido = new JTextField();
		tApellido.setColumns(10);
		tApellido.setBounds(121, 133, 156, 20);
		getContentPane().add(tApellido);
		
		lcorreo= new JLabel("E-Mail");
		lcorreo.setBounds(12, 176, 91, 14);
		getContentPane().add(lcorreo);
		
		tcorreo = new JTextField();
		tcorreo.setColumns(10);
		tcorreo.setBounds(121, 173, 156, 20);
		getContentPane().add(tcorreo);
		
		lSitioWeb= new JLabel("Sitio web");
		lSitioWeb.setBounds(281, 64, 105, 14);
		getContentPane().add(lSitioWeb);
		
		tSitioWeb = new JTextField();
		tSitioWeb.setColumns(10);
		tSitioWeb.setBounds(395, 61, 144, 20);
		getContentPane().add(tSitioWeb);
		
		lBibliografia= new JLabel("Bibliografia");
		lBibliografia.setBounds(281, 97, 91, 14);
		getContentPane().add(lBibliografia);
		
		tBibliografia = new JTextField();
		tBibliografia.setColumns(10);
		tBibliografia.setBounds(392, 93, 147, 100);
		getContentPane().add(tBibliografia);
		
		lDescripcion= new JLabel("Descripcion");
		lDescripcion.setBounds(295, 209, 91, 14);
		getContentPane().add(lDescripcion);
		
		tDescripcion = new JTextField();
		tDescripcion.setColumns(10);
		tDescripcion.setBounds(393, 209, 146, 100);
		getContentPane().add(tDescripcion);
		
		lfechaNac = new JLabel("Fecha Nacimiento");
		lfechaNac.setBounds(12, 274, 125, 14);
		getContentPane().add(lfechaNac);
		
		fechaNac= new JCalendar();
		fechaNac.setBounds(57, 300, 226, 153);
		getContentPane().add(fechaNac);
		
		BCancelar = new JButton("Cancelar");
		BCancelar.setVisible(false);
		BCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});

		BCancelar.setBounds(160, 465, 117, 25);
		getContentPane().add(BCancelar);
		
		BActualizar = new JButton("Actualizar");
		BActualizar.setVisible(false);
		BActualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int anio = fechaNac.getCalendar().get(java.util.Calendar.YEAR) - 1900;
				 int mes = fechaNac.getCalendar().get(java.util.Calendar.MONTH);
				 int dia = fechaNac.getCalendar().get(java.util.Calendar.DATE);
				 Date fecha = new Date(anio,mes,dia);	
				 Date fechaActual = new Date();
				 DtUsuario usr;
				if (!camposVaciosEspectador()) {
					if (fecha.before(fechaActual)){
						if (prueba instanceof DtEspectador) {
							char[] pass = textContra.getPassword();
							String passS = new String(pass);
							char[] pass2 = textContraV.getPassword();
							String passS2 = new String(pass);
							if (passS.equals(passS2)) {
								String encriptMD5=DigestUtils.md5Hex(passS);
								usr = new DtEspectador(tNickname.getText(),tNombre.getText(),tApellido.getText(),tcorreo.getText(),fecha,encriptMD5,null);
								iconU.actualizarUsuario(usr);
								JOptionPane.showMessageDialog(null, "El Espectador se ha modificado con exito", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
								limpiarFormulario();
								ocultarCampos();
								BActualizar.setVisible(false);
								BCancelar.setVisible(false);
							}else {
								JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						else if(!camposVaciosArtista()) {
								if (urlValidator(tSitioWeb.getText())) {
									char[] pass = textContra.getPassword();
									String passS = new String(pass);
									char[] pass2 = textContraV.getPassword();
									String passS2 = new String(pass);
									if (passS.equals(passS2)) {
										String encriptMD5=DigestUtils.md5Hex(passS);
										usr = new DtArtista(tNickname.getText(),tNombre.getText(),tApellido.getText(),tcorreo.getText(),fecha, tDescripcion.getText(),tBibliografia.getText(),tSitioWeb.getText(),encriptMD5,null);
										iconU.actualizarUsuario(usr);
										JOptionPane.showMessageDialog(null, "El Espectador se ha modificado con exito", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
										limpiarFormulario();
										ocultarCampos();
										BActualizar.setVisible(false);
										BCancelar.setVisible(false);
									}else {
										JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
									}
								}
								else
									JOptionPane.showMessageDialog(null, "La url no es valida", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
							}
							else
								JOptionPane.showMessageDialog(null, "Hay cambos Vacios", "Modificar Usuario",JOptionPane.INFORMATION_MESSAGE);
				 		}
					else
					 JOptionPane.showMessageDialog(null, "Fecha Nacimiento invalida", "Modificar Usuario",JOptionPane.INFORMATION_MESSAGE);
				}
				else
					JOptionPane.showMessageDialog(null, "Hay cambos Vacios", "Modificar Usuario",JOptionPane.INFORMATION_MESSAGE);
			}
		});
		BActualizar.setBounds(349, 465, 117, 25);
		getContentPane().add(BActualizar);
		
		JButton bVerDatos = new JButton("Ver Datos");
		bVerDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BActualizar.setVisible(true);
				BCancelar.setVisible(true);
				String usuario = String.valueOf(comboBoxUsuario.getSelectedItem());				
				prueba = iconU.getDtUsuario(usuario);
				if (prueba instanceof DtArtista) {
					mostrarCamposArtista();
					tNickname.setText(prueba.getNickname());
					tNickname.setEnabled(false);
					tNombre.setText(prueba.getNombre());
					tApellido.setText(prueba.getApellido());
					tcorreo.setText(prueba.getCorreo());
					tcorreo.setEnabled(false);
					tSitioWeb.setText(((DtArtista) prueba).getSitio_web());
					tBibliografia.setText(((DtArtista) prueba).getBibliografia());
					tDescripcion.setText(((DtArtista) prueba).getDescripcion());
					fechaNac.setDate(prueba.getfNac());
				}
				else
				{
					mostrarCamposEspectador();
					tNickname.setText(prueba.getNickname());
					tNickname.setEnabled(false);
					tNombre.setText(prueba.getNombre());
					tApellido.setText(prueba.getApellido());
					tcorreo.setText(prueba.getCorreo());
					tcorreo.setEnabled(false);
				}	
			}
			});
		bVerDatos.setBounds(291, 25, 117, 25);
		getContentPane().add(bVerDatos);
		
		lcontra = new JLabel("Contraseña");
		lcontra.setBounds(12, 209, 91, 14);
		getContentPane().add(lcontra);
		
		lcontrav = new JLabel("Confirmar C");
		lcontrav.setBounds(12, 246, 105, 14);
		getContentPane().add(lcontrav);
		
		textContra = new JPasswordField();
		textContra.setVisible(false);
		textContra.setBounds(121, 207, 157, 18);
		getContentPane().add(textContra);
		
		textContraV = new JPasswordField();
		textContraV.setVisible(false);
		textContraV.setBounds(120, 244, 157, 18);
		getContentPane().add(textContraV);
		
		ocultarCampos();
	}
	
	public void InicializarComboBoxesUsuario() {
		DefaultComboBoxModel<String> modelUSuario = new DefaultComboBoxModel<String>(iconU.listarUsuarios());
		comboBoxUsuario.setModel(modelUSuario);
	}
	
	private void limpiarFormulario() {
		tNickname.setText(null);
		tNombre.setText(null);
		tApellido.setText(null);
		tcorreo.setText(null);
		tDescripcion.setText(null);
		tBibliografia.setText(null);
		tSitioWeb.setText(null);
		textContra.setText(null);
		textContraV.setText(null);
	}
	
	private void mostrarCamposEspectador() {
		lNickname.setVisible(true);
		tNickname.setVisible(true);
		lNombre.setVisible(true);
		tNombre.setVisible(true);
		lApellido.setVisible(true);
		tApellido.setVisible(true);
		lcorreo.setVisible(true);
		tcorreo.setVisible(true);
		lfechaNac.setVisible(true);
		fechaNac.setVisible(true);
		tDescripcion.setVisible(false);
		tBibliografia.setVisible(false);
		tSitioWeb.setVisible(false);
		lDescripcion.setVisible(false);
		lBibliografia.setVisible(false);
		lSitioWeb.setVisible(false);
		textContra.setVisible(true);
		textContraV.setVisible(true);
		lcontra.setVisible(true);
		lcontrav.setVisible(true);
	}
	
	private void mostrarCamposArtista() {
		tNickname.setVisible(true);
		tNombre.setVisible(true);
		tApellido.setVisible(true);
		tcorreo.setVisible(true);
		tDescripcion.setVisible(true);
		tBibliografia.setVisible(true);
		tSitioWeb.setVisible(true);
		fechaNac.setVisible(true);
		lNickname.setVisible(true);
		lNombre.setVisible(true);
		lApellido.setVisible(true);
		lcorreo.setVisible(true);
		lDescripcion.setVisible(true);
		lBibliografia.setVisible(true);
		lSitioWeb.setVisible(true);
		lfechaNac.setVisible(true);
		textContra.setVisible(true);
		textContraV.setVisible(true);
		lcontra.setVisible(true);
		lcontrav.setVisible(true);
	}
	
	private void ocultarCampos() {
		tNickname.setVisible(false);
		tNombre.setVisible(false);
		tApellido.setVisible(false);
		tcorreo.setVisible(false);
		tDescripcion.setVisible(false);
		tBibliografia.setVisible(false);
		tSitioWeb.setVisible(false);
		fechaNac.setVisible(false);
		lNickname.setVisible(false);
		lNombre.setVisible(false);
		lApellido.setVisible(false);
		lcorreo.setVisible(false);
		lDescripcion.setVisible(false);
		lBibliografia.setVisible(false);
		lSitioWeb.setVisible(false);
		lfechaNac.setVisible(false);
		textContra.setVisible(false);
		textContraV.setVisible(false);
		lcontra.setVisible(false);
		lcontrav.setVisible(false);
	}
	
	private boolean  camposVaciosEspectador() {
		return ((tNickname.getText().isEmpty()) || (tNombre.getText().isEmpty()) || (tApellido.getText().isEmpty()) || (tcorreo.getText().isEmpty()));
	}
	
	private boolean  camposVaciosArtista() {
		return ((tNickname.getText().isEmpty()) || (tNombre.getText().isEmpty()) || (tApellido.getText().isEmpty()) || (tcorreo.getText().isEmpty()) || (tDescripcion.getText().isEmpty()) || (tBibliografia.getText().isEmpty()) || (tSitioWeb.getText().isEmpty()));
	}
	
    public boolean urlValidator(String url)
    {
        if (url == null) {
            return false;
        }
        Matcher matcher = URL_PATTERN.matcher(url);
        return matcher.matches();
    }	
	
}
