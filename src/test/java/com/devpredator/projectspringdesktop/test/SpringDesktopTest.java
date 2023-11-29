/**
 * 
 */
package com.devpredator.projectspringdesktop.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Properties;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.devpredator.projectspringdesktop.dao.DisqueraDao;
import com.devpredator.projectspringdesktop.dao.impl.DisqueraDaoImpl;

/**
 * @author jat_a Clase de prueba unitaria que permite realizar pruebas con el
 *         framework SPRING
 */
class SpringDesktopTest {

	@Test
	void test() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		assertNotNull(context);

		DisqueraDao disqueraDao = (DisqueraDao) context.getBean("disqueraDao");
		assertNotNull(disqueraDao);

		DisqueraDao disqueraDaoNuevo = (DisqueraDao) context.getBean("disqueraDao");

		assertEquals(disqueraDao, disqueraDaoNuevo);

		System.out.println("Contexto cargado exitosamente");
		System.out.println(disqueraDao);
		System.out.println(disqueraDaoNuevo);
	}

	@Test
	void testWithOutSpring() {
		DisqueraDao disqueraDaoSinSpring = new DisqueraDaoImpl();
		DisqueraDao disqueraDaoSinSpringNuevo = new DisqueraDaoImpl();

		assertNotEquals(disqueraDaoSinSpring, disqueraDaoSinSpringNuevo);
		System.out.println("disqueraDaoSinSpring: " + disqueraDaoSinSpring);
		System.out.println("disqueraDaoSinSpringNuevo: " + disqueraDaoSinSpringNuevo);
	}

	@Test
	void testProperties() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		Properties properties = (Properties) context.getBean("properties");
		System.out.println(properties.get("spring-username"));
	}

}
