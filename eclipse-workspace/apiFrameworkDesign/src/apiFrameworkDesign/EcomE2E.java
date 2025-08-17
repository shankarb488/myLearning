package apiFrameworkDesign;

import static io.restassured.RestAssured.given;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;
import pojo.AddProduct;
import pojo.LoginRequest;
import pojo.LoginResponse;
import pojo.Order;
import pojo.OrderDetails;
import pojo.OrderDetailsResponse;

public class EcomE2E {

	@Test
	public void submitOrder() {

		RequestSpecification ReqSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).build();

		LoginRequest loginRequest = new LoginRequest();
		loginRequest.setUserEmail("shankar.b@gmail.com");
		loginRequest.setUserPassword("123456Aa");

		RequestSpecification loginReqSpec = given().spec(ReqSpec).body(loginRequest);

		LoginResponse response = loginReqSpec.when().post("/api/ecom/auth/login").then().log().all().statusCode(200)
				.extract().response().as(LoginResponse.class);

		String token = response.getToken();
		String userId = response.getUserId();

		RequestSpecification addProductSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("Authorization", token).build();

		RequestSpecification addProductReq = given().spec(addProductSpec).param("productName", "qwerty")
				.param("productAddedBy", userId).param("productCategory", "fashion")
				.param("productSubCategory", "shirts").param("productPrice", 11500)
				.param("productDescription", "Addias Originals").param("productFor", "women").multiPart("productImage",
						new File("C:\\Users\\sbelavalakoni\\Downloads\\Screenshot 2025-08-06 104928.png"));

		AddProduct addProductResponse = addProductReq.when().post("/api/ecom/product/add-product").then().log().all()
				.statusCode(201).extract().response().as(AddProduct.class);

		String productID = addProductResponse.getProductId();
		// System.out.println(productID);

		// Create Order

		RequestSpecification createOrderSpec = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.setContentType(ContentType.JSON).addHeader("Authorization", token).build();

		OrderDetails orderDetail = new OrderDetails();
		orderDetail.setCountry("India");
		orderDetail.setProductOrderedId(productID);

		ArrayList<OrderDetails> orderDetailList = new ArrayList<OrderDetails>();
		orderDetailList.add(orderDetail);
		Order orders = new Order();
		orders.setOrders(orderDetailList);

		RequestSpecification createOrderReq = given().spec(createOrderSpec).body(orders);

		OrderDetailsResponse odr = createOrderReq.when().post("/api/ecom/order/create-order").then().statusCode(201)
				.extract().response().as(OrderDetailsResponse.class);

		List<String> productIDDetails = odr.getOrders();
		String pid = productIDDetails.get(0);

		// Verify Order

		RequestSpecification orderDetailsReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addQueryParam("id", pid).addHeader("Authorization", token).build();
		RequestSpecification orderDetailsRequest = given().log().all().spec(orderDetailsReq);
		String orderDetailsResponse = orderDetailsRequest.when().get("/api/ecom/order/get-orders-details").then().log()
				.all().statusCode(200).extract().response().asString();
		System.out.println(orderDetailsResponse);

		// Delete order
		RequestSpecification deleteProdBaseReq = new RequestSpecBuilder().setBaseUri("https://rahulshettyacademy.com")
				.addHeader("authorization", token).setContentType(ContentType.JSON).build();
		RequestSpecification deleteProdReq = given().log().all().spec(deleteProdBaseReq)
				.pathParam("productId",
				productID);

		String deleteProductResponse = deleteProdReq.when().delete("/api/ecom/product/delete-product/{productId}")
				.then().log().all().extract().response().asString();
		
		JsonPath js1 = new JsonPath(deleteProductResponse);

		Assert.assertEquals("Product Deleted Successfully",js1.get("message"));


	}

}
