package com.hhh.scheduler.domain;

import java.io.Serializable;


/**
 * 调度框架的工作任务数据信息
 * @author 3hhjj
 *
 */
public class JobInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1325470182061563592L;
	
	private String id;
	
	/**
	 * 任务名称(英文字符)
	 */
	private String name;
	
	/**
	 * 任务描述
	 */
	private String note;
	
	/**
	 * 任务分组名
	 */
	private String groupName;
	
	/**
	 * 触发器名
	 */
	private String triggerName;
	
	/**
	 * 触发器组名
	 */
	private String triggerGroupName;
	
	/**
	 * 任务
	 */
	private String jobClass;
	
	/**
	 * corn表达式
	 */
	private String CronExpression;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGroupName() {
		return groupName;
	}

	public void setGroupName(String groupName) {
		this.groupName = groupName;
	}

	public String getTriggerName() {
		return triggerName;
	}

	public void setTriggerName(String triggerName) {
		this.triggerName = triggerName;
	}

	public String getTriggerGroupName() {
		return triggerGroupName;
	}

	public void setTriggerGroupName(String triggerGroupName) {
		this.triggerGroupName = triggerGroupName;
	}

	public String getJobClass() {
		return jobClass;
	}

	public void setJobClass(String jobClass) {
		this.jobClass = jobClass;
	}

	public String getCronExpression() {
		return CronExpression;
	}

	public void setCronExpression(String cronExpression) {
		CronExpression = cronExpression;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

}
