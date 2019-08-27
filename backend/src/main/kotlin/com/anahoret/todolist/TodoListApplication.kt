package com.anahoret.todolist

import kotlinx.html.*
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.RestController
import kotlinx.html.stream.appendHTML

@SpringBootApplication
class TodoListApplication

fun main() {
    runApplication<TodoListApplication>()
}

@RestController
class TodoController {

    @GetMapping("/api/todos")
    fun getTodos(): List<Todo> {
        return listOf(Todo("One"), Todo("Two"))
    }

}

@Controller
class IndexController {

    @GetMapping("", "/")
    @ResponseBody
    fun index(): String {
        return StringBuilder().appendHTML().html {
            body {
                div {
                    id = "react-app"
                }
                script(src = "mp-todolist-frontend.js") {}
            }
        }.toString()
    }

}

data class Todo(val text: String)
