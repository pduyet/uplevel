package bases;

import com.company.drivers.DriverManager;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class BaseTest {

    @BeforeMethod(alwaysRun = true)
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browser) throws Exception {
        DriverManager.getLocalDriver(browser);
    }

    @AfterMethod(alwaysRun = true)
    public void quitDriver() throws Exception {
        DriverManager.quitDriver();
    }
}
