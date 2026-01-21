
package dao;

import model.Book;
import util.DBConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDAO {

	public List<Book> getAllBooks() throws SQLException {
		List<Book> books = new ArrayList<>();
		String sql = "SELECT * FROM books";

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				books.add(new Book(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"),
						rs.getBoolean("is_available")));
			}
		}
		return books;
	}

	public List<Book> getAvailableBooks() throws SQLException {
		String sql = "SELECT * FROM books WHERE is_available = TRUE";
		List<Book> books = new ArrayList<>();

		try (Connection conn = DBConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {

			while (rs.next()) {
				books.add(new Book(rs.getInt("book_id"), rs.getString("title"), rs.getString("author"), true));
			}
		}
		return books;
	}

	public boolean addBook(Book book) throws SQLException {
		String sql = "INSERT INTO books VALUES (?, ?, ?, TRUE)";
		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, book.getId());
			ps.setString(2, book.getTitle());
			ps.setString(3, book.getAuthor());
			return ps.executeUpdate() == 1;
		}
	}

	public boolean bookExists(int bookId) throws SQLException {
		String sql = "SELECT 1 FROM books WHERE book_id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();
			return rs.next();
		}
	}

	public boolean isBookAvailable(int bookId) throws SQLException {
		String sql = "SELECT is_available FROM books WHERE book_id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, bookId);
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				return rs.getBoolean("is_available");
			}
			return false;
		}
	}

	public boolean deleteBook(int bookId) throws SQLException {
		String sql = "DELETE FROM books WHERE book_id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, bookId);
			return ps.executeUpdate() == 1;
		}
	}

	public void updateBook(int bookId, String title, String author) throws SQLException {

		String sql = "UPDATE books SET " + "title = COALESCE(NULLIF(?, ''), title), "
				+ "author = COALESCE(NULLIF(?, ''), author) " + "WHERE book_id = ?";

		try (Connection conn = DBConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setString(1, title);
			ps.setString(2, author);
			ps.setInt(3, bookId);
			ps.executeUpdate();
		}
	}

}
