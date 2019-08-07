package com.jhbh.jxyqyd.commonenum;

public enum E_DefaultValues {

    /**
     *
     */
	USER_PASSWARD("123456");
	
    private String _value;
    private E_DefaultValues(String value)
    {
        _value = value;
    }

    /**
     * 获取枚举属性的值；
     * @return
     */
    public String value()
    {
        return _value;
    }
    
    /**
     * 返回枚举元素
     * @param code 枚举值
     * @return 枚举元素
     */
    public static E_DefaultValues element(String code) { 
        for(E_DefaultValues s : E_DefaultValues.values()) {
            if(s._value.equals(code)) {
            	return s;
            }
        }
        return null;
    }
}
