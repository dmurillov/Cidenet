package empleadosCidenet.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import empleadosCidenet.model.Empleados;

/**
 * 
 * @author dahia
 */
public class ConsultaEmpleadosUI extends JFrame implements KeyListener, MouseListener {

	Container contenedor;
	JPanel jpbtn, jpfiltros, jptable;
	JTable tbconsulta;
	JLabel jlnom, jlonom, jlapel, jlapel2, jltipoid, jlid, jlpais, jlcorreo, jlestado, jlfiltro;
	JTextField jtnom, jtonom, jtapel, jtapel2, jtid, jtcorreo;
	JButton jbadd, jbexit, jbeli, jbedit;
	JComboBox jctipoid, jcpais, jcestado;
	DefaultTableModel dataModel;
	JLabel editar,delete;

	public ConsultaEmpleadosUI() {
		super("Consulta Empleados");
		contenedor = this.getContentPane();
		setLayout(null);
		String cols[] = { "Primer Apellido", "Segundo Apellido", "Primer Nombre", "Otros Nombres", "País del empleo",
				"Tipo Identificación", "Número Identificación", "Correo electrónico", "Fecha de ingreso", "Área",
				"Estado", "Fecha de registro", "Editar", "Eliminar"};

		ImageIcon icoadd = new ImageIcon(
				this.getClass().getResource("/empleadoscidenet/view/resources/images/add.png"));
		ImageIcon icoexit = new ImageIcon(
				this.getClass().getResource("/empleadoscidenet/view/resources/images/cancel.png"));
		ImageIcon icoedit = new ImageIcon(
				this.getClass().getResource("/empleadoscidenet/view/resources/images/edit.png"));
		ImageIcon icodelete = new ImageIcon(
				this.getClass().getResource("/empleadoscidenet/view/resources/images/delete.png"));
		JButton jbadd = new JButton(icoadd);
		JButton jbexit = new JButton(icoexit);
		JButton jbedit = new JButton(icoedit);
		editar = new JLabel(icoedit);
		delete = new JLabel(icodelete);
		jlnom = new JLabel("Primer nombre:");
		jlnom.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlonom = new JLabel("Otros nombres:");
		jlonom.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlapel = new JLabel("Primer apellido:");
		jlapel.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlapel2 = new JLabel("Segundo apellido:");
		jlapel2.setFont(new java.awt.Font("Tahoma", 0, 12));
		jltipoid = new JLabel("Tipo de identificación:");
		jltipoid.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlid = new JLabel("Número de identificación:");
		jlid.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlpais = new JLabel("País del empleo:");
		jlpais.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlcorreo = new JLabel("Correo electrónico:");
		jlcorreo.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlestado = new JLabel("Estado:");
		jlestado.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlfiltro = new JLabel("Filtrar por:");
		jlfiltro.setFont(new java.awt.Font("Tahoma", 0, 12));

		jtnom = new JTextField();
		jtonom = new JTextField("");
		jtapel = new JTextField("");
		jtapel2 = new JTextField("");
		jtid = new JTextField("");
		jtcorreo = new JTextField("");

		jcestado = new JComboBox<>();
		jcestado.addItem("-Estado-");
		jcestado.addItem("Activo");
		jcestado.addItem("Inactivo");
		jcestado.setBackground(Color.white);

		jctipoid = new JComboBox<>();
		jctipoid.addItem("-Tipo ID-");
		jctipoid.addItem("Cédula ciudadanía");
		jctipoid.addItem("Cédula extranjería");
		jctipoid.addItem("Pasaporte");
		jctipoid.addItem("Permiso especial");
		jctipoid.setBackground(Color.white);

		jcpais = new JComboBox<>();
		jcpais.addItem("-País-");
		jcpais.addItem("Colombia");
		jcpais.addItem("Estados Unidos");
		jcpais.setBackground(Color.white);

		/** coordenadas filtros **/
		jlfiltro.setBounds(20, 10, 90, 30);
		jlnom.setBounds(20, 50, 100, 30);
		jlonom.setBounds(290, 50, 100, 30);
		jlapel.setBounds(560, 50, 100, 30);
		jlapel2.setBounds(830, 50, 100, 30);
		jltipoid.setBounds(20, 100, 140, 30);
		jlid.setBounds(310, 100, 140, 30);
		jlpais.setBounds(590, 100, 140, 30);
		jlcorreo.setBounds(820, 100, 140, 30);
		jlestado.setBounds(1120, 100, 100, 30);

		jtnom.setBounds(120, 50, 150, 30);
		jtonom.setBounds(390, 50, 150, 30);
		jtapel.setBounds(660, 50, 150, 30);
		jtapel2.setBounds(950, 50, 150, 30);
		jctipoid.setBounds(160, 100, 130, 30);
		jtid.setBounds(470, 100, 100, 30);
		jcpais.setBounds(700, 100, 100, 30);
		jtcorreo.setBounds(950, 100, 150, 30);
		jcestado.setBounds(1190, 100, 100, 30);

		jbadd.setBounds(1260, 15, 50, 40);
		jbadd.setBackground(Color.black);
		jbedit.setBounds(1160, 15, 50, 40);
		jbedit.setBackground(Color.black);
		jbexit.setBounds(1320, 15, 50, 40);
		jbexit.setBackground(Color.black);
		jbadd.setFocusPainted(false);
		jbexit.setFocusPainted(false);
	

		jpfiltros = new JPanel();
		jpfiltros.setLayout(null);
		jpfiltros.setBorder(BorderFactory.createLineBorder(Color.black));
		jpfiltros.add(jlfiltro);
		jpfiltros.add(jlnom);
		jpfiltros.add(jtnom);
		jpfiltros.add(jlonom);
		jpfiltros.add(jtonom);
		jpfiltros.add(jlapel);
		jpfiltros.add(jtapel);
		jpfiltros.add(jlapel2);
		jpfiltros.add(jtapel2);
		jpfiltros.add(jltipoid);
		jpfiltros.add(jctipoid);
		jpfiltros.add(jlid);
		jpfiltros.add(jtid);
		jpfiltros.add(jlpais);
		jpfiltros.add(jcpais);
		jpfiltros.add(jlcorreo);
		jpfiltros.add(jtcorreo);
		jpfiltros.add(jlestado);
		jpfiltros.add(jcestado);

		jpfiltros.setVisible(true);
		jpfiltros.setBounds(35, 400, 1320, 150);
		contenedor.add(jpfiltros);
		contenedor.add(jbadd);
		contenedor.add(jbexit);
		contenedor.add(jbedit);

		jtnom.requestFocus();

		/** tabla **/
		dataModel = new DefaultTableModel();
		tbconsulta = new JTable(dataModel);
		dataModel.setColumnIdentifiers(cols);
		JScrollPane scrollpnDatos = new JScrollPane(tbconsulta);
		scrollpnDatos.setBounds(20, 60, 1350, 300);
		tbconsulta.setOpaque(true);
		scrollpnDatos.setBackground(Color.white);
		contenedor.add(scrollpnDatos);

		contenedor.setBackground(Color.white);
		jpfiltros.setBackground(Color.white);
		setSize(1400, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		/** acciones botones **/
		jbadd.addActionListener(new addempleado());
		jbexit.addActionListener(new opexit());
		jbedit.addActionListener(new editop());

		/** eventos solo mayus **/
		jtnom.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				Character c = evt.getKeyChar();
				if (Character.isLetter(c)) {
					evt.setKeyChar(Character.toUpperCase(c));
				}
			}
		});

		jtonom.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				Character c = evt.getKeyChar();
				if (Character.isLetter(c)) {
					evt.setKeyChar(Character.toUpperCase(c));
				}
			}
		});

		jtapel.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				Character c = evt.getKeyChar();
				if (Character.isLetter(c)) {
					evt.setKeyChar(Character.toUpperCase(c));
				}
			}
		});

		jtapel2.addKeyListener(new java.awt.event.KeyAdapter() {
			public void keyTyped(java.awt.event.KeyEvent evt) {
				Character c = evt.getKeyChar();
				if (Character.isLetter(c)) {
					evt.setKeyChar(Character.toUpperCase(c));
				}
			}
		});

		/** eventos a txt **/
		jtnom.addKeyListener(this);
		jtonom.addKeyListener(this);
		jtapel.addKeyListener(this);
		jtapel2.addKeyListener(this);
		jtid.addKeyListener(this);
		jtcorreo.addKeyListener(this);
		tbconsulta.addMouseListener(this);
	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyTyped(KeyEvent e) {
		/** restricciones de ingreso de datos **/
		char caracter = e.getKeyChar();
		if ((e.getSource() == jtonom) || (e.getSource() == jtnom) || (e.getSource() == jtapel)
				|| (e.getSource() == jtapel2)) {
			if (e.getKeyChar() > 32 && e.getKeyChar() < 65 || e.getKeyChar() >= 91) {
				e.consume();
			}
		}

		if ((e.getSource() == jtid)) {
			if ((!Character.isLetterOrDigit(caracter) && caracter != ('-'))) {
				e.consume();
			}
		}

	}

	class addempleado implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			RegistroEmpleadosUI re = new RegistroEmpleadosUI();
		}
	}

	class opexit implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			System.exit(EXIT_ON_CLOSE);
		}
	}

	class editop implements ActionListener {
		public void actionPerformed(ActionEvent e) {

			EdicionEmpleadosUI ed = new EdicionEmpleadosUI();
		}
	}

	public void cargarTabla() {
		Empleados res = new Empleados();
		List<Empleados> result = new ArrayList<Empleados>();
		result = (List<Empleados>) res.listarTabla();
		if (tbconsulta.getColumnCount() > 0) {
			dataModel.setRowCount(0);
		}
		for (int i = 0; i < result.size(); i++) {
			Empleados empl = result.get(i);
			SimpleDateFormat forma = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String dIngreso = forma.format(empl.getIngreso());
			String dRegistro = forma.format(empl.getRegistro());
			String dEdicion = forma.format(empl.getEdicion());

			String datos[] = { empl.getApellido(), empl.getApellido2(), empl.getNombre(), empl.getNombreOtro(),
					empl.getPais(), empl.getTipoId(), empl.getId(), empl.getCorreo(), dIngreso, empl.getArea(),
					empl.getEstad(), dRegistro,"Editar","Eliminar"};
			dataModel.addRow(datos);
		}

	}
	
	public void mouseClicked(MouseEvent e) 
    {
		Empleados em = new Empleados();
		int fila = tbconsulta.rowAtPoint(e.getPoint());
		int columna = tbconsulta.columnAtPoint(e.getPoint());
		
		if(columna==12) {
			
		}else if(columna==13) {
			JOptionPane.showMessageDialog(null, "Está seguro de que desea eliminar el empleado?", "Empleados",
					JOptionPane.YES_NO_CANCEL_OPTION);
		}
		
    }

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
    

}
