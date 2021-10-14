package com.testcase.sutie;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.HashMap;

/**
 * @Classname LoginTest
 * @Description junit5中的@nested测试
 */
public class LoginTest {

	private HashMap<String,Object> dataMap = new HashMap<>();

	@Test
	void loginTest(){
		System.out.println("登录成功后，获取到token信息！");
		dataMap.put("token", true);
	}

	@Nested
	class BuyTest{
		@Test
		void buyTest(){
			if(dataMap.get("token").equals(true)){
				System.out.println("login success, you can start shopping !");
			}
		}
	}
}
