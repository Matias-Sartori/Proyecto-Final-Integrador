package com.curso.android.app.sartorimatias.proyectofinalintegrador

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.curso.android.app.sartorimatias.proyectofinalintegrador.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.After
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)
class MainViewModelUnitTest {

    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun mainViewModel_CheckInitialValue() = runTest {
        val value = viewModel.result.value?.text
        assertEquals("", value)
    }

    @Test
    fun mainViewModel_TestComparaTextsWithSameValue() = runTest {
        launch {
            val text1 = "123"
            val text2 = "123"
            viewModel.compareTexts(text1, text2)
        }
        advanceUntilIdle()
        val value = viewModel.result.value?.text
        assertEquals("Ambas cadenas de caracteres son iguales", value)
    }

    @Test
    fun mainViewModel_TestComparaTextsWithDifferentValue() = runTest {
        launch {
            val text1 = "123"
            val text2 = "456"
            viewModel.compareTexts(text1, text2)
        }
        advanceUntilIdle()
        val value = viewModel.result.value?.text
        assertEquals("Las cadenas de caracteres no son iguales", value)
    }
}