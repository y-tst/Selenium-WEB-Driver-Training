package service;

import model.User;

public class UserCreator {

    private static final String TESTDATA_USERNAME = "overdrive.testdata.username";
    private static final String TESTDATA_PASSWORD = "overdrive.testdata.password";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USERNAME), TestDataReader.getTestData(TESTDATA_PASSWORD));
    }
}