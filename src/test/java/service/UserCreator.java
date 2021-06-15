package service;

import Model.User;

public class UserCreator {

    public static final String TESTDATA_USERNAME = "overdrive.testdata.username";
    public static final String TESTDATA_PASSWORD = "overdrive.testdata.password";

    public static User withCredentialsFromProperty() {
        return new User(TestDataReader.getTestData(TESTDATA_USERNAME), TestDataReader.getTestData(TESTDATA_PASSWORD));
    }

    public static User withEmptyUsername() {
        return new User("", TestDataReader.getTestData(TESTDATA_PASSWORD));
    }

    public static User withEmptyPassword() {
        return new User(TestDataReader.getTestData(TESTDATA_USERNAME), "");
    }
}