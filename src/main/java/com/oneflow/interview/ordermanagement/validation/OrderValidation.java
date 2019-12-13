package com.oneflow.interview.ordermanagement.validation;

import com.oneflow.interview.ordermanagement.model.dto.request.OrderCreateRequest;

/**
 * @author - ahmet
 */

public interface OrderValidation {

    void validateOrderSave(OrderCreateRequest orderCreateRequest);

}
