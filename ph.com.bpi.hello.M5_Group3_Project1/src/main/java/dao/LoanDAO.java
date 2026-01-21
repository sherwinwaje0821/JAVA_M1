
package dao;

import model.Loan;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LoanDAO {


public List<Loan> getAllLoans() throws SQLException {
    List<Loan> loans = new ArrayList<>();

    String sql = 
        "SELECT l.loan_id, b.title, u.name " +
        "FROM loans l " +
        "JOIN books b ON l.book_id = b.book_id " +
        "JOIN users u ON l.user_id = u.user_id";

    try (Connection conn = DBConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql);
         ResultSet rs = ps.executeQuery()) {

        while (rs.next()) {
            loans.add(new Loan(
                    rs.getInt("loan_id"),
                    rs.getString("title"),
                    rs.getString("name")
            ));
        }
    }
    return loans;
}

    public boolean borrowBook(int bookId, int userId) throws SQLException {
        String insertLoan = "INSERT INTO loans (book_id, user_id) VALUES (?, ?)";
        String updateBook = "UPDATE books SET is_available = FALSE WHERE book_id = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            try (PreparedStatement ps1 = conn.prepareStatement(insertLoan);
                 PreparedStatement ps2 = conn.prepareStatement(updateBook)) {

                ps1.setInt(1, bookId);
                ps1.setInt(2, userId);
                ps1.executeUpdate();

                ps2.setInt(1, bookId);
                ps2.executeUpdate();

                conn.commit();
                return true;
            } catch (SQLException e) {
                conn.rollback();
                throw e;
            }
        }
    }

    public boolean returnBook(int loanId) throws SQLException {
        String getBook = "SELECT book_id FROM loans WHERE loan_id = ?";
        String deleteLoan = "DELETE FROM loans WHERE loan_id = ?";
        String updateBook = "UPDATE books SET is_available = TRUE WHERE book_id = ?";

        try (Connection conn = DBConnection.getConnection()) {
            conn.setAutoCommit(false);

            int bookId;
            try (PreparedStatement ps = conn.prepareStatement(getBook)) {
                ps.setInt(1, loanId);
                ResultSet rs = ps.executeQuery();
                if (!rs.next()) return false;
                bookId = rs.getInt(1);
            }

            try (PreparedStatement ps = conn.prepareStatement(deleteLoan)) {
                ps.setInt(1, loanId);
                ps.executeUpdate();
            }

            try (PreparedStatement ps = conn.prepareStatement(updateBook)) {
                ps.setInt(1, bookId);
                ps.executeUpdate();
            }

            conn.commit();
            return true;
        }
    }
}
