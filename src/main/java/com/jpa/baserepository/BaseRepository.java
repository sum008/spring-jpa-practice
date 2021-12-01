package com.jpa.baserepository;

import java.util.Optional;

import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

@NoRepositoryBean
public interface BaseRepository<T, I> extends Repository<T, I>{

	<S extends T> S save(S s);
	
	Optional<T> findById(I id);
}
