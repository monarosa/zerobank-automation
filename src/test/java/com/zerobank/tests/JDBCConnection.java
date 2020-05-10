package com.zerobank.tests;

import org.junit.Test;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JDBCConnection {
    String url = "jdbc:oracle:thin:@ec2-18-188-197-49.us-east-2.compute.amazonaws.com:1521:xe";
    String username = "hr";
    String password = "hr";
//Connection--> helps to connect to the database
// Statement-->helps write sql query and execute
    // ResultSet --->data that came from date will be stored in resultset fromat format.

    @Test()
    public void OracleJDBC() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);

        // Statement statement = connection.createStatement();
//so we can use last(), previous() etc...
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        ResultSet resultSet = statement.executeQuery("select * from countries");

        while (resultSet.next()) {

            System.out.println(resultSet.getString(1) + " " + resultSet.getString("country_name") + " " + resultSet.getString("region_id"));
        }

        resultSet.last();
        int lastrow = resultSet.getRow();

        System.out.println(lastrow);

        resultSet.beforeFirst();
        int firstrow = resultSet.getRow();

        System.out.println(firstrow);

        while (resultSet.next()) {

            System.out.println(resultSet.getString(1) + " " + resultSet.getString("country_name") + " " + resultSet.getString("region_id"));
        }


        resultSet.close();
        statement.close();
        connection.close();
    }

    @Test
    public void jdbcMetadata() throws SQLException {
        Connection connection = DriverManager.getConnection(url, username, password);
        Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        String sql = "select employee_id, last_name, job_id, salary from employees";
        ResultSet resultSet = statement.executeQuery(sql);
        //metadata
        DatabaseMetaData dbMetadata = connection.getMetaData();
        //System.out.println("User:" + dbMetadata.getUserName());
        //System.out.println("Database type: " + dbMetadata.getDatabaseProductName());

        //Metadata result set
        ResultSetMetaData rsmetadata = resultSet.getMetaData();
        //System.out.println("column count :" + rsmetadata.getColumnCount());
        int columncount = rsmetadata.getColumnCount();
//        while (columncount>0) {
//            System.out.println("get column name:" + rsmetadata.getColumnName(columncount));
//            columncount--;
//
//        }
//        for (int i = 1; i <= columncount; i++) {
//            System.out.println("get column name:" + rsmetadata.getColumnName(i));
//        }

        //throw resultset into a list of maps
        // create aList of Maps
        List<Map<String, Object>> list = new ArrayList<>();
        ResultSetMetaData rsMdata = resultSet.getMetaData();
        int colCount = rsMdata.getColumnCount();

        while(resultSet.next()){
            Map<String,Object> rowMap= new HashMap<>();
            for(int i=1; i<=colCount; i++){
                rowMap.put(rsMdata.getColumnName(i),resultSet.getObject(i));
            }
        list.add(rowMap);
        }

        for (Map<String,Object> emp:list){
            System.out.println(emp.get("EMPLOYEE_ID"));
        }


        resultSet.close();
        statement.close();
        connection.close();
    }

}
