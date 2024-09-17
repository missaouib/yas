package com.yas.automation.ui.pages;

import lombok.Getter;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * BasePage provides common setup for web pages in the automation framework.
 *
 * <p>It includes:</p>
 * <ul>
 *   <li>WebDriver setup.</li>
 *   <li>WebDriverWait setup.</li>
 *   <li>Common utility methods.</li>
 * </ul>
 *
 * <p>Extend this class to use these features in your page classes.</p>
 */
@Getter
public class BasePage {

    private final WebDriver webDriver;
    private final WebDriverWait wait;

    public BasePage(WebDriver webDriver) {
        this.webDriver = webDriver;
        wait = new WebDriverWait(webDriver, Duration.ofSeconds(30));
    }

    public void wait(Duration duration) {
        try {
            Thread.sleep(duration);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void scrollDown() {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
        wait(Duration.ofSeconds(1));
    }

    public void scrollTo(WebElement webElement) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) webDriver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoView(true);", webElement);
        wait(Duration.ofSeconds(1));
    }

}
