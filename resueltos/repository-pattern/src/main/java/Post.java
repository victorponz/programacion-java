import java.sql.Date;
public class Post {
    private int id;
    private String text;
    private int likes;

    private Date date;
    private User user;

    Post(int id, String text, int likes, Date date, User user){
        this.id = id;
        this.text = text;
        this.user = user;
        this.likes = likes;
        this.date = date;
    }
    Post(String text, User user){
        this(-1, text, 0, new Date(new java.util.Date().getTime()), user);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString(){
        return text + " - " + date;

    }
}
