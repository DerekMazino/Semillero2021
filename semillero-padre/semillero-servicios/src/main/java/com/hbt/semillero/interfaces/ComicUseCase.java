package com.hbt.semillero.interfaces;

import java.util.LinkedList;

import com.hbt.semillero.dto.ComicDTO;

public interface ComicUseCase {
	
	public void crearComic(ComicDTO nuevoComic);
	public LinkedList<ComicDTO> comicsActivos();
	public LinkedList<ComicDTO> comicsInactivos();
	public LinkedList<ComicDTO> allComics(); 
}
