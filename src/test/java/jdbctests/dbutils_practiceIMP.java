package jdbctests;

import org.testng.annotations.Test;
import utilities.DBUtils;

import java.util.List;
import java.util.Map;

public class dbutils_practiceIMP {
    @Test
    public void test1(){
        //create connection
        DBUtils.createConnection();
        //using method to get result as a list of maps, birden fazla row almak icin List i kullaniyoruz.
        List<Map<String, Object>> queryResult = DBUtils.getQueryResultMap("select * from employees");

        //printing the result
        for (Map<String, Object> map : queryResult) {
            System.out.println(map.toString());
        }
        //close connection
        DBUtils.destroy();
    }
    @Test
    public void test2(){
        //create connection
        DBUtils.createConnection();
        //sadece bir row almak icin Map kullaniyoruz
        Map<String, Object> rowMap = DBUtils.getRowMap("select first_name,last_name,salary,job_id from employees\n" +
                "where employee_id = 100");

        System.out.println(rowMap.toString());

        //close connection
        DBUtils.destroy();
    }
}
