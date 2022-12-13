create table book_category_relation (
    book_id int references book(id),
    category_id int references category(id)
);