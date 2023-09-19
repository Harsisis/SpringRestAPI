package com.mns.restapimns.mapper;

public interface IMapper<T, V> {
	public V toDto(T entity);
	public T toEntity(V dto);
}
