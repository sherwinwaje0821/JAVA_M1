
package app;

import dao.BookDAO;
import dao.LoanDAO;
import dao.UserDAO;
import model.Book;
import model.Loan;
import model.User;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class LibraryApplication {

    private final Scanner scanner = new Scanner(System.in);

    private final BookDAO bookDAO = new BookDAO();
    private final LoanDAO loanDAO = new LoanDAO();
    private final UserDAO userDAO = new UserDAO();

    private User currentUser;

 
    public void start() {
        try {
            initUser();
            menuLoop();
        } catch (SQLException e) {
            System.out.println("❌ Database error: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }

  
    private void initUser() throws SQLException {
        System.out.print("Enter User ID: ");
        int userId = readInt();

        User user = userDAO.getUserById(userId);

        if (user == null) {
            System.out.print("User not found. Enter name to register: ");
            String name = scanner.nextLine();
            user = new User(userId, name);
            userDAO.addUser(user);
            System.out.println("✅ User registered.");
        }

        currentUser = user;
        System.out.println("Welcome, " + currentUser.getName());
    }

 
    private void menuLoop() throws SQLException {
        while (true) {
            printMenu();

            int choice = readInt();

            switch (choice) {
                case 1:
                    displayAllBooks();
                    break;
                case 2:
                    displayAvailableBooks();
                    break;
                case 3:
                    displayBorrowedBooks();
                    break;
                case 4:
                    borrowBook();
                    break;
                case 5:
                    returnBook();
                    break;
                case 6:
                    addBook();
                    break;
                case 7:
                    removeBook();
                    break;
                case 8:
                    updateBook();
                    break;
                case 0:
                    System.out.println("📚 Library closed.");
                    return;
                default:
                    System.out.println("❌ Invalid choice.");
            }
        }
    }

 
    private void printMenu() {
        System.out.println("\n========= LIBRARY MENU =========");
        System.out.println("[1] Display All Books");
        System.out.println("[2] Display Available Books");
        System.out.println("[3] Display All Borrowed Books");
        System.out.println("[4] Borrow Book");
        System.out.println("[5] Return Book");
        System.out.println("[6] Add Book");
        System.out.println("[7] Remove Book");
        System.out.println("[8] Update Book");
        System.out.println("[0] Exit");
        System.out.print("Select option: ");
    }

   
    private void displayAllBooks() throws SQLException {
        List<Book> books = bookDAO.getAllBooks();
        System.out.println("\nID | Title | Author | Available");

        for (Book b : books) {
            System.out.println(
                    b.getId() + " | " +
                            b.getTitle() + " | " +
                            b.getAuthor() + " | " +
                            b.isAvailable()
            );
        }
    }

 
    private void displayAvailableBooks() throws SQLException {
        List<Book> books = bookDAO.getAvailableBooks();
        System.out.println("\nID | Title | Author");

        for (Book b : books) {
            System.out.println(b.getId() + " | " + b.getTitle() + " | " + b.getAuthor());
        }
    }

 
    private void displayBorrowedBooks() throws SQLException {
        List<Loan> loans = loanDAO.getAllLoans();
        System.out.println("\nLoan ID | Book Title | Borrower");

        for (Loan l : loans) {
            System.out.println(
                    l.getLoanId() + " | " +
                            l.getBookTitle() + " | " +
                            l.getUserName()
            );
        }
    }

 
    private void borrowBook() throws SQLException {
        displayAvailableBooks();

        System.out.print("Enter Book ID to borrow: ");
        int bookId = readInt();

        if (!bookDAO.bookExists(bookId)) {
            System.out.println("❌ Book does not exist.");
            return;
        }

        if (!bookDAO.isBookAvailable(bookId)) {
            System.out.println("❌ Book already borrowed.");
            return;
        }

        loanDAO.borrowBook(bookId, currentUser.getId());
        System.out.println("✅ Book borrowed successfully.");
    }

  
    private void returnBook() throws SQLException {
        displayBorrowedBooks();

        System.out.print("Enter Loan ID to return: ");
        int loanId = readInt();

        if (!loanDAO.returnBook(loanId)) {
            System.out.println("❌ Loan not found.");
        } else {
            System.out.println("✅ Book returned successfully.");
        }
    }

 
    private void addBook() throws SQLException {
        System.out.print("Book ID: ");
        int id = readInt();

        if (bookDAO.bookExists(id)) {
            System.out.println("❌ Book ID already exists.");
            return;
        }

        System.out.print("Title: ");
        String title = scanner.nextLine();

        System.out.print("Author: ");
        String author = scanner.nextLine();

        bookDAO.addBook(new Book(id, title, author, true));
        System.out.println("✅ Book added.");
    }

 
    private void removeBook() throws SQLException {
        System.out.print("Enter Book ID to remove: ");
        int id = readInt();

        if (!bookDAO.bookExists(id)) {
            System.out.println("❌ Book not found.");
            return;
        }

        bookDAO.deleteBook(id);
        System.out.println("✅ Book removed.");
    }

 
    private void updateBook() throws SQLException {
        System.out.print("Enter Book ID: ");
        int id = readInt();

        if (!bookDAO.bookExists(id)) {
            System.out.println("❌ Book not found.");
            return;
        }

        if (!bookDAO.isBookAvailable(id)) {
            System.out.println("❌ Cannot update borrowed book.");
            return;
        }

        System.out.print("New title (leave blank to keep): ");
        String title = scanner.nextLine();

        System.out.print("New author (leave blank to keep): ");
        String author = scanner.nextLine();

        bookDAO.updateBook(id, title, author);
        System.out.println("✅ Book updated.");
    }

 
    private int readInt() {
        while (!scanner.hasNextInt()) {
            scanner.next(); 
            System.out.print("Enter a valid number: ");
        }
        int value = scanner.nextInt();
        scanner.nextLine(); 
        return value;
    }
}
