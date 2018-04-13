package com.ifi.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ifi.domain.Subj;
import com.ifi.repository.SubRepository;

@Service
public class SubServiceImpl implements SubService{
	@Autowired
	private SubRepository subRepository;

	@Override
	public Iterable<Subj> findAll() {
		// TODO Auto-generated method stub
		return subRepository.findAll();
	}

//	@Override
//	public List<Subj> search(String q) {
//		// TODO Auto-generated method stub
//		return subRepository.listSub(q);
//	}

	@Override
	public Subj findOne(int id) {
		// TODO Auto-generated method stub
		return subRepository.findOne(id);
	}

	@Override
	public void save(Subj subj) {
		// TODO Auto-generated method stub
		subRepository.save(subj);

	}

	@Override
	public void delete(int idsub) {
		// TODO Auto-generated method stub
		subRepository.delete(idsub);

	}

}
