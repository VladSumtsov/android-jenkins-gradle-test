package com.example.exampleapp.test;

import android.test.ActivityInstrumentationTestCase2;

import com.example.exampleapp.MainActivity;
import com.jayway.android.robotium.solo.Solo;

/**
 * Created by jschamburger on 21.02.14.
 */
public class ExampleRobotiumTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private Solo solo;

    public ExampleRobotiumTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        solo = new Solo(getInstrumentation(), getActivity());
    }

    public void testActivity() {
        solo.assertCurrentActivity("Main Activity", MainActivity.class);

    }
}
