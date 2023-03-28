package com.example.newspencify

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping


@Controller
class MainController {
    @GetMapping("/")
    fun getAllExpenses(): String {
        return ("Index")
    }
}

//This is a Kotlin code snippet for a Spring MVC controller class that maps the root URL / to a method getAllExpenses.
// The class is marked with the @Controller annotation,
// which tells Spring that this class is a controller and should be managed by the Spring container.

//The @GetMapping annotation is used to map the root URL / to the getAllExpenses method.
// When a request is made to the root URL, this method is executed.

//The getAllExpenses method returns a string "Index", which is the name of the view that should be rendered when this
// method is executed. This could be the name of an HTML template file or a JSP file that contains the markup for the page.

//Overall, this class provides a simple way to map the root URL to a controller method and return a view to the user.
// Other methods can be added to this class to handle other URLs and requests as needed.