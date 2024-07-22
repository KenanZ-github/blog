package kenan.zigovic.blog.model;

import org.springframework.data.annotation.Id;

public record Author(
                     @Id
                     Integer id,
                     String name,
                     String userName,
                     String email) {
}
