package com.ecommerce.prices.service;

import com.ecommerce.prices.exception.PriceNotFoundException;
import com.ecommerce.prices.model.Price;
import com.ecommerce.prices.model.PriceRequest;

public interface PriceService {

	Price getPrice(PriceRequest priceRequest) throws PriceNotFoundException;

}