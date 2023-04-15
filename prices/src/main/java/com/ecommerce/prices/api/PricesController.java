/**
 * 
 */
package com.ecommerce.prices.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.prices.exception.PriceNotFoundException;
import com.ecommerce.prices.mapper.PriceMapper;
import com.ecommerce.prices.model.Price;
import com.ecommerce.prices.model.PriceDTO;
import com.ecommerce.prices.model.PriceRequest;
import com.ecommerce.prices.model.PriceRequestFactory;
import com.ecommerce.prices.service.PriceService;

/**
 * @author jgonzalezans
 *
 */
@RestController
@RequestMapping("/prices")
public class PricesController {

	@Autowired
	private PriceService priceService;
	@Autowired
	private PriceMapper priceMapper;

	@GetMapping("/{productId}/{brandId}")
	public ResponseEntity<PriceDTO> getPrice(@PathVariable Long productId, @PathVariable Long brandId,
			@RequestParam("applicationDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime applicationDate) {

		PriceRequest priceRequest = PriceRequestFactory.create(applicationDate, productId, brandId);
		try {
			Price price = priceService.getPrice(priceRequest);
			PriceDTO priceDTO = priceMapper.toDto(price);
			return ResponseEntity.ok().body(priceDTO);
		} catch (PriceNotFoundException e) {
			return ResponseEntity.notFound().build();
		}

	}

}
