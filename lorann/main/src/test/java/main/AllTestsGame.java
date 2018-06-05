package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({controller.AllTests.class, main.AllTests.class, model.dao.AllTestsModel.class})
public class AllTestsGame {

}
