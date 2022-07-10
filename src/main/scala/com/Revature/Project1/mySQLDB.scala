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
    while (rs.next()) {
      if (rs.getString(1) == username){
        println("Please try another username.")
        return false
      }

    }
    return true

  }
}
