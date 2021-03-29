import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class SimpleTask {
    WebDriver wd;
    @BeforeMethod
    public void preconditions()
    {
        wd = new ChromeDriver();
        wd.navigate().to("file:///C:/Users/shkod/Downloads/index.html#item4");
      //  wd.navigate().back();
      //  wd.navigate().refresh();
      //  wd.navigate().forward();
        wd.manage().window().maximize();
        wd.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }
    @Test
    public void fillForm()
    {
        //find el -> click -> clear -> send text
       WebElement name =  wd.findElement(By.name("name"));
       WebElement surename = wd.findElement(By.name("surename"));
       WebElement sendBtn = wd.findElement(By.tagName("button"));
       WebElement textBox = wd.findElement(By.className("message"));

    //   name.click();
     //  name.clear();
     //  name.sendKeys("Tom");
        fillField(name, "Tom");
        fillField(surename, "Ford");

        sendBtn.click();
        String res = textBox.getText();
        System.out.println(res);

        Assert.assertEquals(res, "Tom Ford");
     //   Assert.assertTrue(res.);


    }



    public void fillField(WebElement el, String text)
    {
        el.click();
        el.clear();
        el.sendKeys(text);

    }





    @Test
    public void selectItemTest()
    {
        WebElement item = wd.findElement(By.tagName("a"));
        item.click();
        String itemText = item.getText();
        System.out.println(itemText);

        WebElement textBox = wd.findElement(By.className("message"));
        String res = textBox.getText();
        System.out.println(res);

        Assert.assertTrue(res.contains(itemText));

    }
    @Test
    public void selectItemFromList()
    {
       List<WebElement> items =  wd.findElements(By.tagName("a"));
       System.out.println(items.size());

       WebElement item = items.get(2);
       item.click();
       String itemText = item.getText();
        System.out.println(itemText);

        WebElement textBox = wd.findElement(By.className("message"));
        String res = textBox.getText();
        System.out.println(res);

        Assert.assertTrue(res.contains(itemText));

    }
    @AfterMethod
    public void tearDown()
    {
      //  wd.quit();

    }


}
