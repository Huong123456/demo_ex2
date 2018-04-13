package com.ifi.service;

import java.util.List;

import com.ifi.domain.Subj;


public interface SubService {
	Iterable<Subj> findAll();

   // List<Subj> search(String q);

    Subj findOne(int id);

    void save(Subj subj);

    void delete(int id);

}
