package com.support.android.designlibdemo;

import android.support.test.espresso.contrib.RecyclerViewActions;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.test.suitebuilder.annotation.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isCompletelyDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.allOf;

/**
 * Created by rambabuvallapuri on 19/04/2018.
 */


@LargeTest
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> mActivityTestRule = new ActivityTestRule<>(MainActivity.class);

    @Test
    public void testThreeCategoriesDisplayed() {
        onView(withText("Category 1")).check(matches(isCompletelyDisplayed()));
        onView(withText("Category 2")).check(matches(isCompletelyDisplayed()));
        onView(withText("Category 3")).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void testTitleAndDescriptionsDisplayed() throws InterruptedException {
        onView(allOf(withId(R.id.recyclerview), isDisplayed())).perform(RecyclerViewActions.actionOnItemAtPosition(0, click()));
        onView(withText("Info")).check(matches(isCompletelyDisplayed()));
        onView(withText("Friends")).check(matches(isCompletelyDisplayed()));
    }

    @Test
    public void testChangeToNightMode() throws InterruptedException {
        onView(withContentDescription("More options")).perform(click());
        onView(withText("Night mode")).perform(click());
        onView(withText("Night (always)")).perform(click());
    }
}
