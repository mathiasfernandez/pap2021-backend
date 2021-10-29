package presentacion;

import java.awt.Dimension; 
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;

import interfaces.IcEspectaculo;
import interfaces.IcPaquete;
import interfaces.IcPlataforma;
import interfaces.IcRegistro;
import interfaces.IcTest;
import interfaces.IcUsuario;
import logica.Fabrica;
import publicadores.ControladorEspectaculoPublish;

import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Frame;


public class Principal {

	private JFrame frame;

	
	private SeguirUsuario SeguirUsuarioFrame;
	private AltaUsuarioJFrame altaUsuarioInternalFrame;
	private AltaFuncionDeEspectaculo altaFuncionDeEspectaculoInternalFrame;
	private AltaPlataformaJFrame altaPlataformaInternalFrame;
	private AltaEspectaculoJFrame altaEspectaculoFrame;

	private ConsultaFuncionDeEspectaculo consultaFuncionDeEspectaculoInternalFrame;
	private ConsultaUsuarioJFrame consultaUsuarioInternalFrame;
	private ConsultaEspectaculoJFrame consultaEspectaculoInternalFrame;
	private ConsultaPaqueteDeEspectaculos consultaPaqueteDeEspectaculosFrame;
	private CrearPaqueteDeEspectaculosJFrame crearPaqueteDeEspectaculoInternalFrame;
	
	private AgregarEspectaculoAPaquete agregarEspectaculoAPaqueteFrame;
	
	private ModificarUsuarioJFrame modificarUsuarioJFrame;
	
	private RegistroAFuncionDeEspectaculo registroAFuncionDeEspectaculoJFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws IOException
	 */
	public Principal() throws IOException {
		initialize();

		Fabrica fabrica = Fabrica.getInstancia();
		IcUsuario iconU = fabrica.getIControladorUsuario();
		IcEspectaculo iconE = fabrica.getIControladorEspectaculo();
		
		ControladorEspectaculoPublish cp = new ControladorEspectaculoPublish();
		cp.publicar();	
		
		
		IcPlataforma iconP = fabrica.getIControladorPlataforma();
		IcPaquete iconPQ = fabrica.getIControladorPaquete();
		IcRegistro iconR = fabrica.getIControladorRegistro();
		IcTest iconT = fabrica.getIControladorTest();
		iconT.altaData();

		Dimension desktopSize = frame.getSize();
		Dimension jInternalFrameSize;

		altaUsuarioInternalFrame = new AltaUsuarioJFrame(iconU, frame);
		jInternalFrameSize = altaUsuarioInternalFrame.getSize();
		altaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		altaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(altaUsuarioInternalFrame);

		altaFuncionDeEspectaculoInternalFrame = new AltaFuncionDeEspectaculo(iconE, iconP, iconU);
		jInternalFrameSize = altaFuncionDeEspectaculoInternalFrame.getSize();
		altaFuncionDeEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		altaFuncionDeEspectaculoInternalFrame.setVisible(false);
		frame.getContentPane().add(altaFuncionDeEspectaculoInternalFrame);
		
		altaEspectaculoFrame = new AltaEspectaculoJFrame(iconE,iconP,iconU);
		jInternalFrameSize = altaEspectaculoFrame.getSize();
		altaEspectaculoFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		altaEspectaculoFrame.setVisible(false);
		frame.getContentPane().add(altaEspectaculoFrame);

		consultaFuncionDeEspectaculoInternalFrame = new ConsultaFuncionDeEspectaculo(iconE, iconP);
		jInternalFrameSize = consultaFuncionDeEspectaculoInternalFrame.getSize();
		consultaFuncionDeEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		consultaFuncionDeEspectaculoInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaFuncionDeEspectaculoInternalFrame);

