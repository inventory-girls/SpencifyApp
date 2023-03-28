package com.example.newspencify.expenses

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service


@Service
class ExpenseService {
    @Autowired
    private lateinit var repo: ExpenseRepository

    fun listAll(): MutableIterable<Expenses> {
        return repo.findAll()
    }
}

//This is a Kotlin code snippet for an ExpenseService class that defines a method to retrieve all expenses using Spring Data JPA. The class is marked with the @Service annotation, which tells Spring that this class is a service and should be managed by the Spring container.

//The @Autowired annotation is used to inject an instance of the ExpenseRepository into the repo field.
// This is a common approach in Spring to avoid creating and managing instances of dependencies manually.
//The listAll method returns a MutableIterable of Expenses.
// This method simply calls the findAll method of the repo object,
// which retrieves all instances of the Expenses entity from the database.

//Overall, this class provides a simple way to retrieve all expenses from the database and can be used by other classes
// or controllers in the application.
