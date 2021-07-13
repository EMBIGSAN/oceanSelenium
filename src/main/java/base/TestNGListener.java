package base;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestNGListener implements ITestListener {
    public WebDriver driver;
    Base base = new Base();

    @Override
    public void onTestStart(ITestResult result) {
        System.out.println(("*** Running test method " + result.getMethod().getMethodName() + "..."));
        String testname = result.getMethod().getMethodName();
        ExtentTestManager.startTest(testname);
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        ExtentTestManager.getTest().log(Status.PASS, "Test passed");

    }

    @Override
    public void onTestFailure(ITestResult result) {

//        //把base类里的driver对象传递过来这个类
//        this.driver = ((Base)result.getInstance()).driver;
//        //获取失败用例的用例名称 trim是去掉首尾空格
//        String testcaseName = result.getName().toString().trim();
//        //获取当前日期
//        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
//        //截图形成名称
//        String screenshotName = testcaseName + "_" +timeStamp;
//        //调用base类里面的截图方法
//        try {
//            base.takeScreenshot(screenshotName,driver);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
////
//        //extent report
//        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
//        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
//        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());
//
//        // 将失败截图附到Extent Report中
//        try {
////            String path = "D:/EMBIGSAN/ocean/oceanproject/Screenshots/"+screenshotName+".png";
//            String path2 = System.getProperty("user.dir")+"//Screenshots//"+screenshotName+".png";
//            ExtentTestManager.getTest().fail("Screenshot",
//                    MediaEntityBuilder.createScreenCaptureFromPath(path2).build());
//        } catch (IOException e) {
//            System.out.println(e.getCause());
//        }
//
//
//    }
        //获取driver实例，完成driver从base类到用例到TestNGListener的传递
        this.driver = ((Base)result.getInstance()).driver;

        //获取失败用例的名称
        String  testcasename = result.getName().toString().trim();

        //获取当期日期，并按指定格式保存为String类型
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

        //截图名称
        String screenshotname = testcasename+"_"+timeStamp;


        try {
            base.takeScreenshot(screenshotname, driver);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //extent report
        System.out.println("*** Test execution " + result.getMethod().getMethodName() + " failed...");
        ExtentTestManager.getTest().log(Status.FAIL, "Test Failed");
        ExtentTestManager.getTest().log(Status.FAIL, result.getThrowable());

        // 将失败截图附到Extent Report中
        String path = System.getProperty("user.dir")+"\\Screenshots\\"+screenshotname+".png";
//        System.out.println(path.replaceAll("\\\\","/"));
        try {
            ExtentTestManager.getTest().fail("Screenshot",
                    MediaEntityBuilder.createScreenCaptureFromPath(path).build());
        } catch (IOException e) {
            System.out.println(e.getCause());
        }


    }
    @Override
    public void onTestSkipped(ITestResult result) {

    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

    }

    @Override
    public void onTestFailedWithTimeout(ITestResult result) {

    }

    @Override
    public void onStart(ITestContext context) {

    }

    @Override
    public void onFinish(ITestContext context) {
        System.out.println(("*** Test Suite " + context.getName() + " ending ***"));
        ExtentTestManager.endTest();
    }
}
