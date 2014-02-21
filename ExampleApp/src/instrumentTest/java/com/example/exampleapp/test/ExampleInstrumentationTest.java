package com.example.exampleapp.test;

import android.test.ActivityInstrumentationTestCase2;
import android.test.suitebuilder.annotation.MediumTest;
import android.widget.Spinner;

import com.example.exampleapp.MainActivity;
import com.example.exampleapp.R;

import org.junit.Test;

public class ExampleInstrumentationTest extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public ExampleInstrumentationTest() {
        super(MainActivity.class);
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        mActivity = getActivity();

    }

    @MediumTest
    public void testMainActivity() {

        mActivity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                mActivity.getActionBar().setSelectedNavigationItem(1);
            }
        });

        // Stop the activity - The onDestroy() method should save the state of the Spinner
        mActivity.finish();

        // Re-start the Activity - the onResume() method should restore the state of the Spinner
        mActivity = getActivity();

        assertEquals(mActivity.getActionBar().getSelectedNavigationIndex(), 1);

    }
}
