/**
 * El objeto Post es como hemos hecho los objetos hasta ahora; es decir, campos, setters y getters, ya que toda la lógica esta en PostRepositorio y PostService
 *
 * @author (Víctor Ponz)
 * @version (13/03/2023)
 */
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
public class Post
{
    private Date fecha;
    private int id;
    private String texto;
    private int likes;
    private Usuario usuario;

    /**
     * Constructor for objects of class Post
     */
    public Post()
    {
        this.fecha = null;
        this.id = 0;
        this.texto = "";
        this.likes = 0;
        this.usuario = null;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }
    public String getTexto(){
        return texto;
    }
    public void setTexto(String texto){
        this.texto = texto;
    }
    public Date getFecha(){
        return fecha;
    }
    public void setFecha(Date fecha){
        this.fecha = fecha;
    }

    public int getLikes(){
        return likes;
    }
    public void setLikes(int likes){
        this.likes = likes;
    }

    public Usuario getUsuario(){
        return this.usuario;
    }
    public void setUsuario(Usuario usuario){
        this.usuario = usuario;
    }

    public void like(){
        this.likes++;
    }

    public void unlike(){
        this.likes--;
    }
    public void display(){
        /*
         * Formateamos la fecha al locale por defecto del usuario
         */
        DateFormat formatter;
        formatter = DateFormat.getDateTimeInstance(DateFormat.FULL, DateFormat.FULL, Locale.getDefault());
        System.out.println("ID: " + id + " USUARIO: " + usuario.getNombre() + " " + usuario.getApellidos() + " TEXTO: " + texto + " FECHA: " + formatter.format(fecha) + " LIKES: " + likes);
    }
}
