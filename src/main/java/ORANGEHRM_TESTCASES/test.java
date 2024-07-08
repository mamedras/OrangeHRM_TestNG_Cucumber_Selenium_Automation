package ORANGEHRM_TESTCASES;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.config.Configurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class test {
    public static Logger log = LogManager.getLogger(test.class.getName());

    public static void main(String[] args) {
        Configurator.setLevel("java", Level.DEBUG);
        Configurator.setRootLevel(Level.DEBUG);
        log.debug("Setting chrome driver property");
        log.info("Window Maximized");
        log.debug("Now hitting Amazon server");
        log.info("Landed on amazon home page");
        log.debug("Getting the frames count");
        log.info("Frames count retreived");
        log.debug("Identifying Draggable objects");
        log.info("Drag and drop success");
    }
}
