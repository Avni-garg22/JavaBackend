package com.product_hibernate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.prac.Product;
import com.prac.ProductDao;
//ctrl+shift+o

public class ProductDaoTest {

	//emf
	//em
	//et
	static EntityManagerFactory emf;
	EntityManager em;
	
	@BeforeAll
	public static void initEmf() {
	emf=Persistence.createEntityManagerFactory("postgres");
	}
	
	@BeforeEach
	public void initEm() {
		em=emf.createEntityManager();
	}

	@Test
	public void insertProductTest() {
		System.out.println("Product Insert");

		ProductDao dao = new ProductDao();
		Product product = new Product();
		product.setId(6);
		product.setName("Pencil");
		product.setPrice(5);
		String actualRes=dao.insertProduct(product);
		assertEquals("data inserted",actualRes);
	}
	
	public void insertProductTestNull() {
		ProductDao dao = new ProductDao();
		String actualRes=dao.insertProduct(null);
		assertEquals("Illegal Argument",actualRes);
	}
	
@Test
public void findByIdTest() {
	System.out.println("Product Find");
	ProductDao dao=new ProductDao();
	Product p=dao.findProduct(100);
	assertNotNull(p);
}

@Test
public void deleteProductTest() {
    System.out.println("Product Delete Test");

    ProductDao dao = new ProductDao();

    Product product = new Product();
    product.setId(10);
    product.setName("Pen");
    product.setPrice(20);

    dao.insertProduct(product);

    dao.deleteProduct(10);

    Product p = dao.findProduct(10);
    assertNull(p);
}

@AfterEach
public void destroyEm() {
	em.close();
}

@AfterAll
public static void destryEmf() {
	emf.close();
}
}
