package presentacion;



import interfaces.IcPlataforma;
import interfaces.IcUsuario;
import interfaces.IcEspectaculo;
import interfaces.IcRegistro;

import javax.swing.JInternalFrame;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import datatypes.DtFuncion;
import datatypes.ModoCanje;

import javax.swing.JPanel;
import javax.swing.UIManager;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class RegistroAFuncionDeEspectaculo extends JInternalFrame {
	
	
	private JComboBox<String> comboBoxPlataforma;
	private JComboBox<String> comboBoxEspectaculos;
	private JComboBox<String> comboBoxFunciones;
	private JComboBox<String> comboBoxEspectadores;
	private JComboBox<String> comboBoxCanje;
	
	private static final long serialVersionUID = 1L;

	private IcPlataforma iconP;
	private IcEspectaculo iconE;
	private IcUsuario iconU;
	private IcRegistro iconR;
	
	private JTextField txtNombre;
	private JTextField txtFecha;
	private JTextField txtHora;
	private JTextField txtFechaRegistro;
	private String artistasInvitados = "";
	private JTextPane txtpnInvitados;
	/**
	 * Create the frame.
	 * 	 * @param iconP 
	 *   * @param iconE
	 *   * @param iconU
	 *   * @param iconR
	 */
	public RegistroAFuncionDeEspectaculo(IcPlataforma iconP,IcEspectaculo iconE,IcUsuario iconU,IcRegistro iconR){
		this.iconP = iconP;
		this.iconE = iconE;
		this.iconU = iconU;
		this.iconR = iconR;
		setTitle("Registro a Funcion de Espectaculo");
		setBounds(100, 100, 576, 420);
		getContentPane().setLayout(null);
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
		
		comboBoxPlataforma = new JComboBox<String>();
		comboBoxPlataforma.setBounds(48, 58, 231, 21);
		getContentPane().add(comboBoxPlataforma);
		
		JLabel lblNewLabel = new JLabel("PLATAFORMA");
		lblNewLabel.setBounds(48, 37, 112, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblEspectaculosDe = new JLabel("Espectaculos de ");
		lblEspectaculosDe.setBounds(48, 89, 100, 13);
		getContentPane().add(lblEspectaculosDe);
		
		JLabel lblNombrePlataformaEscogida = new JLabel("");
		lblNombrePlataformaEscogida.setBounds(144, 89, 149, 13);
		getContentPane().add(lblNombrePlataformaEscogida);
		
		comboBoxEspectaculos = new JComboBox<String>();
		comboBoxEspectaculos.setBounds(48, 112, 231, 21);
		getContentPane().add(comboBoxEspectaculos);
		
		comboBoxFunciones = new JComboBox<String>();
		comboBoxFunciones.setBounds(48, 167, 231, 21);
		getContentPane().add(comboBoxFunciones);
		
		comboBoxEspectadores = new JComboBox<String>();
		comboBoxEspectadores.setBounds(48, 167, 185, 21);
		getContentPane().add(comboBoxEspectadores);
		
		JLabel lblFuncionesDe = new JLabel("Funciones de ");
		lblFuncionesDe.setBounds(48, 143, 100, 13);
		getContentPane().add(lblFuncionesDe);
		
		JLabel lblNombreEspectaculoEscogido = new JLabel("");
		lblNombreEspectaculoEscogido.setBounds(130, 144, 149, 13);
		getContentPane().add(lblNombreEspectaculoEscogido);
		
		JLabel lblNombreFuncion = new JLabel("Nombre:");
		lblNombreFuncion.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblNombreFuncion.setBounds(325, 64, 52, 14);
		getContentPane().add(lblNombreFuncion);
		
		JLabel lblFechaRegistro = new JLabel("Fecha de registro:");
		lblFechaRegistro.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFechaRegistro.setBounds(325, 113, 96, 14);
		getContentPane().add(lblFechaRegistro);
		
		JLabel lblFechaDelEvento = new JLabel("Fecha del evento:");
		lblFechaDelEvento.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblFechaDelEvento.setBounds(325, 163, 96, 14);
		getContentPane().add(lblFechaDelEvento);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setFont(new Font("Tahoma", Font.PLAIN, 10));
		lblHoraInicio.setBounds(325, 210, 96, 14);
		getContentPane().add(lblHoraInicio);
		
		txtNombre = new JTextField();
		txtNombre.setEditable(false);
		txtNombre.setColumns(10);
		txtNombre.setBounds(325, 83, 183, 20);
		getContentPane().add(txtNombre);
		
		txtFecha = new JTextField();
		txtFecha.setEditable(false);
		txtFecha.setColumns(10);
		txtFecha.setBounds(325, 131, 185, 20);
		getContentPane().add(txtFecha);
		
		txtHora = new JTextField();
		txtHora.setEditable(false);
		txtHora.setColumns(10);
		txtHora.setBounds(325, 180, 185, 20);
		getContentPane().add(txtHora);
		
		txtFechaRegistro = new JTextField();
		txtFechaRegistro.setEditable(false);
		txtFechaRegistro.setColumns(10);
		txtFechaRegistro.setBounds(325, 226, 185, 20);
		getContentPane().add(txtFechaRegistro);
		
		JLabel lblDetalles = new JLabel("Detalles de la Función");
		lblDetalles.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblDetalles.setBounds(325, 44, 143, 14);
		getContentPane().add(lblDetalles);
		
		JPanel DtFuncionPanel = new JPanel();
		DtFuncionPanel.setBorder(UIManager.getBorder("TableHeader.cellBorder"));
		DtFuncionPanel.setBounds(303, 37, 234, 324);
		getContentPane().add(DtFuncionPanel);
		DtFuncionPanel.setLayout(null);
		
		txtpnInvitados = new JTextPane();
		txtpnInvitados.setBounds(20, 223, 187, 91);
		DtFuncionPanel.add(txtpnInvitados);
		txtpnInvitados.setText("Seleccione una funcion para ver los artistas invitados. ");
		txtpnInvitados.setEditable(false);
		
		comboBoxEspectadores = new JComboBox<String>();
		comboBoxEspectadores.setBounds(48, 225, 231, 21);
		getContentPane().add(comboBoxEspectadores);
		
		JLabel lblEspectadores = new JLabel("ESPECTADORES");
		lblEspectadores.setBounds(48, 211, 112, 13);
		getContentPane().add(lblEspectadores);
		
		JDateChooser dateChooserRegistro = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateChooserRegistro.setBounds(137, 256, 96, 21);
		getContentPane().add(dateChooserRegistro);
		
		JLabel lblFechaDeInicio = new JLabel("Fecha de registro");
		lblFechaDeInicio.setBounds(48, 256, 112, 13);
		getContentPane().add(lblFechaDeInicio);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setBounds(45, 340, 112, 21);
		getContentPane().add(btnConfirmar);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.setBounds(167, 340, 112, 21);
		getContentPane().add(btnCancelar);
		
		JLabel lblModoDeCanje = new JLabel("Modo de canje");
		lblModoDeCanje.setBounds(48, 281, 112, 13);
		getContentPane().add(lblModoDeCanje);
		
		comboBoxCanje = new JComboBox<String>();
		comboBoxCanje.setModel(new DefaultComboBoxModel(new String[] {"", "general", "conversion", "prepago"}));
		comboBoxCanje.setBounds(48, 295, 231, 21);
		getContentPane().add(comboBoxCanje);
		
	
		
		
		
		
		//eventos
		
		comboBoxPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNombrePlataformaEscogida.setText(comboBoxPlataforma.getSelectedItem().toString());
				InicializarComboBoxEspectaculos();
				InicializarComboBoxEspectadores();
			}
		});

		comboBoxEspectaculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNombreEspectaculoEscogido.setText(comboBoxEspectaculos.getSelectedItem().toString());
				InicializarComboBoxFuncion();
			}
		});
		
		comboBoxFunciones.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//DtFuncionPanel.setVisible(false);
				getDetallesFuncion(lblNombreEspectaculoEscogido.getText(),comboBoxFunciones.getSelectedItem().toString());
			}
		});
		
		
		
		//confirmar
		btnConfirmar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(dateChooserRegistro.getDate()!= null) {
					String canjeStr = comboBoxCanje.getSelectedItem().toString();
					ModoCanje canje = seleccionarCanje(canjeStr);
					iconR.confirmarRegistro(comboBoxEspectadores.getSelectedItem().toString(),comboBoxFunciones.getSelectedItem().toString() , dateChooserRegistro.getDate(),canje);
					
					JOptionPane.showMessageDialog(null, "Se agregó corractamente",
							  "Error", JOptionPane.INFORMATION_MESSAGE);
				}else {
					JOptionPane.showMessageDialog(null, "Por favor ingrese el campo fecha de inicio",
							  "Error", JOptionPane.WARNING_MESSAGE);
				}
			}
		});
		
		
	}
	
	
	
	
	
	//Funciones 
	
	public ModoCanje seleccionarCanje(String str) {
		ModoCanje mc;
		if(str == "") {
			mc = ModoCanje.conversion;
		}else if (str == "") {
			mc = ModoCanje.prepago;
		}else {
			mc = ModoCanje.general;
		}
		
		return mc;
		
	}
	
	public void InicializarComboBoxPlataforma() {
		DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(iconP.getPlataformas());
		comboBoxPlataforma.setModel(modelPlataforma);
	}
	
	public void InicializarComboBoxEspectaculos() {
		DefaultComboBoxModel<String> modelEspectaculo = new DefaultComboBoxModel<String>(iconE.getArrEspectaculos((String) comboBoxPlataforma.getSelectedItem().toString()));
		comboBoxEspectaculos.setModel(modelEspectaculo);
	}
	
	public void InicializarComboBoxFuncion() {
		try {
			DefaultComboBoxModel<String> modelFuncion = new DefaultComboBoxModel<String>(iconE.listarFunciones((String) comboBoxEspectaculos.getSelectedItem().toString()));
			comboBoxFunciones.setModel(modelFuncion);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public void InicializarComboBoxEspectadores() {
		DefaultComboBoxModel<String> modelEspectadores = new DefaultComboBoxModel<String>(iconU.obtenerEspectadores());
		comboBoxEspectadores.setModel(modelEspectadores);
	}
	
	public void getDetallesFuncion(String espectaculo, String funcion) {
		DtFuncion dtF = iconE.getDtFuncion(espectaculo, funcion); 
		txtNombre.setText(dtF.getNomFun());
		txtFecha.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtF.getFechaFuncion()));
		txtFechaRegistro.setText(new SimpleDateFormat("dd-MM-yyyy").format(dtF.getFechaRegistroFun()));
		txtHora.setText(new SimpleDateFormat("HH:mm").format(dtF.getFechaFuncion()));
		for(String art: dtF.getInvitados()) {
			if(artistasInvitados == "") {
				artistasInvitados += art ; 
			}else {
				artistasInvitados += ", " + art ;	
			}
			
		};
		txtpnInvitados.setText("Artistas Invitados: " + artistasInvitados);
	
	}
}
