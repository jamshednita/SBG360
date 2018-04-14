package com.l360.SBG360.dao;

import java.util.List;

public interface BaseDAO<T> {
	
	T getById(Integer id);
	
	List<T> getAll(Integer limit);
	
	Integer save(T t);
	
	void update(T t);
	
	void delete(T t);

}
