package com.ar.basic.gradle;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class TragamonedasTest {

	@Test
	public void siLosTresTamboresTienenElMismoValorDeberiaDarPremio(){
		
		TamborFactory factory = mock(TamborFactory.class);
		Tambor tambor1Mock = mock(Tambor.class);
		Tambor tambor2Mock = mock(Tambor.class);
		Tambor tambor3Mock = mock(Tambor.class);
		
		when(factory.crearTambor(1)).thenReturn(tambor1Mock);
		when(factory.crearTambor(2)).thenReturn(tambor2Mock);
		when(factory.crearTambor(3)).thenReturn(tambor3Mock);
		
		when(tambor1Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(3);
		when(tambor3Mock.obtenerPosicion()).thenReturn(3);
		
		Tragamonedas maquinita = new Tragamonedas(factory);
		maquinita.activar();
		assertThat(maquinita.entregaPremio()).isTrue();
	}

	@Test
	public void siLosTresTamboresTienenDistintoValorNoDeberiaDarPremio(){
		
		TamborFactory factory = mock(TamborFactory.class);
		Tambor tambor1Mock = mock(Tambor.class);
		Tambor tambor2Mock = mock(Tambor.class);
		Tambor tambor3Mock = mock(Tambor.class);
		
		when(factory.crearTambor(1)).thenReturn(tambor1Mock);
		when(factory.crearTambor(2)).thenReturn(tambor2Mock);
		when(factory.crearTambor(3)).thenReturn(tambor3Mock);
		
		when(tambor1Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(4);
		when(tambor3Mock.obtenerPosicion()).thenReturn(1);
		
		Tragamonedas maquinita = new Tragamonedas(factory);
		maquinita.activar();
		assertThat(maquinita.entregaPremio()).isFalse();
	}
	
	@Test
	public void verificarQueAlActivarElTragamonedasGirenLosTresTambores(){
		
		TamborFactory factory = mock(TamborFactory.class);
		Tambor tambor1Mock = mock(Tambor.class);
		Tambor tambor2Mock = mock(Tambor.class);
		Tambor tambor3Mock = mock(Tambor.class);

		when(factory.crearTambor(1)).thenReturn(tambor1Mock);
		when(factory.crearTambor(2)).thenReturn(tambor1Mock);
		when(factory.crearTambor(3)).thenReturn(tambor3Mock);
		
		when(tambor2Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(3);
		
		Tragamonedas maquinita = new Tragamonedas(factory);
		maquinita.activar();
		
        verify(tambor1Mock, times(1)).girar();
		verify(tambor2Mock, times(1)).girar();
		verify(tambor3Mock, times(1)).girar();
	}
	
	@Test
	@SuppressWarnings("unused")
	public void verificarQueSiNoSeActivaElTragamonedasNoGirenLosTambores(){
		
		TamborFactory factory = mock(TamborFactory.class);
		Tambor tambor1Mock = mock(Tambor.class);
		Tambor tambor2Mock = mock(Tambor.class);
		Tambor tambor3Mock = mock(Tambor.class);
		
		when(factory.crearTambor(1)).thenReturn(tambor1Mock);
		when(factory.crearTambor(2)).thenReturn(tambor2Mock);
		when(factory.crearTambor(3)).thenReturn(tambor3Mock);
		
		when(tambor1Mock.obtenerPosicion()).thenReturn(3);
		when(tambor2Mock.obtenerPosicion()).thenReturn(3);
		when(tambor3Mock.obtenerPosicion()).thenReturn(3);
		
		Tragamonedas maquinita = new Tragamonedas(factory);
		
		verify(tambor1Mock, never()).girar();
		verify(tambor2Mock, never()).girar();
		verify(tambor3Mock, never()).girar();
	}
}
