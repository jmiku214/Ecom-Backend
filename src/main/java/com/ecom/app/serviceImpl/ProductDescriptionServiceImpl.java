package com.ecom.app.serviceImpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.ProductDescriptionDto;
import com.ecom.app.dto.ProductDetailsDto;
import com.ecom.app.model.Product;
import com.ecom.app.model.ProductDescription;
import com.ecom.app.model.SubProduct;
import com.ecom.app.repository.ProductDescriptionRepositroy;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.security.ProductDescriptionService;

@Service
public class ProductDescriptionServiceImpl implements ProductDescriptionService {

	@Autowired
	private ProductDescriptionRepositroy productDescriptionRepositroy;
	
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public ProductDescriptionDto saveProductDesc(ProductDescriptionDto productDescriptionDto) {
		if (productDescriptionDto != null && productDescriptionDto.getId() == null) {
			Optional<ProductDescription> optionalProduct = productDescriptionRepositroy
					.findByProductId(productDescriptionDto.getProductId());
			if (!optionalProduct.isPresent()) {
				ProductDescription descriptionSave = productDescriptionDto.convertToProductDescEntity();
				ProductDescriptionDto descriptionDtoResponse = productDescriptionRepositroy.save(descriptionSave)
						.convertProductDescDto();
				return descriptionDtoResponse;
			} else {
				throw new RuntimeException("Already Exist !!!!");

			}
		} else {
			throw new RuntimeException("Check you request!!!");
		}
	}

	@Override
	public ProductDescriptionDto getAllProductDescription(Long productId) {
		Optional<Product> optionalProduct = productRepository.findById(productId);
		ProductDescriptionDto descriptionDto = optionalProduct.get().convertToProductDescriptionDtoResponse();
		return descriptionDto;
	}

	@Override
	public ProductDescriptionDto updateProductDesc(ProductDescriptionDto productDescriptionDto) {
		if (productDescriptionDto != null && productDescriptionDto.getId() != null) {
			ProductDescription descriptionSave = productDescriptionDto.convertToProductDescEntity();
			ProductDescriptionDto descriptionDtoResponse = productDescriptionRepositroy.save(descriptionSave)
					.convertProductDescDto();
			return descriptionDtoResponse;
		} else {
			throw new RuntimeException("Check you request!!!");
		}
	}

}
