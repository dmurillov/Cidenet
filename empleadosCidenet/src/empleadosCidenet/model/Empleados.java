package empleadosCidenet.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import empleadosCidenet.controller.EmpleadosController;

public class Empleados {

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
	Empleados empleado;
	EmpleadosController ec;

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
	public Empleados() {

		ec = new EmpleadosController();

	}

	/** método registrar empleado **/
	public int registroEmpleado(String apellido, String apellido2, String nombre, String nombreOtro, String pais,
			String tipoId, String id, String correo, Date ingreso, String area, String estado, Date registro,
			Date edicion) {
		int res = 0;
		empleado = new Empleados();
		res = ec.registroEmpleadoC(apellido, apellido2, nombre, nombreOtro, pais, tipoId, id, correo, ingreso, area,
				estado, registro, edicion);
		return res;
	}

	/** método edicion empleado **/
	public int editarEmpleado(String apellido, String apellido2, String nombre, String nombreOtro, String pais,
			String tipoId, String id, String correo, Date ingreso, String area, String estado, Date registro,
			Date edicion) {
		int res = 0;
		empleado = new Empleados();
		// res = usuarioBD.ingresarUsuario(nom, cla, identi, nombr, apel, tel, cel, ema,
		// codP);
		return res;
	}

	/** método eliminar empleado **/
	public int eliminarEmpleado(String apellido, String apellido2, String nombre, String nombreOtro, String pais,
			String tipoId, String id, String correo, Date ingreso, String area, String estado, Date registro,
			Date edicion) {
		int res = 0;
		empleado = new Empleados();
		// res = usuarioBD.ingresarUsuario(nom, cla, identi, nombr, apel, tel, cel, ema,
		// codP);
		return res;
	}

	public Empleados consultaCorreo(String correo) {
		Empleados res = new Empleados();
		res = ec.consultaCorreoC(correo);
		return res;

	}

	public Empleados consultaEmpleado(String id) {
		Empleados res = new Empleados();
		res = ec.consultaEmpleado(id);
		return res;

	}

	public int validarCampos(String apellido, String apellido2, String nombre, String nombreOtro, String pais, String tipoId, String id,
			Date ingreso, String area) {

		int valid = -1;
		if (apellido.trim().length() == 0 || apellido2.trim().length() ==0 || nombre.trim().length() == 0 || pais.trim().length() == 0 || tipoId.trim().length() == 0 || id.length() == 0 || ingreso== null || area.length() == 0) {
			valid = 1; //campos vacios
			return (valid);
		}
		
		if (nombreOtro.trim().length() > 50 || apellido2.length() > 20 || nombre.length() > 20 || apellido.length() > 20) {
			valid = 2; //caracteres máximos
			return (valid);
		}

		return valid;
	}
	
	public List<Empleados> listarTabla() {
		List<Empleados> res = new ArrayList<Empleados>();
		res = ec.cargarEmpleados();
		return res;
	}

}
