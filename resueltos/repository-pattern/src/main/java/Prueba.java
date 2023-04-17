import java.sql.SQLException;
import java.util.List;

public class Prueba {
    public static void main(String[] args) throws SQLException {
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User u = userRepository.findById(3);
        Post post = new Post("texto", u);
        //postRepository.save(post);
        List<Post> posts = postRepository.findAll();
        for (Post p : posts){
            postRepository.delete(p);
            System.out.println(p);
        }
       //postRepository.delete(post);
        posts = postRepository.findAll();
        for (Post p : posts){
            System.out.println(p);
        }
    }
}
