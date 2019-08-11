package com.anahoret.todolist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@SpringBootApplication
class TodoListApplication

fun main() {
    runApplication<TodoListApplication>()
}

@RestController
class TodoController {

    @GetMapping("/todos")
    fun getTodos(): List<Todo> {
        return listOf(Todo("One"), Todo("Two"))
    }

}

data class Todo(val text: String)
