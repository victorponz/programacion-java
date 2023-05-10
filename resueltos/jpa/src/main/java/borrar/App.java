package borrar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.util.Optional;

@SpringBootApplication
public class App implements CommandLineRunner{
    @Autowired
    private BookRepository repository;
    @Autowired
    private LibraryRepository libraryRepository;

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    /**
     * Este método se ejecuta automáticamente cuado el programa se lanza por consola porque
     * implementa CommandLineRunner
     * @param args
     */
    @Override
    public void run(String... args) {
        // save a few customers
        Library library = new Library(1L, "ff");

        libraryRepository.save(library);
        Book book = new Book(1L, "Viyuela");
        book.setLibrary(library);
        library.addBook(book);
        repository.save(book);
        library = libraryRepository.findById(1L);
        for (Book b : library.getBooks()
             ) {
            System.out.println(b);
        }
    }
}
