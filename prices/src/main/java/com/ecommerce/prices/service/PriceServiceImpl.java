package com.ecommerce.prices.service;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecommerce.prices.exception.PriceNotFoundException;
import com.ecommerce.prices.model.Price;
import com.ecommerce.prices.model.PriceRequest;
import com.ecommerce.prices.repository.PriceRepository;

@Service
public class PriceServiceImpl implements PriceService {

	@Autowired
	private PriceRepository priceRepository;

	@Override
	public Price getPrice(PriceRequest priceRequest) throws PriceNotFoundException {

		LocalDateTime requestDate = priceRequest.getDate();
		Long requestBrandId = priceRequest.getBrandId();
		Long requestProductId = priceRequest.getProductId();
		
		// Obtenemos los precios para el producto y marca especificados
		List<Price> prices = priceRepository.findPricesByBrandIdAndProductId(requestBrandId, requestProductId);
	
		// Filtramos los precios que aplican para la fecha especificada
		// Ordenamos los precios filtrados por prioridad (mayor a menor) 
		// y devolvemos el primero, o una excepcion en caso de no encontrar ninguno
		return prices.stream()
	            .filter(p -> !requestDate.isBefore(p.getStartDate()) && !requestDate.isAfter(p.getEndDate()))
	            .sorted(Comparator.comparingInt(Price::getPriority).reversed())
	            .findFirst()
	            .orElseThrow(PriceNotFoundException::new);
	}
}