package university;

public class University {
	
	// data about university
	private String universityName;
	
	// data about the rector
	private String rectorFirst;
	private String rectorLast;
	
	// data about students
	private final int studentsStartingId = 10000;
	private int nStudents = 0;
	private final int maxStudents = 1000;
	private Student[] students = new Student[maxStudents];
	
	// data about courses
	private final int coursesStartingId = 10;
	private int nCourses = 0;
	private final int maxCourses = 50;
	private Course[] courses = new Course[maxCourses];


	/**
	 * When a university is created, an array of students "maxStudents" long it's created.
	 * @param name of University
	 */
	
	public University(String name){
		universityName = name;
	}
	
	public String getName(){
		return universityName;
	}
	
	public void setRector(String first, String last){
		rectorFirst = first;
		rectorLast = last;
	}
	
	public String getRector(){
		return rectorFirst + " " + rectorLast;
	}
	
	public int enroll(String first, String last){
		int id = nStudents + studentsStartingId;
		
		// check (is the university full?)
		if( nStudents == maxStudents ){
			System.out.println( "Error: University is full. Cannot accept other students." );
			return -1;
		}
		
		students[nStudents] = new Student(first, last, id);
		nStudents++;
		return id;
	}
	
	public String student(int id){
		int position = id - studentsStartingId;
		String info;
		
		if( position > nStudents )
			info = "Student " + id + " is not registered.";
		else
			info = students[position].getStudentInfo();
		
		return info;
	}
	
	public int activate(String title, String teacher){
		int id = nCourses + coursesStartingId;
		
		// check (is courses' array full?)
		if( nCourses == maxCourses){
			System.out.println( "Error: a new course cannot be activated.");
			return -1;
		}
		
		courses[nCourses] = new Course(title, teacher, id);
		nCourses++;
		return id;
	}
	
	public String course(int code){
		int position = code - coursesStartingId;
		String info;
		
		if( position > nCourses )
			info = "The course " + code + " doen't exist.";
		else
			info = courses[position].getCourseInfo();
			
		return info;
	}
	
	public void register(int studentID, int courseCode){
		int id = studentID - studentsStartingId;
		int code = courseCode - coursesStartingId;
		
		students[id].setCourse(courses[code]);
		courses[code].setStudent(students[id]);
	}
	
	public String listAttendees(int courseCode){
		int code = courseCode - coursesStartingId;
		
		return courses[code].getAttendees();
	}

	public String studyPlan(int studentID){
		int id = studentID - studentsStartingId;
		
		return students[id].getStudyPlan();
	}
}
