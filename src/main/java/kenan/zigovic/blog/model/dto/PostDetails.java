package kenan.zigovic.blog.model.dto;

import kenan.zigovic.blog.model.Author;
import kenan.zigovic.blog.model.Post;

public record PostDetails(Post post,
                          Author author) {
}
