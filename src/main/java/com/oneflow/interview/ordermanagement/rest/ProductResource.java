package com.oneflow.interview.ordermanagement.rest;

import com.oneflow.interview.ordermanagement.model.dto.request.ProductCreateRequest;
import com.oneflow.interview.ordermanagement.model.dto.response.ProductResponse;
import com.oneflow.interview.ordermanagement.model.entity.Product;
import com.oneflow.interview.ordermanagement.service.ProductService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.MvcUriComponentsBuilder;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author - ahmet
 */

@RestController
@RequestMapping("/product")
public class ProductResource {

    private static final Logger log = LogManager.getLogger(ProductResource.class);

    private final ProductService productService;

    @Autowired
    public ProductResource(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping(value = "/find/{id}" , produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<ProductResponse> getProductById(@PathVariable("id") final Long productId) {
        return ResponseEntity.ok(productService.getProductById(productId));
    }

    @GetMapping(value = "/list" , produces = APPLICATION_JSON_VALUE)
    @ResponseBody
    public ResponseEntity<List<Product>> getAllProducts() {
        return ResponseEntity.ok(productService.findAll());
    }


    @PostMapping(value = "/{id}/save")
    @ResponseBody
    public ResponseEntity<ProductResponse> saveProduct(@PathVariable("id") final Long productId,
                                                       @RequestBody final ProductCreateRequest productCreateRequest) {
        log.info("Incoming request and values : ", productCreateRequest.getProductName()," stock count: " , productCreateRequest.getStockCount());
        return getProductSaveResponse(productId, productCreateRequest);
    }
    /**
     * Helper method which holds common operations
     *@param productCreateRequest Request which holds
     *@param productId      ID for the operation
     * @return {@link ProductResponse ProductSaveResponse} holds status of the result and content which send to server
     */
    private ResponseEntity<ProductResponse> getProductSaveResponse(Long productId, ProductCreateRequest productCreateRequest) {
        Product product = productService.save(productId, productCreateRequest);
        ProductResponse productResponse = new ProductResponse(product.getProductId(),product.getProductName(),product.getStockCount());
        final URI uri =
                MvcUriComponentsBuilder.fromController(getClass())
                        .path("/{id}/save")
                        .buildAndExpand(productResponse.getProductId())
                        .toUri();
        return ResponseEntity.created(uri).body(productResponse);
    }



}
