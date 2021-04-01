import java.sql.*;

public class HelloWorlds {
    public static void main (String [] args )
    {

        System.out.println("hello");
        String mySql ="select * from classicmodels.employees" ;
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306", "ora2", "P@ssw0rd");
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(mySql)) {
            ResultSetMetaData rsmeta = rs.getMetaData();
            int colCount = rsmeta.getColumnCount();
            for (int i = 1; i <= colCount; i++) {
                System.out.print(rsmeta.getColumnName(i)+"          ");

            }
            System.out.println(" ");

            while (rs.next()) {
                for (int i = 1; i <= colCount; i++) {
                    System.out.print(rs.getString(i)+"          ");
                }
                System.out.println("/n");
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
