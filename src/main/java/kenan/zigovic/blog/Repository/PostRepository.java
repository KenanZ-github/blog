package kenan.zigovic.blog.Repository;

import kenan.zigovic.blog.model.Post;
import org.springframework.data.repository.CrudRepository;

public interface PostRepository extends CrudRepository<Post,Integer> {
}
