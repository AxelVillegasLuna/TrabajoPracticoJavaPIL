package persistenciaDatos;

import modelos.Galo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatosGalo {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test;MODE=MySQL";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public void crearTablaGalos() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS galo " +
                    "(id_galo INTEGER NOT NULL AUTO_INCREMENT, " +
                    " nombre VARCHAR(100) NOT NULL, " +
                    " astucia INTEGER NOT NULL, " +
                    " fuerza INTEGER NOT NULL, " +
                    " PRIMARY KEY ( id_galo )) ";

            stmt.executeUpdate(sql);
            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            //Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            //finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                } else {

                }
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                } else {

                }
            } catch (SQLException se) {
                se.printStackTrace();
            } //end finally try
        } //end try
    }

    public void cargarGalos() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "MERGE INTO galo (nombre, astucia, fuerza) KEY(nombre, astucia, fuerza) " + "VALUES ('Asterix', 5, 10) ";

            stmt.executeUpdate(sql);
            sql = "MERGE INTO galo (nombre, astucia, fuerza) KEY(nombre, astucia, fuerza) " + "VALUES ('Obélix', 1, 25) ";

            stmt.executeUpdate(sql);
            sql = "MERGE INTO galo (nombre, astucia, fuerza) KEY(nombre, astucia, fuerza) " + "VALUES ('Panoramix', 3, 18) ";

            stmt.executeUpdate(sql);
            sql = "MERGE INTO galo (nombre, astucia, fuerza) KEY(nombre, astucia, fuerza) " + "VALUES ('Ideafix', 2, 22) ";

            stmt.executeUpdate(sql);
            sql = "MERGE INTO galo (nombre, astucia, fuerza) KEY(nombre, astucia, fuerza) " + "VALUES ('Asurancetúrix', 4, 8) ";

            stmt.executeUpdate(sql);

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    public void obtenerGalos() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM galo";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id_galo");
                String nombre = rs.getString("nombre");
                int astucia = rs.getInt("astucia");
                int fuerza = rs.getInt("fuerza");

                // Display values
                System.out.print(" Número: " + id);
                System.out.print(" - Nombre: " + nombre);
                System.out.print(" - Astucia: " + astucia);
                System.out.println(" - Fuerza: " + fuerza);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    public Galo obtenerGaloEspecifico(int id_galo) {
        Connection conn = null;
        Statement stmt = null;
        Galo galo = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM galo WHERE id_galo = " + id_galo;
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int astucia = rs.getInt("astucia");
                int fuerza = rs.getInt("fuerza");

                galo = new Galo(nombre, astucia, fuerza);
            }
            // STEP 5: Clean-up environment
            rs.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) {
                    stmt.close();
                } else {

                }
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return galo;
    }

    public void guardarGalo(String nombre, int astucia, int fuerza) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO galo (nombre, astucia, fuerza) VALUES ('" + nombre + "' , " + astucia + ", " + fuerza + ")";
            stmt.executeUpdate(sql);

            // STEP 4: Clean-up environment
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            // Handle errors for JDBC
            se.printStackTrace();
        } catch (Exception e) {
            // Handle errors for Class.forName
            e.printStackTrace();
        } finally {
            // finally block used to close resources
            try {
                if (stmt != null) stmt.close();
            } catch (SQLException se2) {
            } // nothing we can do
            try {
                if (conn != null) conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }
}
