package presentacion;

import java.awt.EventQueue;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import interfaces.IcEspectaculo;
import interfaces.IcPlataforma;

import javax.swing.JTextPane;

import datatypes.DtFuncion;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;

import javax.swing.JTextField;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ConsultaFuncionDeEspectaculo extends JInternalFrame {
	
	private IcPlataforma iconP;
	private IcEspectaculo iconE;
	private JTextField txtNombre;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtFechaRegistro;
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> cbEspectaculo;
	private JComboBox<String> cbFuncion;
	private String artistasInvitados = "";
	private JTextPane txtpnInvitados;
	private JButton btnConsultar;
	
	public ConsultaFuncionDeEspectaculo(IcEspectaculo icE, IcPlataforma icP) {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				limpiarForm();
			}
		});
		iconE = icE;
		iconP = icP;
	
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Consulta de Funcion en Espectaculo");
        setBounds(10, 40, 283, 380);
		getContentPane().setLayout(null);
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		lblPlataforma.setBounds(10, 11, 69, 14);
		getContentPane().add(lblPlataforma);
		
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setComboBoxEspectaculo(comboBoxPlataforma.getSelectedItem().toString());
				cbEspectaculo.setEnabled(true);
				
				// reseteo el combobox de funcion
				DefaultComboBoxModel<String> modelVacio = new DefaultComboBoxModel<String>();
				cbFuncion.setModel(modelVacio);
				
				// apago el boton consultar
				btnConsultar.setEnabled(false);
				
			}
		});
		comboBoxPlataforma.setBounds(89, 8, 168, 20);
		getContentPane().add(comboBoxPlataforma);
		
		
		JLabel lblEspectaculo = new JLabel("Espectaculo:");
		lblEspectaculo.setBounds(10, 36, 78, 14);
		getContentPane().add(lblEspectaculo);
		
		cbEspectaculo = new JComboBox<String>();
		cbEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setComboBoxFuncion(cbEspectaculo.getSelectedItem().toString());
				cbFuncion.setEnabled(true);
			}
		});
		cbEspectaculo.setEnabled(false);
		cbEspectaculo.setBounds(89, 33, 168, 20);
		getContentPane().add(cbEspectaculo);
		
		JLabel lblFuncion = new JLabel("Funcion:");
		lblFuncion.setBounds(10, 62, 78, 14);
		getContentPane().add(lblFuncion);
		
		cbFuncion = new JComboBox<String>();
		cbFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnConsultar.setEnabled(true);
			}
		});
		cbFuncion.setEnabled(false);
		cbFuncion.setBounds(89, 59, 168, 20);
		getContentPane().add(cbFuncion);
		
		txtpnInvitados = new JTextPane();
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados. ");
		txtpnInvitados.setEditable(false);
		txtpnInvitados.setBounds(10, 259, 247, 91);
		getContentPane().add(txtpnInvitados);
		
		btnConsultar = new JButton("CONSULTAR");
		btnConsultar.setEnabled(false);
		btnConsultar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDetallesFuncion(cbEspectaculo.getSelectedItem().toString(), cbFuncion.getSelectedItem().toString());				
			}
		});
		btnConsultar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConsultar.setBounds(10, 87, 247, 23);
		getContentPane().add(btnConsultar);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(0, 128, 23, 7);
		getContentPane().add(separator_1);
		
		JLabel lblDetalles = new JLabel("Detalles de la Funci\u00F3n");
		lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalles.setBounds(33, 121, 143, 14);
		getContentPane().add(lblDetalles);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(174, 128, 113, 7);
		getContentPane().add(separator);
		
		JLabel lblNombreFuncion = new JLabel("Nombre:");
		lblNombreFuncion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNombreFuncion.setBounds(10, 146, 52, 14);
		getContentPane().add(lblNombreFuncion);
		
		JLabel lblFechaDelEvento = new JLabel("Fecha del evento:");
		lblFechaDelEvento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFechaDelEvento.setBounds(10, 197, 96, 14);
		getContentPane().add(lblFechaDelEvento);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblHoraInicio.setBounds(11, 224, 96, 14);
		getContentPane().add(lblHoraInicio);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(74, 143, 183, 20);
		getContentPane().add(txtNombre);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(106, 194, 151, 20);
		getContentPane().add(txtFecha);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(75, 221, 183, 20);
		getContentPane().add(txtHora);
		
		JLabel lblFechaRegistro = new JLabel("Fecha de registro:");
		lblFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFechaRegistro.setBounds(10, 172, 96, 14);
		getContentPane().add(lblFechaRegistro);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setEditable(false);
		txtFechaRegistro.setColumns(10);
		txtFechaRegistro.setBounds(106, 169, 151, 20);
		getContentPane().add(txtFechaRegistro);

	}
	public void InicializarComboBoxes() {
		DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(iconP.getPlataformas());
		comboBoxPlataforma.setModel(modelPlataforma);
	}
		
	
	public void setComboBoxEspectaculo(String plataforma) {
		try {
			DefaultComboBoxModel<String> modelespectaculos = new DefaultComboBoxModel<String>(iconE.getArrEspectaculos(plataforma));
	    	cbEspectaculo.setModel(modelespectaculos);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "No existen espectaculos registrados en la plataforma seleccionada" + e.toString(), "Consulta Funcion", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void setComboBoxFuncion(String funcion) {
		try {
			DefaultComboBoxModel<String> modelfuncion = new DefaultComboBoxModel<String>(iconE.getArrFunciones(funcion));
	    	cbFuncion.setModel(modelfuncion);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, "No existen funciones en este espectaculo" + e.toString(), "Consulta Funcion", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void getDetallesFuncion(String espectaculo, String funcion) {
		DtFuncion dtF = iconE.getDtFuncion(espectaculo, funcion); 
		txtNombre.setText(dtF.getNomFun());
		txtFecha.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtF.getFechaFuncion()));
		txtFechaRegistro.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtF.getFechaRegistroFun()));
		txtHora.setText(new SimpleDateFormat("HH:mm").format(dtF.getFechaFuncion()));
		for(String art: dtF.getInvitados()) { // concateno usuarios para mostrar 
			if(artistasInvitados == "") {
				artistasInvitados += art ; // el primero no lleva coma
			}else {
				artistasInvitados += ", " + art ;	
			}
			
		};
		txtpnInvitados.setText("Artistas Invitados: " + artistasInvitados);
	
	}

	public void limpiarForm() {
		txtNombre.setText("");
		txtFecha.setText("");
		txtFechaRegistro.setText("");
		txtHora.setText("");
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados.");
		
		DefaultComboBoxModel<String> modelVacio = new DefaultComboBoxModel<String>();
		comboBoxPlataforma.setModel(modelVacio);
		cbEspectaculo.setModel(modelVacio);
		cbFuncion.setModel(modelVacio);
		btnConsultar.setEnabled(false);
	}
	
}
