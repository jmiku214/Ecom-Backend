package com.ecom.app.service;

import java.util.List;

import com.ecom.app.dto.ParentProductDto;
import com.ecom.app.model.ParentProduct;

public interface ParentProductService {

	List<ParentProductDto> getAllParentProduct();

	ParentProduct saveParentProduct(ParentProductDto parentProduct);

}
