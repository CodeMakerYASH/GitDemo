package CreatingReport.ExtentReport;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class Retry implements IRetryAnalyzer {

	// if the test fails, it will come here and rerun
	
	int count = 0;
	int maxTry = 1;
	
	@Override
	public boolean retry(ITestResult result) {
		// TODO Auto-generated method stub
		
		if(count<maxTry)    // so if a test fails, we can rerun it once via this condition
		{
			count++;
			return true; // if true , the failed case will rerun once again until false is returned
		}
		
		return false;
	}

}
