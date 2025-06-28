package micro.service.product_service.service;

import org.springframework.stereotype.Service;

@Service
public class ProductService {
	
	private boolean validName(String name) {
		System.out.println("the name is :"+name);
		if(name!= null && name.length()>0) {
			System.out.println("correct name is :"+name);
			return true;
		}else {
			System.out.println("wrong name is :"+name);
			throw new RuntimeException("Invalid Product Name");
		}
	}
	
	public boolean nameCheck(String name) {
		System.out.println("the name is :"+name);
		return validName(name);
	}
}
