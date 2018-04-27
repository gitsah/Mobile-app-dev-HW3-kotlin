package com.example.sahand.homework3;

import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.hamcrest.Matcher;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> rule =
            new ActivityTestRule<>(MainActivity.class, true, true);

    @Test
    public void notEighteen() {
        onView(withId(R.id.name_field)).perform(typeText("Steve L")).perform(closeSoftKeyboard());
        onView(withId(R.id.date_of_birth_field)).perform(typeText("02/10/2003")).perform(closeSoftKeyboard());
        onView(withId(R.id.username_field)).perform(typeText("SteveL")).perform(closeSoftKeyboard());
        onView(withId(R.id.occupation_field)).perform(typeText("Waiter")).perform(closeSoftKeyboard());
        onView(withId(R.id.description_field)).perform(typeText("I'm a pretty cool dude")).perform(closeSoftKeyboard());
        onView(withId(R.id.email_field)).perform(typeText("jackson@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());
        onView(withId(R.id.validation_text)).check(matches(withText(R.string.underEighteen)));
    }

    @Test
    public void unfilledFields() {
        onView(withId(R.id.date_of_birth_field)).perform(typeText("05/10/1967")).perform(closeSoftKeyboard());
        onView(withId(R.id.email_field)).perform(typeText("jjj@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());
        onView(withId(R.id.validation_text)).check(matches(withText(R.string.emptyFields)));
    }

    @Test
    public void to2ndPageAndBack() {
        onView(withId(R.id.name_field)).perform(typeText("John M")).perform(closeSoftKeyboard());
        onView(withId(R.id.date_of_birth_field)).perform(typeText("01/20/1989")).perform(closeSoftKeyboard());
        onView(withId(R.id.email_field)).perform(typeText("JohnD@gmail.com")).perform(closeSoftKeyboard());
        onView(withId(R.id.username_field)).perform(typeText("JohnM")).perform(closeSoftKeyboard());
        onView(withId(R.id.occupation_field)).perform(typeText("Carpenter")).perform(closeSoftKeyboard());
        onView(withId(R.id.description_field)).perform(typeText("I'm a pretty cool dude")).perform(closeSoftKeyboard());
        onView(withId(R.id.submit_button)).perform(click());
        onView(withId(R.id.back_button)).perform(click());
        onView(withId(R.id.name_field)).check(matches(withText("")));
    }
}