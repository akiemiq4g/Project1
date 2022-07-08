package com.Revature.Project1
import com.Revature.Project1.DatabaseConx
import scala.io.StdIn.readLine

class Menu(name: String, id: Int) {
  // The Menu Version 1
  // Main Menu Variables
  private var this.name = name;
  private var this.id = id;
  def init(name: String = "Guest", id: Int = 0): Unit = {
    println(s"Welcome ${name} ID: ${id}, to the Dining Out Experience");
    var selection: Int = 0;
    selection = printMenu();
    println(s"You selected: $selection")




  }

  def printMenu(): Int = {
    println("1: Create New User Account")
    println("2: Login")
    println("3. Admin")
    println("4. Exit")
    var selection: Int = 0;
    do {
      selection = readLine("Please enter a selection: ").toInt

      selection match {
        case 1 => createUser()
        case 2 => loggedIn()
        case 3 => loginAdmin()
        case _ => exit()
      }
    } while (selection == 0)
    return selection;
  }

  def createUser(): Unit = {
    println("Welcome New User. ")
    println("Can I get some information to setup your account.")
    val firstName: String = readLine("First Name: ")
    val lastName: String = readLine("Last Name: ")
    val userName: String = readLine("Username: ")
    val password: String = readLine("Password: ")
    val newUser = new DatabaseConx
    newUser.addUser(Array(firstName, lastName, userName, password))

  }

  def loginUser(): Boolean = {
    false
  }

  def loginAdmin(): Boolean = {
    false
  }

  def loggedIn() ={
    println(s"Thank you ${this.name} for logging in.")
    println("What would you like to do:")
    println("1. Modify user info")
    println("2. View Reports")
    println("3. Exit")
    var selection = 0;
    do {
      selection = readLine("Please enter a selection: ").toInt

      selection match {
        case 1 => createUser()
        case 2 => exit()
        case 3 => loginAdmin()
        case _ => exit()
      }
    } while (selection == 0)

  }

  def exit(): Unit = {

  }

}