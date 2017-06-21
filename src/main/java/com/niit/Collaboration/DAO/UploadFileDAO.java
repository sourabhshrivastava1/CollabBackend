package com.niit.Collaboration.DAO;

import com.niit.Collaboration.model.UploadFile;

public interface UploadFileDAO {

	void save(UploadFile uploadFile);

	UploadFile getFile(int username);
}
