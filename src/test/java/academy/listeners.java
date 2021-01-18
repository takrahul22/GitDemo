package academy;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import resources.base;

	public class listeners implements ITestListener {
		
		//using implements means we are using Interface ITestListener
		//Interface has methods without body
		//listeners is a class that implements ITestListener
		
   base b = new base();  //so that we can get all the methods from base class
		public void onTestStart(ITestResult result) {
			// TODO Auto-generated method stub
		
		}

		public void onTestSuccess(ITestResult result) {
			// TODO Auto-generated method stub
		
		}

		public void onTestFailure(ITestResult result) {
			// TODO Auto-generated method stub
			//result.getName(); //This result argument will display the name of test case that got failed
			try {
				b.getscreenshot(result.getName());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		public void onTestSkipped(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
			// TODO Auto-generated method stub
			
		}

		public void onTestFailedWithTimeout(ITestResult result) {
			// TODO Auto-generated method stub
		
		}

		public void onStart(ITestContext context) {
			// TODO Auto-generated method stub
		
		}

		public void onFinish(ITestContext context) {
			// TODO Auto-generated method stub
		
		}

		@Override
		public int hashCode() {
			// TODO Auto-generated method stub
			return super.hashCode();
		}

		@Override
		public boolean equals(Object obj) {
			// TODO Auto-generated method stub
			return super.equals(obj);
		}

		@Override
		protected Object clone() throws CloneNotSupportedException {
			// TODO Auto-generated method stub
			return super.clone();
		}

		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return super.toString();
		}

		@Override
		protected void finalize() throws Throwable {
			// TODO Auto-generated method stub
			super.finalize();
		}
		
		
	}
	
	
	


