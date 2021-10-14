package com.testcase.suite2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

/**
 * @Classname LogoutTest
 * @Description TODO
 * @Date 2021/10/14 20:28
 * @Created by qingwei.han
 */
@DisplayName(value = "测试退出功能")
public class LogoutTest {

	@Test
	@DisplayName(value = "logout test-1")
	public void testLogout(){
		System.out.println("logout successfully !");
	}

	@Test
	@DisplayName(value = "logout test-2")
	@Tag("two")
	public void testLogout2(){
		System.out.println("logout successfully 2!");
	}
}
