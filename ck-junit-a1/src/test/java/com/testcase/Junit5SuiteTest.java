package com.testcase;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

/**
 * @Classname Junit5SuiteTest
 * @Description TODO
 */

@RunWith(JUnitPlatform.class)
@SelectPackages({"com.testcase.sutie"})
//@IncludePackages({"com.testcase.sutie", "com.testcase.suite2"})
//@IncludeTags(value = {"two"})
public class Junit5SuiteTest {

}
