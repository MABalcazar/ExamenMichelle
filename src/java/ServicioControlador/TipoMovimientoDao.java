/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/File.java to edit this template
 */
package ServicioControlador;



import ClaseModeloPojos.TipoMovimiento;
import java.sql.*;
import java.util.*;

public class TipoMovimientoDao {
    private Connection conn;

    public TipoMovimientoDao(Connection conn) {
        this.conn = conn;
    }

    public List<TipoMovimiento> obtenerTodos() throws SQLException {
        List<TipoMovimiento> lista = new ArrayList<>();
        String sql = "SELECT * FROM tipo_movimiento";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            TipoMovimiento tm = new TipoMovimiento();
            tm.setId(rs.getInt("id"));
            tm.setNombre(rs.getString("nombre"));
            lista.add(tm);
        }

        return lista;
    }
}
