package com.jiaoshen.dto;

import com.jiaoshen.enpty.SuccessKilled;
import com.jiaoshen.enums.SeckillStatEnum;

public class SeckillExecution {
  
	private long seckillId;
  
    private int state;
    
    private String stateInfo;
    
    private SuccessKilled successKilled;

	public long getSeckillId() {
		return seckillId;
	}

	public void setSeckillId(long seckillId) {
		this.seckillId = seckillId;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getStateInfo() {
		return stateInfo;
	}

	public void setStateInfo(String stateInfo) {
		this.stateInfo = stateInfo;
	}

	public SuccessKilled getSuccessKilled() {
		return successKilled;
	}

	public void setSuccessKilled(SuccessKilled successKilled) {
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId,SeckillStatEnum statenum, SuccessKilled successKilled) {
		super();
		this.seckillId = seckillId;
		this.state = statenum.getState();
		this.stateInfo = statenum.getStateinfo();
		this.successKilled = successKilled;
	}

	public SeckillExecution(long seckillId, SeckillStatEnum statenum) {
		super();
		this.seckillId = seckillId;
		this.state = statenum.getState();
		this.stateInfo = statenum.getStateinfo();
	}
    
    
  
}
