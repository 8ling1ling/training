package cn.sunline.tiny.demo.service;

import cn.sunline.tiny.demo.mapper.BaseMapper;

public abstract class BaseService<T,PK>{

	public void deleteByPK(PK id) {

		getMapper().deleteById(id);

	}

	public PK insert(T t) {

		return getMapper().insert(t);

	}

	public int update(T t) {

		return getMapper().updateById(t);

	}

	public T selectById(PK id) {

		return getMapper().selectById(id);

	}

	 public abstract BaseMapper<T,PK> getMapper();
}