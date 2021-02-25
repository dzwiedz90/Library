package com.library.database.service.dataaccess.borrows;

import java.util.HashMap;
import java.util.Map;

import com.library.database.service.executors.StatementExecutor;
import com.library.resources.model.Borrow;

public class BorrowsData {

	public Map<Long, Borrow> getAllBorrows() {
		Map<Long, Borrow> borrows = new HashMap<>();

		String query = "SELECT br.borrows_id, br.borrows_date_borrowed, br.borrows_return_date, br.borrows_is_returned, br.borrows_date_returned, b.books_id, b.books_title, r.readers_id, r.readers_name, r.readers_surname FROM borrows AS br INNER JOIN books AS b ON br.books_id=b.books_id INNER JOIN readers AS r ON br.readers_id=r.readers_id;";
		StatementExecutor executor = new StatementExecutor(query, "query");
		borrows = BorrowsParser.parseAllBorrows(executor.rs);
		executor.closeConnection();

		return borrows;
	}

	public boolean checkIfBorrowed(long bookId) {
		String query = "SELECT borrows_is_returned FROM borrows  WHERE books_id=" + bookId
				+ " AND borrows_is_returned=0;";
		StatementExecutor executor = new StatementExecutor(query, "query");
		if (executor.checkData() == true) {
			executor.closeConnection();
			return true;
		} else
			executor.closeConnection();
		return false;
	}

	public void addBorrow(Borrow borrow) {
		String query = "INSERT INTO borrows(books_id, readers_id, borrows_date_borrowed, borrows_return_date, borrows_is_returned) "
				+ "VALUES(" + borrow.getBookId() + ", " + borrow.getReaderId() + ", '" + borrow.getDateBorrowed()
				+ "', '" + borrow.getReturnDate() + "', " + borrow.getIsReturned() + ");";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}

	public void updateBorrow(long id) {
		String query = "UPDATE borrows SET borrows_is_returned=1, borrows_date_returned='18.02.2021' WHERE borrows_id="+id+";";
		StatementExecutor executor = new StatementExecutor(query, "update");
		executor.closeConnection();
	}
}
