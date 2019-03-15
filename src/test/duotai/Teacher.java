package test.duotai;

public class Teacher {
	public void teach(){
		
	}
	
	public static void main(String[] args) {
		Teacher t1 = new ChineseTeacher();
		t1.teach();
		System.out.println(t1.getClass().getName());
		Teacher t2 = new Math_Teacher();
		t2.teach();
	}
}
