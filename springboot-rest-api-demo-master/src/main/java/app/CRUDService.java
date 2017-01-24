package app;

import java.util.List;

public interface CRUDService<E> {

	E save(E entity);

	E getById(String id);

	List<E> getAll();

	void delete(String id);
}
