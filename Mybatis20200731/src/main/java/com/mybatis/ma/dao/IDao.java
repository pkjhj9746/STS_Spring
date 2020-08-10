package com.mybatis.ma.dao;

import java.util.ArrayList;

import com.mybatis.ma.dto.ContentDto;

public interface IDao {
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mWriter, String mContent);
	public ContentDto viewDao(String strID);
	public void deleteDao(String bId);
}
