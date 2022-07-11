package com.Revature.Project1
import com.Revature.Project1.DatabaseConx

import java.io.Console
import scala.io.StdIn._
import java.util.Scanner
import scala.language.postfixOps

class Menu(name: String, id: Int){
  // The Menu Version 1
  // Main Menu Variables

  var this.name: String = name;
  var this.id: Int = id;

  //var dbConnection = new DatabaseConx;
  val cons = System.console()
  def init(name: String = "Guest", id: Int = 0): Unit = {
    println(s"Welcome ${name} ID: ${id}, to the Dining Out Experience");
    var selection: Int = 0;
    selection = printMenu();




  }

  def printMenu(): Int = {
    println("1: Create New User Account")
    println("2: Login")
    println("3. Admin")
    println("4. Exit")
    var selection: Int = 0;
    try {
      do {
        selection = readLine("Please enter a selection: ").toInt

        selection match {
          case 1 => createUser()
          case 2 => loginUser()
          case 3 => loginAdmin()
          case 4 => exit()
        }
      } while (selection != 4)
    } catch{
        case e: MatchError =>{
          println("Please check your entry and try a correct value from the menu.")
          init()
        }
        case f: NumberFormatException => {
          println("You entered a non-numeric value. Please check your entry and try again.")
          init()
        }


      }
    return selection;
  }

  def createUser(isAdmin: Boolean = false): Unit = {
    println("Welcome New User. ")
    println("Can I get some information to setup your account.")
    var console: Console = System.console()
    val firstName: String = readLine("First Name: ")
    val lastName: String = readLine("Last Name: ")
    var userName:String = ""
    var test: Boolean = true;
    do {
      userName = readLine("Username: ")
      test = mySQLDB.checkUsername(userName)

      if (test == true){
        println("Please try another username.")
      }

    } while (test == true)

    val password: String = readLine("Password: ")
    val user: Array[String] = Array(firstName, lastName, userName, password)
    mySQLDB.saveUser(user, isAdmin)

    // var password: Array[Char] = console.readPassword


    /*val newUser = new DatabaseConx
    newUser.addUser(Array(firstName, lastName, userName, password))*/

  }

  def loginUser(): Boolean = {

    var username = readLine("Please enter your username: ")
    if (mySQLDB.checkUsername(username) == true) {
      var password = readLine("Please enter your password: ")
      if (mySQLDB.checkPassword(username, password) == true) {
        println("Login successful")
        loggedIn(username)
        return true
      } else {
        println("Login unsuccessful")
        return false
      }
    }else{
      print("User not found")
      return false
    }
    // Revisit to get a try/catch work around for whether the app is run within IDE or console.
    // var password: Array[Char] = cons.readPassword("Please enter your password: ")
  }

  def loginAdmin(): Boolean = {
    false
  }

  def loggedIn(username:String) ={
    println(s"Thank you ${this.name} for logging in.")
    println("What would you like to do:")
    println("1. Modify user info")
    println("2. View Reports")
    println("3. Change User")
    println("4. Exit")
    var selection = 0;
    do {
      selection = readLine("Please enter a selection: ").toInt

      selection match {
        case 1 => createUser()
        case 2 => exit()
        case 3 => loginUser()
        case _ => exit()
      }
    } while (selection == 0 || selection.isValidInt )

  }

  def exit(): Unit = {

  }

}
