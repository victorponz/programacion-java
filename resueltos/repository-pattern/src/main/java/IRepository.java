import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public interface IRepository<T> {
    public List<T> findAll() throws SQLException;
    public T findById(int id) throws SQLException;
    public void save(T entity)  throws SQLException;
    public void delete(User user) throws SQLException ;
    public T bdToEntity(ResultSet rs) throws SQLException ;
}
