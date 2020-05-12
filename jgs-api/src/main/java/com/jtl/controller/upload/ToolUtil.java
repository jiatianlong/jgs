package com.jtl.controller.upload;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


public class ToolUtil {

	public static String getChangeMa(int i,int length){
		long time = System.currentTimeMillis();
		String istring = String.valueOf(i);
		while (istring.length() < length) {
			istring = "0" + istring ; 
		}
		return istring+time;
	}

    public static void main(String[] args) {
    	
    
    	System.out.println(betweenDate(getNowDate(), 3));
	}
    
	//获取yyyyMM
	public static String getNowDate_yyyyMM()
	{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyyMM");
		String time=format.format(date);
		return time;
	}
	
	public static String getNowDateStr()
	{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date);
		return time;
	}
	
	public static String getNowDateStr_yyyMMdd()
	{
		Date date=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date);
		return time;
	}
	
	public static Date getNowDate() {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date time = null;
		try {
			time = df.parse(df.format(new Date()));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return time;
	}
	
	  /** 
     * 得到几天后的时间 
     *  
     * @param d 
     * @param day 
     * @return 
     */  
    public static Date getDateAfter(Date d, int day) {  
        Calendar now = Calendar.getInstance();  
        now.setTime(d);  
        now.set(Calendar.DATE, now.get(Calendar.DATE) + day);  
        return now.getTime();  
    }
    
    public static boolean betweenDate(Date d, int day) { 
    	 //System.out.println(d);
       // System.out.println(getNowDate());
        //System.out.println(getDateAfter(getNowDate(),day));
    	if ( d.after( ToolUtil.getNowDate() ) && d.before( ToolUtil.getDateAfter(getNowDate(),day) ) ) 
    		return true;
    	
    	return false;
    }
    
    public static boolean isAfterTodate(Date d) { 
   	 //System.out.println(d);
      // System.out.println(getNowDate());
       //System.out.println(getDateAfter(getNowDate(),day));
   	if ( d.after( ToolUtil.getNowDate()  ) )
   		return true;
   	
   	return false;
   }
    
    //获取当前登录的ip地址
  	public static String getIpAddress() throws UnknownHostException { 
  		InetAddress address = InetAddress.getLocalHost(); 
  		
  		return address.getHostAddress(); 
  	}
  	
   //创建6位随机码
  	public static String getSixRandom(){
  		Random random = new Random();
  		int temp = random.nextInt(999999);
  		while(temp < 100000){
  			temp = random.nextInt(999999);
  		}
  		return String.valueOf(temp);
  	}

    

}
