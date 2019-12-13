package com.oneflow.interview.ordermanagement.validation;

import com.oneflow.interview.ordermanagement.constant.ValidationConstants;
import com.oneflow.interview.ordermanagement.exception.BadRequestException;
import com.oneflow.interview.ordermanagement.model.dto.request.OrderCreateRequest;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.Optional;

/**
 * @author - ahmet
 */

@Component
public class OrderValidationImpl implements OrderValidation {

    private static final Logger log = LogManager.getLogger(OrderValidationImpl.class);

    @Override
    public void validateOrderSave(OrderCreateRequest orderCreateRequest) {
        if(!Optional.ofNullable(orderCreateRequest.getUsername()).isPresent()){
            log.error("Username can not be null " );
            throw  new BadRequestException(ValidationConstants.ORDER_REQUEST_ERROR);
        }
        if(!Optional.ofNullable(orderCreateRequest.getAddress()).isPresent()){
            log.error("Address can not be null " );
            throw  new BadRequestException(ValidationConstants.ORDER_REQUEST_ERROR);
        }
    }
}
