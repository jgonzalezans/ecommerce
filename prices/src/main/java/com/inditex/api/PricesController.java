/**
 * 
 */
package com.inditex.api;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.inditex.exception.PriceNotFoundException;
import com.inditex.mapper.PriceMapper;
import com.inditex.model.Price;
import com.inditex.model.PriceDTO;
import com.inditex.model.PriceRequest;
import com.inditex.model.PriceRequestFactory;
import com.inditex.service.PriceService;

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
