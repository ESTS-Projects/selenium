package est.systems_si.selenium;

import java.util.Random;

public class Config {
    static final int timeout = 200;
    static final int pause = 10000;
    static final String password = "my_password";
    static final String lastName = "my_last_name";
    static final String phoneNumber = "0656895632";
    static final String firstName = "my_first_name";
    static final String Url = "http://www.tutorialsninja.com/demo";
    static final String email = "my_email_" + Integer.toString(new Random().nextInt(1000)) + "@gmail.com";
    static final String driverType = "edge";
    static final String driverPath = "C:\\Users\\EOussama\\Documents\\études\\modules\\management des sI\\tps\\selenium\\drivers\\msedgedriver.exe";
}
