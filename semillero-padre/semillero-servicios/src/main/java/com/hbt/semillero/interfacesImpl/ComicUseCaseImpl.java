package com.hbt.semillero.interfacesImpl;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedList;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.*;
import com.hbt.semillero.interfaces.ComicUseCase;

public class ComicUseCaseImpl implements ComicUseCase{
	
	private LinkedList<ComicDTO> listaComics = new LinkedList<ComicDTO>();

	@Override
	public void crearComic(ComicDTO nuevoComic) {
		// TODO Auto-generated method stub
		listaComics.add(nuevoComic);
	}

	@Override
	public LinkedList<ComicDTO> comicsActivos() {
		LinkedList<ComicDTO> activos = new LinkedList<ComicDTO>();
		for(ComicDTO comicActual: listaComics)
			if(comicActual.getEstadoEnum().equals(EstadoEnum.ACTIVO))
				activos.add(comicActual);
		return activos;
	}

	@Override
	public LinkedList<ComicDTO> comicsInactivos() {
		LinkedList<ComicDTO> inactivos = new LinkedList<ComicDTO>();
		for(ComicDTO comicActual: listaComics)
			if(comicActual.getEstadoEnum().equals(EstadoEnum.INACTIVO))
				inactivos.add(comicActual);
		return inactivos;
	}

	@Override
	public LinkedList<ComicDTO> allComics() {
		return listaComics;
	}
	
	public void fabricaComics() {
		crearComic(new ComicDTO(1L,"X-men Nº1","Marvel",TematicaEnum.AVENTURAS,
				"Nº1",50,new BigDecimal(25000),"Stan Lee",true,
				LocalDate.now(),EstadoEnum.INACTIVO,10L));
		crearComic(new ComicDTO(2L,"X-Force Nº1","Marvel",TematicaEnum.AVENTURAS,
				"Nº1",50,new BigDecimal(25000),"Stan Lee",true,
				LocalDate.now(),EstadoEnum.INACTIVO,11L));
		crearComic(new ComicDTO(3L,"V de Vendetta","Vertico Comics",TematicaEnum.BELICO,
				"Nº1",50,new BigDecimal(25000),"Alan Moore",true,
				LocalDate.now(),EstadoEnum.ACTIVO,12L));
		crearComic(new ComicDTO(4L,"El Regreso del Caballero Oscuro","DC Comics",TematicaEnum.HORROR,
				"Nº1",50,new BigDecimal(25000),"Dennis O'Neile",true,
				LocalDate.now(),EstadoEnum.ACTIVO,13L));
		crearComic(new ComicDTO(5L,"Watchmen","DC Comics",TematicaEnum.BELICO,
				"Nº1",50,new BigDecimal(25000),"Alan Moore",true,
				LocalDate.now(),EstadoEnum.ACTIVO,14L));
		crearComic(new ComicDTO(6L,"Death Note","Shūeisha",TematicaEnum.HORROR,
				"Nº1",50,new BigDecimal(25000),"Tsugumi Ohba",true,
				LocalDate.now(),EstadoEnum.INACTIVO,15L));
		crearComic(new ComicDTO(7L,"Torre de Dios","Naver",TematicaEnum.FANTASTICO,
				"Nº1",50,new BigDecimal(25000),"SUI",true,
				LocalDate.now(),EstadoEnum.ACTIVO,16L));
		crearComic(new ComicDTO(8L,"Fullmetal Alchemist","Gekkan Shōnen Gangan",TematicaEnum.AVENTURAS,
				"Nº1",50,new BigDecimal(25000),"Hiromu Arakawa",true,
				LocalDate.now(),EstadoEnum.INACTIVO,17L));
		crearComic(new ComicDTO(9L,"SoloLeveling","D&C Media",TematicaEnum.CIENCIA_FICCION,
				"Nº1",50,new BigDecimal(25000),"Chugong",true,
				LocalDate.now(),EstadoEnum.ACTIVO,18L));
		crearComic(new ComicDTO(10L,"Spiderman","Marvel",TematicaEnum.AVENTURAS,
				"Nº1",50,new BigDecimal(25000),"Stan Lee",true,
				LocalDate.now(),EstadoEnum.ACTIVO,19L));
	}

}
