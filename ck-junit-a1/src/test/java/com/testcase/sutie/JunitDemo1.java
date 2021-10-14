package com.testcase.sutie;

import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.*;

/**
 * @Classname JunitDemo1
 * @Description TODO
 * @Date 2021/10/14 19:31
 * @Created by qingwei.han
 */

@DisplayName("junit5 演示类")
public class JunitDemo1 {

	//@beforeall:在所有的方法之前，运行;
	@BeforeAll
	public static void beforeAll(){
		System.out.println("Before ------");
	}


	//@afterall: 在所有的方法之后运行;
	@AfterAll
	public static void afterAll(){
		System.out.println("after ------");
	}

	@BeforeEach
	public void beforeEach(){
		System.out.println("Before each1111111111");
	}

	@AfterEach
	public void afterEach(){
		System.out.println("After each!222222222");
	}


	@Before
	public void before(){
		System.out.println("only before.........");
	}

	@After
	public void after(){
		System.out.println("only after---------------");
	}

	@Test
	@Disabled
	void fun1(){
		System.out.println("test 01");
	}

	@Test
	@DisplayName("fun2-B")
	@RepeatedTest(value = 3)
	void fun2(){
		System.out.println("test 02");
	}
}
