package com.library.database.service.dataaccess.borrows;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.library.resources.model.Borrow;

public class BorrowsParser {

	public static Map<Long, Borrow> parseAllBorrows(ResultSet rs) {
		Map<Long, Borrow> borrows = new HashMap<>();
		try {			
			Long i = 1L;
			while (rs.next()) {
				Borrow borrow = new Borrow();
				borrow.setId(rs.getInt("borrows_id"));
				borrow.setDateBorrowed(rs.getString("borrows_date_borrowed"));
				borrow.setReturnDate(rs.getString("borrows_return_date"));
				borrow.setDateReturned(rs.getString("borrows_date_returned"));
				borrow.setIsReturned(rs.getBoolean("borrows_is_returned"));
				borrow.setBookId(rs.getInt("books_id"));
				borrow.setBookTitle(rs.getString("books_title"));
				borrow.setReaderId(rs.getInt("readers_id"));
				borrow.setReaderName(rs.getString("readers_name"));
				borrow.setReaderSurname(rs.getString("readers_surname"));
				
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
