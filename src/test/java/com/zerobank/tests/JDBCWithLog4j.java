package com.zerobank.tests;

import com.zerobank.utilities.ConfigurationReader;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;

import java.sql.*;

public class JDBCWithLog4j {

    public static final Logger logger= LogManager.getLogger();

    @Test
    public void getRecordsCount(){
        logger.info("Establishing data base connection");

        try(
                Connection connection= DriverManager.getConnection(ConfigurationReader.getProperty("mysqldb"),
                "root","monarosa");

            Statement statement=connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
            ResultSet resultSet=statement.executeQuery("select * from employees where first_name like 'ell%';");

        ){
         logger.debug("Executing query: elect * from employees where first_name like 'ell%';");
         logger.info(ConfigurationReader.getProperty("mysqldb"));

            while (resultSet.next()) {

                System.out.println(resultSet.getString(1) + " " + resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
            }

            resultSet.last();
            logger.info("Number if records etch from data base " +resultSet.getRow());

        }
        catch (Exception e){
        logger.error("error message from database");
        logger.error(e.getStackTrace());

        }



    }
}
