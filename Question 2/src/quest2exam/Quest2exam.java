/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package quest2exam;
import java.sql.*;
import java.util.*;
public class Quest2exam{

        public static void main(String[] args) {
                Connection con=null;
                
                Scanner sc=new Scanner(System.in);
                try {
                        ResultSet rs=null;
                        Class.forName("com.mysql.jdbc.Driver");
                        con=DriverManager.getConnection("jdbc:mysql://localhost:3306/umtexam","root","");
                        System.out.println("connected");
                        con.setAutoCommit(false);
                        Statement stmt=con.createStatement();
                        String sql="select * from Cities";
                        rs=stmt.executeQuery(sql);
                        while(rs.next()) {
                                System.out.println(rs.getString("city_id"));
                                System.out.println(rs.getString("city_name"));
                        }
                
                }
                catch(Exception e) {e.printStackTrace();}

        }

}