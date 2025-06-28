package micro.service.product_service.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import micro.service.product_service.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
