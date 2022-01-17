package com.example.wordsapp

import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.navigation.Navigation
import androidx.navigation.testing.TestNavHostController
import androidx.recyclerview.widget.RecyclerView
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import com.example.wordsapp.MainActivity
import com.example.wordsapp.R
import org.junit.Assert.assertEquals
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

    /* Test RecyclerView navigation through Activities not valid anymore */
    @Test
    fun navigate_to_word_by_position(){
        /* Click on letter C - position 2 (index 0) */
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(25, click()))
        onView(withText("Words That Start With Z"))
            .check(matches(isDisplayed()))
    }


    @Test
    fun navigate_to_words_nav_component(){
        /* Setup:
        *  1. Create a test instance of the navigation controller.
        *  2. Isolate fragment for testing. Theme has to be passed so that the UI components know which theme to use.
        *  3. Declare which navigation graph will the nav controller use for the fragment.
        */
        val navController = TestNavHostController(ApplicationProvider.getApplicationContext())
        val letterListScenario = launchFragmentInContainer<LetterListFragment>(themeResId = R.style.Theme_Words)
        letterListScenario.onFragment { fragment ->
            navController.setGraph(R.navigation.nav_graph)
            Navigation.setViewNavController(fragment.requireView(), navController)
        }

        /* Trigger event that prompts the navigation */
        onView(withId(R.id.recycler_view))
            .perform(RecyclerViewActions
                .actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        assertEquals(navController.currentDestination?.id,R.id.wordListFragment)
    }
}