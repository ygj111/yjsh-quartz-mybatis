package com.hhh.scheduler.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.hhh.scheduler.domain.JobInfo;

@Mapper
public interface JobInfoMapper {

	@Select("select id, name, note, group_name as groupName, trigger_name as triggerName, trigger_group_name as triggerGroupName,"
			+ " job_class as jobClass, cron_expression as CronExpression from sys_scheduler_jobinfo where name=#{name}")
	public JobInfo findByName(@Param("name")String name);
	
	@Delete("delete from sys_scheduler_jobinfo where name=#{name}")
	public void deleteByName(@Param("name")String name);
	
	@Select("select id, name, note, group_name as groupName, trigger_name as triggerName, trigger_group_name as triggerGroupName,"
			+ " job_class as jobClass, cron_expression as CronExpression from sys_scheduler_jobinfo")
	public List<JobInfo> findAll();
	
	@Select("select id, name, note, group_name as groupName, trigger_name as triggerName, trigger_group_name as triggerGroupName,"
			+ " job_class as jobClass, cron_expression as CronExpression from sys_scheduler_jobinfo where id=#{id}")
	public JobInfo findOne(@Param("id")String id);
	
	@Insert("insert into sys_scheduler_jobinfo(id, name, note, group_name, trigger_name, trigger_group_name, job_class, cron_expression)values"
			+ "(#{id}, #{name}, #{note}, #{groupName}, #{triggerName}, #{triggerGroupName}, #{jobClass}, #{CronExpression})")
	public void add(JobInfo job);
	
	@Update("update sys_scheduler_jobinfo set note=#{note}, group_name=#{groupName}, trigger_name=#{triggerName}, trigger_group_name=#{triggerGroupName}"
			+ ", job_class=#{jobClass}, cron_expression=#{CronExpression} where name=#{name}")
	public void update(JobInfo job);
	
	@Delete("delete from sys_scheduler_jobinfo where id=#{id}")
	public void delete(@Param("id")String id);
}
