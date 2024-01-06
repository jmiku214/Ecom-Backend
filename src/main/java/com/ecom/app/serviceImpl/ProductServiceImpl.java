package com.ecom.app.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.ecom.app.dto.ProductDetailsDto;
import com.ecom.app.dto.ProductDto;
import com.ecom.app.dto.SearchDto;
import com.ecom.app.model.Product;
import com.ecom.app.model.SubProduct;
import com.ecom.app.repository.ProductRepository;
import com.ecom.app.repository.SubProductRepository;
import com.ecom.app.service.ProductService;
import com.ecom.app.util.Pagination;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private SubProductRepository subProductRepository;

	@Override
	public ProductDto saveProduct(ProductDto productDto) {
//		try {
		if (productDto != null && (productDto.getId() == null || productDto.getId() == 0)) {
//				List<Product> productList = productRepository.findByModelName(productDto.getModelName());
//				if (productList.size() > 0)
//					throw new RuntimeException("Duplicate ModelName cannot allow!!!");
			Product productSave = productRepository.save(productDto.convertToProductEntity());
			return productSave.convertToProductDto();
		} else {
			throw new RuntimeException("Check you request!!!");
		}
//		} catch (Exception e) {
//			throw new RuntimeException(e.getMessage());
//		}
	}

	@Override
	public ProductDetailsDto getAllProductDetails(Long subProductId) {
		Optional<SubProduct> optionalSub = subProductRepository.findById(subProductId);
		ProductDetailsDto productDetailsDto = optionalSub.get().convertToProductDetailsDto();
		return productDetailsDto;
	}

	@Override
	public ProductDto productGetById(Long id) {
		Optional<Product> productById = productRepository.findById(id);
		return productById.get().convertToProductDto();
	}

	@Override
	public ProductDto updateProduct(ProductDto productDto) {
		try {
			if (productDto != null && productDto.getId() != null) {
//				List<Product> productList = productRepository.findByModelName(productDto.getModelName());
//				if (productList.size() > 1)
//					throw new RuntimeException("Duplicate ModelName cannot allow!!!");
				Product productSave = productRepository.save(productDto.convertToProductEntity());
				return productSave.convertToProductDto();
			} else {
				throw new RuntimeException("Check you request!!!");
			}
		} catch (Exception e) {
			throw new RuntimeException(e.getMessage());
		}
	}

	@Override
	public String deleteProduct(Long id) {

		productRepository.deleteById(id);
		return "Successfully Deleted !!!";
	}

	@Override
	public ProductDetailsDto sortAllProducts(SearchDto searchDto) {
		Optional<SubProduct> optionalSub = subProductRepository.findById(searchDto.getSubProductId());
		List<Product> productList = optionalSub.get().getProductId();
		try {
		if (searchDto.getSortType() == 2) {
			productList = productRepository.findByIdAndDesc(searchDto.getSubProductId());
		} else if (searchDto.getSortType() == 3) {
			productList = productRepository.findByIdAndAsc(searchDto.getSubProductId());
		} 
		}catch (Exception e) {
			productList=null;
		}
		ProductDetailsDto productDetailsDto = optionalSub.get().convertToProductDetailsDto();
		productDetailsDto.setProductList(productList != null
						? productList.stream().map(e -> e.convertToProductDto()).collect(Collectors.toList())
						: null);
		return productDetailsDto;
	}

}
