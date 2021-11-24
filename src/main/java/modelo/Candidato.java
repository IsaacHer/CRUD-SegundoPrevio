package modelo;

import java.io.Serializable;
import lombok.Data;

public class Candidato implements Serializable {
	private Integer id;
	private String documento;
	private String nombre;
	private String apellido;
	private int eleccion;
	private int numero;
	
	public Candidato(Integer id, String documento, String nombre, String apellido, int eleccion, int numero) {
		this.id = id;
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eleccion = eleccion;
		this.numero = numero;
	}

	public Candidato(String documento, String nombre, String apellido, int eleccion, int numero) {
		
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
		this.eleccion = eleccion;
		this.numero = numero;
	}

	public Candidato(String documento, String nombre, String apellido) {
		this.documento = documento;
		this.nombre = nombre;
		this.apellido = apellido;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getEleccion() {
		return eleccion;
	}

	public void setEleccion(int eleccion) {
		this.eleccion = eleccion;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}
	
	
	
	
	
	
	
	
}
