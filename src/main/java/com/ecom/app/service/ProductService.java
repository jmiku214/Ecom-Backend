package com.ecom.app.service;

import com.ecom.app.dto.ProductDetailsDto;
import com.ecom.app.dto.ProductDto;
import com.ecom.app.dto.SearchDto;

public interface ProductService {

	ProductDto saveProduct(ProductDto productDto);

	ProductDetailsDto getAllProductDetails(Long subProductId);

	ProductDto productGetById(Long id);

	ProductDto updateProduct(ProductDto productDto);

	String deleteProduct(Long id);

	ProductDetailsDto sortAllProducts(SearchDto searchDto);

}
