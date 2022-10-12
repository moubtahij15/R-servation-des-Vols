package mvc.DAO;

import mvc.model.Personne;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonneDAO {
    public PersonneDAO() {
    }

    boolean login(Personne personne) throws SQLException, ClassNotFoundException {
        Connection con = (Connection) mvc.helpers.Connection.getInstance().getConnection();

        PreparedStatement stmt = con.prepareStatement("select count(*) from admin where email = ? and password = ?");
        stmt.setString(1, personne.getUsername());
        stmt.setString(2, personne.getPassword());
        ResultSet rs = stmt.executeQuery();

        if (rs.next()) {
            return rs.getInt(1) == 1;
        }
        return false;
    }
}
