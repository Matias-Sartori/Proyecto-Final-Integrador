package com.curso.android.app.practica.counter.view

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.curso.android.app.sartorimatias.proyectofinalintegrador.R
import com.curso.android.app.sartorimatias.proyectofinalintegrador.view.MainActivity
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun mainActivity_compareTextsWithSameValue() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text1)
        ).perform(
            ViewActions.typeText("123")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text2)
        ).perform(
            ViewActions.typeText("123")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Ambas cadenas de caracteres son iguales")
            )
        )
    }

    @Test
    fun mainActivity_compareTextsWithDifferentValue() {
        Espresso.onView(
            ViewMatchers.withId(R.id.text1)
        ).perform(
            ViewActions.typeText("123")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text2)
        ).perform(
            ViewActions.typeText("456")
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.compareButton)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Las cadenas de caracteres no son iguales")
            )
        )
    }
}