package com.example.codilitytest.repository

import com.example.codilitytest.api.ApiService
import com.example.codilitytest.model.DataModel
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.MockitoAnnotations

class DetailRepositoryTest {

    @Mock
    private lateinit var mockApiService: ApiService

    private lateinit var mainRepository: MainRepository

    @Before
    fun setup() {
        MockitoAnnotations.initMocks(this)
        mainRepository = MainRepository(mockApiService)
    }

    @Test
    fun fetchDetailData_success() {
        // Mock response data
        val mockData = listOf(
            DataModel(1, "Item 1"),
            DataModel(2, "Item 2")
        )

        // Mock ApiService response
        runBlocking {
            `when`(mockApiService.getDetailData()).thenReturn(mockData)
            val result = mainRepository.fetchDetailData()
            assertEquals(mockData, result)
        }
    }

    @Test(expected = Exception::class)
    fun fetchDetailData_error() {
        // Mock ApiService throwing an exception
        runBlocking {
            `when`(mockApiService.getDetailData()).thenThrow(Exception("API Error"))
            mainRepository.fetchDetailData()
        }
    }
}
