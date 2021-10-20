package com.testcase.sutie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Random;

/**
 * @Classname LoginTest
 * @Description junit5中的@nested测试，其中@Nested的规律：从下往上执行。
 */
@DisplayName(value = "测试登录功能")
public class LoginTest {

	private static HashMap<String, Integer> dataMap = new HashMap<>();

	@Test
	@DisplayName("1、登录获取token")
	void loginTest(){
		System.out.println("登录成功后，获取到token信息！");
		LoginTest.dataMap.put("token", new Random().nextInt());
	}


	@Nested
	@DisplayName("3、测试支付")
	class PayTest{
		@DisplayName("测试支付")
		@Test
		public void payTest(){
			if(null != dataMap.get("customer")){
				System.out.println("购物车加入成功，进行支付。");
			}else {
				System.out.println("没登录，就无法购物");
			}
		}
	}

	@Nested
	@DisplayName("2、测试商品加入购物车")
	class BuyTest{

		@Test
		@DisplayName("测试购物")
		void buyTest(){
			if(dataMap.get("token") != null){
				System.out.println("login success, Start shopping !");
				LoginTest.dataMap.put("customer", null);
			}else{
				System.out.println("login failure, please login again !");
			}
		}
	}
}
