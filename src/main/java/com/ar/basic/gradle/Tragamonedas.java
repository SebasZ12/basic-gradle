package com.ar.basic.gradle;

public class Tragamonedas {
	
	private Tambor tambor1;
	private Tambor tambor2;
	private Tambor tambor3;
	
	public Tragamonedas(TamborFactory factory) {
		tambor1 = factory.crearTambor(1);
		tambor2 = factory.crearTambor(2);
		tambor3 = factory.crearTambor(3);
	}
	
	public void activar() {
		tambor1.girar();
		tambor2.girar();
		tambor3.girar();
	}

	public boolean entregaPremio() {
		return tambor1.obtenerPosicion() == tambor2.obtenerPosicion() && tambor3.obtenerPosicion() == tambor2.obtenerPosicion();
	}

}
