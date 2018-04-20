package co.edu.usbcali.banco.jpa;

import static org.junit.jupiter.api.Assertions.*;

import java.math.BigDecimal;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import co.edu.usbcali.banco.modelo.Cliente;
import co.edu.usbcali.banco.modelo.TipoDocumento;

class TestCliente {

	private final static Logger log = LoggerFactory.getLogger(TestCliente.class);
	static EntityManagerFactory  entityManagerFactory = null;
	static EntityManager entityManager = null;
	
	BigDecimal clieId = new BigDecimal(142020);
	
	@Test
	@DisplayName("Crear Cliente")
	void atest() {
		
		assertNotNull(entityManager,"El entitymanager es nulo");
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		assertNull(cliente, "El cliente ya existe");
		
		cliente = new Cliente();
		cliente.setActivo('S');
		cliente.setClieId(clieId);
		cliente.setDireccion("Avenida siempre viva");
		cliente.setEmail("naruto@gmial.com");
		cliente.setNombre("Naruto Uzumaki");
		cliente.setTelefono("55555555");
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, 2L);
		assertNotNull(tipoDocumento,"El tipo de documento no existe");
		cliente.setTipoDocumento(tipoDocumento);
		
		entityManager.getTransaction().begin();
			entityManager.persist(cliente);
		entityManager.getTransaction().commit();
		
		log.info("Se ejecuto la prueba A");
		
	}	
	
	@Test
	void btest() {
		
		assertNotNull(entityManager,"El entitymanager es nulo");
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		assertNotNull(cliente, "El cliente no existe");
		
		
		log.info("id cliente: " + cliente.getClieId());
		log.info("nombre cliente: " + cliente.getNombre());
		
	}
	
	@Test
	@DisplayName("Modificar Cliente")
	void ctest() {
		
		assertNotNull(entityManager,"El entitymanager es nulo");
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		assertNotNull(cliente, "El cliente no existe");
		
		cliente.setActivo('N');
		cliente.setClieId(clieId);
		cliente.setDireccion("La Aldea de la Hoja");
		cliente.setEmail("naruto@gmial.com");
		cliente.setNombre("Naruto Uzumaki");
		cliente.setTelefono("55555555");
		
		TipoDocumento tipoDocumento = entityManager.find(TipoDocumento.class, 2L);
		assertNotNull(tipoDocumento,"El tipo de documento no existe");
		cliente.setTipoDocumento(tipoDocumento);
		
		entityManager.getTransaction().begin();
			entityManager.merge(cliente);
		entityManager.getTransaction().commit();
		
		log.info("Se ejecuto la prueba C");
		
	}	
	
	@Test
	@DisplayName("Borrar Cliente")
	void dtest() {
		
		assertNotNull(entityManager,"El entitymanager es nulo");
		Cliente cliente = entityManager.find(Cliente.class, clieId);
		assertNotNull(cliente, "El cliente no existe");
		
		entityManager.getTransaction().begin();
			entityManager.remove(cliente);
		entityManager.getTransaction().commit();
		
		log.info("Se ejecuto la prueba D");
		
	}			
	
	@Test
	@DisplayName("Consultar Clientes")
	void etest() {
		
		assertNotNull(entityManager,"El entitymanager es nulo");
		
		String jpql = "SELECT cli FROM Cliente cli";
		
		List<Cliente> lstClientes = entityManager.createQuery(jpql).getResultList();
		
		/*
		for (Cliente cliente: lstClientes) {
			log.info("ID: " + cliente.getClieId());
			log.info("NOMBRE:" + cliente.getNombre());
		}
		*/
		
		lstClientes.forEach(cliente -> {
			log.info("ID: " + cliente.getClieId());
			log.info("NOMBRE:" + cliente.getNombre());			
		});
		
		log.info("Se ejecuto la prueba E");
		
	}			
	@BeforeAll
	public static void iniciar() {
		
		entityManagerFactory = Persistence.createEntityManagerFactory("banco-logica");
		entityManager = entityManagerFactory.createEntityManager();
		
		log.info("Ejecuto el BeforeAll");
	}
	
	@AfterAll
	public static void finalizar() {
		
		entityManager.close();
		entityManagerFactory.close();
		log.info("Ejecuto el AfterAlll");
	}
	
	@BeforeEach
	public void antesB() {
		log.info("Se ejecuto antes de cada prueba");
	}
	
	@AfterEach
	public void despuesB() {
		log.info("Se ejecuto despues de cada prueba");
	}

}
