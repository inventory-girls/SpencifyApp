package com.example.newspencify.expenses

import jakarta.persistence.*
import org.springframework.data.jpa.repository.Temporal
import java.util.*


@Entity
@Table(name="expenses")
class Expenses (
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   var id: Int? = null,

   @Column(nullable = false,length = 45)
   var amount: Int = 0,

   @Column(nullable = false, length = 100)
   var description: String? = null,

   @Column(nullable = false, length = 100)
   var category: String? = null,

   @Column(nullable = false)
   var image: String? = null,

   @Column(name = "date", nullable = false)
   @Temporal(TemporalType.TIMESTAMP)
   var date: Date? = null
) {

   fun getExpenseId(): Int? {
      return id
   }

   private fun getExpenseAmount(): Int {
      return amount
   }

   fun getExpenseDescription(): String? {
      return description
   }

   private fun getExpenseCategory(): String? {
      return category
   }

   private fun getExpenseImage(): String? {
      return image
   }

   private fun getExpenseDate(): Date? {
      return date
   }

   // setter methods
   private fun setGetExpenseId(newId: Int?) {
      id = newId
   }

   private fun setGetAmount(newAmount: Int) {
      amount = newAmount
   }

   private fun setGetDescription(newDescription: String?) {
      description = newDescription
   }

   private fun setGetCategory(newCategory: String?) {
      category = newCategory
   }

   private fun setGetImage(newImage: String?) {
      image = newImage
   }

   private fun setGetDate(newDate: Date?) {
      date = newDate
   }

   override fun toString(): String {
      return "Expenses{" +
              "id=$id" +
              ", description='$description'" +
              ", category=$category" +
              ", image=$image" +
              ", date=$date" +
              "}"
   }
}


//This code defines a Kotlin class called Expenses with the @Entity and @Table annotations,
// which indicate that this class will be used to map database table entries to objects in the application.
// The Expenses class contains several properties such as id, amount, description, category, image, and date, each of which maps to a column in a database table.

//The @Id annotation indicates that the id property is the primary key for the table,
// and the @GeneratedValue annotation specifies that the value for id will be generated automatically.

//The @Column annotation is used to define each column in the table, including the column name,
// the data type, and other constraints such as nullability and maximum length.

//The Expenses class also contains several methods to get and set the values of its properties.
// The get methods are used to retrieve the current value of a property, while the set methods are used to update the value of a property.

//Finally, the toString method is overridden to provide a string representation of the Expenses object,
// which is used to print or display the object in a user interface.
// The toString method concatenates the values of the object's properties into a single string,
// which can be used for debugging purposes or to provide feedback to the user.





