package com.testcase.sutie;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @Classname LoginTest
 * @Description junit5中的@nested测试
 */
@DisplayName(value = "测试登录功能")
public class LoginTest {

	private static HashMap<String,String> dataMap = new HashMap<>();

	@Test
	@DisplayName("登录获取token")
	void loginTest(){
		System.out.println("登录成功后，获取到token信息！");
		LoginTest.dataMap.put("token", "123");
	}

	@Nested
	class BuyTest{

		@Test
		@DisplayName("测试购物")
		void buyTest(){
			if(dataMap.get("token").equals("123")){
				System.out.println("login success, you can start shopping !");
			}else{
				System.out.println("login failure, you need login again !");
			}
		}
	}
}
