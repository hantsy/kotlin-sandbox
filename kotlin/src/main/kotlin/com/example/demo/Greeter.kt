package com.example.demo

class Greeter(private val greeting: Greeting) {
    fun sayHello(name:String):String = "Hello, ${greeting.hello(name)}"
}