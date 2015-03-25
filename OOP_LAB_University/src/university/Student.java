package university;

public class Student {

	// data about the student
	private String first;
	private String last;
	private int id;
	
	// data about the courses attended by the student
	private final int maxCourses = 25;
	private Course[] courses = new Course[maxCourses];
	private int nCourses = 0;
	
	public Student(String first, String last, int id){
		this.first = first;
		this.last = last;
		this.id = id;
	}
	
	public int getStudentId(){
		return id;
	}
	
	public String getStudentInfo(){
		return id + " " + first + " " + last;
	}
	
	public void setCourse(Course c){
		
		if( nCourses == maxCourses ){
			System.out.println( "Error: student cannot attend further courses.");
			return;
		}
		courses[nCourses] = c;	// just assigning a reference
		nCourses++;
	}
	
	public String getStudyPlan(){
		
		StringBuffer list = new StringBuffer("");
		
		if( nCourses != 0 ){
			for(int i=0; i < nCourses; i++){
				list.append(courses[i].getCourseInfo() );
				if( i != (nCourses-1) )	//TODO: This doesn't work! Try to delete the last \n after for construct
					list.append("\n");
			}
		}else{ 
			return "Student " + id + " has no active course";
		}

		return list.toString();
	}
	
	
}
