package com.ifi.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import com.ifi.domain.Subj;

public interface SubRepository extends CrudRepository<Subj, Integer>{
	//List<Subj> listSub(String q);
}
