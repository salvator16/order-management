package com.oneflow.interview.ordermanagement.resource;

import com.oneflow.interview.ordermanagement.model.dto.request.OrderCreateRequest;
import com.oneflow.interview.ordermanagement.model.dto.request.ProductCreateRequest;
import com.oneflow.interview.ordermanagement.model.dto.response.OrderResponse;
import com.oneflow.interview.ordermanagement.model.dto.response.ProductResponse;
import com.oneflow.interview.ordermanagement.model.entity.Order;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.ResultMatcher;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

/**
 * @author - ahmet
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class OrderRestTest extends AbstractRestTest {

    public static String ORDER_SAVE_URI = "/order/save";
    public static String ORDER_FIND_BY_USERNAME_URI = "/order/find/%s";

    private OrderCreateRequest orderCreateRequest;
    private ProductCreateRequest productCreateRequest;

    ResultMatcher created = MockMvcResultMatchers.status().isCreated();
    ResultMatcher statusOk = MockMvcResultMatchers.status().isOk();


    @Test
    public void saveOrderTest() throws Exception {
        OrderResponse response = doPostAndReturn(String.format(ORDER_SAVE_URI), orderCreateRequest,
                created, OrderResponse.class);
        assertEquals("Order is as expected", "Ahmet", response.getUsername());

        ProductResponse product = doGetAndReturn(String.format(ProductRestTest.PRODUCT_FIND_URI, 5), ProductResponse.class);
        assertEquals("Order Successfull", new Integer(498), product.getStockCount());
    }

    @Test
    public void findOrderByUsernameTest() throws Exception {
        doPostAndReturn(String.format(ProductRestTest.PRODUCT_SAVE_URI, 5), productCreateRequest,
                created, ProductResponse.class);

        doPostAndReturn(String.format(ORDER_SAVE_URI), orderCreateRequest,
                created, OrderResponse.class);

        List<Order> orderList = (List<Order>) doGetAndReturnList(String.format(ORDER_FIND_BY_USERNAME_URI, "Ahmet"), statusOk, Order.class);
        assertNotEquals("Order found", orderList.size() > 0);

    }


    @Before
    public void setUp() {
        productCreateRequest = new ProductCreateRequest("Tobacco", 500);
        orderCreateRequest = new OrderCreateRequest();
        orderCreateRequest.setProductId(5L);
        orderCreateRequest.setAddress("Istanbul/TURKEY");
        orderCreateRequest.setUsername("Ahmet");
    }


}
