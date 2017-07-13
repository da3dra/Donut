package ua.step.smirnova.service;

import java.util.List;

public interface GenericService<E, K> {
	E add(E entity);

	E edit(E entity);

	List<E> getAll();

	void delete(K id);

	public E get(K id);
}
