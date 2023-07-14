package com.example.demo

import org.junit.jupiter.api.Test
import org.mockito.Mockito.*

class GreetingTest {

    @Test
    fun `mock Greeting interface`() {
        val greeting: Greeting = mock()
        val greeter = Greeter(greeting)

        `when`(greeting.hello(anyString())).thenReturn("World")

        greeter.sayHello("test")

        verify(greeting, times(1)).hello(anyString())
    }
}