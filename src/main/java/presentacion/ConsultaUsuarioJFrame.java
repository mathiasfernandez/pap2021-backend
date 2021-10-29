package presentacion;

import java.awt.Color;
import java.awt.Window;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;

import interfaces.IcEspectaculo;
import interfaces.IcPaquete;
import interfaces.IcUsuario;
import javax.swing.JTextPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import datatypes.DtArtista;
import datatypes.DtEspectaculo;
import datatypes.DtFuncion;
import datatypes.DtPaquete;
import datatypes.DtUsuario;

import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;

public class ConsultaUsuarioJFrame extends JInternalFrame {
	
	
	private IcUsuario iconU;
	private IcEspectaculo iconE;
	private IcPaquete iconPaq;
	
	private JComboBox<String> comboBoxUsuario;
	private JComboBox<String> comboBoxEspectaculoA;
	private JComboBox<String> comboBoxFuncionEs;
	private JComboBox<String> comboBoxPaqueteEs;
	private JComboBox<String> comboBoxFuncionU;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textFieldNickname;
	private JTextField textFieldNombre;
	private JTextField textFieldApellido;
	private JTextField textFieldEmail;
	private JTextField textFieldFnac;
	private JTextField textFieldSitioWeb;
	private JTextField textFieldBibliografia;
	private JTextField textFieldDescripcion;
	private JTextField textFieldNombreE;
	private JTextField textFieldDescripcionE;
	private JTextField textFieldDuracionE;
	private JTextField textFieldMinEspectadoresE;
	private JTextField textFieldMaxEspectadoresE;
	private JTextField textFieldUrlE;
	private JTextField textFieldCostoE;
	private JTextField textFieldFechaRegistroE;
	private JTextField textFieldNombrePaq;
	private JTextField textFieldDescripcionPaq;
	private JTextField textFieldFinicioPaq;
	private JTextField textFieldFfinalPaq;
	private JTextField textFieldDescuentoPaq;
	private JTextField textFieldCostoPaq;
	private JTextField textFieldFaltaPaq;
	private JTextField textFieldNombreF;
	private JTextField textFieldFechaF;
	private JTextField textFieldHoraF;
	private JTextField textFieldFechaRF;
	private String artistasInvitados = "";
	private JTextPane txtpnInvitados;
	private JPanel panelEspectador;
	private JPanel panelArtista;

