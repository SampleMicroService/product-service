package micro.service.product_service.controller;

import static org.hamcrest.CoreMatchers.any;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.*;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.math.BigDecimal;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import micro.service.product_service.entity.Product;
import micro.service.product_service.repository.ProductRepository;
import micro.service.product_service.service.ProductService;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {
	@Mock
	ProductService service;
	@Mock
	ProductRepository productRepository;
	
	static Product product;
	
	@BeforeAll
	static void init() {
		product = new Product();
		product.setId(1L);
		product.setName("IPhone");
		product.setPrice(BigDecimal.TEN);
		product.setQuantity(10);
		product.setDescription("Brand New Condition");
		
		System.out.println("before all");
	}

	@Test
	void createProduct() {
		
		when(productRepository.save(product)).thenReturn(product);
		
		Product newProduct = productRepository.save(product);
		
		assertEquals(1L, newProduct.getId());
		assertNotNull(newProduct);
		assertTrue(newProduct.getName().equals("IPhone"));
        System.out.println("save product");
    }
	
	@Test
	void deleteProduct() {
		doNothing().when(productRepository).deleteById(1L);;
		
		productRepository.deleteById(1L);
		
		verify(productRepository,times(1)).deleteById(1L);
    }
	
//	@Test
//	void testPrivateMethodsTrue() throws NoSuchMethodException, SecurityException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
//		Method method = ProductService.class.getDeclaredMethod("validName", String.class);
//		method.setAccessible(true);
//		boolean result = (boolean) method.invoke(service, "Book");
//		assertTrue(result);
//		
//	}
	
	@Test
	void exceptionTest() {
		service = new ProductService();
		RuntimeException assertThrows = Assertions.assertThrows(RuntimeException.class, () -> {
			service.nameCheck(null);
		});
		
		verify(productRepository, never()).save(Mockito.any(Product.class));
	}
	
	@AfterAll
	static void destroy() {
		product = new Product();
		System.out.println("object cleared");
	}

}
