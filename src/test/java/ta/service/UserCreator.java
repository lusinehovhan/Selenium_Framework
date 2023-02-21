package ta.service;

import ta.model.User;

public class UserCreator {

    public static final String TESTDATA_USER_NAME = "testdata.user.name";
    public static final String TESTDATA_USER_EMAIL = "testdata.user.email";
    public static final String TESTDATA_USER_PASSWORD = "testdata.user.password";
    public static final String TESTDATA_BROWSER ="chrome";

    public static User withCredentialsFromProperty(){
        return new User(TestDataReaderSingleton.getInstance().getTestData(TESTDATA_USER_NAME),
                TestDataReaderSingleton.getInstance().getTestData(TESTDATA_USER_EMAIL),
                TestDataReaderSingleton.getInstance().getTestData(TESTDATA_USER_PASSWORD));
    }
}
