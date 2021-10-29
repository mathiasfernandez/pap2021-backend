package presentacion;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import java.awt.Graphics;
import java.awt.image.BufferedImage;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.toedter.calendar.JCalendar;

import exepciones.FuncionYaExisteExcepcion;
import interfaces.IcEspectaculo;
import interfaces.IcPlataforma;
import interfaces.IcUsuario;
import logica.Espectaculo;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import java.awt.Font;
import javax.swing.JSeparator;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.AbstractListModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ListSelectionModel;

import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTextPane;

import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;




public class AltaFuncionDeEspectaculo extends JInternalFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private IcEspectaculo icEspectaculo;
	private IcPlataforma icPlataforma;
	private IcUsuario icUsuario;

	private BufferedImage image;
	private JTextField txtNombreFuncion;
	private JComboBox<String> cbPlataforma;
	private JComboBox<String> cbEspectaculo;
	private JComboBox<String> cbArtista;
	private List<String> artistasInvitados = new ArrayList<String>();
	private String strArtistasInvitados = "";
	private JButton btnConfirmar;
	private JTextPane txtpnConfirmadosAgregarLista;
	private JList<String> listHoraInicio;
	private JList<String> listMinutoInicio;
	private JCalendar calFuncion;
	private JScrollPane scrollMinutos;
	private JScrollPane scrollHora;
	private DefaultComboBoxModel<String> modelVacio = new DefaultComboBoxModel<String>();
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);        
    }
    
 
    
	public AltaFuncionDeEspectaculo(IcEspectaculo icE, IcPlataforma icP, IcUsuario icU) throws IOException {
		addComponentListener(new ComponentAdapter() {
			@Override
			public void componentHidden(ComponentEvent arg0) {
				limpiar();
			}
		});	

		this.icPlataforma = icP;
		this.icEspectaculo = icE;
		this.icUsuario = icU;
		
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setClosable(true);
        setTitle("Alta de Funcion");
        setBounds(10, 40, 283, 491);
		getContentPane().setLayout(null);
		
		
		JLabel lblPlataforma = new JLabel("Plataforma:");
		lblPlataforma.setBounds(10, 11, 69, 14);
		getContentPane().add(lblPlataforma);
		
		cbPlataforma = new JComboBox<String>();
		cbPlataforma.setBounds(89, 8, 175, 20);
		getContentPane().add(cbPlataforma);
		cbPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setComboBoxEspectaculo((String) cbPlataforma.getSelectedItem().toString());
			}
		});
		
		JLabel lblEspectaculo = new JLabel("Espectaculo:");
		lblEspectaculo.setBounds(10, 36, 78, 14);
		getContentPane().add(lblEspectaculo);
		
		cbEspectaculo = new JComboBox<String>();
		cbEspectaculo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent arg0) {
				txtNombreFuncion.setEnabled(true);
				setComboBoxArtista((String) cbEspectaculo.getSelectedItem().toString());
				cbArtista.setEnabled(true);
				txtNombreFuncion.setEnabled(true);
				calFuncion.setEnabled(true);
				listHoraInicio.setEnabled(true);
				listMinutoInicio.setEnabled(true);
			}
		});
		cbEspectaculo.setBounds(89, 33, 175, 20);
		getContentPane().add(cbEspectaculo);
		
		
		scrollHora = new JScrollPane();
		scrollHora.setEnabled(true);
		scrollHora.setSize(66, 20);
		scrollHora.setLocation(90, 291);
		getContentPane().add(scrollHora);
		listHoraInicio = new JList<String>();
		//listHoraInicio.setBackground(Color.LIGHT_GRAY);
		//listHoraInicio.setEnabled(false);
		scrollHora.setViewportView(listHoraInicio);
		listHoraInicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listHoraInicio.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		listHoraInicio.setModel(new AbstractListModel<String>() {
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"00", "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		
		
		scrollMinutos = new JScrollPane();
		scrollMinutos.setEnabled(true);
		scrollMinutos.setSize(78, 20);
		scrollMinutos.setLocation(166, 291);
		getContentPane().add(scrollMinutos);
		listMinutoInicio = new JList<String>();
		//listMinutoInicio.setBackground(Color.LIGHT_GRAY);
		//listMinutoInicio.setEnabled(false);
		scrollMinutos.setViewportView(listMinutoInicio);
		listMinutoInicio.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listMinutoInicio.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		
		listMinutoInicio.setModel(new AbstractListModel<String>() {
			/**
			 * 
			 */
			private static final long serialVersionUID = 1L;
			String[] values = new String[] {"00", "15", "30", "45"};
			public int getSize() {
				return values.length;
			}
			public String getElementAt(int index) {
				return values[index];
			}
		});
		
		

		
		JLabel lblNuevaFuncion = new JLabel("Nueva Funci\u00F3n");
		lblNuevaFuncion.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNuevaFuncion.setBounds(43, 61, 96, 14);
		getContentPane().add(lblNuevaFuncion);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(144, 68, 131, 7);
		getContentPane().add(separator);
		
		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(-12, 68, 45, 7);
		getContentPane().add(separator_1);
		
		JLabel lblHoraInicio = new JLabel("Hora Inicio:");
		lblHoraInicio.setBounds(18, 296, 69, 14);
		getContentPane().add(lblHoraInicio);
		
		JLabel lblFechaDelEvento = new JLabel("Fecha del evento:");
		lblFechaDelEvento.setBounds(18, 114, 175, 14);
		getContentPane().add(lblFechaDelEvento);
		
		calFuncion = new JCalendar();
		calFuncion.getDayChooser().setWeekOfYearVisible(false);
		calFuncion.setBounds(18, 132, 226, 153);
		calFuncion.setEnabled(true);
		getContentPane().add(calFuncion);
		
		JLabel lblNombreFuncion = new JLabel("Nombre:");
		lblNombreFuncion.setBounds(18, 89, 52, 14);
		getContentPane().add(lblNombreFuncion);
		
		txtNombreFuncion = new JTextField();
		txtNombreFuncion.setEnabled(false);
		txtNombreFuncion.setBounds(66, 86, 175, 20);
		getContentPane().add(txtNombreFuncion);
		txtNombreFuncion.setColumns(10);
		
		JLabel lblInvitados = new JLabel("Invitados");
		lblInvitados.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInvitados.setBounds(43, 322, 96, 14);
		getContentPane().add(lblInvitados);
		
		JSeparator separator_1_1 = new JSeparator();
		separator_1_1.setBounds(-12, 329, 45, 7);
		getContentPane().add(separator_1_1);
		
		JSeparator separator_2 = new JSeparator();
		separator_2.setBounds(110, 329, 165, 7);
		getContentPane().add(separator_2);
		
		btnConfirmar = new JButton("CONFIRMAR FUNCION");
		btnConfirmar.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent arg0) {
				if((listHoraInicio.isSelectionEmpty() == false ) & (listMinutoInicio.isSelectionEmpty() == false )) {
					if(txtNombreFuncion.getText().trim().isEmpty() == false) {
						Date fecha = calFuncion.getDate();
						fecha.setHours( Integer.parseInt(listHoraInicio.getSelectedValue()));
						fecha.setMinutes(Integer.parseInt(listMinutoInicio.getSelectedValue()));
						
						LocalDateTime ahora = LocalDateTime.now();
						Date dateAhora = convertToDateViaSqlTimestamp(ahora);
						dateAhora.setHours(0);
						dateAhora.setMinutes(0);
						
						if(fecha.compareTo(dateAhora) > 0 ) { // si el evento es hoy o en el futuro
							try {
								icEspectaculo.setFuncion(cbEspectaculo.getSelectedItem().toString(), txtNombreFuncion.getText().toString(), fecha, artistasInvitados);
								JOptionPane.showMessageDialog(null,"Se agrego la funcion correctamente!!", "Agregar Funcion", JOptionPane.INFORMATION_MESSAGE);
								limpiar();
								dispose(); // cierra esta ventana
								
								}catch(Exception e) {
								JOptionPane.showMessageDialog(null, "Algo salio mal :(", "Alta Funcion de Espectaculo", JOptionPane.ERROR_MESSAGE);
								dispose(); // cierra esta ventana
							}
						}else {
							JOptionPane.showMessageDialog(null, "La fecha de la funcion no puede ser en el pasado", "Alta Funcion de Espectaculo", JOptionPane.ERROR_MESSAGE);
						}
						
						
					}else {
						JOptionPane.showMessageDialog(null, "El nombre de la funcion no puede estar vacio", "Alta Funcion de Espectaculo", JOptionPane.ERROR_MESSAGE);
					}
				}else {
					JOptionPane.showMessageDialog(null, "Seleccione Hora y Minutos para el inicio de la Funcion", "Alta Funcion de Espectaculo", JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnConfirmar.setEnabled(false);
		btnConfirmar.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnConfirmar.setBounds(0, 438, 267, 23);
		getContentPane().add(btnConfirmar);
		
		JButton btnAgregar = new JButton("Agregar");
		btnAgregar.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(artistasInvitados.contains((String) cbArtista.getSelectedItem().toString()) == false){ // si aun no se agrego
					artistasInvitados.add((String) cbArtista.getSelectedItem().toString());
					strArtistasInvitados = String.join(", ", artistasInvitados);
					txtpnConfirmadosAgregarLista.setText("Confirmados: " + strArtistasInvitados);
				}
				btnConfirmar.setEnabled(true);
			}
		});
		btnAgregar.setEnabled(false);
		btnAgregar.setBounds(179, 347, 78, 20);
		getContentPane().add(btnAgregar);
		
		
		cbArtista = new JComboBox<String>();
		cbArtista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnAgregar.setEnabled(true);
			}
		});

		cbArtista.setBounds(10, 347, 165, 20);
		getContentPane().add(cbArtista);
		
		txtpnConfirmadosAgregarLista = new JTextPane();
		txtpnConfirmadosAgregarLista.setEditable(false);
		txtpnConfirmadosAgregarLista.setText("Confirmados: " + strArtistasInvitados);
		txtpnConfirmadosAgregarLista.setBounds(10, 374, 247, 62);
		getContentPane().add(txtpnConfirmadosAgregarLista);
		
		
		JLabel lblSeparadorHora = new JLabel(":");
		lblSeparadorHora.setBounds(159, 296, 37, 14);
		getContentPane().add(lblSeparadorHora);
	
		

	}
	
	public void InicializarComboBoxes() {
		try {
			DefaultComboBoxModel<String> modelPlataforma = new DefaultComboBoxModel<String>(icPlataforma.getPlataformas());
			cbPlataforma.setModel(modelPlataforma);
			cbPlataforma.setSelectedIndex(0);
		} catch (Exception e) {
			this.setVisible(false);
			JOptionPane.showMessageDialog(this, "No existen plataformas registradas en el sistema", "Alta Funcion de Espectaculo", JOptionPane.ERROR_MESSAGE);
			limpiar();
			dispose();
		}
	}
	
	
	public void setComboBoxEspectaculo(String plataforma) {
		try {
			btnConfirmar.setEnabled(false);
			String[] esp = icEspectaculo.getArrEspectaculos(plataforma);
	    	if(esp.length != 0) {
	    		DefaultComboBoxModel<String> modelespectaculos = new DefaultComboBoxModel<String>(esp);
	    		cbEspectaculo.setModel(modelespectaculos);
	    		cbEspectaculo.setSelectedIndex(0);
	    		cbEspectaculo.setEnabled(true);
	    	}else {
	    		cbEspectaculo.setEnabled(false);
	    		throw new Exception("No existen espectaculos registrados en la plataforma " + plataforma);
	    	}
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(this, e.getMessage().toString(), "Alta Funcion de Espectaculo", JOptionPane.ERROR_MESSAGE);
			cbEspectaculo.setModel(modelVacio);
		} 
	}
	
	public void setComboBoxArtista(String espectaculo) {
		try {
			DefaultComboBoxModel<String> modelartistas = new DefaultComboBoxModel<String>(icUsuario.getArtistas());
	    	cbArtista.setModel(modelartistas);
		} catch (Exception e) {
			txtNombreFuncion.setEnabled(false);
			JOptionPane.showMessageDialog(this, "No existen artistas registrados para el Espectaculo " + e.toString(), "Alta Funcion de Espectaculo", JOptionPane.ERROR_MESSAGE);
		} 
	}
	
	public void limpiar() {

		txtNombreFuncion.setText("");
		txtNombreFuncion.setEnabled(false);
		
		txtpnConfirmadosAgregarLista.setText("Confirmados: ");
		txtpnConfirmadosAgregarLista.setEnabled(false);
		listHoraInicio.setSelectedIndex(0);
		listHoraInicio.setEnabled(false);
		listMinutoInicio.setSelectedIndex(0);
		listMinutoInicio.setEnabled(false);
		calFuncion.setEnabled(false);
		artistasInvitados.clear();
		strArtistasInvitados = "";
		scrollHora.setAlignmentX(0);
		scrollMinutos.setAlignmentX(0);
		
		
		
		cbPlataforma.setModel(modelVacio);
		cbEspectaculo.setModel(modelVacio);
		
	}
	public Date convertToDateViaSqlTimestamp(LocalDateTime dateToConvert) {
	    return java.sql.Timestamp.valueOf(dateToConvert);
	}
}
