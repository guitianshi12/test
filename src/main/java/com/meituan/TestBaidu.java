package main.java.com.meituan;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by Administrator on 2017/11/19 0019.
 */
public class TestBaidu {
    WebDriver webDriver;
    @Test
    public void login(){

    webDriver = new InternetExplorerDriver();
    webDriver.get("http://mail.126.com/");
    try{

    Thread.sleep(1000);
    webDriver.switchTo().frame("x-URS-iframe");
    WebElement webElement = webDriver.findElement(By.name("email"));
    webElement.clear();
    webElement.sendKeys("jd_liuk");
    webDriver.findElement(By.name("password")).sendKeys("1qaz2wsx3edc");
    webDriver.findElement(By.id("dologin")).click();
    Thread.sleep(1000);
    webDriver.findElement(By.linkText("继续登录")).click();
    Thread.sleep(1000);
    webDriver.switchTo().parentFrame();
    String s = webDriver.findElement(By.linkText("退出")).getText();
    System.out.println("----------------"+s);
    Assert.assertEquals(s,"退出");

    }catch (Exception e){
        e.printStackTrace();
    }finally {
        webDriver.quit();
    }
    }
}
