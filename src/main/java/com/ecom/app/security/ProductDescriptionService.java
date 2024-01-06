package com.ecom.app.security;

import com.ecom.app.dto.ProductDescriptionDto;

public interface ProductDescriptionService {

	ProductDescriptionDto saveProductDesc(ProductDescriptionDto productDescriptionDto);

	ProductDescriptionDto getAllProductDescription(Long productId);

	ProductDescriptionDto updateProductDesc(ProductDescriptionDto productDescriptionDto);

}
