package com.hhh.scheduler.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MyTestJob implements Job {

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException {
		System.out.println("spring-boot Mybatis Quartz 测试正在运行, ha ha ha >>>>>>>>>>>>>>>>>>>>>>>");

	}

}
