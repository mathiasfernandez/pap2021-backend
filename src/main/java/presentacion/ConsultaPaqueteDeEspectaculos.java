package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

import interfaces.IcEspectaculo;
import interfaces.IcPaquete;
import interfaces.IcPlataforma;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;

import antlr.collections.List;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaquete;

import java.awt.event.ItemListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.event.ItemEvent;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import java.awt.SystemColor;
import javax.swing.JTextPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ConsultaPaqueteDeEspectaculos extends JInternalFrame {
	private IcEspectaculo iconE;
	private IcPlataforma iconP;
	private IcPaquete iconPaq;
	private JTable tablaEspectaculos;
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
	private String artistasInvitados = "";
	private JTextPane txtpnInvitados;

	public ConsultaPaqueteDeEspectaculos(IcPaquete icon, IcEspectaculo iconE, IcPlataforma iconP) {
		setClosable(true);
		ArrayList<String> espectaculos = icon.listarPaquetes();
		this.iconE = iconE;
		this.iconP = iconP;
		
		setBounds(100, 100, 886, 460);
		getContentPane().setLayout(null);
		
		JLabel lblConsultaPaquete = new JLabel("CONSULTA PAQUETE");
		lblConsultaPaquete.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblConsultaPaquete.setBounds(10, 11, 258, 29);
		getContentPane().add(lblConsultaPaquete);
		
		JLabel lblNewLabel = new JLabel("Nombre");
		lblNewLabel.setBounds(10, 91, 73, 14);
		getContentPane().add(lblNewLabel);
		
		JLabel lblDescripcion = new JLabel("Descripcion");
		lblDescripcion.setBounds(10, 114, 73, 14);
		getContentPane().add(lblDescripcion);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio");
		lblFechaInicio.setBounds(10, 139, 73, 14);
		getContentPane().add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin");
		lblFechaFin.setBounds(10, 163, 73, 14);
		getContentPane().add(lblFechaFin);
		
		JLabel lblDescuento = new JLabel("Descuento");
		lblDescuento.setBounds(10, 188, 73, 14);
		getContentPane().add(lblDescuento);
		
		JLabel lblFechaAlta = new JLabel("Fecha Alta");
		lblFechaAlta.setBounds(10, 213, 73, 14);
		getContentPane().add(lblFechaAlta);
		
		JLabel lblPrecio = new JLabel("Precio");
		lblPrecio.setBounds(10, 238, 73, 14);
		getContentPane().add(lblPrecio);
		
		DefaultTableModel tableModel = new DefaultTableModel(){
			public boolean isCellEditable(int row, int column)
			 {
			     return false;
			 }
		};
		tablaEspectaculos = new JTable(tableModel);
		tableModel.addColumn("Espectaculos");
		tablaEspectaculos.setBounds(10, 263, 259, 123);
		getContentPane().add(tablaEspectaculos);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setToolTipText("Espectaculo");
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel.setBackground(SystemColor.control);
		panel.setBounds(278, 31, 365, 388);
		getContentPane().add(panel);
		
		JComboBox comboBoxFuncion = new JComboBox();
		comboBoxFuncion.setBounds(76, 249, 120, 22);
		panel.add(comboBoxFuncion);
		
		JButton btnConsultarEspectaculo = new JButton("VER ESPECTACULO");
		btnConsultarEspectaculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DtEspectaculo DTe = iconE.buscarEspectaculoNombre(String.valueOf(tableModel.getValueAt(tablaEspectaculos.getSelectedRow(),0)));
				textFieldNombreE.setText(DTe.getNombreEsp());
				textFieldDescripcionE.setText(DTe.getDescripcion());
				textFieldDuracionE.setText(Integer.toString(DTe.getDuracion()));
				textFieldCostoE.setText(Float.toString(DTe.getCosto()));
				textFieldMaxEspectactadoresE.setText(Integer.toString(DTe.getMaxEspectadores()));
				textFieldMinEspectactoresE.setText(Integer.toString(DTe.getMinEspectadores()));
				textFieldFechaRegistroE.setText(new SimpleDateFormat("dd-MM-yyyy").format(DTe.getFechaRegistro()));
				textFieldUrlE.setText(DTe.getUrl());
				String[] esps = iconE.listarFunciones(String.valueOf(tableModel.getValueAt(tablaEspectaculos.getSelectedRow(),0)));
				
				for (int i=0; i<esps.length; i++) { 
					comboBoxFuncion.addItem(esps[i]); 
				}
				comboBoxFuncion.setSelectedIndex(-1);
				limpiarFormFuncion();
			}
		});
		btnConsultarEspectaculo.setBounds(10, 396, 258, 23);
		getContentPane().add(btnConsultarEspectaculo);
		
		JLabel txtNom = new JLabel("....");
		txtNom.setHorizontalAlignment(SwingConstants.CENTER);
		txtNom.setVisible(false);
		txtNom.setForeground(new Color(255, 51, 0));
		txtNom.setBounds(93, 87, 175, 22);
		getContentPane().add(txtNom);
		
		JLabel txtDes = new JLabel("....");
		txtDes.setVisible(false);
		txtDes.setHorizontalAlignment(SwingConstants.CENTER);
		txtDes.setForeground(new Color(255, 51, 0));
		txtDes.setBounds(93, 114, 175, 22);
		getContentPane().add(txtDes);
		
		JLabel txtFechaIn = new JLabel("....");
		txtFechaIn.setVisible(false);
		txtFechaIn.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaIn.setForeground(new Color(255, 51, 0));
		txtFechaIn.setBounds(93, 139, 175, 22);
		getContentPane().add(txtFechaIn);
		
		JLabel txtFechaFin = new JLabel("....");
		txtFechaFin.setVisible(false);
		txtFechaFin.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaFin.setForeground(new Color(255, 51, 0));
		txtFechaFin.setBounds(93, 163, 175, 22);
		getContentPane().add(txtFechaFin);
		
		JLabel txtDesc = new JLabel("....");
		txtDesc.setVisible(false);
		txtDesc.setHorizontalAlignment(SwingConstants.CENTER);
		txtDesc.setForeground(new Color(255, 51, 0));
		txtDesc.setBounds(93, 188, 175, 22);
		getContentPane().add(txtDesc);
		
		JLabel txtFechaAlta = new JLabel("....");
		txtFechaAlta.setVisible(false);
		txtFechaAlta.setHorizontalAlignment(SwingConstants.CENTER);
		txtFechaAlta.setForeground(new Color(255, 51, 0));
		txtFechaAlta.setBounds(93, 213, 175, 22);
		getContentPane().add(txtFechaAlta);
		
		JLabel txtPrecio = new JLabel("....");
		txtPrecio.setVisible(false);
		txtPrecio.setHorizontalAlignment(SwingConstants.CENTER);
		txtPrecio.setForeground(new Color(255, 51, 0));
		txtPrecio.setBounds(93, 238, 175, 22);
		getContentPane().add(txtPrecio);
		
		JComboBox cmbPaquetes = new JComboBox(espectaculos.toArray());
		cmbPaquetes.setSelectedIndex(-1);
		cmbPaquetes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				DtPaquete pac = icon.infoPaquete(cmbPaquetes.getSelectedItem().toString());
				DateFormat dateFormat = new SimpleDateFormat("dd-mm-yyyy");  
				String finicio = dateFormat.format(pac.getfInicio());  
				String ffin = dateFormat.format(pac.getfFinal());
				String falta = dateFormat.format(pac.getfAlta());
				txtNom.setText(pac.getNombre());
				txtDes.setText(pac.getDescripcion());
				txtFechaIn.setText(finicio);
				txtFechaFin.setText(ffin);
				txtDesc.setText(pac.getDescripcion());
				txtFechaAlta.setText(falta);
				txtPrecio.setText(String.valueOf(pac.getCosto()));
				txtNom.setVisible(true);
				txtDes.setVisible(true);
				txtFechaIn.setVisible(true);
				txtFechaFin.setVisible(true);
				txtDesc.setVisible(true);
				txtFechaAlta.setVisible(true);
				txtPrecio.setVisible(true);
				ArrayList<DtEspectaculo> esps = new ArrayList();
				esps.addAll(pac.getEspectaculos());
				tableModel.setRowCount(0);
				for(DtEspectaculo esp: esps) {
					tableModel.insertRow(0, new Object[] { "" + esp.getNombreEsp() + "" });			
				}
			}
		});
		cmbPaquetes.setBounds(10, 48, 258, 22);
		getContentPane().add(cmbPaquetes);
		
		JLabel lblNewLabel_12_2 = new JLabel("Detalles de Espectaculo");
		lblNewLabel_12_2.setBounds(278, 11, 129, 14);
		getContentPane().add(lblNewLabel_12_2);
		
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
		textFieldNombreE.setColumns(10);
		textFieldNombreE.setBounds(116, 8, 223, 20);
		panel.add(textFieldNombreE);
		
		textFieldDescripcionE = new JTextField();
		textFieldDescripcionE.setEditable(false);
		textFieldDescripcionE.setColumns(10);
		textFieldDescripcionE.setBounds(116, 32, 223, 20);
		panel.add(textFieldDescripcionE);
		
		textFieldDuracionE = new JTextField();
		textFieldDuracionE.setEditable(false);
		textFieldDuracionE.setColumns(10);
		textFieldDuracionE.setBounds(291, 57, 48, 20);
		panel.add(textFieldDuracionE);
		
		textFieldMinEspectactoresE = new JTextField();
		textFieldMinEspectactoresE.setEditable(false);
		textFieldMinEspectactoresE.setColumns(10);
		textFieldMinEspectactoresE.setBounds(291, 92, 48, 20);
		panel.add(textFieldMinEspectactoresE);
		
		textFieldMaxEspectactadoresE = new JTextField();
		textFieldMaxEspectactadoresE.setEditable(false);
		textFieldMaxEspectactadoresE.setColumns(10);
		textFieldMaxEspectactadoresE.setBounds(291, 118, 48, 20);
		panel.add(textFieldMaxEspectactadoresE);
		
		textFieldUrlE = new JTextField();
		textFieldUrlE.setEditable(false);
		textFieldUrlE.setColumns(10);
		textFieldUrlE.setBounds(116, 143, 223, 20);
		panel.add(textFieldUrlE);
		
		textFieldCostoE = new JTextField();
		textFieldCostoE.setEditable(false);
		textFieldCostoE.setColumns(10);
		textFieldCostoE.setBounds(291, 170, 48, 20);
		panel.add(textFieldCostoE);
		
		textFieldFechaRegistroE = new JTextField();
		textFieldFechaRegistroE.setEditable(false);
		textFieldFechaRegistroE.setColumns(10);
		textFieldFechaRegistroE.setBounds(116, 204, 223, 20);
		panel.add(textFieldFechaRegistroE);
		
		JLabel lblFunciones = new JLabel("Funciones");
		lblFunciones.setBounds(10, 253, 68, 14);
		panel.add(lblFunciones);
		
		JButton btnNewButton = new JButton("Ver Detalles");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDetallesFuncion(String.valueOf(tableModel.getValueAt(tablaEspectaculos.getSelectedRow(),0)),comboBoxFuncion.getSelectedItem().toString());
			}
		});
		btnNewButton.setBounds(212, 249, 127, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel_12 = new JLabel("Detalles de Funcion");
		lblNewLabel_12.setBounds(658, 11, 266, 14);
		getContentPane().add(lblNewLabel_12);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_1.setBackground(SystemColor.control);
		panel_1.setBounds(658, 31, 201, 388);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_10 = new JLabel("Nombre");
		lblNewLabel_10.setBounds(10, 20, 74, 14);
		panel_1.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Fecha");
		lblNewLabel_10_1.setBounds(10, 48, 48, 14);
		panel_1.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("Hora Inicio");
		lblNewLabel_10_1_1.setBounds(10, 78, 82, 14);
		panel_1.add(lblNewLabel_10_1_1);
		
		JLabel lblNewLabel_10_1_1_1 = new JLabel("Fecha Registro");
		lblNewLabel_10_1_1_1.setBounds(10, 109, 74, 14);
		panel_1.add(lblNewLabel_10_1_1_1);
		
		textFieldNombreF = new JTextField();
		textFieldNombreF.setEditable(false);
		textFieldNombreF.setColumns(10);
		textFieldNombreF.setBounds(94, 17, 96, 20);
		panel_1.add(textFieldNombreF);
		
		textFieldFechaF = new JTextField();
		textFieldFechaF.setEditable(false);
		textFieldFechaF.setColumns(10);
		textFieldFechaF.setBounds(94, 45, 96, 20);
		panel_1.add(textFieldFechaF);
		
		textFieldHoraF = new JTextField();
		textFieldHoraF.setEditable(false);
		textFieldHoraF.setColumns(10);
		textFieldHoraF.setBounds(94, 75, 96, 20);
		panel_1.add(textFieldHoraF);
		
		textFieldFechaRF = new JTextField();
		textFieldFechaRF.setEditable(false);
		textFieldFechaRF.setColumns(10);
		textFieldFechaRF.setBounds(94, 106, 96, 20);
		panel_1.add(textFieldFechaRF);
		
		JLabel lblNewLabel_11 = new JLabel("Artistas invitados");
		lblNewLabel_11.setBounds(10, 137, 149, 14);
		panel_1.add(lblNewLabel_11);
		
		JTextPane txtpnInvitados = new JTextPane();
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados. ");
		txtpnInvitados.setEditable(false);
		txtpnInvitados.setBounds(10, 153, 180, 224);
		panel_1.add(txtpnInvitados);
	}
	
	/*public void CargarTextField(String esp) {
		
	}*/
	

	public void getDetallesFuncion(String esp, String fun) {
		DtFuncion dtF = iconE.getDtFuncion(esp, fun); 
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
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados.");
		DefaultComboBoxModel<String> modelVacio = new DefaultComboBoxModel<String>();

	}
	
	public void limpiarFormFuncion() {
		
		textFieldNombreF.setText("");
		textFieldFechaF.setText("");
		textFieldFechaRF.setText("");
		textFieldHoraF.setText("");
		
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
		
	}
	private static class __Tmp {
		private static void __tmp() {
			  javax.swing.JPanel __wbp_panel = new javax.swing.JPanel();
		}
	}
}
