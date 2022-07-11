package com.Revature.Project1

import java.sql.{Connection, DriverManager}

object mySQLDB {
  private var connection: Connection = _

  def connect(): Unit = {
    val url = "jdbc:mysql://localhost:3306/userdb"
    val driver = "com.mysql.cj.jdbc.Driver"
    val username = "bobby"
    val password = "bobby"

    try {
      Class.forName(driver)
      connection = DriverManager.getConnection(url, username, password)
      //println("MySQL CONNECTION IS GOOD")

    } catch {
      case e: Exception => e.printStackTrace()
        println("something is wrong")
    }
  }

  def checkUsername(username: String): Boolean ={
    connect()
    val statement = connection.prepareStatement("SELECT user FROM usertable")
    val rs = statement.executeQuery()
    rs.next()
    // while (rs != null) {
    if (rs.getString(1) == username){
      return true
    }else{
      return false
    }


  }

  def checkPassword(user: String, pass: String): Boolean={
    connect()
    val statement = connection.prepareStatement(s"SELECT password FROM usertable WHERE user = '$user' ")
    var checking = statement.executeQuery()
    try {
      checking.next()
      //println(checking.getstring())
      if (checking.getString("password") == pass){

        true
      } else {
        false
      }

    }
  }

  def saveUser(user:Array[String], isAdmin: Boolean = false):Boolean = {
    connect()
    val firstName: String = user(0)
    val lastName: String = user(1)
    val userName: String = user(2)
    val password: String = user(3)
    val userId: Int = 5
    var adminStatus: Int = 0
    if (isAdmin == true){
      adminStatus = 1
    }
    var statement = connection.prepareStatement(s"INSERT INTO usertable ( user, password, first_name, last_name, isAdmin) VALUES (?,?,?,?,?)")
    var rs = 0
    try {
      //statement.setInt(1, userId)
      statement.setString(1, userName)
      statement.setString(2, password)
      statement.setString(3, firstName)
      statement.setString(4, lastName)
      statement.setShort(5, adminStatus.toShort)
      rs = statement.executeUpdate()
      println(s"Thank you $firstName $lastName your account has been created.")
      println(rs.toString)
    }
    return true
  }

  def viewUsers(): Unit = {
    connect()
    try {
      val statement = connection.createStatement
      val rs = statement.executeQuery("SELECT * FROM usertable")
      while (rs.next) {
        println(rs.getRow())
      }
    } catch {
      case e: Exception => e.printStackTrace
        println("In catch")
    }
    connection.close
  }
}
