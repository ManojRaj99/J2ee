package prog1;
import java.util.*;
import java.util.HashMap;
public class hashMapStud {
public static void main(String args[]){
	HashMap<String,student> hm = new HashMap<String,student>();
	
	student s1 = new student("name1",20,9.1);
	hm.put("1ms20is068",s1);
	
	student s2 = new student("name2",21,9);
	hm.put("1ms20is069",s2);
	
	student s3= hm.get("1ms20is068");
	System.out.println(s3);
	
	student s4 = new student("name3",18,8.9);
	hm.put("1ms20is106",s4);
	
	student s5 = hm.get("1ms20is106");
	s5.cgpa= 5.8;
	hm.put("1ms20is106", s5);
	System.out.println();
	
	
	
	for(Map.Entry<String, student> h:hm.entrySet())
	{
		System.out.println("key is: "+h.getKey());
		student s = h.getValue();
		System.out.println();
		
		if(s.cgpa>9)
		System.out.println("student cgpa greater than 9 is: \n"+s);
		
	}


	for(Map.Entry<String, student> h:hm.entrySet())
	{
		System.out.println("key is: "+h.getKey());
		student s = h.getValue();
		System.out.println();
		
		if(s.age<21)
		System.out.println("age less than 21 is: : \n"+s);
		
	}
	student s6 = new student("name5",21,9);
	hm.put("1ms20is090",s6);
	System.out.println(hm);
	
	hm.remove("1ms20is090");
	System.out.println(hm);
	
	
}
}
