package presentacion;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import datatypes.DtEspectaculo;
import datatypes.DtPaquete;
import interfaces.IcPaquete;
import interfaces.IcPlataforma;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AgregarEspectaculoAPaquete extends JInternalFrame {
	private JComboBox cmbEspectaculo;

	public AgregarEspectaculoAPaquete(IcPaquete icon) {
		setClosable(true);
		ArrayList<String> paquetes = icon.listarPaquetes();
		ArrayList<String> plataformas = icon.listarPlataformas();
		JComboBox cmbPaquetes = new JComboBox(paquetes.toArray());
		cmbPaquetes.setSelectedIndex(-1);
		
		setBounds(100, 100, 352, 297);
		getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("AGREGAR ESPECTACULO A PAQUETE");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 11, 316, 29);
		getContentPane().add(lblNewLabel);
		
		JButton btnAgregar = new JButton("AGREGAR");
		btnAgregar.setEnabled(false);
		
		cmbEspectaculo = new JComboBox();
		cmbEspectaculo.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cmbEspectaculo.getSelectedIndex() != -1) {
					btnAgregar.setEnabled(true);
				}			
			}
		});
		cmbEspectaculo.setEnabled(false);
		cmbEspectaculo.setBounds(10, 172, 316, 22);
		getContentPane().add(cmbEspectaculo);
		
		JComboBox cmbPlataforma = new JComboBox(plataformas.toArray());
		cmbPlataforma.setSelectedIndex(-1);
		cmbPlataforma.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if (cmbPlataforma.getSelectedIndex() != -1) {
					cmbEspectaculo.removeAllItems();
					ArrayList<String> espectaculos = icon.listaEspectaculosNOPAQUETE(cmbPlataforma.getSelectedItem().toString(), cmbPaquetes.getSelectedItem().toString());
					for (String espe: espectaculos) {
						cmbEspectaculo.addItem(espe);
					}
					cmbEspectaculo.setSelectedIndex(-1);
					cmbEspectaculo.setEnabled(true);
				}		
			}
		});
		
		
		cmbPlataforma.setEnabled(false);
		cmbPlataforma.setBounds(10, 120, 316, 22);
		getContentPane().add(cmbPlataforma);
		
		
		btnAgregar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (cmbEspectaculo.getSelectedIndex()==-1 || cmbPaquetes.getSelectedIndex()==-1 || cmbPlataforma.getSelectedIndex()==-1) {
					JOptionPane.showMessageDialog(null,"Debe seleccionar todos los campos!", "Agregar espectaculo a paquete",JOptionPane.ERROR_MESSAGE);
				}else {
					icon.agregarEspectaculoAPaquete(cmbPaquetes.getSelectedItem().toString(), cmbEspectaculo.getSelectedItem().toString());
					JOptionPane.showMessageDialog(null,"Se agrego el espectaculo correctamente!", "Agregar espectaculo a paquete",JOptionPane.INFORMATION_MESSAGE);
				}			
			}
		});
		btnAgregar.setBounds(237, 229, 89, 23);
		getContentPane().add(btnAgregar);

		
		cmbPaquetes.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				if(cmbPaquetes.getSelectedIndex() != -1) {
					cmbPlataforma.setEnabled(true);
					cmbPlataforma.setSelectedIndex(-1);
				}			
			}
		});
		cmbPaquetes.setBounds(10, 70, 316, 22);
		getContentPane().add(cmbPaquetes);
		
		JLabel lblNewLabel_1 = new JLabel("PAQUETE:");
		lblNewLabel_1.setBounds(10, 51, 100, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("PLATAFORMA:");
		lblNewLabel_1_1.setBounds(10, 103, 100, 14);
		getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("ESPECTACULO:");
		lblNewLabel_1_1_1.setBounds(10, 153, 100, 14);
		getContentPane().add(lblNewLabel_1_1_1);
	}
}
