package com.library.resources.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.library.database.service.dataaccess.readers.ReadersData;
import com.library.resources.model.Reader;

public class ReaderService {
	// Object that will run queries to database
		ReadersData readersData = new ReadersData();
		// Map with Reader objects created using data from database
		private Map<Long, Reader> readers;

		// Gets all readers from database and saves them as Map into memory for further usage 
		public ReaderService() {
			refreshReaders();
		}
		
		public void refreshReaders() {
			readers = readersData.getAllReaders();
		}

		/**
		 * Gets all readers from Map
		 * 
		 * @return Returns ArrayList of all Readers
		 */
		public List<Reader> getAllReaders() {
			return new ArrayList<Reader>(readers.values());
		}

		/**
		 * Gets all readers from Map
		 * @param id ID of a reader go get
		 * @return Returns a reader for a specified id
		 */
		public Reader getReader(long id) {
			Reader reader = readers.get(id);
			return reader;
		}

		/**
		 * Uses readerData object to add a new reader into database
		 * @param reader Reader object from user used to create entry in database
		 * @return Returns a reader object added to database
		 */
		public Reader addReader(Reader reader) {
			readersData.addReader(reader);
			refreshReaders();
			return reader;
		}

		/**
		 * Uses readersData object to modify existing reader entry in database
		 * @param reader Reader object from user used to make changes in entry in database related to this object
		 * @return Returns a reader object with changes made
		 */
		public Reader updateReader(Reader reader) {
			if (reader.getId() <= 0) {
				return null;
			}
			readersData.updateReader(reader);
			return reader;
		}

		/**
		 * Uses readersData object to archive reader
		 * @param readerId id of a reader that will be archived
		 * @return Returns a reader object that was archived or null if failed to meet conditions
		 */
		public Reader deleteReader(long readerId) {
			if (readers.get(readerId).getIsArchived() == false) {
				readersData.deleteReader(readerId);
				return readers.remove(readerId);
			} else
				return null;
		}
}