		consultaEspectaculoInternalFrame = new ConsultaEspectaculoJFrame(iconE,iconP,iconPQ);
		jInternalFrameSize = consultaEspectaculoInternalFrame.getSize();
		consultaEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		consultaEspectaculoInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaEspectaculoInternalFrame);

		consultaUsuarioInternalFrame = new ConsultaUsuarioJFrame(iconU,iconE,iconPQ);
		jInternalFrameSize = consultaUsuarioInternalFrame.getSize();
		consultaUsuarioInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		consultaUsuarioInternalFrame.setVisible(false);
		frame.getContentPane().add(consultaUsuarioInternalFrame);
		
		altaPlataformaInternalFrame = new AltaPlataformaJFrame(iconP);
		jInternalFrameSize = altaPlataformaInternalFrame.getSize();
		altaPlataformaInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		altaPlataformaInternalFrame.setVisible(false);
		frame.getContentPane().add(altaPlataformaInternalFrame);
		
		agregarEspectaculoAPaqueteFrame = new AgregarEspectaculoAPaquete(iconPQ);
		jInternalFrameSize = agregarEspectaculoAPaqueteFrame.getSize();
		agregarEspectaculoAPaqueteFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		agregarEspectaculoAPaqueteFrame.setVisible(false);
		frame.getContentPane().add(agregarEspectaculoAPaqueteFrame);
		
		crearPaqueteDeEspectaculoInternalFrame = new CrearPaqueteDeEspectaculosJFrame(iconPQ);
		jInternalFrameSize = crearPaqueteDeEspectaculoInternalFrame.getSize();
		crearPaqueteDeEspectaculoInternalFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		crearPaqueteDeEspectaculoInternalFrame.setVisible(false);
		frame.getContentPane().add(crearPaqueteDeEspectaculoInternalFrame);
		
		modificarUsuarioJFrame = new ModificarUsuarioJFrame(iconU);
		jInternalFrameSize = modificarUsuarioJFrame.getSize();
		modificarUsuarioJFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		modificarUsuarioJFrame.setVisible(false);
		frame.getContentPane().add(modificarUsuarioJFrame);
		
		registroAFuncionDeEspectaculoJFrame = new RegistroAFuncionDeEspectaculo(iconP,iconE,iconU,iconR);
		jInternalFrameSize = registroAFuncionDeEspectaculoJFrame.getSize();
		registroAFuncionDeEspectaculoJFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		registroAFuncionDeEspectaculoJFrame.setVisible(false);
		frame.getContentPane().add(registroAFuncionDeEspectaculoJFrame);
		
		consultaPaqueteDeEspectaculosFrame = new ConsultaPaqueteDeEspectaculos(iconPQ,iconE,iconP);
		jInternalFrameSize = consultaPaqueteDeEspectaculosFrame.getSize();
		consultaPaqueteDeEspectaculosFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		consultaPaqueteDeEspectaculosFrame.setVisible(false);
		frame.getContentPane().add(consultaPaqueteDeEspectaculosFrame);
		
		SeguirUsuarioFrame = new SeguirUsuario(iconU);
		jInternalFrameSize = SeguirUsuarioFrame.getSize();
		SeguirUsuarioFrame.setLocation((desktopSize.width - jInternalFrameSize.width) / 2,
				(desktopSize.height - jInternalFrameSize.height) / 2);
		SeguirUsuarioFrame.setVisible(false);
		frame.getContentPane().add(SeguirUsuarioFrame);
		
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.getContentPane().setBackground(Color.LIGHT_GRAY);
		frame.setBounds(100, 100, 688, 637);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(Color.LIGHT_GRAY);
		frame.setJMenuBar(menuBar);

		JMenu mnNewMenu = new JMenu("Altas");
		menuBar.add(mnNewMenu);

		JMenuItem mntmNewMenuItem = new JMenuItem("Usuario");
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				altaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmNewMenuItem);

		JMenuItem mntmNewMenuItem_1 = new JMenuItem("Espectaculo");
		mntmNewMenuItem_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				altaEspectaculoFrame.setVisible(true);
				altaEspectaculoFrame.InicializarComboBoxesPlataforma();
				altaEspectaculoFrame.InicializarComboBoxesArtista();
			}
		});
		mnNewMenu.add(mntmNewMenuItem_1);
		
		// boton menu: Nueva > Funcion
		JMenuItem mntmFuncion = new JMenuItem("Funcion");
		mntmFuncion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				esconderTodo();
				altaFuncionDeEspectaculoInternalFrame.InicializarComboBoxes();
				altaFuncionDeEspectaculoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmFuncion);
		
		JMenuItem mntmPlataforma = new JMenuItem("Plataforma");
		mntmPlataforma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				esconderTodo();
				altaPlataformaInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmPlataforma);
		//ALTA PAQUETE
		JMenuItem mntmPaquete = new JMenuItem("Paquete");
		mntmPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				crearPaqueteDeEspectaculoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu.add(mntmPaquete);

		JMenu mnNewMenu_1 = new JMenu("Bajas");
		menuBar.add(mnNewMenu_1);

		JMenu mnNewMenu_2 = new JMenu("Modificaciones");
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_4 = new JMenuItem("Agregar espectaculo a paquete");
		mntmNewMenuItem_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				agregarEspectaculoAPaqueteFrame.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_4_1 = new JMenuItem("Usuario");
		mntmNewMenuItem_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				modificarUsuarioJFrame.setVisible(true);
				modificarUsuarioJFrame.InicializarComboBoxesUsuario();
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_4_1);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("Registro a funcion de espectaculo");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				registroAFuncionDeEspectaculoJFrame.setVisible(true);
				registroAFuncionDeEspectaculoJFrame.InicializarComboBoxPlataforma();
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_5);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("Seguir a un usuario");
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				SeguirUsuarioFrame.setVisible(true);
				SeguirUsuarioFrame.InicializarComboBoxesUsuario();
				SeguirUsuarioFrame.InicializarComboBoxesUsuarioParaSeguir();
				
				
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);

		JMenu mnNewMenu_3 = new JMenu("Consultas");
		menuBar.add(mnNewMenu_3);

		JMenuItem mntmNewMenuItem_2 = new JMenuItem("Usuario");
		mntmNewMenuItem_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				consultaUsuarioInternalFrame.InicializarComboBoxes();
				consultaUsuarioInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_2);

		JMenuItem mntmNewMenuItem_3 = new JMenuItem("Espectaculo");
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				consultaEspectaculoInternalFrame.InicializarComboBoxes();
				consultaEspectaculoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmNewMenuItem_3);
		
		// Consulta > Funcion
		JMenuItem mntmFuncion_1 = new JMenuItem("Funcion");
		mntmFuncion_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				consultaFuncionDeEspectaculoInternalFrame.InicializarComboBoxes(); // inicializa plataformas
				consultaFuncionDeEspectaculoInternalFrame.setVisible(true);
			}
		});
		mnNewMenu_3.add(mntmFuncion_1);
		
		JMenuItem btnConsulPaquete = new JMenuItem("Paquete");
		btnConsulPaquete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				esconderTodo();
				consultaPaqueteDeEspectaculosFrame.setVisible(true);
			}
		});
		mnNewMenu_3.add(btnConsulPaquete);
		
	}
	
	public void esconderTodo() {
		altaUsuarioInternalFrame.setVisible(false);
		consultaUsuarioInternalFrame.setVisible(false);
		consultaEspectaculoInternalFrame.setVisible(false);
		consultaFuncionDeEspectaculoInternalFrame.setVisible(false);
		altaPlataformaInternalFrame.setVisible(false);
		altaFuncionDeEspectaculoInternalFrame.setVisible(false);
		altaEspectaculoFrame.setVisible(false);
		agregarEspectaculoAPaqueteFrame.setVisible(false);
		crearPaqueteDeEspectaculoInternalFrame.setVisible(false);
		modificarUsuarioJFrame.setVisible(false);
		registroAFuncionDeEspectaculoJFrame.setVisible(false);
		consultaPaqueteDeEspectaculosFrame.setVisible(false);
		SeguirUsuarioFrame.setVisible(false);
	}
}
