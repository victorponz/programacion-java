import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IRepository<User> {
    private List<User> entities = new ArrayList<>();
    private java.sql.Connection con;
    public UserRepositoryImpl(){
        this.con = SocialNetworkService.getConnection();
    }
    public User bdToEntity(ResultSet rs) throws SQLException {
        return new User(rs.getInt("id"), rs.getString("nombre"), rs.getString("apellidos"));
    }
    public List<User> findAll() throws SQLException {

        List<User> users = new ArrayList<>();

        Statement st = this.con.createStatement();
        //Ejecutar la consulta, guardando los datos devueltos en un Resulset
        ResultSet rs = st.executeQuery("SELECT * FROM users ORDER BY apellidos, nombre");

        while(rs.next()){
            //Mapeamos el registro de la BD en un Usuario
            User u =  bdToEntity(rs);
            //Añadir el Usuario al conjunto de users
            users.add(u);
        }
        return users;
    }
    public User findById(int id) throws SQLException {
        PreparedStatement st = con.prepareStatement("SELECT * FROM users WHERE id = ? ");
        st.setInt(1, id);

        ResultSet rs = st.executeQuery();
        User u = null;
        //Si la consulta devuelve algún resultado ...
        if (rs.next()){
            // ... lo mapeamos a un objeto Usuario
            u = bdToEntity(rs);
        }
        //Devolvemos el Usuario ya mapeado
        return u;
    }

    public void save(User user) throws SQLException{
        if (user.getId() == -1){
            ResultSet rs;
            PreparedStatement st = null;
            String query = "INSERT INTO users (nombre, apellidos) VALUES (?, ?)";
            //Fijáos en Statement.RETURN_GENERATED_KEYS. Permite recuperar el campo ID autogenerado por MySql
            st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);

            st.setString(1, user.getNombre());
            st.setString(2, user.getApellidos());

            st.executeUpdate();

            //Recuperar el id autogenerado
            rs = st.getGeneratedKeys();
            //Este ResultSet solo puede contener un registro: el ID autogenerado

            if (rs.next()){
                //Ahora ya sabemos cuál es el nuevo id del Usuario
                user.setId(rs.getInt(1));
                System.out.println("ID Autogenerado:  " + user.getId());
            }
        }else{
            PreparedStatement st = con.prepareStatement("UPDATE users SET NOMBRE = ?, APELLIDOS = ? WHERE id = ?");
            st.setString(1, user.getNombre());
            st.setString(2, user.getApellidos());
            st.setInt(3, user.getId());

            int existe = st.executeUpdate();
        }

    }

    public void deleteById(int id) throws SQLException {
        PreparedStatement st = con.prepareStatement("DELETE FROM users WHERE id = ?");
        st.setInt(1, id);
        int existe = st.executeUpdate();
        st.close();
    }
}
