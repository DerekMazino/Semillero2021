package PruebasUnitarias;

import java.util.LinkedList;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.junit.Assert;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.enums.EstadoEnum;
import com.hbt.semillero.interfacesImpl.ComicUseCaseImpl;



/**
 * 
 * @author Camilo
 */
public class CreacionComicTest{
	
	private final static Logger log = Logger.getLogger(ComicDTO.class);
	
	/**
	 * Metodo para inicializar el Log
	 */
	@BeforeTest
	public static void iniciarLog()
	{
		BasicConfigurator.configure();
		log.info("PRUEBAS UNITARIAS!!!");
		
	}
	/**
	 * Metodo para imprimir una lista de comics que sean de tipo ComicDTO
	 */
	public void imprimirComics(LinkedList<ComicDTO> comics) {
		for(ComicDTO comicActual: comics) 
			System.out.println(comicActual);
	}
	/**
	 * Metodo para validar los comics activos
	 */
	@Test
	private void validarActiviso(LinkedList<ComicDTO> comics) {
		log.info("Inicio prueba validarActiviso()");

		boolean paso = true;
		
		try {
			
			
			for(ComicDTO comicActual: comics) {
				if(comicActual.getEstadoEnum().equals(EstadoEnum.INACTIVO)) {
					paso = false;
					break;
				}
							
			}
			if(!paso)
			{
				Assert.assertFalse(paso);
				log.info("Se produjo un error en validarActiviso()");
				throw new Exception("Uno o varios comics no deberían estar en esta lista");
			}
			
			Assert.assertTrue(paso);

			log.info("Lista de comics activos");
			imprimirComics(comics);	
			
		}catch(Exception e)
		{
			Assert.assertEquals(e.getMessage(), "Hay elementos que no deberían estar aca");

		}	
		log.info("Finaliza la ejecucion del metodo validarActiviso()");
	}
	/**
	 * Metodo para validad comics inactivos
	 */
	@Test
	private void validadInactivos(LinkedList<ComicDTO> comics, LinkedList<ComicDTO> todos) {
		log.info("Inicio prueba validadInactivos()");

		boolean paso = true;
		int tamanioListaTotal = todos.size();
		int numeroTotalActivos = tamanioListaTotal - comics.size();
		int numeroTotalInactivos = comics.size();
		try {
			
			
			for(ComicDTO comicActual: comics) {
				if(comicActual.getEstadoEnum().equals(EstadoEnum.ACTIVO)) {
					paso = false;
					break;
				}
							
			}
			if(!paso)
			{
				Assert.assertFalse(paso);
				log.info("Se produjo un error en validarActiviso()");
				throw new Exception("Uno o varios comics no deberían estar en esta lista");
			}
			
			Assert.assertTrue(paso);
			
			log.info("Lista de comics activos");
			
		}catch(Exception e)
		{
			Assert.assertEquals(e.getMessage(), "Se ha detectado que de "+tamanioListaTotal+ 
					" se encontraron que " + numeroTotalActivos +" se encuentran activos"+
					" y"+ numeroTotalInactivos +" inactivos.\nLos comics Inactivos son:");
			imprimirComics(comics);
		}	
		log.info("Finaliza la ejecucion del metodo validadInactivos()");
	}
	
	
	/**
	 * Metodo main para inicializar 
	 */
	public static void main(String[] args){
		CreacionComicTest pruebas = new CreacionComicTest();
		ComicUseCaseImpl usecase = new ComicUseCaseImpl();
		usecase.fabricaComics();
		LinkedList<ComicDTO> todos = usecase.allComics();
		LinkedList<ComicDTO> activos = usecase.comicsActivos();
		LinkedList<ComicDTO> inactivos = usecase.comicsInactivos();
		CreacionComicTest.iniciarLog();
		pruebas.validadInactivos(inactivos,todos);
		pruebas.validarActiviso(activos);
	}

}


