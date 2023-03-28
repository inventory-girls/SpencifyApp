package com.example.newspencify

import com.example.newspencify.expenses.ExpenseRepository
import com.example.newspencify.expenses.Expenses
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest
import org.springframework.test.annotation.Rollback
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import java.util.*

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Rollback(false)
class ExpenseRepositoryTests {
    @Autowired
    lateinit var repo: ExpenseRepository

    @Test
    fun testAddExpense() {
        val newExpense = Expenses()
        newExpense.amount = 96
        newExpense.description = "Food for clients"
        newExpense.category = "Food"
        newExpense.image="https://rb.gy/ojufvhlo"
        newExpense.date = Date()
        val savedExpense = repo.save(newExpense)


        println(savedExpense)

        Assertions.assertThat(savedExpense).isNotNull
        Assertions.assertThat(savedExpense.getExpenseId()).isGreaterThan(0)
    }

    @Test
    fun testFindAll() {
        val expenses: Iterable<Expenses> = repo.findAll()
        assertThat(expenses).hasSizeGreaterThan(0)

        for (expense in expenses) {
            println("Find All$expense")
        }
    }

    @Test
    fun testUpdatingExpense() {
        val userId: Int = 1
        val findExpenseID = repo.findById(userId)
        val expense: Expenses = findExpenseID.get()
        expense.amount = 4
        repo.save(expense)

        val updatedExpense: Expenses = repo.findById(userId).get()
        Assertions.assertThat(updatedExpense.amount).isEqualTo(4)
        println("Update$expense")
    }

    @Test
    fun testGetExpenses() {
        val userId= 1;
        val findExpenseID = repo.findById(userId);

        Assertions.assertThat(findExpenseID).isPresent
        println("findId" + findExpenseID.get())
    }


    @Test
    fun testDeleteExpense() {
        // create a test expense
        val testExpense = Expenses(amount = 100, category = "Food", image="https://rb.gy/ojufvhlp", date = Date(), description = "Lunch")

        // save the expense to the database
        val savedExpense = repo.save(testExpense)

        // delete the expense
        repo.delete(savedExpense)

        // try to retrieve the expense from the database
        val retrievedExpense = savedExpense.id?.let { repo.findById(it).orElse(null) }

        // verify that the expense was deleted
        Assertions.assertThat(retrievedExpense).isNull()
        println("deleted$retrievedExpense")

    }
}
//This is a unit test file that tests the functionality of the ExpenseRepository class, which is responsible for accessing the database and performing CRUD (Create, Read, Update, Delete) operations on the Expenses table.
//The annotations used in this file are as follows:
//@DataJpaTest: This annotation is used to test JPA repositories. It will auto-configure the Spring Data JPA-related configuration and create only the beans needed for testing the persistence layer.
//@AutoConfigureTestDatabase: This annotation is used to configure the test database.
//@Rollback: This annotation is used to roll back the transaction after each test method.
//The tests in this file are as follows:
//testAddExpense(): This test method creates a new Expenses object, sets its properties, and saves it to the database using the ExpenseRepository. It then asserts that the saved object is not null and that its ID is greater than 0.
//testFindAll(): This test method retrieves all expenses from the database using the ExpenseRepository and asserts that the list of expenses is not empty.
//testUpdatingExpense(): This test method retrieves an expense from the database using its ID, updates its amount property, saves it back to the database, and then retrieves it again using its ID. It then asserts that the amount property of the retrieved expense is equal to the updated amount.
//testGetExpenses(): This test method retrieves an expense from the database using its ID and asserts that the retrieved expense is present.
//testDeleteExpense(): This test method creates a new expense, saves it to the database, deletes it from the database using the ExpenseRepository, and then tries to retrieve the deleted expense from the database using its ID. It then asserts that the retrieved expense is null, indicating that the expense was successfully deleted.







