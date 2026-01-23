package bbdd_interfaces.conectoresbbdd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import org.postgresql.util.PSQLException;

/**
 *
 * @author 2DAM
 */
public class ConectoresBBDD {

    public void addDepartment(Department dep) {
    
        try {
            
            Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/aprendizaje", "alumno", "alumno");
            Statement st = con.createStatement();
            st.execute(
                    "INSERT INTO empleados.departamentos (id_departamento, nombre_departamento, id_director, id_localizacion) "
                            + " VALUES (" + dep.getId() + ", \'" + dep.getName() + "\', " + dep.getIdDirector() + ", " + dep.getIdLocalizacion() + ")");
        } catch (SQLException ex) {
            
            System.out.println("fdasmnf");
        }
    }
}
