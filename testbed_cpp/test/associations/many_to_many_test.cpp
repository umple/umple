#include <iostream>
#include <cassert>
#include "../RTCpp/Author.h"
#include "../RTCpp/Book.h"


void many_to_many_test() {
    // Create Authors
    Author author1("Author One");
    Author author2("Author Two");

    // Create Books
    Book book1("Book One");
    Book book2("Book Two");

    // Initially, no books are linked with authors
    assert(author1.numberOfBooks() == 0);
    assert(author2.numberOfBooks() == 0);

    // Initially, no authors are linked with books
    assert(book1.numberOfAuthors() == 0);
    assert(book2.numberOfAuthors() == 0);

    // Associate Book1 with Author1 and Author2
    bool added = book1.addAuthor(&author1);
    assert(added == true);
    assert(book1.numberOfAuthors() == 1);
    assert(author1.numberOfBooks() == 1);
    assert(author1.getBook(0) == &book1);

    added = book1.addAuthor(&author2);
    assert(added == true);
    assert(book1.numberOfAuthors() == 2);
    assert(author2.numberOfBooks() == 1);
    assert(author2.getBook(0) == &book1);

    // Associate Book2 with Author1
    added = book2.addAuthor(&author1);
    assert(added == true);
    assert(book2.numberOfAuthors() == 1);
    assert(author1.numberOfBooks() == 2);
    assert(author1.getBook(1) == &book2);

    // Test removing author from a book
    bool removed = book1.removeAuthor(&author1);
    assert(removed == true);
    assert(book1.numberOfAuthors() == 1);
    assert(author1.numberOfBooks() == 1);

    // Test removing book from an author
    removed = author2.removeBook(&book1);
    assert(removed == true);
    assert(author2.numberOfBooks() == 0);
    assert(book1.numberOfAuthors() == 0);

    std::cout << "Many-to-many association test passed successfully." << std::endl;
}

int main() {
    many_to_many_test();
    return 0;
}
