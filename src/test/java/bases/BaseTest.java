package bases;

import com.company.core.drivers.DriverManager;
import com.company.utils.TestListener;
import org.testng.annotations.*;

@Listeners({TestListener.class})
public class BaseTest {

    @BeforeClass(alwaysRun = true)
    @Parameters({"browser"})
    public void createDriver(@Optional("chrome") String browser) throws Exception {
        DriverManager.getLocalDriver(browser);
    }

    @AfterClass(alwaysRun = true)
    public void quitDriver() {
        DriverManager.quitDriver();
    }
}
