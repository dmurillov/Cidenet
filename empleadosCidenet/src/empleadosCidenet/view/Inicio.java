package empleadosCidenet.view;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

import empleadosCidenet.utilities.Conexion;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * 
 * @author dahia
 */
public class Inicio extends JFrame {
	Container contenedor;

	public Inicio() {
		super("Cidenet");
		contenedor = this.getContentPane();
		setLayout(null);
		ImageIcon icologo = new ImageIcon(
				this.getClass().getResource("/empleadoscidenet/view/resources/images/cidenet-logo.png"));
		ImageIcon icobtn = new ImageIcon(
				this.getClass().getResource("/empleadoscidenet/view/resources/images/next.png"));
		JLabel jlogo = new JLabel(icologo);
		JLabel jltitle = new JLabel("Gestión de empleados");
		jltitle.setFont(new java.awt.Font("Tahoma", 0, 12));
		JButton jbiniciar = new JButton(icobtn);

		// coordenadas-style
		jlogo.setBounds(87, 50, 350, 182);
		jltitle.setBounds(199, 252, 125, 32);
		jbiniciar.setBounds(237, 292, 50, 40);
		setSize(524, 389);
		jbiniciar.setBackground(Color.black);
		jbiniciar.setFocusPainted(false);
		contenedor.setBackground(Color.white);

		// componentes al contenedor
		contenedor.add(jbiniciar);
		contenedor.add(jlogo);
		contenedor.add(jltitle);
		setVisible(true);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// acciones al btn
		jbiniciar.addActionListener(new opinicio());
	}

	class opinicio implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			hide();
			ConsultaEmpleadosUI ce = new ConsultaEmpleadosUI();
			ce.cargarTabla();
		}
	}

	public static void main(String[] args) throws SQLException {
		Inicio in = new Inicio();
		
		Conexion cone = new Conexion();
        Connection con = cone.getConnection();
		if (con != null) {
			System.out.println("good");
		}
		else {
			System.out.println("bad");
		}
        
	}

}