	/**
	 * Create the frame.
	 * @param iconU 
	 */
	public ConsultaUsuarioJFrame(IcUsuario iconU,IcEspectaculo iconE,IcPaquete iconP) {
		getContentPane().setBackground(Color.LIGHT_GRAY);
		this.iconU = iconU;
		this.iconE = iconE;
		this.iconPaq = iconP;
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		setTitle("Consulta Usuario");
		
		setBounds(100, 100, 1246, 575);
		getContentPane().setLayout(null);
		
		JButton btnCancelar = new JButton("Volver");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarForm();
				setVisible(false);
			}
		});
		btnCancelar.setBounds(1132, 511, 89, 23);
		getContentPane().add(btnCancelar);
		
		JLabel lblNewLabel = new JLabel("Listado de usuarios");
		lblNewLabel.setBounds(596, 32, 155, 14);
		getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 105, 403, 407);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabelNicknameU = new JLabel("NickName");
		lblNewLabelNicknameU.setBounds(10, 14, 108, 14);
		panel.add(lblNewLabelNicknameU);
		
		textFieldNickname = new JTextField();
		textFieldNickname.setEditable(false);
		textFieldNickname.setColumns(10);
		textFieldNickname.setBounds(149, 11, 146, 20);
		panel.add(textFieldNickname);
		
		JLabel lblNewLabelNombreU = new JLabel("Nombre");
		lblNewLabelNombreU.setBounds(10, 39, 66, 14);
		panel.add(lblNewLabelNombreU);
		
		textFieldNombre = new JTextField();
		textFieldNombre.setEditable(false);
		textFieldNombre.setColumns(10);
		textFieldNombre.setBounds(149, 36, 146, 20);
		panel.add(textFieldNombre);
		
		JLabel lblNewLabel_4_1 = new JLabel("Apellido");
		lblNewLabel_4_1.setBounds(10, 64, 40, 14);
		panel.add(lblNewLabel_4_1);
		
		textFieldApellido = new JTextField();
		textFieldApellido.setEditable(false);
		textFieldApellido.setColumns(10);
		textFieldApellido.setBounds(149, 61, 146, 20);
		panel.add(textFieldApellido);
		
		textFieldEmail = new JTextField();
		textFieldEmail.setEditable(false);
		textFieldEmail.setColumns(10);
		textFieldEmail.setBounds(149, 89, 146, 20);
		panel.add(textFieldEmail);
		
		JLabel lblNewLabel_4_1_1 = new JLabel("Email");
		lblNewLabel_4_1_1.setBounds(10, 92, 40, 14);
		panel.add(lblNewLabel_4_1_1);
		
		textFieldFnac = new JTextField();
		textFieldFnac.setEditable(false);
		textFieldFnac.setColumns(10);
		textFieldFnac.setBounds(149, 120, 146, 20);
		panel.add(textFieldFnac);
		
		JLabel lblNewLabel_4_1_2 = new JLabel("Fecha de Nacimiento");
		lblNewLabel_4_1_2.setBounds(10, 123, 108, 14);
		panel.add(lblNewLabel_4_1_2);
		
		panelArtista = new JPanel();
		panelArtista.setBounds(10, 186, 387, 210);
		panel.add(panelArtista);
		panelArtista.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelArtista.setBackground(Color.LIGHT_GRAY);
		panelArtista.setLayout(null);
		
		JLabel lblNewLabel_4_1_2_1 = new JLabel("Sitio Web");
		lblNewLabel_4_1_2_1.setBounds(10, 14, 108, 14);
		panelArtista.add(lblNewLabel_4_1_2_1);
		
		textFieldSitioWeb = new JTextField();
		textFieldSitioWeb.setBounds(138, 11, 146, 20);
		panelArtista.add(textFieldSitioWeb);
		textFieldSitioWeb.setEditable(false);
		textFieldSitioWeb.setColumns(10);
		
		JLabel lblNewLabel_4_1_2_1_1 = new JLabel("Bibliografia");
		lblNewLabel_4_1_2_1_1.setBounds(10, 39, 108, 14);
		panelArtista.add(lblNewLabel_4_1_2_1_1);
		
		textFieldBibliografia = new JTextField();
		textFieldBibliografia.setBounds(138, 44, 146, 63);
		panelArtista.add(textFieldBibliografia);
		textFieldBibliografia.setEditable(false);
		textFieldBibliografia.setColumns(10);
		
		JLabel lblNewLabel_4_1_2_1_1_1 = new JLabel("Descripcion");
		lblNewLabel_4_1_2_1_1_1.setBounds(10, 111, 108, 14);
		panelArtista.add(lblNewLabel_4_1_2_1_1_1);
		
		textFieldDescripcion = new JTextField();
		textFieldDescripcion.setBounds(138, 113, 146, 63);
		panelArtista.add(textFieldDescripcion);
		textFieldDescripcion.setEditable(false);
		textFieldDescripcion.setColumns(10);
		
		JLabel lblListadoDeEspectaculos = new JLabel("Listado de Espectaculos");
		lblListadoDeEspectaculos.setBounds(10, 187, 130, 14);
		panelArtista.add(lblListadoDeEspectaculos);
		
		comboBoxEspectaculoA = new JComboBox<String>();
		comboBoxEspectaculoA.setBounds(138, 183, 144, 22);
		panelArtista.add(comboBoxEspectaculoA);
		
		JButton btnDetallesE = new JButton("Detalles");
		btnDetallesE.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CargarTextFieldEspectaculo();
			}
		});
		btnDetallesE.setBounds(292, 183, 89, 23);
		panelArtista.add(btnDetallesE);
		
		panelEspectador = new JPanel();
		panelEspectador.setBounds(10, 149, 387, 36);
		panel.add(panelEspectador);
		panelEspectador.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panelEspectador.setBackground(Color.LIGHT_GRAY);
		panelEspectador.setLayout(null);
		
		JLabel lblListadoDeFunciones = new JLabel("Listado de Funciones");
		lblListadoDeFunciones.setBounds(10, 11, 163, 14);
		panelEspectador.add(lblListadoDeFunciones);
		
		comboBoxFuncionU = new JComboBox<String>();
		comboBoxFuncionU.setBounds(136, 7, 150, 22);
		panelEspectador.add(comboBoxFuncionU);
		
		JButton btnDetallesF = new JButton("Detalles");
		btnDetallesF.setBounds(288, 7, 89, 23);
		panelEspectador.add(btnDetallesF);
		
		comboBoxUsuario = new JComboBox<String>();
		comboBoxUsuario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				limpiarFormUsuario();
				limpiarFormPaquete();
				limpiarFuncion();
				limpiarEspectaculo();
				String usuario = String.valueOf(comboBoxUsuario.getSelectedItem());				
				DtUsuario user = iconU.getDtUsuario(usuario);
				if (user instanceof DtArtista) {
					
					panelEspectador.setVisible(false);
					panelArtista.setVisible(true);
					InicializarComboBoxesEspectaculo();
					textFieldNickname.setText(user.getNickname());
					textFieldNombre.setText(user.getNombre());
					textFieldApellido.setText(user.getApellido());
					textFieldEmail.setText(user.getCorreo());
					textFieldSitioWeb.setText(((DtArtista) user).getSitio_web());
					textFieldBibliografia.setText(((DtArtista) user).getBibliografia());
					textFieldDescripcion.setText(((DtArtista) user).getDescripcion());
					textFieldFnac.setText(new SimpleDateFormat("dd-MM-yyyy").format(user.getfNac()));
				}
				else
				{
					limpiarArtista();
					panelArtista.setVisible(false);
					panelEspectador.setVisible(true);
					textFieldNickname.setText(user.getNickname());
					textFieldNombre.setText(user.getNombre());
					textFieldApellido.setText(user.getApellido());
					textFieldEmail.setText(user.getCorreo());
					textFieldFnac.setText(new SimpleDateFormat("dd-MM-yyyy").format(user.getfNac()));
				}	
			}
		});
		comboBoxUsuario.setBounds(584, 50, 144, 22);
		getContentPane().add(comboBoxUsuario);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setToolTipText("Espectaculo");
		panel_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(417, 105, 365, 407);
		getContentPane().add(panel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Nombre");
		lblNewLabel_2.setBounds(10, 11, 48, 14);
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Descripcion");
		lblNewLabel_3.setBounds(10, 35, 88, 14);
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Duracion (Horas)");
		lblNewLabel_4.setBounds(10, 60, 136, 14);
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("Minimo Espectadores");
		lblNewLabel_5.setBounds(10, 95, 162, 14);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Maximo Espectadores");
		lblNewLabel_6.setBounds(10, 121, 136, 14);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Url");
		lblNewLabel_7.setBounds(10, 146, 88, 14);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Costo ($)");
		lblNewLabel_8.setBounds(10, 173, 105, 14);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Fecha de Regsitro");
		lblNewLabel_9.setBounds(10, 207, 88, 14);
		panel_1.add(lblNewLabel_9);
		
		textFieldNombreE = new JTextField();
		textFieldNombreE.setEditable(false);
		textFieldNombreE.setColumns(10);
		textFieldNombreE.setBounds(116, 8, 223, 20);
		panel_1.add(textFieldNombreE);
		
		textFieldDescripcionE = new JTextField();
		textFieldDescripcionE.setEditable(false);
		textFieldDescripcionE.setColumns(10);
		textFieldDescripcionE.setBounds(116, 32, 223, 20);
		panel_1.add(textFieldDescripcionE);
		
		textFieldDuracionE = new JTextField();
		textFieldDuracionE.setEditable(false);
		textFieldDuracionE.setColumns(10);
		textFieldDuracionE.setBounds(291, 57, 48, 20);
		panel_1.add(textFieldDuracionE);
		
		textFieldMinEspectadoresE = new JTextField();
		textFieldMinEspectadoresE.setEditable(false);
		textFieldMinEspectadoresE.setColumns(10);
		textFieldMinEspectadoresE.setBounds(291, 92, 48, 20);
		panel_1.add(textFieldMinEspectadoresE);
		
		textFieldMaxEspectadoresE = new JTextField();
		textFieldMaxEspectadoresE.setEditable(false);
		textFieldMaxEspectadoresE.setColumns(10);
		textFieldMaxEspectadoresE.setBounds(291, 118, 48, 20);
		panel_1.add(textFieldMaxEspectadoresE);
		
		textFieldUrlE = new JTextField();
		textFieldUrlE.setEditable(false);
		textFieldUrlE.setColumns(10);
		textFieldUrlE.setBounds(116, 143, 223, 20);
		panel_1.add(textFieldUrlE);
		
		textFieldCostoE = new JTextField();
		textFieldCostoE.setEditable(false);
		textFieldCostoE.setColumns(10);
		textFieldCostoE.setBounds(291, 170, 48, 20);
		panel_1.add(textFieldCostoE);
		
		textFieldFechaRegistroE = new JTextField();
		textFieldFechaRegistroE.setEditable(false);
		textFieldFechaRegistroE.setColumns(10);
		textFieldFechaRegistroE.setBounds(116, 204, 223, 20);
		panel_1.add(textFieldFechaRegistroE);
		
		JLabel lblFunciones = new JLabel("Funciones");
		lblFunciones.setBounds(10, 253, 68, 14);
		panel_1.add(lblFunciones);
		
		JLabel lblPaquetes = new JLabel("Paquetes");
		lblPaquetes.setBounds(10, 282, 68, 14);
		panel_1.add(lblPaquetes);
		
		comboBoxFuncionEs = new JComboBox<String>();
		comboBoxFuncionEs.setBounds(76, 249, 114, 22);
		panel_1.add(comboBoxFuncionEs);
		
		comboBoxPaqueteEs = new JComboBox<String>();
		comboBoxPaqueteEs.setBounds(76, 278, 114, 22);
		panel_1.add(comboBoxPaqueteEs);
		
		JButton btnNewButton_1 = new JButton("Detalles");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDetallesPaquete();
			}
		});
		btnNewButton_1.setBounds(200, 278, 88, 23);
		panel_1.add(btnNewButton_1);
		
		JButton btnDetalles_1 = new JButton("Detalles");
		btnDetalles_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getDetallesFuncion();
			}
		});
		btnDetalles_1.setBounds(198, 249, 89, 23);
		panel_1.add(btnDetalles_1);
		
		JLabel lblNewLabel_12_2 = new JLabel("Detalles de Espectaculo");
		lblNewLabel_12_2.setBounds(417, 90, 129, 14);
		getContentPane().add(lblNewLabel_12_2);
		
		JLabel lblNewLabel_12_2_1 = new JLabel("Detalles de Usuario");
		lblNewLabel_12_2_1.setBounds(10, 90, 129, 14);
		getContentPane().add(lblNewLabel_12_2_1);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_1_1.setBackground(Color.LIGHT_GRAY);
		panel_1_1.setBounds(792, 339, 429, 173);
		getContentPane().add(panel_1_1);
		
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
		
		JLabel lblNewLabel_12_1 = new JLabel("Detalles de Paquete");
		lblNewLabel_12_1.setBounds(802, 319, 263, 14);
		getContentPane().add(lblNewLabel_12_1);
		
		JPanel panel_1_2 = new JPanel();
		panel_1_2.setLayout(null);
		panel_1_2.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.BLACK, null, null, null));
		panel_1_2.setBackground(Color.LIGHT_GRAY);
		panel_1_2.setBounds(792, 110, 429, 194);
		getContentPane().add(panel_1_2);
		
		JLabel lblNewLabel_10 = new JLabel("Nombre");
		lblNewLabel_10.setBounds(10, 23, 74, 14);
		panel_1_2.add(lblNewLabel_10);
		
		JLabel lblNewLabel_10_1 = new JLabel("Fecha");
		lblNewLabel_10_1.setBounds(10, 48, 48, 14);
		panel_1_2.add(lblNewLabel_10_1);
		
		JLabel lblNewLabel_10_1_1 = new JLabel("Hora Inicio");
		lblNewLabel_10_1_1.setBounds(10, 73, 82, 14);
		panel_1_2.add(lblNewLabel_10_1_1);
		
		JLabel lblNewLabel_10_1_1_1 = new JLabel("Fecha Registro");
		lblNewLabel_10_1_1_1.setBounds(10, 98, 74, 14);
		panel_1_2.add(lblNewLabel_10_1_1_1);
		
		textFieldNombreF = new JTextField();
		textFieldNombreF.setEditable(false);
		textFieldNombreF.setColumns(10);
		textFieldNombreF.setBounds(94, 20, 96, 20);
		panel_1_2.add(textFieldNombreF);
		
		textFieldFechaF = new JTextField();
		textFieldFechaF.setEditable(false);
		textFieldFechaF.setColumns(10);
		textFieldFechaF.setBounds(94, 45, 96, 20);
		panel_1_2.add(textFieldFechaF);
		
		textFieldHoraF = new JTextField();
		textFieldHoraF.setEditable(false);
		textFieldHoraF.setColumns(10);
		textFieldHoraF.setBounds(94, 70, 96, 20);
		panel_1_2.add(textFieldHoraF);
		
		textFieldFechaRF = new JTextField();
		textFieldFechaRF.setEditable(false);
		textFieldFechaRF.setColumns(10);
		textFieldFechaRF.setBounds(94, 95, 96, 20);
		panel_1_2.add(textFieldFechaRF);
		
		JLabel lblNewLabel_11 = new JLabel("Artistas invitados");
		lblNewLabel_11.setBounds(210, 11, 149, 14);
		panel_1_2.add(lblNewLabel_11);
		
		txtpnInvitados = new JTextPane();
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados. ");
		txtpnInvitados.setEditable(false);
		txtpnInvitados.setBounds(210, 27, 200, 156);
		panel_1_2.add(txtpnInvitados);
		
		JLabel lblNewLabel_12 = new JLabel("Detalles de Funcion");
		lblNewLabel_12.setBounds(799, 90, 266, 14);
		getContentPane().add(lblNewLabel_12);

	}
	public void InicializarComboBoxes() {
		DefaultComboBoxModel<String> modelUsuarios = new DefaultComboBoxModel<String>(iconU.listarUsuarios());
		comboBoxUsuario.setModel(modelUsuarios);
	}
	
	
	public void InicializarComboBoxesEspectaculo() {
		DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(iconE.listarEspectaculosArtista((String) comboBoxUsuario.getSelectedItem().toString()));
		comboBoxEspectaculoA.setModel(modelEspectaculo);
	}
	
	public void InicializarComboBoxFuncion() {
		DefaultComboBoxModel<String> modelFuncionEs =  new DefaultComboBoxModel<String>(iconE.listarFunciones((String) comboBoxEspectaculoA.getSelectedItem().toString()));
		comboBoxFuncionEs.setModel(modelFuncionEs);
	}
	
	public void InicializarComboBoxPaquete() {
		DefaultComboBoxModel<String> modelPaqueteEs = new DefaultComboBoxModel<String>(iconE.listarPaquetes((String) comboBoxEspectaculoA.getSelectedItem().toString()));
		comboBoxPaqueteEs.setModel(modelPaqueteEs);
	}
	
	
	
	
	public void CargarTextFieldEspectaculo() {
		DtEspectaculo e = iconE.buscarEspectaculoNombre((String) comboBoxEspectaculoA.getSelectedItem());
		textFieldNombreE.setText(e.getNombreEsp());
		textFieldDescripcionE.setText(e.getDescripcion());
		textFieldDuracionE.setText(Integer.toString(e.getDuracion()));
		textFieldCostoE.setText(Float.toString(e.getCosto()));
		textFieldMaxEspectadoresE.setText(Integer.toString(e.getMaxEspectadores()));
		textFieldMinEspectadoresE.setText(Integer.toString(e.getMinEspectadores()));
		textFieldFechaRegistroE.setText(new SimpleDateFormat("dd-MM-yyyy").format(e.getFechaRegistro()));
		textFieldUrlE.setText(e.getUrl());
		InicializarComboBoxFuncion();
		InicializarComboBoxPaquete();		
	}
	
	
	public void getDetallesFuncion() {
		DtFuncion dtF = iconE.getDtFuncion((String) comboBoxEspectaculoA.getSelectedItem().toString(), (String) comboBoxFuncionEs.getSelectedItem().toString()); 
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
		DtPaquete dtP = iconPaq.infoPaquete((String) comboBoxPaqueteEs.getSelectedItem().toString()); 
		textFieldNombrePaq.setText(dtP.getNombre());
		textFieldDescripcionPaq.setText(dtP.getDescripcion());
		textFieldDescuentoPaq.setText(Integer.toString(dtP.getDescuento()));
		textFieldFaltaPaq.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtP.getfAlta()));
		textFieldFfinalPaq.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtP.getfFinal()));
		textFieldFinicioPaq.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtP.getfInicio()));
		textFieldCostoPaq.setText(Float.toString(dtP.getCosto()));
	}
	
	public void limpiarArtista() {
		
		textFieldSitioWeb.setText("");
		textFieldBibliografia.setText("");
		textFieldDescripcion.setText("");
		
	}
	
	
