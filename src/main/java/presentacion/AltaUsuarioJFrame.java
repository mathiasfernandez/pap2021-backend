package presentacion;

import javax.swing.JInternalFrame; 
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import interfaces.IcUsuario;

import javax.swing.JButton;
import javax.swing.JFrame;
import com.toedter.calendar.JCalendar;

import datatypes.DtArtista;
import datatypes.DtEspectador;
import datatypes.DtUsuario;

import exepciones.UsuarioRepetidoExepcion;

import logica.ManejadorUsuario;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JRadioButtonMenuItem;
//import com.jgoodies.forms.factories.DefaultComponentFactory;
import java.awt.TextField;
import java.awt.TextArea;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.security.MessageDigest;

import javax.swing.JFormattedTextField;
import javax.swing.JPasswordField;

public class AltaUsuarioJFrame extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IcUsuario iconU;
	private JTextField tnickname;
	private JTextField tnombre;
	private JTextField tapellido;
	private JTextField temail;
	private JTextField TSitioWeb;
	private TextField TDescripcion;
	private TextField TBibliografia;
	private JCalendar fechaNac;
	
	private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";

    private final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
    private JPasswordField textContra;
    private JPasswordField textContraV;

	
	/**
	 * Create the frame.
	 * @param iconU 
	 */
	public AltaUsuarioJFrame(IcUsuario iconU,JFrame principal) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.iconU = iconU;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Alta Usuario");
		setBounds(100, 100, 516, 489);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Nickname");
		lblNewLabel.setBounds(10, 35, 105, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nombre");
		lblNewLabel_1.setBounds(10, 70, 91, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Apellido");
		lblNewLabel_2.setBounds(10, 102, 115, 14);
		getContentPane().add(lblNewLabel_2);
		
		tnickname = new JTextField();
		tnickname.setBounds(172, 35, 122, 20);
		getContentPane().add(tnickname);
		tnickname.setColumns(10);
		
		tnombre = new JTextField();
		tnombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if (Character.isDigit(validar)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras","Ayuda", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tnombre.setBounds(172, 67, 122, 20);
		tnombre.setColumns(10);
		getContentPane().add(tnombre);
		
		tapellido = new JTextField();
		tapellido.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if (Character.isDigit(validar)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo letras","Ayuda", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tapellido.setBounds(172, 99, 122, 20);
		tapellido.setColumns(10);
		getContentPane().add(tapellido);
		
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
				tnombre.setEnabled(true);
				tapellido.setEnabled(true);
				fechaNac.setEnabled(true);	
			}
		});
		btnNewButton_1.setBounds(80, 422, 134, 23);
		getContentPane().add(btnNewButton_1);
		
		temail = new JTextField();
		temail.setBounds(172, 131, 122, 20);
		temail.setColumns(10);
		getContentPane().add(temail);
		
		JLabel lblNewLabel_2_1 = new JLabel("E-Mail");
		lblNewLabel_2_1.setBounds(10, 134, 91, 14);
		getContentPane().add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_2_1_1.setBounds(10, 231, 152, 14);
		getContentPane().add(lblNewLabel_2_1_1);
		
		JLabel LBibliografia = new JLabel("Bibliografia");
		LBibliografia.setBounds(330, 157, 91, 14);
		getContentPane().add(LBibliografia);
		LBibliografia.setVisible(false);
		
		TSitioWeb = new JTextField();
		TSitioWeb.setBounds(442, 109, 175, 20);
		TSitioWeb.setColumns(10);
		getContentPane().add(TSitioWeb);
		TSitioWeb.setVisible(false);
		
		JLabel LSitioweb = new JLabel("Sitio web");
		LSitioweb.setBounds(333, 109, 91, 14);
		getContentPane().add(LSitioweb);
		LSitioweb.setVisible(false);
		
		JLabel LDescripcion = new JLabel("Descripcion");
		LDescripcion.setBounds(330, 268, 115, 14);
		getContentPane().add(LDescripcion);
		LDescripcion.setVisible(false);
		
		JPanel panel = new JPanel();
		panel.setBounds(330, 12, 167, 59);
		getContentPane().add(panel);
		
		fechaNac = new JCalendar();
		fechaNac.setBounds(27, 257, 226, 153);
		getContentPane().add(fechaNac);
		
		TDescripcion = new TextField();
		TDescripcion.setBounds(442, 268, 172, 97);
		getContentPane().add(TDescripcion);
		TDescripcion.setVisible(false);
		
		TBibliografia = new TextField();
		TBibliografia.setBounds(445, 152, 172, 97);
		getContentPane().add(TBibliografia);
		TBibliografia.setVisible(false);
		
		JRadioButton radio_Artista = new JRadioButton("Artista");
		JRadioButton radio_Espectador = new JRadioButton("Espectador");
		radio_Espectador.setSelected(true);
		
		radio_Espectador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(50, 50, 516, 489);
				LBibliografia.setVisible(false);
				TBibliografia.setVisible(false);
				LSitioweb.setVisible(false);
				TSitioWeb.setVisible(false);
				LDescripcion.setVisible(false);
				TDescripcion.setVisible(false);
				radio_Artista.setSelected(false);
				limpiarFormulario();
				tnombre.setEnabled(true);
				tapellido.setEnabled(true);
				fechaNac.setEnabled(true);	
			}
		});
		
		panel.add(radio_Espectador);
		panel.add(radio_Artista);
		radio_Artista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setBounds(50, 50, 688, 489);
				LBibliografia.setVisible(true);
				TBibliografia.setVisible(true);
				LSitioweb.setVisible(true);
				TSitioWeb.setVisible(true);
				LDescripcion.setVisible(true);
				TDescripcion.setVisible(true);
				radio_Espectador.setSelected(false);
				AltaUsuarioJFrame.setDefaultLocale(getLocale());
				tnombre.setEnabled(true);
				tapellido.setEnabled(true);
				fechaNac.setEnabled(true);	
			}
		});
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.setBounds(297, 422, 134, 23);
		btnNewButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 int anio = fechaNac.getCalendar().get(java.util.Calendar.YEAR) - 1900;
				 int mes = fechaNac.getCalendar().get(java.util.Calendar.MONTH);
				 int dia = fechaNac.getCalendar().get(java.util.Calendar.DATE);
				 Date fecha = new Date(anio,mes,dia);	
				 Date fechaActual = new Date();
				if(radio_Espectador.isSelected()== false && radio_Artista.isSelected()==false)
					JOptionPane.showMessageDialog(null,"Por favor seleccione un tipo de usuario");
				else if (radio_Espectador.isSelected()== true ){
					try {
						if (!camposVaciosEspectador()) {
							 if (fecha.before(fechaActual)){
							// Patron para validar el email
							Pattern pattern = Pattern
									.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
							// El email a validar
							String email = temail.getText();
							Matcher mather = pattern.matcher(email);
								if (mather.find() == true) {
									char[] pass = textContra.getPassword();
									String passS = new String(pass);
									char[] pass2 = textContraV.getPassword();
									String passS2 = new String(pass);
									if (passS.equals(passS2)) {
										//String encriptMD5=DigestUtils.md5Hex(passS);
										DtEspectador es = new DtEspectador(tnickname.getText(),tnombre.getText(),tapellido.getText(),temail.getText(),fecha,passS2,null);
										iconU.confirmarAltaUsuario(es);
										JOptionPane.showMessageDialog(null, "El Espectador se ha creado con exito", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
										limpiarFormulario();
										tnombre.setEnabled(true);
										tapellido.setEnabled(true);
										fechaNac.setEnabled(true);
									}else {
										JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
									}									
								} else 
									JOptionPane.showMessageDialog(null, "El email no es valido", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);	
							 }
							 else
								 JOptionPane.showMessageDialog(null, "Fecha Nacimiento invalida", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
						}
								else
									JOptionPane.showMessageDialog(null, "Hay Cambos vacios", "Alta Usuario",JOptionPane.ERROR_MESSAGE);
						} catch (UsuarioRepetidoExepcion e1) {
							e1.getMessage();
							JOptionPane.showMessageDialog(null, e1.getMessage(), "Agregar Socio", JOptionPane.ERROR_MESSAGE);
							tnombre.setEnabled(false);
							tapellido.setEnabled(false);
							fechaNac.setEnabled(false);	
						}
				}
				else {
					try {
						if (!camposVaciosArtista()) {
							if (fecha.before(fechaActual)){
							// Patron para validar el email
							Pattern pattern = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
							// El email a validar
							String email = temail.getText();
							Matcher mather = pattern.matcher(email);
								if (mather.find() == true) {
									if (urlValidator(TSitioWeb.getText())) {
										char[] pass = textContra.getPassword();
										String passS = new String(pass);
										char[] pass2 = textContraV.getPassword();
										String passS2 = new String(pass);
										if (passS.equals(passS2)) {
											//String encriptMD5=DigestUtils.md5Hex(passS);
											DtArtista ar = new DtArtista(tnickname.getText(),tnombre.getText(),tapellido.getText(),temail.getText(),fecha, TDescripcion.getText(),TBibliografia.getText(),TSitioWeb.getText(),passS,null);
											iconU.confirmarAltaUsuario(ar);
											JOptionPane.showMessageDialog(null, "El Artista se ha creado con exito", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
											limpiarFormulario();
											tnombre.setEnabled(true);
											tapellido.setEnabled(true);
											fechaNac.setEnabled(true);
										}else {
											JOptionPane.showMessageDialog(null, "Las contraseñas no coinciden", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
										}			
									}
									else
										JOptionPane.showMessageDialog(null, "La url no es valida", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
								} else 
							JOptionPane.showMessageDialog(null, "El email no es valido", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);	
						}
						 else
							 JOptionPane.showMessageDialog(null, "Fecha Nacimiento invalida", "Alta Usuario",JOptionPane.INFORMATION_MESSAGE);
						}
						else
							JOptionPane.showMessageDialog(null, "Hay Cambos vacios", "Alta Usuario",JOptionPane.ERROR_MESSAGE);
						} catch (UsuarioRepetidoExepcion e1) {
						e1.getMessage();
						JOptionPane.showMessageDialog(null, e1.getMessage(), "Agregar Socio", JOptionPane.ERROR_MESSAGE);
						tnombre.setEnabled(false);
						tapellido.setEnabled(false);
						fechaNac.setEnabled(false);	
						}
					}
			}
		});
		getContentPane().add(btnNewButton);	
		
		JLabel lblNewLabel_2_1_2 = new JLabel("Contraseña");
		lblNewLabel_2_1_2.setBounds(10, 165, 91, 14);
		getContentPane().add(lblNewLabel_2_1_2);
		
		textContra = new JPasswordField();
		textContra.setBounds(172, 163, 122, 18);
		getContentPane().add(textContra);
		
		textContraV = new JPasswordField();
		textContraV.setBounds(172, 193, 122, 18);
		getContentPane().add(textContraV);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Confirmar contraseña");
		lblNewLabel_2_1_2_1.setBounds(10, 195, 152, 14);
		getContentPane().add(lblNewLabel_2_1_2_1);
	}
	
	private void limpiarFormulario() {
		tnickname.setText(null);
		tnombre.setText(null);
		tapellido.setText(null);
		temail.setText(null);
		TDescripcion.setText(null);
		TBibliografia.setText(null);
		TSitioWeb.setText(null);
		textContra.setText(null);
		textContraV.setText(null);
	}
	private boolean  camposVaciosEspectador() {
		return ((tnickname.getText().isEmpty()) || (tnombre.getText().isEmpty()) || (tapellido.getText().isEmpty()) || (temail.getText().isEmpty()));
	}
	
	private boolean  camposVaciosArtista() {
		return ((tnickname.getText().isEmpty()) || (tnombre.getText().isEmpty()) || (tapellido.getText().isEmpty()) || (temail.getText().isEmpty()) || (TDescripcion.getText().isEmpty()) || (TBibliografia.getText().isEmpty()) || (TSitioWeb.getText().isEmpty()));
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
