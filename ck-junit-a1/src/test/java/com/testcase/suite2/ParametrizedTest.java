package com.testcase.suite2;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * @Classname ParametrizedTest
 * @Description 标准化用例中的参数化:valueSource, EnumSource, MethodSource, CsvSource，CsvFileSource, ArgumentsSource
 */
@DisplayName("标准化用例参数化")
public class ParametrizedTest {

	public static final String THE_STR = "hello";

	// 1. @parametrizedTest表示带参数化的测试，单个参数为基础类型的数据
	@ParameterizedTest
	@ValueSource(ints={1, 2, 3})
	void testWithValueSource(int argument){
		assertTrue(argument > 0 && argument < 4);
	}

	// 1. @parametrizedTest，单个参数，类型为：String的情况；
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = {"hello1", "hello2", "hello3", "", " ", "\t", "\n"})
	void testStringValueSource(String argument){
		System.out.println(argument);
		assertTrue(argument.length() > 0);
	}
}