public void limpiarForm() {
		
		textFieldNickname.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldDescripcion.setText("");
		textFieldBibliografia.setText("");
		textFieldSitioWeb.setText("");
		textFieldFnac.setText("");
		textFieldEmail.setText("");
		textFieldNombreF.setText("");
		textFieldFechaF.setText("");
		textFieldFechaRF.setText("");
		textFieldHoraF.setText("");
		textFieldNombreE.setText("");
		textFieldDescripcionE.setText("");
		textFieldDuracionE.setText("");
		textFieldCostoE.setText("");
		textFieldMaxEspectadoresE.setText("");
		textFieldMinEspectadoresE.setText("");
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
		panelEspectador.setVisible(true);
		panelArtista.setVisible(true);
		comboBoxFuncionEs.setModel(modelVacio);
		comboBoxEspectaculoA.setModel(modelVacio);
		comboBoxPaqueteEs.setModel(modelVacio);
		comboBoxUsuario.setModel(modelVacio);
	}

public void limpiarEspectaculo() {
	
	textFieldNombreF.setText("");
	textFieldFechaF.setText("");
	textFieldFechaRF.setText("");
	textFieldHoraF.setText("");
	textFieldNombreE.setText("");
	textFieldDescripcionE.setText("");
	textFieldDuracionE.setText("");
	textFieldCostoE.setText("");
	textFieldMaxEspectadoresE.setText("");
	textFieldMinEspectadoresE.setText("");
	textFieldFechaRegistroE.setText("");
	textFieldUrlE.setText("");
	textFieldNombreF.setText("");
	textFieldFechaF.setText("");
	textFieldFechaRF.setText("");
	textFieldHoraF.setText("");
	DefaultComboBoxModel<String> modelVacio = new DefaultComboBoxModel<String>();
	comboBoxFuncionEs.setModel(modelVacio);
	comboBoxPaqueteEs.setModel(modelVacio);
}
	
	public void limpiarFuncion() {
		
		textFieldNombreF.setText("");
		textFieldFechaF.setText("");
		textFieldFechaRF.setText("");
		textFieldHoraF.setText("");
	}
	
	public void limpiarFormUsuario() {
		
		textFieldNickname.setText("");
		textFieldNombre.setText("");
		textFieldApellido.setText("");
		textFieldDescripcion.setText("");
		textFieldBibliografia.setText("");
		textFieldSitioWeb.setText("");
		textFieldFnac.setText("");
		textFieldEmail.setText("");
		DefaultComboBoxModel<String> modelVacio = new DefaultComboBoxModel<String>();
		comboBoxEspectaculoA.setModel(modelVacio);
		comboBoxFuncionU.setModel(modelVacio);
		
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
}
