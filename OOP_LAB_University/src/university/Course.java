package university;

public class Course {

	// data about the course
	private String name;
	private String teacher;
	private int id;
	
	// data about students attending the course
	private final int maxStudents = 100;
	private Student[] students = new Student[maxStudents];
	private int nStudents = 0;
	
	public Course(String name, String teacher, int id){
		this.name = name;
		this.teacher = teacher;
		this.id = id;
	}
	
	public String getCourseInfo(){
		return id + " " + name + " " + teacher;
	}

	public void setStudent(Student s){
		
		if( nStudents == maxStudents ){
			System.out.println( "Error: student cannot attend this course because it is full.");
			return;
		}
		
		students[nStudents] = s;	// just assigning a reference
		
		nStudents++;
	}
	
	public String getAttendees(){
		
		StringBuffer list = new StringBuffer("");
		
		if( nStudents != 0 ){
			for(int i=0; i < nStudents; i++)
				list.append(students[i].getStudentInfo() ).append("\n");
			
		} else {
			return "Course " + id + "has no students enrolled.";
		}
		
		// deleting the last \n
		list.delete(list.length()-1,list.length());
		
		return list.toString();
	}
}
