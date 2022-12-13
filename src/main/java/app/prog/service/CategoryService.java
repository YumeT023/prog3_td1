package app.prog.service;

import app.prog.model.BookEntity;
import app.prog.model.CategoryEntity;
import app.prog.repository.BookRepository;
import app.prog.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class CategoryService {
    private final CategoryRepository repository;

    public List<CategoryEntity> getBooks() {
        return repository.findAll();
    }

    public CategoryEntity getById(Integer id) {
        return repository.getById(id);
    }
}
