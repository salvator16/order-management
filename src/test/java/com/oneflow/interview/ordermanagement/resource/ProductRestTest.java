package com.oneflow.interview.ordermanagement.resource;

import com.oneflow.interview.ordermanagement.model.dto.request.ProductCreateRequest;
import com.oneflow.interview.ordermanagement.model.dto.response.ProductResponse;
import com.oneflow.interview.ordermanagement.model.entity.Product;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author - ahmet
 */

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ProductRestTest extends AbstractRestTest {

    private Long productId;
    private ProductCreateRequest productCreateRequest;

    public static String PRODUCT_SAVE_URI = "/product/%s/save";
    public static String PRODUCT_FIND_URI = "/product/find/%s";

    ResultMatcher created = MockMvcResultMatchers.status().isCreated();

    @Test
    public void saveProductTest() throws Exception {
        ProductResponse response = doPostAndReturn(String.format(PRODUCT_SAVE_URI, productId), productCreateRequest,
                created, ProductResponse.class);
        ProductResponse originalResponse = createResponse();
        assertEquals("Product save worked as supposed to be", response, originalResponse);
    }

    @Test
    public void findProductTest() throws Exception {

        doPostAndReturn(String.format(PRODUCT_SAVE_URI, 2), productCreateRequest,
                created, ProductResponse.class);
        doPostAndReturn(String.format(PRODUCT_SAVE_URI, 3), productCreateRequest,
                created, ProductResponse.class);

        ProductResponse product1 = doGetAndReturn(String.format(PRODUCT_FIND_URI, 2), ProductResponse.class);
        ProductResponse product2 = doGetAndReturn(String.format(PRODUCT_FIND_URI, 3), ProductResponse.class);
        assertNotEquals("Product found", product1.getProductId() == 2L);
        assertNotEquals("Product found", product2.getProductId() == 3L);

    }

    @Before
    public void setUp() {
        productCreateRequest = new ProductCreateRequest();
        productCreateRequest.setProductName("Tobacco");
        productCreateRequest.setStockCount(500);
        productId = 1L;
    }

    private ProductResponse createResponse() {
        return new ProductResponse(productId, productCreateRequest.getProductName(), productCreateRequest.getStockCount());
    }

}


