package persistenciaDatos;

import modelos.Romano;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatosRomano {
    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "org.h2.Driver";
    static final String DB_URL = "jdbc:h2:~/test";

    //  Database credentials
    static final String USER = "sa";
    static final String PASS = "";

    public void crearTablaRomanos() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            //STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            //STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "CREATE TABLE IF NOT EXISTS romano " +
                    "(id_romano INTEGER NOT NULL AUTO_INCREMENT, " +
                    " nombre VARCHAR(100) NOT NULL, " +
                    " dientes INTEGER NOT NULL, " +
                    " salud INTEGER NOT NULL, " +
                    " PRIMARY KEY ( id_romano )) ";

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

    public void cargarRomanos() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "MERGE INTO romano (nombre, dientes, salud) KEY(nombre, dientes, salud) " + "VALUES ('Caius Bonus', 32, 80)";

            stmt.executeUpdate(sql);
            sql = "MERGE INTO romano (nombre, dientes, salud) KEY(nombre, dientes, salud) " + "VALUES ('Gracolinus', 32, 50)";

            stmt.executeUpdate(sql);
            sql = "MERGE INTO romano (nombre, dientes, salud) KEY(nombre, dientes, salud) " + "VALUES ('Langelus', 32, 100)";

            stmt.executeUpdate(sql);
            sql = "MERGE INTO romano (nombre, dientes, salud) KEY(nombre, dientes, salud) " + "VALUES ('Hotelterminus', 32, 30)";

            stmt.executeUpdate(sql);
            sql = "MERGE INTO romano (nombre, dientes, salud) KEY(nombre, dientes, salud) " + "VALUES ('Belicus', 32, 15)";

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
            } // end finally try
        } // end try
    }

    public void obtenerRomanos() {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM romano";
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while (rs.next()) {
                // Retrieve by column name
                int id = rs.getInt("id_romano");
                String nombre = rs.getString("nombre");
                int dientes = rs.getInt("dientes");
                int salud = rs.getInt("salud");

                // Display values
                System.out.print(" Número: " + id);
                System.out.print(" - Nombre: " + nombre);
                System.out.print(" - Dientes: " + dientes);
                System.out.println(" - Salud: " + salud);
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
                } else {

                }
            } catch (SQLException se) {
                se.printStackTrace();
            } // end finally try
        } // end try
    }

    public Romano obtenerRomanoEspecifico(int id_romano) {
        Connection conn = null;
        Statement stmt = null;
        Romano romano = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "SELECT * FROM romano WHERE id_romano = " + id_romano;
            ResultSet rs = stmt.executeQuery(sql);

            // STEP 4: Extract data from result set
            while (rs.next()) {
                String nombre = rs.getString("nombre");
                int dientes = rs.getInt("dientes");
                int salud = rs.getInt("salud");

                romano = new Romano(nombre, dientes, salud);
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
                } else {

                }
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        return romano;
    }

    public void guardarRomano(String nombre, int dientes, int salud) {
        Connection conn = null;
        Statement stmt = null;
        try {
            // STEP 1: Register JDBC driver
            Class.forName(JDBC_DRIVER);

            // STEP 2: Open a connection
            conn = DriverManager.getConnection(DB_URL, USER, PASS);

            // STEP 3: Execute a query
            stmt = conn.createStatement();
            String sql = "INSERT INTO romano (nombre, dientes, salud) VALUES ('" + nombre + "' , " + dientes + ", " + salud + ")";
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
            } // end finally try
        } // end try
    }
}
