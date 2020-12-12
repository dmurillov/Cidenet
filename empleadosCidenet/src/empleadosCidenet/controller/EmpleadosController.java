package empleadosCidenet.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import empleadosCidenet.model.Empleados;
import empleadosCidenet.utilities.Conexion;

public class EmpleadosController {

	private String apellido;
	private String apellido2;
	private String nombre;
	private String nombreOtro;
	private String pais;
	private String tipoId;
	private String id;
	private String correo;
	private Date ingreso;
	private String area;
	private String estad;
	private Date registro;
	private Date edicion;

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getApellido2() {
		return apellido2;
	}

	public void setApellido2(String apellido2) {
		this.apellido2 = apellido2;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getNombreOtro() {
		return nombreOtro;
	}

	public void setNombreOtro(String nombreOtro) {
		this.nombreOtro = nombreOtro;
	}

	public String getPais() {
		return pais;
	}

	public void setPais(String pais) {
		this.pais = pais;
	}

	public String getTipoId() {
		return tipoId;
	}

	public void setTipoId(String tipoId) {
		this.tipoId = tipoId;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public Date getIngreso() {
		return ingreso;
	}

	public void setIngreso(Date ingreso) {
		this.ingreso = ingreso;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getEstad() {
		return estad;
	}

	public void setEstad(String estad) {
		this.estad = estad;
	}

	public Date getRegistro() {
		return registro;
	}

	public void setRegistro(Date registro) {
		this.registro = registro;
	}

	public Date getEdicion() {
		return edicion;
	}

	public void setEdicion(Date edicion) {
		this.edicion = edicion;
	}

	/** constructor **/
	public EmpleadosController() {

	}

	public int registroEmpleadoC(String apellido, String apellido2, String nombre, String nombreOtro, String pais,
			String tipoId, String id, String correo, Date ingreso, String area, String estado, Date registro,
			Date edicion) {
		String sql = "INSERT INTO EMPLEADOS(APELLIDO,SEGUNDOAPELLIDO,NOMBRE,OTRONOMBRE,PAIS,TIPOID,ID,CORREO,FECHAI,AREA,ESTADO,FECHAR,FECHAE) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
		Conexion cone = new Conexion();
		java.sql.Date sIngreso = new java.sql.Date(ingreso.getTime()); // convertir a sql format
		java.sql.Date sRegistro = new java.sql.Date(registro.getTime());
		java.sql.Date sEdicion = new java.sql.Date(edicion.getTime());
		int res = 0;
		try {
			Connection con = cone.getConnection();
			if (con != null) {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, apellido);
				pst.setString(2, apellido2);
				pst.setString(3, nombre);
				pst.setString(4, nombreOtro);
				pst.setString(5, pais);
				pst.setString(6, tipoId);
				pst.setString(7, id);
				pst.setString(8, correo);
				pst.setDate(9, sIngreso);
				pst.setString(10, area);
				pst.setString(11, estado);
				pst.setDate(12, sRegistro);
				pst.setDate(13, sEdicion);
				res = pst.executeUpdate();
				pst.close();
				System.out.println("Registro exitoso");
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		}
		return res;

	}

	/** método para validar que ya no exista el correo **/
	public Empleados consultaCorreoC(String correo) {
		Empleados res = new Empleados();
		String sql = "SELECT CORREO FROM EMPLEADOS WHERE CORREO = ?";
		Conexion cone = new Conexion();
		ResultSet r = null;
		try {
			Connection con = cone.getConnection();
			if (con != null) {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, correo);
				r = pst.executeQuery();
				if (r.next()) {
					res.setCorreo(r.getString(1));
				} else {
					res = null;
				}
				r.close();
				pst.close();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		}
		return res;

	}

	/** consultar empleado registrado **/
	public Empleados consultaEmpleado(String id) {
		Empleados res = new Empleados();
		String sql = "SELECT Apellido,SegundoApellido,Nombre,OtroNombre,Pais,TipoId,ID,Correo,FechaI,Area,Estado,FechaE FROM EMPLEADOS WHERE ID = ?;";
		Conexion cone = new Conexion();
		ResultSet r = null;
		try {
			Connection con = cone.getConnection();
			if (con != null) {
				PreparedStatement pst = con.prepareStatement(sql);
				pst.setString(1, id);
				r = pst.executeQuery();
				if (r.next()) {
					res.setApellido(r.getString(1));
					res.setApellido2(r.getString(2));
					res.setNombre(r.getString(3));
					res.setNombreOtro(r.getString(4));
					res.setPais(r.getString(5));
					res.setTipoId(r.getString(6));
					res.setId(r.getString(7));
					res.setCorreo(r.getString(8));
					res.setRegistro(r.getDate(9));
					res.setArea(r.getString(10));
					res.setEstad(r.getString(11));
					res.setEdicion(r.getDate(12));
				} else {
					res = null;
				}
				r.close();
				pst.close();
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
			System.out.println("Error");
		}
		return res;

	}

	//método para listar tabla
	public List<Empleados> cargarEmpleados() {

		List<Empleados> empleados = new ArrayList();
		String sql = "SELECT * FROM Empleados ";
		PreparedStatement pst = null;
		Conexion cone = new Conexion();
		Connection con = cone.getConnection();
		ResultSet r = null;
		try {
			if (con != null) {
				pst = con.prepareStatement(sql);

				r = pst.executeQuery();
				while (r.next()) {
					Empleados emple = new Empleados();
					emple.setApellido(r.getString(1));
					emple.setApellido2(r.getString(2));
					emple.setNombre(r.getString(3));
					emple.setNombreOtro(r.getString(4));
					emple.setPais(r.getString(5));
					emple.setTipoId(r.getString(6));
					emple.setId(r.getString(7));
					emple.setCorreo(r.getString(8));
					emple.setIngreso(r.getDate(9));
					emple.setArea(r.getString(10));
					emple.setEstad(r.getString(11));
					emple.setRegistro(r.getDate(12));
					emple.setEdicion(r.getDate(13));

					empleados.add(emple);
				}
				r.close();
				pst.close();

			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return empleados;

	}

}
