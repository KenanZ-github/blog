package kenan.zigovic.blog.Controller;

import kenan.zigovic.blog.Repository.AuthorRepository;
import kenan.zigovic.blog.Repository.PostRepository;
import kenan.zigovic.blog.model.Post;
import kenan.zigovic.blog.model.dto.PostDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/posts")
public class PostController {
    private final PostRepository postRepository;
    private final AuthorRepository authorRepository;

    public PostController(PostRepository postRepository, AuthorRepository authorRepository) {
        this.postRepository = postRepository;
        this.authorRepository = authorRepository;
    }

    @GetMapping
    public Iterable<Post> findAll(){
        return postRepository.findAll();
    }

    @GetMapping("/{id}")
    public Post findById (@PathVariable Integer id){
        return postRepository.findById(id).orElse(null);
    }
    @GetMapping("{id}/details")
    public PostDetails getPostDetails (@PathVariable int id){
        Post post = postRepository.findById(id).orElse(null);
        return new PostDetails(post,authorRepository.findById(post.getAuthor().getId()).get());

    }
}
