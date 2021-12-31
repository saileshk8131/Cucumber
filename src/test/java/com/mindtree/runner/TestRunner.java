package com.mindtree.runner;

import org.junit.runner.RunWith;
import org.testng.annotations.Listeners;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.junit.Cucumber;

@RunWith(Cucumber.class)

@CucumberOptions(features = { "src\\test\\resources" }, glue = { "com.mindtree.stepDefinition" },tags= "@tag1,@tag2" )

@Listeners({com.mindtree.utility.Listener.class,com.mindtree.utility.SuiteListener.class})
public class TestRunner extends AbstractTestNGCucumberTests{

}
