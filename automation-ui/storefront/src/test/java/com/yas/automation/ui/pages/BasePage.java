package com.yas.automation.ui.pages;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

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
}
