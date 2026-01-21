
package model;

public class Loan {
    private int loanId;
    private String bookTitle;
    private String userName;

    public Loan(int loanId, String bookTitle, String userName) {
        this.loanId = loanId;
        this.bookTitle = bookTitle;
        this.userName = userName;
    }

    public int getLoanId() { return loanId; }
    public String getBookTitle() { return bookTitle; }
    public String getUserName() { return userName; }
}
