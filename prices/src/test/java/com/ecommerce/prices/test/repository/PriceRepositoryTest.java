package com.ecommerce.prices.test.repository;

import static org.assertj.core.api.Assertions.assertThat;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.jdbc.Sql;

import com.ecommerce.prices.model.Price;
import com.ecommerce.prices.repository.PriceRepository;
import com.ecommerce.prices.test.config.TestConfig;

@Import(TestConfig.class)
@DataJpaTest
@Sql("/insert.sql")
class PriceRepositoryTest {

	@Autowired
	private PriceRepository priceRepository;

	@Test
	void findPricesByBrandIdAndProductId() {
		// Given
		long productId = 35455L;
		long brandId = 1L;
		LocalDateTime date = LocalDateTime.of(2020, 6, 14, 0, 0);
		
		// When
		List<Price> prices = priceRepository.findPricesByBrandIdAndProductId(brandId, productId);
		
		Price price = prices.stream()
		        .filter(p -> p.getStartDate()
		                .isEqual(date))
		        .findFirst()
		        .orElse(null);

		// Then
		assertThat(price).isNotNull();
		assertThat(price.getFinalPrice()).isEqualByComparingTo(BigDecimal.valueOf(35.50));
		assertThat(price.getPriceList()).isEqualTo(1);
		assertThat(price.getStartDate()).isEqualTo(LocalDateTime.of(2020, 6, 14, 0, 0));
		assertThat(price.getEndDate()).isEqualTo(LocalDateTime.of(2020, 12, 31, 23, 59, 59));
		assertThat(price.getPriority()).isZero();
		assertThat(price.getCurrency()).isEqualTo("EUR");
	}
}
