package testcases;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenersTestNG implements ITestListener {
	public void onStart(ITestContext context) {
		System.out.println("-------------------------");
		System.out.println("onStart method started \n");
	}

	public void onFinish(ITestContext context) {
		System.out.println("onFinish method started");
		System.out.println("------------------------- \n");

	}

	public void onTestStart(ITestResult result) {
		System.out.println("-------");
		System.out.println("New Test Started " + result.getName()+"\n");
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("onTestSuccess Method " + result.getName()+"\n");
	}

	public void onTestFailure(ITestResult result) {
		System.out.println("onTestFailure Method " + result.getName()+"\n");
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("onTestSkipped Method " + result.getName()+"\n");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		System.out.println("onTestFailedButWithinSuccessPercentage " + result.getName()+"\n");
	}
}





















