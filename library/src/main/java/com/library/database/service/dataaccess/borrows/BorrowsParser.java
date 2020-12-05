package com.library.database.service.dataaccess.borrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.library.resources.model.Book;
import com.library.resources.model.Borrow;

public class BorrowsParser {
	
	public static Map parseAllBorrows(ResultSet rs) {
		Map<Long, Borrow> borrows = new HashMap<>();
		try {
			Long i = 1L;
			while (rs.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(rs.getInt("books_id"));
				borrow.setDateBorrowed(rs.getString("books_title"));
				borrow.setReturnDate(rs.getString("books_isbn"));
				borrow.setIsReturned(rs.getBoolean("books_year_published"));
				borrow.setBookId(rs.getInt("authors_name"));
				borrow.setBookTitle(rs.getString("authors_surname"));
				borrow.setReaderId(rs.getInt("publishers_name"));
				borrow.setReaderName(rs.getString("publishers_name"));
				borrow.setReaderSurname(rs.getString("publishers_name"));

				borrows.put(i, borrow);
				i++;
			}
		} catch (SQLException e) {
			System.out.print(e.getMessage());
			e.printStackTrace();
		}
		return borrows;
	}
}
