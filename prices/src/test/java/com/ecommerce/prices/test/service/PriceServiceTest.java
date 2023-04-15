package com.ecommerce.prices.test.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;

import com.ecommerce.prices.exception.PriceNotFoundException;
import com.ecommerce.prices.model.Price;
import com.ecommerce.prices.model.PriceRequest;
import com.ecommerce.prices.model.PriceRequestFactory;
import com.ecommerce.prices.repository.PriceRepository;
import com.ecommerce.prices.service.PriceServiceImpl;

@SpringBootTest
class PriceServiceTest {

	@Mock
	private PriceRepository priceRepository;

	@InjectMocks
	private PriceServiceImpl priceService;

	@Test
	void testGetPrice() throws PriceNotFoundException {
		// Crear instancia de PriceRequest
		PriceRequest priceRequest = PriceRequestFactory.create(LocalDateTime.of(2020, 6, 14, 10, 0), 35455L, 1L);


		// Mockear llamada al repositorio
		List<Price> prices = Arrays.asList(
		        new Price(1L, 1L, 35455L, 1, LocalDateTime.of(2020, 6, 14, 0, 0),
		                LocalDateTime.of(2020, 12, 31, 23, 59, 59), new BigDecimal("35.50"), "EUR", 0),
		        new Price(2L, 1L, 35455L, 2, LocalDateTime.of(2020, 6, 14, 15, 0),
		                LocalDateTime.of(2020, 6, 14, 18, 30), new BigDecimal("25.45"), "EUR", 1),
		        new Price(3L, 1L, 35455L, 3, LocalDateTime.of(2020, 6, 15, 0, 0),
		                LocalDateTime.of(2020, 6, 15, 11, 0), new BigDecimal("30.50"), "EUR", 1),
		        new Price(4L, 1L, 35455L, 4, LocalDateTime.of(2020, 6, 15, 16, 0),
		                LocalDateTime.of(2020, 12, 31, 23, 59, 59), new BigDecimal("38.95"), "EUR", 1)
		);

		//Cuando se llame al repository dentro del servicio se usara la lista anterior de datos
		when(priceRepository.findPricesByBrandIdAndProductId(priceRequest.getBrandId(), priceRequest.getProductId()))
				.thenReturn(prices);

		// Llamar al servicio y verificar el resultado
		Price expectedPrice =  new Price(1L, 1L, 35455L, 1, LocalDateTime.of(2020, 6, 14, 0, 0),
                LocalDateTime.of(2020, 12, 31, 23, 59, 59), new BigDecimal("35.50"), "EUR", 0);
		Price actualPrice = priceService.getPrice(priceRequest);
		assertEquals(expectedPrice, actualPrice,"El precio devuelto por el servicio no es el esperado");
	}

}