package com.ecommerce.prices.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.prices.model.Price;


public interface PriceRepository extends JpaRepository<Price, Long> {

	List<Price> findPricesByBrandIdAndProductId(Long brandId, Long productId);

}