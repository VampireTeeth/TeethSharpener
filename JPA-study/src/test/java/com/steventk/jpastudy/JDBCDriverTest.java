package com.steventk.jpastudy;

import java.sql.Connection;
import java.sql.DriverManager;

import junit.framework.Assert;

import org.junit.Test;

public class JDBCDriverTest {
    
    @Test
    public void testDriver() throws Exception {
        String url = "jdbc:postgresql://localhost/mydb";
        Connection conn = DriverManager.getConnection(url, "steven", "steven");
        Assert.assertTrue(conn != null);
    }

}
