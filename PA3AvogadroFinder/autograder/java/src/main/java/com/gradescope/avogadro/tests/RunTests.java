package com.gradescope.avogadro.tests;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

import com.gradescope.avogadro.tests.test_beadtracker;
import com.gradescope.avogadro.tests.test_blobfinder;
import com.gradescope.jh61b.grader.GradedTestListenerJSON;

@RunWith(Suite.class)
@Suite.SuiteClasses({
	test_blobfinder.class,
            test_beadtracker.class,
	    test_avogadro.class,
            })

public class RunTests {
    public static void main(String[] args) {

        JUnitCore runner = new JUnitCore();
        runner.addListener(new GradedTestListenerJSON());

        Result r = runner.run(RunTests.class);
    }
}
