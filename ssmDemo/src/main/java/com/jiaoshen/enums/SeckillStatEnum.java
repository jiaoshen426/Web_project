package com.jiaoshen.enums;

/**状态枚举表
 * 
 * @author jiaoshen
 * @date   2017年12月28日
 */
public enum SeckillStatEnum {
	SUCCESS(1,"秒杀成功"),
	END(0,"秒杀结束"),
	REPEAT_KILL(-1,"重复秒杀"),
	INNER_ERROR(-2,"系统异常"),
	DATA_REWRITE(-3,"数据异常");
	private String stateinfo;
	
	private  int state;

	public String getStateinfo() {
		return stateinfo;
	}

	public int getState() {
		return state;
	}

	private SeckillStatEnum( int state,String stateinfo) {
		this.stateinfo = stateinfo;
		this.state = state;
	}
	
	public static SeckillStatEnum stateof(int index){
		for(SeckillStatEnum state : values()){
			if(state.getState() == index){
				return state;
			}
		}
		return null;
	}
    
}
