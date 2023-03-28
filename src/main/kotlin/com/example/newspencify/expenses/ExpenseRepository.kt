package com.example.newspencify.expenses

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import java.util.*

//interface expenseRepository : CrudRepository< Expense, Id> {
//}
@Repository
interface ExpenseRepository : CrudRepository<Expenses,Int>{
    // interface methods here
//    fun findByCategory(category: String): List<Expenses>
//look more into this
}

//    override fun findById(id: Int): Optional<Expenses>
//    override fun findAll(): List<Expenses>
//    override fun <S : Expenses?> save(entity: S & Any): S & Any
//    override fun delete(expense: Expenses)





//this code defines an interface ExpenseRepository that is used to interact with a database that stores Expenses objects.

//The @Repository annotation is used to indicate that this interface is a Spring Data repository,
// which is used to simplify the process of interacting with a database.
//This interface extends CrudRepository,
// which is a built-in interface in Spring Data that provides basic CRUD (Create, Read, Update, Delete) operations for a
// database entity. The Expenses class is the entity that this repository will be working with,
// and Int represents the type of the primary key for the Expenses class.

//In addition to the basic CRUD operations,
// this interface defines a custom method called findByCategory(category: String): List<Expenses>.
// This method takes a String parameter called category and returns a list of
// Expenses objects that match the specified category.

//Overall, this code is creating a Spring Data repository that can be used
// to interact with a database to perform CRUD operations on Expenses objects and provides a
// custom method to find expenses by category.