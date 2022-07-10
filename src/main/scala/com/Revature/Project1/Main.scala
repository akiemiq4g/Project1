package com.Revature.Project1

import scala.io.StdIn._

object Main {
  def main(args: Array[String]): Unit = {

//    val dbConx = new DatabaseConx;
//    dbConx.addUser(Array("Akiem", "Watley", "awatley", "blahblah"))
//    dbConx.viewUsers();


    //testing loading data
//    var selection = "exit"
//    do {
//      var selection = readLine("Please enter a menu option")
//      var report = 0
//
//      if(selection.toInt.isValidInt) {
//        report = selection.toInt
//      }
//
//      dbConx.loadData(report);
//    }while(selection != "exit" )

//    val Menu1 = new Menu("Guest", 1)
//    Menu1.init()
  mySQLDB.checkUsername("testing")

  }
}
