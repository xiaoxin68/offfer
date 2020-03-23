package com.offer.chapter3;

/**
 * 表示数值的字符串
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020年2月11日
 * @Since: 1.0
 */
public class problem20 {
	public static void main(String[] args) {
		char[] str = {'1','2','e','1'};
		System.out.println(isNumeric(str));
	}
	
	/**
	 * 方式一：推荐使用
	 */
	private static int inx;
    public static boolean isNumeric(char[] str) {
        if(str==null || str.length==0){
            return false;
        }
        inx = 0;
        boolean flag = scanInteger(str);
        //判断小数部分
        if(inx<str.length && str[inx]=='.'){
            inx = inx+1;
            //之所以使用||，而没有使用&&的原因。
            //小数可以没有整数部分，如.123等于0.123；
            //小数点后面可以没有数字，如233.等于233.0；当然，小数点前后都可以有数字，如1.123；
            flag = scanUInteger(str)||flag;   
        }
        //判断指数部分
        if(inx<str.length && (str[inx]=='e' || str[inx]=='E')){
            inx = inx+1;
            flag = flag&&scanInteger(str);
        }
        return flag&& inx>=str.length;
    }

    //判断是否是整数
    public static boolean scanInteger(char[] str){
        if(inx<str.length &&(str[inx]=='+' || str[inx]=='-')){
            inx = inx+1;
        }
        return scanUInteger(str);
    }

    //判断是否是无符号整数
    public static boolean scanUInteger(char[] str){
        int inx1=inx;
        while(inx<str.length && str[inx]>='0' && str[inx]<='9'){
           inx = inx + 1;
        }
        return inx>inx1;
    }

	/**
	 * 正则表达式
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric2(char[] str) {
		String string = String.valueOf(str);
		return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
	}

	/**
	 * 利用系统自身校验机制
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric3(char[] str) {
		try {
			double re = Double.parseDouble(new String(str));
		} catch (NumberFormatException e) {
			return false;
		}
		return true;
	}
}
