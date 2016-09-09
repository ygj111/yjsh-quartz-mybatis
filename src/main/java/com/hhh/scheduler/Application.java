package com.hhh.scheduler;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.hhh.config.DruidConfig;
import com.hhh.config.QuartzConfiguration;
import com.hhh.scheduler.domain.JobInfo;
import com.hhh.scheduler.service.QuartzManager;

@SpringBootApplication
@EnableTransactionManagement
@Import({DruidConfig.class, QuartzConfiguration.class})
public class Application {
	
    private final static String DEFAULT_JOB_GROUP_NAME = "hhh_Quartz_Default_Group";  
    private final static String DEFAULT_TRIGGER_GROUP_NAME = "hhh_Quartz_Default_TriggerGroup";
    
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	
	/**
	 * 启动工作任务
	 * @param manager
	 * @return
	 */
	@Bean
	CommandLineRunner lookup(final QuartzManager manager){
		return new CommandLineRunner() {
			@Override
			public void run(String... args) throws Exception {
			/**********************初始化任务数据*****************************/
				/*
				 * 初始化数据，根据任务名称进行，如果数据库表中已存在此任务名称的任务，数据将会被丢弃
				 * 所有的任务实现放在job包中
				 */
				JobInfo job = new JobInfo();
				job.setName("test_job_name");//任务名称必须唯一
				job.setGroupName(DEFAULT_JOB_GROUP_NAME);
				job.setTriggerName("test_job_trigger_name");//触发器名在一个触发器分组中必须唯一
				job.setTriggerGroupName(DEFAULT_TRIGGER_GROUP_NAME);
				job.setJobClass("com.hhh.scheduler.job.MyTestJob");
				job.setCronExpression("10/50 * * * * ?");
				manager.addJob(job);
				
			/**********************初始化任务数据*****************************/
				
				
				manager.startJobs();
			}
		};
	}
}
