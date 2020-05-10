package com.zerobank.tests;

import com.zerobank.utilities.DBType;
import com.zerobank.utilities.DBUtility;
import org.junit.Assert;
import org.junit.Test;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class EmployeesDBT {


    @Test
    public void countTest() throws SQLException {
        DBUtility.establishConnection(DBType.ORACLE);


        Assert.assertTrue(DBUtility.getRowsCount("select * from employees where job_id='IT_PROG'") > 0);
        DBUtility.closeConnections();
    }

    @Test
    public void nameTestByID() throws SQLException {
        DBUtility.establishConnection(DBType.ORACLE);

        List<Map<String, Object>> empdata = DBUtility.runSQLQuery("select first_name, last_name from employees where employee_id=105");
        Assert.assertEquals("David", empdata.get(0).get("FIRST_NAME"));
        Assert.assertEquals("Austin", empdata.get(0).get("LAST_NAME"));
        DBUtility.closeConnections();
    }


}
