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
		refreshBorrowsData();
	}

	private void refreshBorrowsData() {
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
		borrowsData.addBorrow(borrow);
		refreshBorrowsData();
		return borrow;
	}

	public Borrow updateBorrow(long id) {
		if (id <= 0) {
			return null;
		}
		borrowsData.updateBorrow(id);
		refreshBorrowsData();
		return borrows.get(id);
	}
}
