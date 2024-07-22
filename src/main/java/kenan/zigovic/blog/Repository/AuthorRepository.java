package kenan.zigovic.blog.Repository;

import kenan.zigovic.blog.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Integer> {
}
