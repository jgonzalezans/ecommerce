package com.ecommerce.prices.model;

import java.time.LocalDateTime;

public class PriceRequestFactory {

	private PriceRequestFactory() {
	}

	public static PriceRequest create(LocalDateTime fechaAplicacion, Long idProducto, Long idCadena) {
		return new PriceRequest(fechaAplicacion, idProducto, idCadena);
	}
}
