import kotlin.browser.document
import react.dom.render
import react.*

class App : RComponent<RProps, RState>() {
    override fun RBuilder.render() {
        +"Hello World!"
    }
}

fun RBuilder.app() = child(App::class) {}

fun main() {
    document.getElementById("react-app")?.let {
        render(it) {
            app()
        }
    } ?: console.log("No #react-app element found")
}
