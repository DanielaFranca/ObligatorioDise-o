package uy.edu.ctc.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table (name = "potencia")
public class UsoPersonal extends Electrodomestico{
	
	@Column
	private int potencia;

	public int getPotencia() {
		return potencia;
	}

	public void setPotencia(int potencia) {
		this.potencia = potencia;
	}
	
	public UsoPersonal (long id, String nombre, String marca, double precio, int potencia) {
		super(id, nombre, marca, precio);
		this.potencia = potencia;
	}
}
