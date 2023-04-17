import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
public interface IRepository<T> {
     List<T> findAll() throws SQLException;
     T findById(int id) throws SQLException;
     void save(T entity)  throws SQLException;
     void delete(T entity) throws SQLException ;
     T bdToEntity(ResultSet rs) throws SQLException ;
}
