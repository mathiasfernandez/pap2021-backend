package presentacion;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IcEspectaculo;
import interfaces.IcPlataforma;
import interfaces.IcUsuario;

import javax.swing.JTextField;
/*
import conexion.Conexion;
import datatypes.DtEspectaculo;
import datatypes.DtEspectador;
import exepciones.UsuarioRepetidoExepcion;
*/
import exepciones.EspectaculoRepetidoExepcion;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import com.toedter.calendar.JCalendar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AltaEspectaculoJFrame extends JInternalFrame{
	private IcEspectaculo iconE;
	private IcPlataforma iconP;
	private IcUsuario iconU;
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxArtista;
	
	private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";

    private final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);

	
	private static final long serialVersionUID = 1L;
	private JLabel lNombre;
	private JLabel lDescripcion;
	private JLabel lDuracion;
	private JLabel lEspMin;
	private JLabel lEspMax;
	private JLabel lURL;
	private JLabel lCosto;
	private JLabel lFecha;
	private JTextField tnombre;
	private JTextField tDuracion;
	private JTextField tEspMin;
	private JTextField tEspMax;
	private JTextField tURL;
	private JTextField tCosto;
	private JTextField tDescripcion;
	
	public AltaEspectaculoJFrame(IcEspectaculo iconE, IcPlataforma iconP, IcUsuario iconU) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.iconE = iconE;
		this.iconP = iconP;
		this.iconU = iconU;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Alta Espectaculo");
		setBounds(100, 100, 516, 591);
		getContentPane().setLayout(null);
		JLabel lPlataforma = new JLabel("Plataforma:");
		lPlataforma.setBounds(12, 43, 130, 15);
		getContentPane().add(lPlataforma);

		comboBoxPlataforma = new JComboBox();
		comboBoxPlataforma.setBounds(137, 38, 170, 24);
		
		getContentPane().add(comboBoxPlataforma);
		
		JLabel lOrganizador = new JLabel("Organizador:");
		lOrganizador.setBounds(12, 79, 130, 15);
		getContentPane().add(lOrganizador);
		comboBoxArtista = new JComboBox();
		comboBoxArtista.setBounds(137, 74, 170, 24);
		getContentPane().add(comboBoxArtista);
		lNombre = new JLabel("Nombre:");
		lNombre.setBounds(12, 120, 130, 15);
		getContentPane().add(lNombre);
		
		lDescripcion = new JLabel("Descripcion:");
		lDescripcion.setBounds(12, 174, 130, 15);
		getContentPane().add(lDescripcion);
		
		lDuracion = new JLabel("Duracion:");
		lDuracion.setBounds(12, 232, 80, 15);
		getContentPane().add(lDuracion);
		
		lEspMin = new JLabel("Espectadores minimos:");
		lEspMin.setBounds(12, 259, 208, 15);
		getContentPane().add(lEspMin);
		
		lEspMax = new JLabel("Espectadores maximos:");
		lEspMax.setBounds(12, 286, 208, 15);
		getContentPane().add(lEspMax);
		
		lURL = new JLabel("URL:");
		lURL.setBounds(12, 313, 208, 15);
		getContentPane().add(lURL);
		
		lCosto = new JLabel("Costo:");
		lCosto.setBounds(12, 340, 68, 15);
		getContentPane().add(lCosto);
		
		lFecha = new JLabel("Fecha de alta:");
		lFecha.setBounds(12, 367, 208, 15);
		getContentPane().add(lFecha);
		
		tnombre = new JTextField();
		tnombre.setBounds(137, 118, 170, 19);
		getContentPane().add(tnombre);
		tnombre.setColumns(10);
		
		tDuracion = new JTextField();
		tDuracion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if (Character.isLetter(validar)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros","Ayuda", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tDuracion.setColumns(10);
		tDuracion.setBounds(137, 230, 170, 19);
		getContentPane().add(tDuracion);
		
		tEspMin = new JTextField();
		tEspMin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if (Character.isLetter(validar)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros","Ayuda", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tEspMin.setColumns(10);
		tEspMin.setBounds(218, 257, 86, 19);
		getContentPane().add(tEspMin);
		
		tEspMax = new JTextField();
		tEspMax.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if (Character.isLetter(validar)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros","Ayuda", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tEspMax.setColumns(10);
		tEspMax.setBounds(218, 286, 86, 19);
		getContentPane().add(tEspMax);
		
		tURL = new JTextField();
		tURL.setColumns(10);
		tURL.setBounds(137, 311, 170, 19);
		getContentPane().add(tURL);
		
		tCosto = new JTextField();
		tCosto.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char validar=e.getKeyChar();
				if (Character.isLetter(validar)){
					getToolkit().beep();
					e.consume();
					JOptionPane.showMessageDialog(rootPane, "Ingresar solo numeros","Ayuda", JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		tCosto.setColumns(10);
		tCosto.setBounds(137, 338, 170, 19);
		getContentPane().add(tCosto);
		
		JCalendar fechaAlta = new JCalendar();
		fechaAlta.setBounds(137, 371, 226, 153);
		getContentPane().add(fechaAlta);
		
		tDescripcion = new JTextField();
		tDescripcion.setBounds(137, 147, 357, 76);
		getContentPane().add(tDescripcion);
		tDescripcion.setColumns(10);
		
		JButton btnNewButton = new JButton("Confirmar");
		btnNewButton.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				if (!camposVaciosEspectaculo()) {
					int anio = fechaAlta.getCalendar().get(java.util.Calendar.YEAR) - 1900;
					int mes = fechaAlta.getCalendar().get(java.util.Calendar.MONTH);
					int dia = fechaAlta.getCalendar().get(java.util.Calendar.DATE);
					Date fecha = new Date(anio,mes,dia);
					int duracion = Integer.parseInt(tDuracion.getText());
					int minEsp = Integer.parseInt(tEspMin.getText());
					int maxEsp = Integer.parseInt(tEspMax.getText());
					Float costos = Float.parseFloat(tCosto.getText());
					if ((minEsp < 0) ||(maxEsp < 0)) {
						JOptionPane.showMessageDialog(null, "Los espectadores mayores 0", "Alta Espectaculo",JOptionPane.ERROR_MESSAGE);
					}
					else if (minEsp > maxEsp) {
						JOptionPane.showMessageDialog(null, "La capacidad MIN es mayor a la capacidad MAX", "Alta Espectaculo",JOptionPane.ERROR_MESSAGE);
					}
					else if (costos < -1) {
						JOptionPane.showMessageDialog(null, "El costo mayor o igual a 0", "Alta Espectaculo",JOptionPane.ERROR_MESSAGE);
					}
					
					else if (urlValidator(tURL.getText())) {
							String plataforma = String.valueOf(comboBoxPlataforma.getSelectedItem());
							String artista = String.valueOf(comboBoxArtista.getSelectedItem());
							iconE.confirmarAltaEspectaculo(tnombre.getText(), tDescripcion.getText(),duracion,minEsp,maxEsp,tURL.getText(),costos,fecha,plataforma,artista,null);
							JOptionPane.showMessageDialog(null, "El Espectaculo se ha creado con exito", "Alta Espectaculo",JOptionPane.INFORMATION_MESSAGE);
							limpiarFormulario();
						}
					else
						JOptionPane.showMessageDialog(null, "La url no es valida", "Alta Espectaculo",JOptionPane.INFORMATION_MESSAGE);
					}
				else
					JOptionPane.showMessageDialog(null, "Hay Cambos vacios", "Alta Espectaculo",JOptionPane.ERROR_MESSAGE);
				} catch (EspectaculoRepetidoExepcion e1) {
					e1.getMessage();
					JOptionPane.showMessageDialog(null, e1.getMessage(), "Alta Espectaculo", JOptionPane.ERROR_MESSAGE);
				}
		}	
		});
		btnNewButton.setBounds(375, 522, 117, 25);
		getContentPane().add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Cancelar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormulario();
			}
		});
		btnNewButton_1.setBounds(12, 522, 117, 25);
		getContentPane().add(btnNewButton_1);
		
		JLabel lblHs = new JLabel("hs");
		lblHs.setBounds(317, 232, 20, 15);
		getContentPane().add(lblHs);
		
		JLabel lblUyu = new JLabel("UYU");
		lblUyu.setBounds(317, 340, 20, 15);
		getContentPane().add(lblUyu);

	}

	public void InicializarComboBoxesPlataforma() {
		DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(iconP.getPlataformas());
		comboBoxPlataforma.setModel(modelPlataforma);
	}
	public void InicializarComboBoxesArtista() {
		DefaultComboBoxModel<String> modelArtista = new DefaultComboBoxModel<String>(iconU.getArtistas());
		comboBoxArtista.setModel(modelArtista);
	}
	
	private void limpiarFormulario() {
		tnombre.setText(null);
		tDescripcion.setText(null);
		tEspMin.setText(null);
		tEspMax.setText(null);
		tCosto.setText(null);
		tDuracion.setText(null);
		tURL.setText(null);
	}
	
	private boolean  camposVaciosEspectaculo() {
		return ((tnombre.getText().isEmpty()) || (tDescripcion.getText().isEmpty()) || (tEspMin.getText().isEmpty()) || (tEspMax.getText().isEmpty()) || (tCosto.getText().isEmpty()) || (tDuracion.getText().isEmpty()) || (tURL.getText().isEmpty()));
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