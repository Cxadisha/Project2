import Data.Sql;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;

public class dpData {

    @DataProvider(name = "dp")
    public static Object[][] dpData() {

//        String sql = "SELECT TOP 1 *\n" +
//                "from [users].[dbo].[users]\n" +
//                "ORDER BY id DESC;";

        String sql2 = "select top 1 id, firstName, lastName, phone, email, format ([dateOfBirth], 'dd/MM/yyyy') as dateOfBirth, password\n" +
                "from [users].[dbo].[users]\n" +
                "order by id desc;";

        String name = null;
        String lastName = null;
        String phone = null;
        String email = null;
        String dateOfBirth = null;
        String password = null;

        try (Connection conn = Sql.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(sql2)) {

            while (rs.next()) {
                name = rs.getString("firstName");
                lastName = rs.getString("lastName");
                phone = rs.getString("phone");
                email = rs.getString("email");
                dateOfBirth = rs.getString("dateOfBirth");
                password = rs.getString("password");
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return new Object[][]{
                {name, lastName, phone, email, dateOfBirth, password}
        };
    }
}
