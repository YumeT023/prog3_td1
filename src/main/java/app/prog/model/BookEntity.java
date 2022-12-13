package app.prog.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "book")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BookEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;

    @ManyToOne()
    @JoinColumn(name = "author_id")
    private AuthorEntity author;

    @ManyToMany
    @JoinTable(
            name = "book_category_relation",
            joinColumns = @JoinColumn(name = "book.id"),
            inverseJoinColumns = @JoinColumn(name = "category.id")
    )
    private List<CategoryEntity> categories;

    private Integer pageNumber;
    private LocalDate releaseDate;

    public boolean hasAuthor() {
        return author != null;
    }

}
