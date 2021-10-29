package presentacion;

import java.time.*; 
import java.time.LocalDateTime;
import javax.swing.JOptionPane;
import exepciones.CargaDePaqueteErronea;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import presentacion.Principal;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import com.toedter.calendar.JCalendar;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import javax.swing.ImageIcon;
import com.toedter.calendar.JDayChooser;


import com.toedter.calendar.JDateChooser;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.Color;
import javax.swing.SwingConstants;


import interfaces.IcPaquete;
import javax.swing.JCheckBox;
public class CrearPaqueteDeEspectaculosJFrame extends JInternalFrame {

	/**
	 * 
	 */
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtNombreDelNuevo;
	private JTextField txtDescripcionCrearPaqueteDeEspectaculo;
	private JTextField textDescuentoCrearPaqueteDeEspectaculo;
	boolean existePaquete = false;
	private  IcPaquete iconP;
	boolean negativo = false;


	/**
	 * Create the frame.
	 */
	public CrearPaqueteDeEspectaculosJFrame(IcPaquete iconP) {
		 setClosable(true);
		this.iconP = iconP;
		setTitle("Crear Paquete de Espectaculo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 383, 384);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setResizable(true);
        setIconifiable(true);
        setMaximizable(true);
        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        
       
       
		
	
		JLabel lblNombreYaExiste = new JLabel("El nombre de paquete ingresado ya existe.");
		lblNombreYaExiste.setForeground(Color.RED);
		lblNombreYaExiste.setVisible(false);
		lblNombreYaExiste.setBounds(133, 45, 309, 13);
		contentPane.add(lblNombreYaExiste);
		
		txtNombreDelNuevo = new JTextField("");
		txtNombreDelNuevo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				
				existePaquete = iconP.ExistePaquete(txtNombreDelNuevo.getText());
				if (existePaquete) {
					lblNombreYaExiste.setVisible(true);
				}else {
					lblNombreYaExiste.setVisible(false);
				}
			}
		});
		
		
		txtNombreDelNuevo.addMouseListener(new MouseAdapter() {
			
			boolean editado = false;
			public void mouseClicked(MouseEvent e) {
				
				if(!editado) {
					txtNombreDelNuevo.setText("");
					editado = true;
				}
			}
		});
		txtNombreDelNuevo.addKeyListener(new KeyAdapter() {
	
		});
		txtNombreDelNuevo.setBounds(133, 58, 232, 19);
		contentPane.add(txtNombreDelNuevo);
		txtNombreDelNuevo.setColumns(10);
		
		txtDescripcionCrearPaqueteDeEspectaculo = new JTextField();
		txtDescripcionCrearPaqueteDeEspectaculo.setHorizontalAlignment(SwingConstants.LEFT);
		txtDescripcionCrearPaqueteDeEspectaculo.addMouseListener(new MouseAdapter() {
		
			boolean editado = false;
			public void mouseClicked(MouseEvent e) {
				
				if(!editado) {
					txtDescripcionCrearPaqueteDeEspectaculo.setText("");
					editado = true;
				}
			}
		});
		txtDescripcionCrearPaqueteDeEspectaculo.setColumns(10);
		txtDescripcionCrearPaqueteDeEspectaculo.setBounds(133, 101, 232, 84);
		contentPane.add(txtDescripcionCrearPaqueteDeEspectaculo);
		
		textDescuentoCrearPaqueteDeEspectaculo = new JTextField();
		
		
		
		textDescuentoCrearPaqueteDeEspectaculo.setEditable(false);
		textDescuentoCrearPaqueteDeEspectaculo.setColumns(10);
		textDescuentoCrearPaqueteDeEspectaculo.setBounds(161, 265, 91, 19);
		contentPane.add(textDescuentoCrearPaqueteDeEspectaculo);
		
		
		
		JDateChooser dateChooserInicio = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateChooserInicio.setBounds(161, 216, 91, 19);
		contentPane.add(dateChooserInicio);
		
		
		
		JLabel lblNewLabel = new JLabel("Fecha de inicio");
		lblNewLabel.setBounds(10, 216, 298, 13);
		contentPane.add(lblNewLabel);
		
		JLabel lblFechaDeFinalizacin = new JLabel("Fecha de finalización");
		lblFechaDeFinalizacin.setBounds(10, 245, 309, 13);
		contentPane.add(lblFechaDeFinalizacin);
		
		JDateChooser dateChooserFinalizacion = new JDateChooser("yyyy/MM/dd", "####/##/##", '_');
		dateChooserFinalizacion.setBounds(161, 239, 91, 19);
		contentPane.add(dateChooserFinalizacion);
		
		
		JButton btnNewButton_1 = new JButton("Confirmar");
		btnNewButton_1.setBounds(133, 319, 91, 26);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNombreDelPaquete = new JLabel("Nombre del Paquete");
		lblNombreDelPaquete.setBounds(10, 61, 119, 13);
		contentPane.add(lblNombreDelPaquete);
		
		JLabel lblDescripci = new JLabel("Descripción");
		lblDescripci.setBounds(10, 101, 119, 13);
		contentPane.add(lblDescripci);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("Descuento");
		chckbxNewCheckBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textDescuentoCrearPaqueteDeEspectaculo.setEditable(true);
				chckbxNewCheckBox.setEnabled(false);
			}
		});
		chckbxNewCheckBox.setBounds(6, 264, 93, 21);
		contentPane.add(chckbxNewCheckBox);
		
		JLabel lblDescuentoNegativo = new JLabel("No puede ser negativo el valor descuento");
		lblDescuentoNegativo.setForeground(Color.RED);
		lblDescuentoNegativo.setBounds(10, 294, 309, 13);
		contentPane.add(lblDescuentoNegativo);
		lblDescuentoNegativo.setVisible(false);
		
		textDescuentoCrearPaqueteDeEspectaculo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				textDescuentoCrearPaqueteDeEspectaculo.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						String aux = textDescuentoCrearPaqueteDeEspectaculo.getText();
						
					}
				});
			}
		});
		
		
		
		
		// CONFIRMAR
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			
		public void mouseClicked(MouseEvent e) {
				String fechaFinalizacion;
				String fechaInicio;
				int descuento = 0;
				try {
					 fechaFinalizacion = dateChooserFinalizacion.getDate().toString();
					 fechaInicio = dateChooserInicio.getDate().toString();
					 LocalDateTime localDateTime = LocalDateTime.now();
				     LocalDate localDate = localDateTime.toLocalDate();
				     Date date = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
					 
					 if(dateChooserInicio.getDate().after(dateChooserFinalizacion.getDate())) {
						 JOptionPane.showMessageDialog(null, "La fecha de inicio no puede ser superior a la fecha de fin",
								  "Error", JOptionPane.WARNING_MESSAGE);
					 }else if(!(dateChooserInicio.getDate().before(date)) || !(dateChooserFinalizacion.getDate().before(date))){
						 if(lblNombreYaExiste.isVisible()==false && txtNombreDelNuevo.getText()!= "Nombre del nuevo Paquete" && txtDescripcionCrearPaqueteDeEspectaculo.getText() != "Descripción" && fechaFinalizacion != null && fechaInicio != null) {//Comprobamos requerimientos para confrimar datos ingresados correctamente.
								if(textDescuentoCrearPaqueteDeEspectaculo.isEditable()) {
									String descuentostr = textDescuentoCrearPaqueteDeEspectaculo.getText().toString();
									descuento = Integer.parseInt(descuentostr);
									if(descuento > 0) {
										lblDescuentoNegativo.setVisible(false);
										negativo = false;
									}else {
										lblDescuentoNegativo.setVisible(true);
										negativo = true;
									}
								}
								
								if(!negativo) {
									iconP.agregarPaquete(txtNombreDelNuevo.getText(),txtDescripcionCrearPaqueteDeEspectaculo.getText(),dateChooserInicio.getDate(),dateChooserFinalizacion.getDate(),descuento, date,null);

									txtNombreDelNuevo.setText("");
									txtDescripcionCrearPaqueteDeEspectaculo.setText("");
									textDescuentoCrearPaqueteDeEspectaculo.setText("");
									textDescuentoCrearPaqueteDeEspectaculo.setEditable(false);
									dateChooserInicio.setCalendar(null);
									dateChooserFinalizacion.setCalendar(null);
									chckbxNewCheckBox.setEnabled(true);

									JOptionPane.showMessageDialog(null, txtNombreDelNuevo.getText() + " " +"Ingresado correctamente",
											  "Exitoso", JOptionPane.INFORMATION_MESSAGE);
								}

							}else {
								JOptionPane.showMessageDialog(null, "Por favor ingrese los datos correctamente",
										  "Error", JOptionPane.WARNING_MESSAGE);
							}
					 }
				}catch(Exception e1){//si no puede convertir a string los dateChooser es porque estan vacios
					JOptionPane.showMessageDialog(null, "Por favor ingrese los datos correctamente",
							  "Error", JOptionPane.WARNING_MESSAGE);
				}
				
			}
		});

		
	}
	
	
}
