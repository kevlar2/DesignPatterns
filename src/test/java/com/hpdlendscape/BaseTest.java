package com.hpdlendscape;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

public class BaseTest {

    public WebDriver initializeDriver() {

        System.setProperty("webdriver.edge.driver", "E:\\WebDrivers\\msedgedriver.exe");
        WebDriver driver = new EdgeDriver();
        driver.manage().window().maximize();

        return driver;
    }

    public List<HashMap<String, String>> getJsonData(String jsonFilePath) throws IOException {

        // Convert json file to string
        String jsonContent = FileUtils.readFileToString(new File(jsonFilePath), StandardCharsets.UTF_8);

        ObjectMapper mapper = new ObjectMapper();

        List<HashMap<String, String>> getData = mapper.readValue(jsonContent,new TypeReference<List<HashMap<String, String>>>(){});

        return getData;
    }

}
