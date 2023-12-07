package uy.edu.ctc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table (name = "electrodomesticos")
public abstract class Electrodomestico {
		
	@Id
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	private Long id;
		
	@Column (length = 30)		
	private String nombre;
		
	@Column (length = 30)		
	private String marca;
	
	@Column
	private Double precio;

	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Double getPrecio() {
		return precio;
	}

	public void setPrecio(Double precio) {
		this.precio = precio;
	}

	public Electrodomestico (long id, String nombre, String marca, double precio) {
		this.id = id;
		this.nombre = nombre;
		this.marca = marca;
		this.precio = precio;
	}
		
			
}
	
	

