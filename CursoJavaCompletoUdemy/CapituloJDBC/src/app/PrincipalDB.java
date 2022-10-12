package app;

import db.DB;
import db.DbException;
import db.DbIntegrityException;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 *
 * @author Alisson Chiquitto <chiquitto@gmail.com>
 */
public class PrincipalDB {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // mainInsertSeller(args);
        // mainInsertDepartment(args);
        // mainInsertDelete(args);
        // mainSelect(args);
        mainTransactions(args);
    }

    private static void mainInsertDepartment(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "INSERT INTO department (Name) VALUES ('Depto 1'), ('Depto 2')",
                    Statement.RETURN_GENERATED_KEYS);

            int rowsAffected = st.executeUpdate();

            System.out.printf("Pronto! Linhas afetadas: %d%n", rowsAffected);

            if (rowsAffected > 0) {
                ResultSet rs = st.getGeneratedKeys();

                int size = 0;

                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.printf("Pronto! Id=%d%n", id);
                }
                size = rs.getRow();
                System.out.println(size);

                DB.closeResultSet(rs);
            } else {
                System.out.println("Nenhuma linha afetada");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            System.out.println("Fechar coisos");

            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    private static void mainInsertSeller(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;

        SimpleDateFormat sdfIn = new SimpleDateFormat("dd/MM/yyyy");

        try {
            conn = DB.getConnection();
            st = conn.prepareStatement(
                    "Insert into seller"
                    + " (Name, Email, BirthDate, BaseSalary, DepartmentId)"
                    + " Values"
                    + " (?, ?, ?, ?, ?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, "Chiquitto");
            st.setString(2, "chiquitto@gmail.com");
            st.setDate(3, new Date(sdfIn.parse("15/12/2000").getTime()));
            st.setDouble(4, 3000);
            st.setInt(5, 1);

            int rowsAffected = st.executeUpdate();

            System.out.printf("Pronto! Linhas afetadas: %d%n", rowsAffected);

            if (rowsAffected > 0) {
                rs = st.getGeneratedKeys();
                while (rs.next()) {
                    int id = rs.getInt(1);
                    System.out.printf("Pronto! Id=%d%n", id);
                }
            } else {
                System.out.println("Nenhuma linha afetada");
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    private static void mainSelect(String[] args) {
        Connection conn = null;
        Statement st = null;
        ResultSet rs = null;

        try {
            conn = DB.getConnection();
            st = conn.createStatement();
            rs = st.executeQuery("Select * From department");

            while (rs.next()) {
                System.out.printf("%d: %s%n", rs.getInt("Id"), rs.getString("Name"));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            DB.closeResultSet(rs);
            DB.closeStatement(st);
            DB.closeConnection();
        }

    }

    private static void mainInsertDelete(String[] args) {
        Connection conn = null;
        PreparedStatement st = null;
        try {
            conn = DB.getConnection();

            st = conn.prepareStatement(
                    "DELETE FROM department "
                    + "WHERE "
                    + "Id = ?");

            st.setInt(1, 5);

            int rowsAffected = st.executeUpdate();

            System.out.println("Done! Rows affected: " + rowsAffected);
        } catch (SQLException e) {
            throw new DbIntegrityException(e.getMessage());
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

    private static void mainTransactions(String[] args) {
        Connection conn = null;
        Statement st = null;
        try {
            conn = DB.getConnection();

            conn.setAutoCommit(false);

            st = conn.createStatement();

            int rows1 = st.executeUpdate("UPDATE seller SET BaseSalary = 2090 WHERE DepartmentId = 1");

            //int x = 1;
            //if (x < 2) {
            //	throw new SQLException("Fake error");
            //}
            int rows2 = st.executeUpdate("UPDATE seller SET BaseSalary = 3090 WHERE DepartmentId = 2");

            conn.commit();

            System.out.println("rows1 = " + rows1);
            System.out.println("rows2 = " + rows2);
        } catch (SQLException e) {
            try {
                conn.rollback();
                throw new DbException("Transaction rolled back! Caused by: " + e.getMessage());
            } catch (SQLException e1) {
                throw new DbException("Error trying to rollback! Caused by: " + e1.getMessage());
            }
        } finally {
            DB.closeStatement(st);
            DB.closeConnection();
        }
    }

}
