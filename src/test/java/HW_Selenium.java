import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class HW_Selenium {
    WebDriver wd;
    @BeforeMethod
    public void preconditions()
    {
        wd = new ChromeDriver();
        wd.navigate().to("https://demoqa.com/text-box");
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void fillForm()
    {
        WebElement name = wd.findElement(By.id("userName"));
        WebElement email = wd.findElement(By.id("userEmail"));
        WebElement address = wd.findElement(By.id("currentAddress"));
        WebElement submitBtn = wd.findElement(By.id("submit"));
        WebElement output = wd.findElement(By.id("output"));

        fillField(name, "Persik");
        fillField(email, "Persik@gmail.com");
        fillField(address, "Tel aviv");

        submitBtn.click();
        String res = output.getText();
        System.out.println(res);

        Assert.assertEquals(res, "Name:Persik\n" +
                "Email:Persik@gmail.com\n" +
                "Current Address :Tel aviv");



    }
    public  void fillField(WebElement el, String text)
    {
        el.click();
        el.clear();
        el.sendKeys(text);
    }

}
