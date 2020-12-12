package empleadosCidenet.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;

import empleadosCidenet.model.Empleados;

/**
 * 
 * @author dahia
 */
public class RegistroEmpleadosUI extends JFrame implements KeyListener {
	Container contenedor;
	JLabel jlapel, jlapel2, jlnom, jlonom, jlpais, jltipoid, jlid, jlfecha, jlarea, jlestado, jlregistro, jlnota;
	JTextField jtapel, jtapel2, jtnom, jtonom, jtid, jtfecha, jtregistro, jtestado;
	JComboBox jcpais, jctipo, jcarea;
	JDateChooser calendar;
	Empleados empleado;
	String apellido;
	String apellido2;
	String nombre;
	String nombreOtro;
	String pais;
	String tipoId;
	String id;
	String correo;
	Date ingreso;
	String area;
	String estad;
	Date registro;
	Date edicion;
	Date actual = new Date();
	int res = 0;

	public RegistroEmpleadosUI() {
		super("Registro Empleados");
		contenedor = this.getContentPane();
		contenedor.setBackground(Color.white);
		setSize(600, 600);
		setLocationRelativeTo(null);
		setResizable(false);
		setVisible(true);
		DateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		calendar = new JDateChooser();

		/** paneles y elementos **/
		JPanel paneldatos = new JPanel();
		paneldatos.setLayout(new GridLayout(12, 2, 10, 10));
		paneldatos.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));
		paneldatos.setBackground(Color.white);
		contenedor.add(paneldatos, BorderLayout.CENTER);

		JPanel panelop = new JPanel();
		panelop.setLayout(new GridLayout(1, 2, 50, 10));
		panelop.setBackground(Color.white);
		contenedor.add(panelop, BorderLayout.SOUTH);
		panelop.setBorder(BorderFactory.createEmptyBorder(20, 40, 20, 40));

		JButton jbadd = new JButton("Registrar empleado");
		jbadd.setBackground(Color.black);
		jbadd.setFocusPainted(false);
		jbadd.setForeground(Color.white);
		jbadd.setFont(new java.awt.Font("Tahoma", 0, 12));
		JButton jbcancel = new JButton("Cancelar");
		jbcancel.setBackground(Color.black);
		jbcancel.setFocusPainted(false);
		jbcancel.setForeground(Color.white);
		jbcancel.setFont(new java.awt.Font("Tahoma", 0, 12));

		panelop.add(jbadd);
		panelop.add(jbcancel);

		paneldatos.setVisible(true);
		panelop.setVisible(true);

		jlapel = new JLabel("Primero apellido*");
		jlapel.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlapel2 = new JLabel("Segundo apellido*");
		jlapel2.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlnom = new JLabel("Primer nombre*");
		jlnom.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlonom = new JLabel("Otros nombres");
		jlonom.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlpais = new JLabel("País del empleo*");
		jlpais.setFont(new java.awt.Font("Tahoma", 0, 12));
		jltipoid = new JLabel("Tipo de identificación*");
		jltipoid.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlid = new JLabel("Número de identificación*");
		jlid.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlfecha = new JLabel("Fecha de ingreso*");
		jlfecha.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlarea = new JLabel("Área*");
		jlarea.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlestado = new JLabel("Estado:");
		jlestado.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlregistro = new JLabel("Fecha y hora de registro:");
		jlregistro.setFont(new java.awt.Font("Tahoma", 0, 12));
		jlnota = new JLabel("(*) Campos obligatorios");
		jlnota.setFont(new java.awt.Font("Tahoma", 0, 12));

		jtapel = new JTextField();
		jtapel2 = new JTextField();
		jtnom = new JTextField();
		jtonom = new JTextField();
		jtid = new JTextField();
		jtfecha = new JTextField();
		jtregistro = new JTextField(formato.format(actual));
		jtregistro.setEditable(false);
		jtestado = new JTextField("Activo");
		jtestado.setEditable(false);

		jctipo = new JComboBox<>();
		jctipo.addItem("");
		jctipo.addItem("Cédula ciudadanía");
		jctipo.addItem("Cédula extranjería");
		jctipo.addItem("Pasaporte");
		jctipo.addItem("Permiso especial");
		jctipo.setBackground(Color.white);

		jcpais = new JComboBox<>();
		jcpais.addItem("");
		jcpais.addItem("Colombia");
		jcpais.addItem("Estados Unidos");
		jcpais.setBackground(Color.white);

		jcarea = new JComboBox<>();
		jcarea.addItem("");
		jcarea.addItem("Administración");
		jcarea.addItem("Financiera");
		jcarea.addItem("Compras");
		jcarea.addItem("Infraestructura");
		jcarea.addItem("Operación");
		jcarea.addItem("Talento Humano");
		jcarea.addItem("Servicios Varios");
		jcarea.setBackground(Color.white);

		paneldatos.add(jlapel);
		paneldatos.add(jtapel);
		paneldatos.add(jlapel2);
		paneldatos.add(jtapel2);
		paneldatos.add(jlnom);
		paneldatos.add(jtnom);
		paneldatos.add(jlonom);
		paneldatos.add(jtonom);
		paneldatos.add(jlpais);
		paneldatos.add(jcpais);
		paneldatos.add(jltipoid);
		paneldatos.add(jctipo);
		paneldatos.add(jlid);
		paneldatos.add(jtid);
		paneldatos.add(jlfecha);
		paneldatos.add(calendar);
		paneldatos.add(jlarea);
		paneldatos.add(jcarea);
		paneldatos.add(jlestado);
		paneldatos.add(jtestado);
		paneldatos.add(jlregistro);
		paneldatos.add(jtregistro);
		paneldatos.add(jlnota);

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

		jtnom.addKeyListener(this);
		jtonom.addKeyListener(this);
		jtapel.addKeyListener(this);
		jtapel2.addKeyListener(this);
		jtid.addKeyListener(this);

		/** acciones botones **/
		jbadd.addActionListener(new addNew());
		jbcancel.addActionListener(new opexit());

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

		if ((e.getSource() == jtid)) {
			if ((!Character.isLetterOrDigit(caracter) && caracter != ('-'))) {
				e.consume();
			}
		}
		if ((e.getSource() == jtonom) || (e.getSource() == jtnom) || (e.getSource() == jtapel)
				|| (e.getSource() == jtapel2)) {
			if (e.getKeyChar() > 32 && e.getKeyChar() < 65 || e.getKeyChar() >= 91) {
				e.consume();
			}
		}

	}

	class addNew implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			empleado = new Empleados();
			Empleados rst = new Empleados();
			apellido = jtapel.getText();
			apellido2 = jtapel2.getText();
			nombre = jtnom.getText();
			nombreOtro = jtonom.getText();
			pais = (String) jcpais.getSelectedItem();
			tipoId = (String) jctipo.getSelectedItem();
			id = jtid.getText();
			ingreso = calendar.getDate();
			area = (String) jcarea.getSelectedItem();
			estad = jtestado.getText();
			registro = actual;
			edicion = actual;
			res = empleado.validarCampos(apellido, apellido2, nombre, nombreOtro, pais, tipoId, id, ingreso, area);
			if (res == -1) {
				correo = generarCorreo(nombre, apellido);
				rst = empleado.consultaEmpleado(id);
				if (rst == null) {
					res = empleado.registroEmpleado(apellido, apellido2, nombre, nombreOtro, pais, tipoId, id, correo,
							ingreso, area, estad, registro, edicion);
					if (res > 0) {
						JOptionPane.showMessageDialog(null, "Se ha creado el nuevo empleado exitosamente", "Empleados",
								JOptionPane.INFORMATION_MESSAGE);
						limpiar();
					}
				} else {
					JOptionPane.showMessageDialog(null, "El empleado ya se encuentra registrado", "Empleados",
							JOptionPane.ERROR_MESSAGE);
				}
			} else {
				mensajeError();
			}

		}
	}

	public String generarCorreo(String nom, String apellido) {
		String nCorreo;
		int num;
		Empleados res = new Empleados();
		String[] sp;
		String x, y;
		String apel = apellido.replaceAll(" ", "");
		nCorreo = nom + "." + apel + "@cidenet.com.co";
		boolean ex = true;
		while (ex == true) {
			ex = correoExiste(nCorreo);
			if (ex == false) {
				break;
			} else {
				sp = nCorreo.split("@");
				x = sp[0];
				y = x.substring(x.length() - 1);
				if (y.equals(apellido.substring(apellido.length() - 1))) {
					num = 1;
				} else {
					num = Integer.parseInt(y);
					num++;
				}
				String numY = String.valueOf(num);
				nCorreo = nom + "." + apel + "." + numY + "@cidenet.com.co";
				}

		}

		nCorreo.toLowerCase();
		return nCorreo;

	}

	public boolean correoExiste(String corre) {
		boolean c = false;
		Empleados r = new Empleados();
		r = r.consultaCorreo(corre);
		if (r != null) {
			if (r.getCorreo().equals(corre)) {
				c = true;
			}
		}
		return c;
	}

	public void mensajeError() {
		
		if(res==1) {
			JOptionPane.showMessageDialog(null, "Los campos con (*) son obligatorios", "Empleados",
					JOptionPane.ERROR_MESSAGE);
		}else if(res==2) {
			JOptionPane.showMessageDialog(null, "Los nombres y apellidos no pueden superar los 20 caracteres", "Empleados",
					JOptionPane.ERROR_MESSAGE);
		}

	}
	
	//limpiar campos
	public void limpiar(){
		jtapel.setText("");
		jtapel2.setText("");
		jtnom.setText("");
		jtonom.setText("");
		jtid.setText("");
		jtfecha.setText("");
		jtregistro.setText("");
		jtestado.setText("");
		jcpais.setSelectedItem("");
		jcarea.setSelectedItem("");
		jctipo.setSelectedItem("");
		}
	
	class opexit implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			hide();
		}
	}

}
