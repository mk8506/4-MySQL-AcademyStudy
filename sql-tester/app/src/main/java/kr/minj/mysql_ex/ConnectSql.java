package kr.minj.mysql_ex;

import kr.minj.helper.DBHelper;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConnectSql {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Enter dname: ");
    String dname = scanner.nextLine().replace("'", "//'");
    System.out.print("Enter loc: ");
    String loc = scanner.nextLine().replace("'", "//'");
    scanner.close();

    String sql = "insert into department (dname, loc) values (" +dname+ ", " +loc+ ")";
    Statement stmt = null;
    int result = 0;
    Connection connection = DBHelper.getInstance().open();
        
    try {
      stmt = connection.createStatement();
      result = stmt. executeUpdate(sql);
    } catch (SQLException e) {
      System.out.println("===== Query Error =====");
      e.printStackTrace();
    } finally {
      if (stmt != null) {
         try {
            stmt.close();
         } catch (SQLException e) {
            e.printStackTrace();
         }
       }
    }
    
    System.out.println("finished");
    System.out.println(result);
    DBHelper.getInstance().close();
    DBHelper.freeInstance();
  }
}
