package app.prog.controller.mapper;

import app.prog.controller.response.BookResponse;
import app.prog.controller.response.CreateBookResponse;
import app.prog.controller.response.UpdateBookResponse;
import app.prog.model.AuthorEntity;
import app.prog.model.BookEntity;
import app.prog.service.AuthorService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@AllArgsConstructor
public class BookRestMapper {
    private final AuthorService authorService;

    public BookResponse toRest(BookEntity domain) {
        AuthorEntity author = authorService.getAuthorByName(domain.getAuthor().getName());

        return BookResponse.builder()
                .id(domain.getId())
                .title(domain.getTitle())
                .categories(domain.getCategories())
                .author(author.getName())
                .hasAuthor(domain.hasAuthor())
                .build();
    }

    public BookEntity toDomain(CreateBookResponse rest) {
        var bookEntity = BookEntity.builder();

        AuthorEntity authorEntity = authorService.getAuthorByName(rest.getAuthor());

        return bookEntity
                .title(rest.getTitle())
                .categories(rest.getCategories())
                .author(authorEntity)
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }

    public BookEntity toDomain(UpdateBookResponse rest) {
        var bookEntity = BookEntity.builder();
        var author = rest.getAuthor();

        if (Objects.isNull(author)) {
            AuthorEntity authorEntity = authorService.getAuthorByName(author);
            bookEntity.author(authorEntity);
        }

        return bookEntity
                .id(rest.getId())
                .title(rest.getTitle())
                .categories(rest.getCategories())
                .pageNumber(0) //Constraint not null in database, default value is 0
                .build();
    }
}
