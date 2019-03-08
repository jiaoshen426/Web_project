package com.jiaoshen.enums;

/**״̬ö�ٱ�
 * 
 * @author jiaoshen
 * @date   2017��12��28��
 */
public enum SeckillStatEnum {
	SUCCESS(1,"��ɱ�ɹ�"),
	END(0,"��ɱ����"),
	REPEAT_KILL(-1,"�ظ���ɱ"),
	INNER_ERROR(-2,"ϵͳ�쳣"),
	DATA_REWRITE(-3,"�����쳣");
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
