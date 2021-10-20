package com.testcase.suite2;

import com.tcl.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Classname ParametrizedTest
 * @Description 标准化用例中的参数化:valueSource, EnumSource, MethodSource, CsvSource，CsvFileSource, ArgumentsSource
 */
@DisplayName("标准化用例参数化")
@Slf4j
public class ParametrizedTest {

	public static final String THE_STR = "hello";

	// 1. @parametrizedTest表示带参数化的测试，单个参数为基础类型的数据
	@ParameterizedTest
	@ValueSource(ints={1, 2, 3, 4})
	void testWithValueSource(int argument){
		assertTrue(argument > 0 && argument < 5);
	}

	// 2. @parametrizedTest，单个参数，类型为：空字符串的情况；
	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = {"", "\b", " ", "\t", "\n"})
	void testStringValueSource(String argument){
		System.out.println(argument);
		assertTrue(argument == null || argument.trim().isEmpty());
	}

	// @MethodSource
	public static Person[] personSource(){
		Person p1 = new Person();
		p1.setId(100);
		p1.setName("summer");
		Person p2 = new Person();
		p2.setId(200);
		p2.setName("winter");
		Person p3 = new Person();
		p3.setId(300);
		p3.setName("John");
		return new Person[]{p1, p2, p3};
	}

	@ParameterizedTest
	@MethodSource(value = "personSource")
	void nameLenGreater4(Person person){
		assertTrue(person.getName().length() > 4);

	}

	static Stream<Arguments> stringIntAndListProvider(){
		return Stream.of(
				Arguments.arguments("apple", 1, Arrays.asList("a", "b", "c")),
				Arguments.arguments("lemon", 2, Arrays.asList("s", "t", "u")),
				Arguments.arguments("paris", 3, Arrays.asList("x", "y", "z"))

		);
	}

	@ParameterizedTest
	@MethodSource(value = "stringIntAndListProvider")
	void testWithMultiArgMethodSource(String str, int num, List<String> list){
		assertEquals(5, str.length());
		assertTrue(num >= 1);
		assertEquals(3, list.size());

	}


	// csv格式的参数化
	@ParameterizedTest
	@CsvSource(value = {"apple, 100",
						"banana, 200",
						"strawberry, 300"}, delimiterString = ",")
	void testWithCsvPresent(String fruitName, int fruitPrice){
		log.info("Fruit: {}, FruitPrice: {}", fruitName, fruitPrice);
		assertNotNull(fruitName);
		assertNotEquals(0, fruitPrice);
	}

}
