package bases;

import com.company.Utils.TestListener;
import com.company.drivers.DriverManager;
import org.testng.annotations.*;

@Listeners({TestListener.class})
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
