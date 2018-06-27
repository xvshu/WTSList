package sqlite;

import com.xs.java.dbs.sqlite.ResultSetExtractor;
import com.xs.java.dbs.sqlite.RowMapper;
import com.xs.java.dbs.sqlite.SqliteHelper;
import com.xs.java.model.WebTables;
import com.xs.java.model.WebTablesRowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class SqliteTest {

    public static void main(String[] args) {
        testMax();
    }

    public static void testHelper() {
        try {
            SqliteHelper h = new SqliteHelper();
            h.executeUpdate("drop table if exists test;");
            h.executeUpdate("create table test(name varchar(20));");
            h.executeUpdate("insert into test values('sqliteHelper test');");
            List<String> sList = h.executeQuery("select name from test", new RowMapper<String>() {
                @Override
                public String mapRow(ResultSet rs, int index)
                        throws SQLException {
                    return rs.getString("name");
                }
            });
            System.out.println(sList.get(0));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testHelper2() {
        try {
            SqliteHelper h = new SqliteHelper();

            h.executeUpdate("insert into Web_Table values(1,'测试','默认','百度','http://localhost:8899/#/three');");
            List<WebTables> sList = h.executeQuery("select * from Web_Table", new WebTablesRowMapper());
            System.out.println(sList.size());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void testMax(){
        String findMaxSql = " SELECT max(ID) as max FROM Web_Table;";
        try {
            int maxIdResult = new SqliteHelper().executeQuery(findMaxSql, new ResultSetExtractor<Integer>() {

                @Override
                public Integer extractData(ResultSet rs) {
                    Integer result = 0;
                    if (rs != null) {
                        try {
                            result = Integer.valueOf(rs.getInt("max"));
                        } catch (Exception ex) {
                            ex.printStackTrace();
                        }
                    }
                    return result;
                }
            });

            System.out.println(maxIdResult);
        }catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
