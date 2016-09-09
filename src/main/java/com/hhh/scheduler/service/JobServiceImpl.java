package com.hhh.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hhh.scheduler.domain.JobInfo;
import com.hhh.scheduler.mapper.JobInfoMapper;

@Service
@Transactional
public class JobServiceImpl implements JobService {
	
	@Autowired
	private JobInfoMapper jobDao;

	@Override
	@Transactional(readOnly=true)
	public List<JobInfo> findJobAll() {
		List<JobInfo> list = jobDao.findAll();
		return list;
	}

	@Transactional(readOnly=true)
	@Override
	public JobInfo findJobById(String id) {
		return jobDao.findOne(id);
	}

	@Transactional(readOnly=true)
	@Override
	public JobInfo findJobByName(String name) {
		return jobDao.findByName(name);
	}

	@Override
	public JobInfo saveJob(JobInfo job) {
		if(job.getId() == null || "".equals(job.getId())){
			job.setId(getPrimaryKey());
			jobDao.add(job);
		}else{
			jobDao.update(job);
		}
		
		return job;
	}
	
	@Override
	public JobInfo addJob(JobInfo job){
		if(findJobByName(job.getName()) == null){
			job = saveJob(job);
		}
		return job;
	}

	@Override
	public void deleteJobById(String id) {
		jobDao.delete(id);
	}

	@Override
	public void deleteJobByName(String name) {
		jobDao.deleteByName(name);
	}

	
	private String getPrimaryKey() {
		return java.util.UUID.randomUUID().toString().replace("-", "");
	}
}
