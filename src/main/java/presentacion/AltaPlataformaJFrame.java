package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import exepciones.PlataformaRepetidaExepcion;
import interfaces.IcPlataforma;

import javax.swing.JButton;
import javax.swing.JFrame;

import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class AltaPlataformaJFrame extends JInternalFrame {
	private JTextField txtNombre;
	private JTextField txtDescripcion;
	private JTextField txtUrl;
	private IcPlataforma icon;
	
	private static final String URL_REGEX =
            "^((((https?|ftps?|gopher|telnet|nntp)://)|(mailto:|news:))" +
                    "(%{2}|[-()_.!~*';/?:@&=+$, A-Za-z0-9])+)" + "([).!';/?:, ][[:blank:]])?$";

	private final Pattern URL_PATTERN = Pattern.compile(URL_REGEX);
	
	public AltaPlataformaJFrame(IcPlataforma icon) {
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Plataforma");
		setBounds(100, 100, 309, 300);
		getContentPane().setLayout(null);
		JButton btnConfirmar = new JButton("CONFIRMAR");
		
		JLabel lblNewLabel = new JLabel("AGREGAR PLATAFORMA");
		lblNewLabel.setBounds(12, 12, 195, 15);
		getContentPane().add(lblNewLabel);
		
		txtNombre = new JTextField();
		txtNombre.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!txtNombre.getText().isEmpty()) {
					txtDescripcion.setEnabled(true);
				}else {
					txtDescripcion.setEnabled(false);
				}
			}
		});
		txtNombre.setBounds(101, 70, 170, 19);
		getContentPane().add(txtNombre);
		txtNombre.setColumns(10);
		
		txtDescripcion = new JTextField();
		txtDescripcion.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!txtDescripcion.getText().isEmpty()) {
					txtUrl.setEnabled(true);
				} else {
					txtUrl.setEnabled(false);
				}
			}
		});
		txtDescripcion.setEnabled(false);
		txtDescripcion.setBounds(101, 112, 170, 19);
		getContentPane().add(txtDescripcion);
		txtDescripcion.setColumns(10);
		
		txtUrl = new JTextField();
		txtUrl.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (!txtUrl.getText().isEmpty()) {
					btnConfirmar.setEnabled(true);
				}else {
					btnConfirmar.setEnabled(false);
				}
			}
		});
		txtUrl.setEnabled(false);
		txtUrl.setBounds(101, 153, 170, 19);
		getContentPane().add(txtUrl);
		txtUrl.setColumns(10);
		
		
		btnConfirmar.setEnabled(false);
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				// Accion boton confirmar
				if(txtNombre.getText().isEmpty() || txtDescripcion.getText().isEmpty() || txtUrl.getText().isEmpty() || urlValidator(txtUrl.getText())) {
					JOptionPane.showMessageDialog(null,"Debe ingresar todos los campos!", "Agregar Plataforma",JOptionPane.ERROR_MESSAGE);
				}else {
					try {
						boolean exsisteNombrePla = icon.existePlataforma(txtNombre.getText());
						if (exsisteNombrePla == false) {
							icon.confirmarAltaPlataforma(txtNombre.getText(), txtDescripcion.getText(), txtUrl.getText());
							JOptionPane.showMessageDialog(null,"Se agrego la plataforma correctamente!!", "Agregar Plataforma", JOptionPane.INFORMATION_MESSAGE);
							limpiar();
						}else {
							JOptionPane.showMessageDialog(null,"Ya existe la plataforma ingresada!", "Agregar Plataforma",JOptionPane.ERROR_MESSAGE);
						}
					} catch (PlataformaRepetidaExepcion e) {
						JOptionPane.showMessageDialog(null,e.getMessage(), "Agregar Plataforma",JOptionPane.ERROR_MESSAGE);
					}			
				}
			}
		});
		btnConfirmar.setBounds(169, 231, 117, 25);
		getContentPane().add(btnConfirmar);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setBounds(12, 73, 94, 15);
		getContentPane().add(lblNombre);
		
		JLabel lblDescripcion = new JLabel("Descripcion:");
		lblDescripcion.setBounds(12, 115, 94, 15);
		getContentPane().add(lblDescripcion);
		
		JLabel lblUrl = new JLabel("URL:");
		lblUrl.setBounds(12, 156, 94, 15);
		getContentPane().add(lblUrl);
	
	}
	private void limpiar() {
		txtNombre.setText("");
		txtDescripcion.setText("");
		txtUrl.setText("");
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
