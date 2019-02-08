



SELECT book.title
FROM book
WHERE book.id NOT IN(
    SELECT book_id
    FROM checkout_item
    WHERE book_id NOT NULL
);

SELECT movie.title
FROM movie
WHERE movie.id NOT IN(
    SELECT movie_id
    FROM checkout_item
    WHERE movie_id NOT NULL
);




