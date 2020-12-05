package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.service.dataaccess.borrows.BorrowsData;
import com.library.resources.model.Borrow;

public class BorrowService {
	BorrowsData borrowsData = new BorrowsData();
	private Map<Long, Borrow> borrows;

	public BorrowService() {
		borrows = borrowsData.getAllBorrows();
	}

	public List<Borrow> getAllBorrows() {
		return new ArrayList<Borrow>(borrows.values());
	}
	
	public Borrow getBorrow(long id) {
		Borrow borrow = borrows.get(id);
		return borrow;
	}
	
	public Borrow addBorrow(Borrow borrow) {
//		message.setId(messages.size() + 1);
//		messages.put(message.getId(), message);
//		database action
		return borrow;
	}
	
	public Borrow updateBorrow(Borrow borrow) {
//		if (message.getId() <= 0) {
//			return null;
//		}
//		messages.put(message.getId(), message);
//		database action
		return borrow;
	}
	
	public Borrow deleteBorrow(long id) {
//		database action
		return borrows.remove(id);
	}
}
