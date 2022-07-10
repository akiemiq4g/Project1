package com.Revature.Project1

import org.apache.log4j.{Level, Logger}
import org.apache.spark.sql.SparkSession
// import com.mysql.cj.jdbc.Driver
import org.apache.spark
import ujson.IndexedValue.True

import java.sql.DriverManager
import java.sql.Connection
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import scala.collection.mutable.ArrayBuffer

class DatabaseConx {



  Logger.getLogger("org").setLevel(Level.OFF)
  Logger.getLogger("akka").setLevel(Level.OFF)
  // create a spark session
  // for Windows
  //System.setProperty("hadoop.home.dir", "C:\\Hadoop3")
  val spark = SparkSession
    .builder
    .appName("hello hive")
    .config("spark.master", "local[*]")
    //.config("spark.driver.allowMultipleContexts","true")
    .enableHiveSupport()
    .getOrCreate()
  Logger.getLogger("org").setLevel(Level.ERROR)
  println("created spark session")

  val url = "jdbc:mysql://localhost:3306/userdb"
  val user = "bobby"
  val pass = "bobby"
  import spark.implicits._



//  Code to be removed
//  val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
//  val loadingDate = LocalDateTime.of(2001, 3, 9, 0, 0, 0)
//  val x = loadingDate.format(formatter)
//
//  val sourceDf = spark.read.format("jdbc").option("url", url)
//    .option("dbtable", "users").option("user", user)
//    .option("password", pass).load()
//  sourceDf.show()




  def addUser(userInfo:Array[String]): Boolean = {
    val url = "jdbc:mysql://localhost:3306/userdb"
    val user = "bobby"
    val pass = "bobby"


    val sourceDf = spark.read.format("jdbc").option("url", url)
      .option("dbtable", "usertable").option("user", user)
      .option("password", pass).load()
    sourceDf.show()
    return true
  }

  def viewUsers(): Unit = {
    val url = "jdbc:mysql://localhost:3306/mysql/userdb"
    val driver = "com.mysql.jdbc.Driver"
    val username = "bobby"
    val password = "bobby"
    var connection: Connection = null
    try {
      Class.forName(driver)
      var connection = DriverManager.getConnection(url, username, password)
      val statement = connection.createStatement
      val rs = statement.executeQuery("SELECT * FROM usertable")
      while (rs.next) {
        println(rs)
      }
    } catch {
      case e: Exception => e.printStackTrace
        println("In catch")
    }
    connection.close
  }


  def viewData()={

  }
  def loadData(report: Int = 0)={
    /*val spark = SparkSession
      .builder
      .appName("Project 1")
      .config("spark.master", "local[*]")
      .enableHiveSupport()
      .getOrCreate()
    Logger.getLogger("org").setLevel(Level.ERROR)
    println("created spark session")

    import spark.implicits._*/

    val df = spark.read
      .format ("restaurant.csv")
      .option ("inferSchema", "true")
      .option ("header", "true")
      .csv ("src/main/resources/restaurant.csv")

    report match {

      case 0 => {
        println ("Preview of the first 20 lines of all data: ")
        df.show(20)
      }
      case 1 => {
        println("Preview of the last 20 lines of all data: ")
        df.tail(20)
        df.show()
      }
      case 2 => {
        val sqlDF = spark.sql("SELECT restaurant_id, name, borough, cuisine FROM restaurant")
        sqlDF.groupBy("borough").count().show()
      }

    }



  }






}
