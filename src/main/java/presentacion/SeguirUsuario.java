package presentacion;

import javax.swing.DefaultComboBoxModel;

import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import interfaces.IcUsuario;
import logica.UsuariosSeguidosID;

import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SeguirUsuario extends JInternalFrame {
	private static final long serialVersionUID = 1L;
	
	public IcUsuario iconU;
	
	private JComboBox<String> comboBoxUsuario;
	private JComboBox<String> comboBoxUsuario_1;

	public SeguirUsuario(IcUsuario iconU) {
		this.iconU = iconU;
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(null);
		
		comboBoxUsuario = new JComboBox<String>();
		comboBoxUsuario.setBounds(119, 25, 244, 32);
		getContentPane().add(comboBoxUsuario);
		
		comboBoxUsuario_1 = new JComboBox<String>();
		comboBoxUsuario_1.setBounds(119, 84, 244, 32);
		getContentPane().add(comboBoxUsuario_1);
		
		JLabel lblNewLabel = new JLabel("seguidor");
		lblNewLabel.setBounds(24, 35, 87, 13);
		getContentPane().add(lblNewLabel);
		
		JLabel lblUsuarioASeguir = new JLabel("usuario a seguir");
		lblUsuarioASeguir.setBounds(24, 94, 87, 13);
		getContentPane().add(lblUsuarioASeguir);
		
		JButton btnNewButton = new JButton("seguir");
		
		btnNewButton.setBounds(119, 151, 85, 21);
		getContentPane().add(btnNewButton);
		
		JButton btnDejarDeSeguir = new JButton("dejar de seguir");
		
		btnDejarDeSeguir.setBounds(232, 151, 131, 21);
		getContentPane().add(btnDejarDeSeguir);
		
		//seguir

		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iconU.seguirUsuario(comboBoxUsuario.getSelectedItem().toString(),comboBoxUsuario_1.getSelectedItem().toString());	
				
			}
		});
		
		//dejar de seguir
		btnDejarDeSeguir.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				iconU.dejarDeSeguirUsuario(comboBoxUsuario.getSelectedItem().toString(),comboBoxUsuario_1.getSelectedItem().toString());	
			}
		});
	}
	
	public void InicializarComboBoxesUsuario() {
		DefaultComboBoxModel<String> modelUSuario = new DefaultComboBoxModel<String>(iconU.listarUsuarios());
		comboBoxUsuario.setModel(modelUSuario);
	}
	
	public void InicializarComboBoxesUsuarioParaSeguir() {
		DefaultComboBoxModel<String> modelUSuario = new DefaultComboBoxModel<String>(iconU.listarUsuarios());
		comboBoxUsuario_1.setModel(modelUSuario);
	}
}
