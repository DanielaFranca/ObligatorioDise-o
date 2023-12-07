package uy.edu.ctc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "lineaBlanca")
public class LineaBlanca extends Electrodomestico{
	
	@Column
	private Double capacidad;

	public Double getCapacidad() {
		return capacidad;
	}

	public void setCapacidad(Double capacidad) {
		this.capacidad = capacidad;
	}
	
	public LineaBlanca (long id, String nombre, String marca, double precio, double capacidad) {
		super(id, nombre, marca, precio);
		this.capacidad = capacidad;
	}
}
