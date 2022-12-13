begin transaction;
alter table book
    drop column author,
    add column author_id int references author(id);
end;