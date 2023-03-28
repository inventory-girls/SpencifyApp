package com.example.newspencify.expenses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.ui.Model


@Controller
class ExpenseController {
    @Autowired
    private lateinit var service: ExpenseService

    @GetMapping("/getAllExpenses")
    fun showExpenseList(model: Model): String {
        val listExpenses = service.listAll()
        model.addAttribute("listExpenses", listExpenses)
        return "expenses"
    }
}

//This is a Kotlin class called ExpenseController.
// It is annotated with @Controller, which means that it is a Spring MVC controller that handles HTTP requests.

//The class has a member variable called service, which is an instance of ExpenseService.
// This variable is annotated with @Autowired,
// which means that Spring will automatically inject an instance of ExpenseService into the controller when it is created.

//The class has a single method called showExpenseList,
// which is annotated with @GetMapping. This means that the method will handle HTTP GET requests to the /getAllExpenses URL.
// The method takes a Model object as a parameter, which is used to add data to the view.

//Inside the method, the service variable is used to retrieve a list of all expenses from the database.
// The list is then added to the Model object using the key "listExpenses".
// Finally, the method returns the name of a view template called "expenses", which will be used to render the HTML response.
