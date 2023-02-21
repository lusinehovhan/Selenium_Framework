package ta.service;

import java.util.ResourceBundle;

public class TestDataReaderSingleton {
    private static TestDataReaderSingleton testDataReader = new TestDataReaderSingleton();

    private TestDataReaderSingleton() {
    }

    public static TestDataReaderSingleton getInstance() {
        return testDataReader;
    }

    private static ResourceBundle resourceBundle = ResourceBundle.getBundle(System.getProperty("environment"));

    public String getTestData(String key){

        return resourceBundle.getString(key);
    }
}
