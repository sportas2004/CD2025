# Diagrama de Clases

```mermaid
classDiagram
    class Book {
        - String isbn
        - String title
        - boolean available
        + Book(String isbn, String title)
        + String getIsbn()
        + String getTitle()
        + boolean isAvailable()
        + void borrow()
        + void giveBack()
    }

    class User {
        - String id
        - String name
        - List<Loan> loans
        + User(String id, String name)
        + String getName()
        + String getId()
        + List<Loan> getLoans()
        + void addLoan(Loan loan)
        + void removeLoan(Loan loan)
    }

    class Loan {
        - Book book
        - User user
        - LocalDate startDate
        - LocalDate endDate
        + Loan(Book book, User user)
        + Book getBook()
        + User getUser()
        + LocalDate getStartDate()
        + void closeLoan()
        + boolean isActive()
    }

    class LibraryService {
        - Map<String, Book> books
        - Map<String, User> users
        + void addBook(Book book)
        + void addUser(User user)
        + Loan borrowBook(String isbn, String userId)
        + void returnBook(Loan loan)
    }

    LibraryService "1" --> "*" Book : gestiona
    LibraryService "1" --> "*" User : gestiona
    User "1" --> "*" Loan : tiene
    Loan "1" --> "1" Book : presta
    Loan "1" --> "1" User : pertenece a
```

## Descripción de las clases

- `Book`: representa un libro con ISBN, título y disponibilidad.
- `User`: representa un usuario con identificador, nombre y lista de préstamos.
- `Loan`: representa un préstamo entre un libro y un usuario, con fecha de inicio y estado activo.
- `LibraryService`: gestiona el catálogo de libros, usuarios y operaciones de préstamo y devolución.
