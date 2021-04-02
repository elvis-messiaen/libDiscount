package fr.afpa.libDiscount;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestEntitiesDao {
	
	@Before
	public void setUp() throws Exception{
		
	}
	
	@Test
	public void testEntities() {
		try {
			ClassPathXmlApplicationContext app = new ClassPathXmlApplicationContext("ok");
			assertTrue(true);
		} catch (Exception e) {
			assertTrue(e.getMessage(),false);
		}
	}
	

}
