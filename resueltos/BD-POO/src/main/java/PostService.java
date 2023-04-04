import java.sql.*;
public class PostService {
    static java.sql.Connection con = DatabaseConnection.getInstance().getConnection();
    private PostService(){

    }
    public void insertPost(Post post) throws SQLException{
        if (post.getId() != -1){
            System.out.println("El post ya existe");
            return;
        }
        ResultSet rs;
        PreparedStatement st = null;


        String query = "INSERT INTO posts (TEXTO, LIKES, ID_USUARIO ) VALUES (?, 0, ?)";
        //Fijáos en Statement.RETURN_GENERATED_KEYS. Permite recuperar el campo ID autogenerado por MySql
        st = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
        st.setString(1, post.getTexto());
        st.setInt(2, post.getUsuario().getId());
        st.executeUpdate();

        //Recuperar el id autogenerado
        rs = st.getGeneratedKeys();
        //Este ResultSet solo puede contener un registro: el ID autogenerado

        if (rs.next()){
            //Ahora ya sabemos cuál es el nuevo id del Usuario
            post.setId(rs.getInt(1));
            System.out.println("ID Autogenerado:  " + post.getId());
        }
        System.out.println("Post insertado");
        st.close();
    }
}
