package kenan.zigovic.blog;

import kenan.zigovic.blog.Repository.AuthorRepository;
import kenan.zigovic.blog.Repository.PostRepository;
import kenan.zigovic.blog.model.Author;
import kenan.zigovic.blog.model.Comment;
import kenan.zigovic.blog.model.Post;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jdbc.core.mapping.AggregateReference;

@SpringBootApplication
public class BlogApplication {

	public static void main(String[] args) {
		SpringApplication.run(BlogApplication.class, args);
	}
	@Bean
	CommandLineRunner commandLineRunner (PostRepository postRepository,
	                                     AuthorRepository authorRepository){
	return args -> {
		Author author= authorRepository.save(new Author(null, "Kenan","keno","zigovic.kenan@gmail.com"));
		AggregateReference<Author, Integer> authorAggregateReference = AggregateReference.to(author.id());
		Post post= postRepository.save(new Post("Prvi post","Sadržaj posta",authorAggregateReference));
		post.addComment(new Comment("Moj prvi komentar", "Sadržaj"));
		postRepository.save(post);
	};
}
}
