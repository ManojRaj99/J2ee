package prog1;

public class student {
	
	int age;
	double cgpa;
	String name;
	
  student(String n,int a,double cg){
	  name =n;
	  age=a;
	  cgpa=cg;
  }


 public String toString(){
	 return name+" "+age+" "+cgpa+" ";
 }
}
