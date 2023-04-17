import java.sql.SQLException;
import java.util.List;

public class Prueba {
    public static void main(String[] args) throws SQLException {
        PostRepositoryImpl postRepository = new PostRepositoryImpl();
        UserRepositoryImpl userRepository = new UserRepositoryImpl();
        User u = userRepository.findById(3);
        Post post = new Post("texto", u);
        //postRepository.save(post);
        /*List<Post> posts = postRepository.findAll();
        for (Post p : posts){
            System.out.println(p);
            System.out.println(p.getUser().getPosts());
        }*/
        List<User> allUsers = userRepository.findAll();
        for (User user : allUsers){
            for (Post p : postRepository.findByUser(user)){
                System.out.println(user.getId());
                System.out.println(p);

            }
        }

    }
}
