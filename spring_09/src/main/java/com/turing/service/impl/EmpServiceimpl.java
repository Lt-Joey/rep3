package com.turing.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.turing.entity.Emp;
import com.turing.entity.EmpExample;
import com.turing.entity.EmpExample.Criteria;
import com.turing.mapper.EmpMapper;
import com.turing.service.IEmpService;
@Service
public class EmpServiceimpl implements IEmpService{
	@Autowired
	private EmpMapper empMapper;
	@Override
	public List<Emp> findAll() {
		return empMapper.selectByExample(null);
	}
	@Override
	public boolean findByName(String name) {
		EmpExample example=new EmpExample();
		Criteria criteria = example.createCriteria();
		criteria.andEnameEqualTo(name);
		List<Emp> list = empMapper.selectByExample(example);
		return list.size()>0?true:false;
	}
	@Override
	public int addEmp(Emp emp) {
		return empMapper.insert(emp);
	}

}
