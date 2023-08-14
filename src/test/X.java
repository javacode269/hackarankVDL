package test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class X {
    public static void main(String[] a) throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mariadb://localhost:4006/survey","survey","Survey@123");
        PreparedStatement stmt = conn.prepareStatement("insert into test_cpm_rutgon (isdn,create_date) values(?,now())");

        for(int i =0 ;i<1000;i++){
            stmt.setString(1,"1");
            stmt.addBatch();
            if(i%200==0){
                stmt.executeBatch();
            }
        }
        stmt.close();
        conn.close();

    }
}
