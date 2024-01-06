package com.ecom.app.serviceImpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.ParentProductDto;
import com.ecom.app.model.ParentProduct;
import com.ecom.app.repository.ParentProductRepository;
import com.ecom.app.service.ParentProductService;

@Service
public class ParentProductServiceImpl implements ParentProductService {

	@Autowired
	private ParentProductRepository parentProductRepository;

	@Override
	public List<ParentProductDto> getAllParentProduct() {

		return parentProductRepository.findAll().stream().map(e -> e.convertToParentProductDto())
				.collect(Collectors.toList());
	}

	@Override
	public ParentProduct saveParentProduct(ParentProductDto parentProduct) {
		ParentProduct product = new ParentProduct();
		product.setImageUrl(parentProduct.getImageUrl());
		product.setProductName(parentProduct.getProductName());
		ParentProduct productObj = parentProductRepository.save(product);
		return productObj;
	}

}
