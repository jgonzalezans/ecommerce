package com.inditex.service;

import com.inditex.exception.PriceNotFoundException;
import com.inditex.model.Price;
import com.inditex.model.PriceRequest;

public interface PriceService {

	Price getPrice(PriceRequest priceRequest) throws PriceNotFoundException;

}