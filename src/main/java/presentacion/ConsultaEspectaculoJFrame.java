package presentacion;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;

import interfaces.IcEspectaculo;
import interfaces.IcPaquete;
import interfaces.IcPlataforma;
import interfaces.IcRegistro;
import interfaces.IcUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaquete;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ConsultaEspectaculoJFrame extends JInternalFrame {

	private IcEspectaculo iconE;
	private IcPlataforma iconP;
	private IcPaquete iconPaq;
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxEspectaculo;
	private JComboBox<String> comboBoxPaquete;
	private JComboBox<String> comboBoxFuncion;
	private String artistasInvitados = "";
	private JTextPane txtpnInvitados;
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNombreE;
	private JTextField textFieldDescripcionE;
	private JTextField textFieldDuracionE;
	private JTextField textFieldMinEspectactoresE;
	private JTextField textFieldMaxEspectactadoresE;
	private JTextField textFieldUrlE;
	private JTextField textFieldCostoE;
	private JTextField textFieldFechaRegistroE;
	private JTextField textFieldNombreF;
	private JTextField textFieldFechaF;
	private JTextField textFieldHoraF;
	private JTextField textFieldFechaRF;
	private JTextField textFieldNombrePaq;
	private JTextField textFieldDescripcionPaq;
	private JTextField textFieldFinicioPaq;
	private JTextField textFieldFfinalPaq;
	private JTextField textFieldDescuentoPaq;
	private JTextField textFieldCostoPaq;
	private JTextField textFieldFaltaPaq;

	/**
	 * Create the frame.
	 * @param iconU 
	 */
	public ConsultaEspectaculoJFrame(IcEspectaculo iconE, IcPlataforma iconP,IcPaquete iconPaq) {
		
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				limpiarForm();
			}
		});
		
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.iconE = iconE;
		this.iconP = iconP;
		this.iconPaq  = iconPaq;
		
		setResizable(true);
	    setIconifiable(true);
	    setMaximizable(true);
	    setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
	    setClosable(true);
		setTitle("Consulta Espectaculo");
		setBounds(100, 100, 844, 565);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Plataforma");
		lblNewLabel.setBounds(292, 21, 68, 14);
		getContentPane().add(lblNewLabel);
		
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InicializarComboBoxEspectaculo();
				limpiarFormFuncion();
				limpiarFormPaquete();
				limpiarFormEspectaculo();
			}
		});
		comboBoxPlataforma.setBounds(382, 17, 137, 22);
		getContentPane().add(comboBoxPlataforma);
		
		
		comboBoxEspectaculo = new JComboBox<String>();
		comboBoxEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarTextField();							
			}
		});
		comboBoxEspectaculo.setBounds(382, 50, 137, 22);
		getContentPane().add(comboBoxEspectaculo);
		
		JLabel lblNewLabel_1 = new JLabel("Espectaculo");
		lblNewLabel_1.setBounds(292, 54, 68, 14);
		getContentPane().add(lblNewLabel_1);
		
		JPanel panel = new JPanel();
		panel.setToolTipText("Espectaculo");
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 103, 365, 388);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 11, 48, 14);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(10, 35, 88, 14);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Duracion (Horas)");
		lblNewLabel_4.setBounds(10, 60, 136, 14);
		panel.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Minimo Espectadores");
		lblNewLabel_5.setBounds(10, 95, 162, 14);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Maximo Espectadores");
		lblNewLabel_6.setBounds(10, 121, 136, 14);
		panel.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Url");
		lblNewLabel_7.setBounds(10, 146, 88, 14);
		panel.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Costo ($)");
		lblNewLabel_8.setBounds(10, 173, 105, 14);
		panel.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Fecha de Regsitro");
		lblNewLabel_9.setBounds(10, 207, 88, 14);
		panel.add(lblNewLabel_9);
		
		textFieldNombreE = new JTextField();
		textFieldNombreE.setEditable(false);
		textFieldNombreE.setBounds(116, 8, 223, 20);
		panel.add(textFieldNombreE);
		textFieldNombreE.setColumns(10);
		
		textFieldDescripcionE = new JTextField();
		textFieldDescripcionE.setEditable(false);
		textFieldDescripcionE.setBounds(116, 32, 223, 20);
		panel.add(textFieldDescripcionE);
		textFieldDescripcionE.setColumns(10);
		
		textFieldDuracionE = new JTextField();
		textFieldDuracionE.setEditable(false);
		textFieldDuracionE.setBounds(291, 57, 48, 20);
		panel.add(textFieldDuracionE);
		textFieldDuracionE.setColumns(10);
		
		textFieldMinEspectactoresE = new JTextField();
		textFieldMinEspectactoresE.setEditable(false);
		textFieldMinEspectactoresE.setBounds(291, 92, 48, 20);
		panel.add(textFieldMinEspectactoresE);
		textFieldMinEspectactoresE.setColumns(10);
		
		textFieldMaxEspectactadoresE = new JTextField();
		textFieldMaxEspectactadoresE.setEditable(false);
		textFieldMaxEspectactadoresE.setBounds(291, 118, 48, 20);
		panel.add(textFieldMaxEspectactadoresE);
		textFieldMaxEspectactadoresE.setColumns(10);
		
		textFieldUrlE = new JTextField();
		textFieldUrlE.setEditable(false);
		textFieldUrlE.setBounds(116, 143, 223, 20);
		panel.add(textFieldUrlE);
		textFieldUrlE.setColumns(10);
		
		textFieldCostoE = new JTextField();
		textFieldCostoE.setEditable(false);
		textFieldCostoE.setBounds(291, 170, 48, 20);
		panel.add(textFieldCostoE);
		textFieldCostoE.setColumns(10);
		
		textFieldFechaRegistroE = new JTextField();
		textFieldFechaRegistroE.setEditable(false);
		textFieldFechaRegistroE.setBounds(116, 204, 223, 20);
		panel.add(textFieldFechaRegistroE);
		textFieldFechaRegistroE.setColumns(10);
		
		JLabel lblFunciones = new JLabel("Funciones");
		lblFunciones.setBounds(10, 253, 68, 14);
		panel.add(lblFunciones);
		
		JLabel lblPaquetes = new JLabel("Paquetes");
		lblPaquetes.setBounds(10, 282, 68, 14);
		panel.add(lblPaquetes);
		
		comboBoxFuncion = new JComboBox<String>();
		comboBoxFuncion.setBounds(76, 249, 114, 22);
		panel.add(comboBoxFuncion);
		
		comboBoxPaquete = new JComboBox<String>();
		comboBoxPaquete.setBounds(76, 278, 114, 22);
		panel.add(comboBoxPaquete);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(385, 103, 429, 194);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_12 = new JLabel("Detalles de Funcion");
		lblNewLabel_12.setBounds(392, 83, 266, 14);
		getContentPane().add(lblNewLabel_12);
		
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(385, 328, 429, 160);
		getContentPane().add(panel_1_1);
		panel_1_1.setLayout(null);
		
		JLabel lblNewLabel_12_1 = new JLabel("Detalles de Paquete");
		lblNewLabel_12_1.setBounds(395, 308, 263, 14);
		getContentPane().add(lblNewLabel_12_1);
		
		JButton btnNewButton = new JButton("Ver Detalles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDetallesFuncion();
			}
		});
		btnNewButton.setBounds(200, 249, 127, 23);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Ver detalles");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDetallesPaquete();
			}
		});
		btnNewButton_1.setBounds(200, 278, 127, 23);
		panel.add(btnNewButton_1);
		
		
		
		JLabel lblNewLabel_10 = new JLabel("Nombre");
		lblNewLabel_10.setBounds(10, 23, 74, 14);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Fecha");
		lblNewLabel_10_1.setBounds(10, 48, 48, 14);
		panel_1.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("Hora Inicio");
		lblNewLabel_10_1_1.setBounds(10, 73, 82, 14);
		panel_1.add(lblNewLabel_10_1_1);
		
		JLabel lblNewLabel_10_1_1_1 = new JLabel("Fecha Registro");
		lblNewLabel_10_1_1_1.setBounds(10, 98, 74, 14);
		panel_1.add(lblNewLabel_10_1_1_1);
		
		textFieldNombreF = new JTextField();
		textFieldNombreF.setEditable(false);
		textFieldNombreF.setBounds(94, 20, 96, 20);
		panel_1.add(textFieldNombreF);
		textFieldNombreF.setColumns(10);
		
		textFieldFechaF = new JTextField();
		textFieldFechaF.setEditable(false);
		textFieldFechaF.setBounds(94, 45, 96, 20);
		panel_1.add(textFieldFechaF);
		textFieldFechaF.setColumns(10);
		
		textFieldHoraF = new JTextField();
		textFieldHoraF.setEditable(false);
		textFieldHoraF.setBounds(94, 70, 96, 20);
		panel_1.add(textFieldHoraF);
		textFieldHoraF.setColumns(10);
		
		textFieldFechaRF = new JTextField();
		textFieldFechaRF.setEditable(false);
		textFieldFechaRF.setBounds(94, 95, 96, 20);
		panel_1.add(textFieldFechaRF);
		textFieldFechaRF.setColumns(10);
		
		JLabel lblNewLabel_11 = new JLabel("Artistas invitados");
		lblNewLabel_11.setBounds(210, 11, 149, 14);
		panel_1.add(lblNewLabel_11);
		
		txtpnInvitados = new JTextPane();
		txtpnInvitados.setBounds(210, 27, 200, 156);
		panel_1.add(txtpnInvitados);
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados. ");
		txtpnInvitados.setEditable(false);
		
		
		JLabel lblNewLabel_10_2 = new JLabel("Nombre");
		lblNewLabel_10_2.setBounds(10, 29, 48, 14);
		panel_1_1.add(lblNewLabel_10_2);
		
		JLabel lblNewLabel_10_1_2 = new JLabel("Descripcion");
		lblNewLabel_10_1_2.setBounds(239, 29, 74, 14);
		panel_1_1.add(lblNewLabel_10_1_2);
		
		JLabel lblNewLabel_10_1_1_2 = new JLabel("Fecha Inicio");
		lblNewLabel_10_1_1_2.setBounds(10, 63, 74, 14);
		panel_1_1.add(lblNewLabel_10_1_1_2);
		
		JLabel lblNewLabel_10_1_1_1_1 = new JLabel("Fecha Final");
		lblNewLabel_10_1_1_1_1.setBounds(239, 63, 74, 14);
		panel_1_1.add(lblNewLabel_10_1_1_1_1);
		
		textFieldNombrePaq = new JTextField();
		textFieldNombrePaq.setEditable(false);
		textFieldNombrePaq.setColumns(10);
		textFieldNombrePaq.setBounds(94, 26, 96, 20);
		panel_1_1.add(textFieldNombrePaq);
		
		textFieldDescripcionPaq = new JTextField();
		textFieldDescripcionPaq.setEditable(false);
		textFieldDescripcionPaq.setColumns(10);
		textFieldDescripcionPaq.setBounds(323, 26, 96, 20);
		panel_1_1.add(textFieldDescripcionPaq);
		
		textFieldFinicioPaq = new JTextField();
		textFieldFinicioPaq.setEditable(false);
		textFieldFinicioPaq.setColumns(10);
		textFieldFinicioPaq.setBounds(94, 60, 96, 20);
		panel_1_1.add(textFieldFinicioPaq);
		
		textFieldFfinalPaq = new JTextField();
		textFieldFfinalPaq.setEditable(false);
		textFieldFfinalPaq.setColumns(10);
		textFieldFfinalPaq.setBounds(323, 60, 96, 20);
		panel_1_1.add(textFieldFfinalPaq);
		
		JLabel lblNewLabel_10_1_1_1_1_1 = new JLabel("Descuento (%)");
		lblNewLabel_10_1_1_1_1_1.setBounds(228, 106, 85, 14);
		panel_1_1.add(lblNewLabel_10_1_1_1_1_1);
		
		textFieldDescuentoPaq = new JTextField();
		textFieldDescuentoPaq.setEditable(false);
		textFieldDescuentoPaq.setColumns(10);
		textFieldDescuentoPaq.setBounds(323, 103, 96, 20);
		panel_1_1.add(textFieldDescuentoPaq);
		
		JLabel lblNewLabel_10_1_1_1_1_1_1 = new JLabel("Costo");
		lblNewLabel_10_1_1_1_1_1_1.setBounds(10, 106, 74, 14);
		panel_1_1.add(lblNewLabel_10_1_1_1_1_1_1);
		
		textFieldCostoPaq = new JTextField();
		textFieldCostoPaq.setEditable(false);
		textFieldCostoPaq.setColumns(10);
		textFieldCostoPaq.setBounds(94, 103, 96, 20);
		panel_1_1.add(textFieldCostoPaq);
		
		JLabel lblNewLabel_10_1_1_1_1_1_1_1 = new JLabel("Fecha de Alta");
		lblNewLabel_10_1_1_1_1_1_1_1.setBounds(10, 134, 74, 14);
		panel_1_1.add(lblNewLabel_10_1_1_1_1_1_1_1);
		
		textFieldFaltaPaq = new JTextField();
		textFieldFaltaPaq.setEditable(false);
		textFieldFaltaPaq.setColumns(10);
		textFieldFaltaPaq.setBounds(94, 131, 96, 20);
		panel_1_1.add(textFieldFaltaPaq);
		
		JButton btnNewButton_2 = new JButton("Volver");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarForm();
				setVisible(false);
			}
		});
		btnNewButton_2.setBounds(722, 499, 89, 23);
		getContentPane().add(btnNewButton_2);		
		
	
		
		JLabel lblNewLabel_12_2 = new JLabel("Detalles de Espectaculo");
		lblNewLabel_12_2.setBounds(10, 83, 129, 14);
		getContentPane().add(lblNewLabel_12_2);

	}
	
	public void InicializarComboBoxes() {
		DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(iconP.getPlataformas());
		comboBoxPlataforma.setModel(modelPlataforma);
	}
	
	public void InicializarComboBoxEspectaculo() {
		DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(iconE.getArrEspectaculos((String) comboBoxPlataforma.getSelectedItem().toString()));
		comboBoxEspectaculo.setModel(modelEspectaculo);
	}
	
	public void InicializarComboBoxFuncion() {
		DefaultComboBoxModel<String> modelFuncion = new DefaultComboBoxModel<String>(iconE.listarFunciones((String) comboBoxEspectaculo.getSelectedItem().toString()));
		comboBoxFuncion.setModel(modelFuncion);
	}
	
	public void InicializarComboBoxPaquete() {
		DefaultComboBoxModel<String> modelPaquete = new DefaultComboBoxModel<String>(iconE.listarPaquetes((String) comboBoxEspectaculo.getSelectedItem().toString()));
		comboBoxPaquete.setModel(modelPaquete);
	}
	
	
	public void CargarTextField() {
		DtEspectaculo e = iconE.buscarEspectaculoNombre((String) comboBoxEspectaculo.getSelectedItem());
		textFieldNombreE.setText(e.getNombreEsp());
		textFieldDescripcionE.setText(e.getDescripcion());
		textFieldDuracionE.setText(Integer.toString(e.getDuracion()));
		textFieldCostoE.setText(Float.toString(e.getCosto()));
		textFieldMaxEspectactadoresE.setText(Integer.toString(e.getMaxEspectadores()));
		textFieldMinEspectactoresE.setText(Integer.toString(e.getMinEspectadores()));
		textFieldFechaRegistroE.setText(new SimpleDateFormat("dd-MM-yyyy").format(e.getFechaRegistro()));
		textFieldUrlE.setText(e.getUrl());
		InicializarComboBoxFuncion();
		InicializarComboBoxPaquete();
		limpiarFormFuncion();
		limpiarFormPaquete();
		
	}
	

	public void getDetallesFuncion() {
		DtFuncion dtF = iconE.getDtFuncion((String) comboBoxEspectaculo.getSelectedItem().toString(), (String) comboBoxFuncion.getSelectedItem().toString()); 
		textFieldNombreF.setText(dtF.getNomFun());
		textFieldFechaF.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtF.getFechaFuncion()));
		textFieldFechaRF.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtF.getFechaRegistroFun()));
		textFieldHoraF.setText(new SimpleDateFormat("HH:mm").format(dtF.getFechaFuncion()));
		for(String art: dtF.getInvitados()) { // concateno usuarios para mostrar 
			if(artistasInvitados == "") {
				artistasInvitados += art ; // el primero no lleva coma
			}else {
				artistasInvitados += ", " + art ;	
			}
			
		};
		txtpnInvitados.setText("Artistas Invitados: " + artistasInvitados);
	
	}
	
	public void getDetallesPaquete() {
		DtPaquete dtP = iconPaq.infoPaquete((String) comboBoxPaquete.getSelectedItem().toString()); 
		textFieldNombrePaq.setText(dtP.getNombre());
		textFieldDescripcionPaq.setText(dtP.getDescripcion());
		textFieldDescuentoPaq.setText(Integer.toString(dtP.getDescuento()));
		textFieldFaltaPaq.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtP.getfAlta()));
		textFieldFfinalPaq.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtP.getfFinal()));
		textFieldFinicioPaq.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtP.getfInicio()));
		textFieldCostoPaq.setText(Float.toString(dtP.getCosto()));
	}
	
	public void limpiarForm() {
		
		textFieldNombreF.setText("");
		textFieldFechaF.setText("");
		textFieldFechaRF.setText("");
		textFieldHoraF.setText("");
		textFieldNombreE.setText("");
		textFieldDescripcionE.setText("");
		textFieldDuracionE.setText("");
		textFieldCostoE.setText("");
		textFieldMaxEspectactadoresE.setText("");
		textFieldMinEspectactoresE.setText("");
		textFieldFechaRegistroE.setText("");
		textFieldUrlE.setText("");
		textFieldNombrePaq.setText("");
		textFieldDescripcionPaq.setText("");
		textFieldDescuentoPaq.setText("");
		textFieldFaltaPaq.setText("");
		textFieldFfinalPaq.setText("");
		textFieldFfinalPaq.setText("");
		textFieldFinicioPaq.setText("");
		textFieldCostoPaq.setText("");
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados.");
		DefaultComboBoxModel<String> modelVacio = new DefaultComboBoxModel<String>();
		comboBoxPlataforma.setModel(modelVacio);
		comboBoxFuncion.setModel(modelVacio);
		comboBoxEspectaculo.setModel(modelVacio);
		comboBoxPaquete.setModel(modelVacio);
	}
	
	public void limpiarFormFuncion() {
		
		textFieldNombreF.setText("");
		textFieldFechaF.setText("");
		textFieldFechaRF.setText("");
		textFieldHoraF.setText("");
		
	}
	
	public void limpiarFormPaquete() {
		
		textFieldNombrePaq.setText("");
		textFieldDescripcionPaq.setText("");
		textFieldDescuentoPaq.setText("");
		textFieldFaltaPaq.setText("");
		textFieldFfinalPaq.setText("");
		textFieldFfinalPaq.setText("");
		textFieldFinicioPaq.setText("");
		textFieldCostoPaq.setText("");
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados.");
		
	}
	
	public void limpiarFormEspectaculo() {
		
		textFieldNombreE.setText("");
		textFieldDescripcionE.setText("");
		textFieldDuracionE.setText("");
		textFieldCostoE.setText("");
		textFieldMaxEspectactadoresE.setText("");
		textFieldMinEspectactoresE.setText("");
		textFieldFechaRegistroE.setText("");
		textFieldUrlE.setText("");
		DefaultComboBoxModel<String> modelVacio = new DefaultComboBoxModel<String>();
		comboBoxPaquete.setModel(modelVacio);
		comboBoxFuncion.setModel(modelVacio);
		
	}

}
