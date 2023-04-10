package com.inditex.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import com.inditex.model.Price;
import com.inditex.model.PriceDTO;

@Mapper(componentModel = "spring")
public interface PriceMapper {
	PriceMapper INSTANCE = Mappers.getMapper(PriceMapper.class);

	// Ignora los campos que no existen en PriceDTO
	@Mapping(target = "id", ignore = true)
	@Mapping(target = "priority", ignore = true)
	@Mapping(target = "currency", ignore = true)
	Price toEntity(PriceDTO priceDTO);

	@InheritInverseConfiguration
	PriceDTO toDto(Price price);
}
