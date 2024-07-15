package com.example.codilitytest.ui.feature

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Before
    fun setup() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    @Test
    fun detailScreen_displayedCorrectly() {
        // Check if a TextView with specific text is displayed
        Espresso.onView(ViewMatchers.withText("Detail data fetched"))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }

    // Add more UI tests as needed
}
