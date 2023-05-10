package borrar;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Library {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(mappedBy = "library", fetch=FetchType.EAGER)
    private List<Book> books;

    public Library(){
        books = new ArrayList<>();
    }
    public Library(Long id, String name) {
        this.id = id;
        this.name = name;
        this.books = new ArrayList<>();
    }

    public void addBook(Book book){
        this.books.add(book);
    }
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getBooks() {
        return books;
    }
}
