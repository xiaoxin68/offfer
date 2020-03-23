package com.offer.chapter3;

/**
 * ��ʾ��ֵ���ַ���
 * 
 * @Description:
 * @Source: JDK 1.8
 * @Author: ZhangXiaoxin
 * @Date: 2020��2��11��
 * @Since: 1.0
 */
public class problem20 {
	public static void main(String[] args) {
		char[] str = {'1','2','e','1'};
		System.out.println(isNumeric(str));
	}
	
	/**
	 * ��ʽһ���Ƽ�ʹ��
	 */
	private static int inx;
    public static boolean isNumeric(char[] str) {
        if(str==null || str.length==0){
            return false;
        }
        inx = 0;
        boolean flag = scanInteger(str);
        //�ж�С������
        if(inx<str.length && str[inx]=='.'){
            inx = inx+1;
            //֮����ʹ��||����û��ʹ��&&��ԭ��
            //С������û���������֣���.123����0.123��
            //С����������û�����֣���233.����233.0����Ȼ��С����ǰ�󶼿��������֣���1.123��
            flag = scanUInteger(str)||flag;   
        }
        //�ж�ָ������
        if(inx<str.length && (str[inx]=='e' || str[inx]=='E')){
            inx = inx+1;
            flag = flag&&scanInteger(str);
        }
        return flag&& inx>=str.length;
    }

    //�ж��Ƿ�������
    public static boolean scanInteger(char[] str){
        if(inx<str.length &&(str[inx]=='+' || str[inx]=='-')){
            inx = inx+1;
        }
        return scanUInteger(str);
    }

    //�ж��Ƿ����޷�������
    public static boolean scanUInteger(char[] str){
        int inx1=inx;
        while(inx<str.length && str[inx]>='0' && str[inx]<='9'){
           inx = inx + 1;
        }
        return inx>inx1;
    }

	/**
	 * ������ʽ
	 * 
	 * @param str
	 * @return
	 */
	public boolean isNumeric2(char[] str) {
		String string = String.valueOf(str);
		return string.matches("[\\+-]?[0-9]*(\\.[0-9]*)?([eE][\\+-]?[0-9]+)?");
	}

	/**
	 * ����ϵͳ����У�����
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
