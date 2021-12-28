package com.example.wordsapp

import androidx.recyclerview.widget.RecyclerView
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.wordsapp.MainActivity
import com.example.wordsapp.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class NavigationTests {
    /* Make an activity scenario rule for the main activity. */
    @get:Rule
    val activity = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun navigate_to_word_by_letter(){
        /* Click on letter C */
        onView(withText("C"))
            .perform(click())
        onView(withText("Words That Start With C"))
            .check(matches(isDisplayed()))
    }
    
    @Test
    fun navigate_to_word_by_position(){
        /* Click on letter C - position 2 (index 0) */
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(25, click()))
        onView(withText("Words That Start With Z"))
            .check(matches(isDisplayed()))
    }
}