package com.code.yhz;

import java.io.IOException;
import java.sql.*;

/**
 * @Author yhz
 * @Date 2020/9/9 15:55
 */
public class TestMysql {
    public static void main(String args[]){
        int count=0;
        Connection[]conn=new Connection[1000];
        Statement[]stmt =new Statement[1000];
        ResultSet[]rs =new ResultSet[1000];
        try{
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            for(count=0;count<300;count++){
                conn[count] = DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql", "root", "hicc");
                stmt[count]=conn[count].createStatement();
                rs[count]=stmt[count].executeQuery("SELECT * FROM user");
                while (rs[count].next()){
//System.out.println(rs.getString(1)+"t "+rs.getString(2));
                }
                System.out.print(count+"t");
            }

        }catch(SQLException ex1){
            System.out.println("n"+ex1.toString());
        }catch(InstantiationException ex2){
            System.out.println("n"+ex2.toString());
        }catch(ClassNotFoundException ex3){
            System.out.println("n"+ex3.toString());
        }catch(IllegalAccessException ex4){
            System.out.println("n"+ex4.toString());
        }finally{
            try{
                System.out.println("nSystem has opened "+count--+" Mysql connections.nPress Enter key to close the connections");
                System.in.read();
                System.out.println("nClose the Connections:");
                for(;count>=0;count--){
                    rs[count].close();
                    stmt[count].close();
                    conn[count].close();
                    System.out.print(count+"t");
                }
            }catch(SQLException ex){
                System.out.println("n Close connection exception:"+ex.toString());
            }catch(IOException io_ex){}
        }//end the first "try"
    }
}
