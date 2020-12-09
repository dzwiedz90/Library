package com.library.database.service.dataaccess.borrows;

import java.util.HashMap;
import java.util.Map;

import com.library.database.service.wrappers.StatementExecutor;
import com.library.resources.model.Borrow;

public class BorrowsData {

	public Map<Long, Borrow> getAllBorrows() {
		Map<Long, Borrow> borrows = new HashMap<>();

		String query = "SELECT br.borrows_id, br.borrows_date_borrowed, br.borrows_return_date, br.borrows_is_returned, b.books_id, b.books_title, r.readers_id, r.readers_name, r.readers_surname FROM borrows AS br INNER JOIN books AS b ON br.books_id=b.books_id INNER JOIN readers AS r ON br.readers_id=r.readers_id;";
		StatementExecutor wrapper = new StatementExecutor(query, "query");
		borrows = BorrowsParser.parseAllBorrows(wrapper.rs);
		wrapper.closeConnection();

		return borrows;
	}

	public boolean checkIfBorrowed(long bookId) {
		String query = "SELECT borrows_is_returned FROM borrows  WHERE books_id=" + bookId
				+ " AND borrows_is_returned=0;";
		StatementExecutor wrapper = new StatementExecutor(query, "query");
		if (wrapper.checkData() == true) {
			wrapper.closeConnection();
			return true;
		} else
			wrapper.closeConnection();
		return false;
	}
}
