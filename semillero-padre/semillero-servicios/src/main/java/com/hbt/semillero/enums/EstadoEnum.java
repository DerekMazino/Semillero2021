package com.hbt.semillero.enums;

/**
 * 
 * <b>Descripción:<b> Enumerador para indicar si el comic esta activo o inactivo

 * @author Camilo
 * @version
 */
public enum EstadoEnum {
	
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.inactivo");
	
	/**
	 * Atributo que contiene el estado actual del comic
	 */
	private String estado;
	/**
	 * 
	 * Constructor
	 * @param estado
	 */
	EstadoEnum(String estado)
	{
		this.estado = estado;
	}
	
	
	/**
	 * Metodo get, retorna el valor dentro de estado
	 * @return El estado asociado a la clase
	 */
	public String getEstado() {
		return estado;
	}

	
	
}