package com.oneflow.interview.ordermanagement.validation;

import com.oneflow.interview.ordermanagement.constant.ValidationConstants;
import com.oneflow.interview.ordermanagement.exception.BadRequestException;
import com.oneflow.interview.ordermanagement.exception.ContentNotFoundException;
import com.oneflow.interview.ordermanagement.exception.ProductAlreadyExistException;
import com.oneflow.interview.ordermanagement.exception.StockNotEnoughException;
import com.oneflow.interview.ordermanagement.model.dto.request.ProductCreateRequest;
import com.oneflow.interview.ordermanagement.model.entity.Product;
import com.oneflow.interview.ordermanagement.repository.ProductRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Optional;

/**
 * @author - ahmet
 */

@Component
public class ProductValidationImpl implements ProductValidation {

    private static final Logger log = LogManager.getLogger(ProductValidationImpl.class);
    private ProductRepository productRepository;

    @Autowired
    public ProductValidationImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public void validateProductSave(ProductCreateRequest productCreateRequest) {
        if(!Optional.ofNullable(productCreateRequest.getProductName()).isPresent()){
            log.error("Product Name is Null " );
            throw  new BadRequestException(ValidationConstants.PRODUCT_REQUEST_ERROR);
        }
        if(!Optional.ofNullable(productCreateRequest.getStockCount()).isPresent()){
            log.error("Product Count is Null " );
            throw  new BadRequestException(ValidationConstants.PRODUCT_REQUEST_ERROR);
        }

    }

    @Override
    public void validateProductIdExist(Long productId) {
        if(Objects.nonNull(productRepository.findByProductId(productId))){
            log.error(ValidationConstants.PRODUCT_ID_ALREADY_EXIST + "for {productId Id : } " + productId);
            throw new ProductAlreadyExistException(ValidationConstants.PRODUCT_ID_ALREADY_EXIST);
        }
    }

    @Override
    public void validateProductStockCount(Product product) {
        if(product.getStockCount() < 1 )
            throw new StockNotEnoughException(ValidationConstants.PRODUCT_STOCK_NOT_ENOUGH);
    }

    @Override
    public void validateProductExist(Product product) {
        if(Objects.isNull(product)) {
            throw new ContentNotFoundException(ValidationConstants.PRODUCT_NOT_FOUND);
        }
    }
}
