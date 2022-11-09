import javax.swing.*;

/**
 * courselisting class manages a set of the course that we we provide in the code
 *
 * Group Activity
 * @author Nepa1 Batch10
 */

public class CourseListingSystem  {
	
	//------------PUBLIC DATA MEMBERS---------------------------
	/**
	 * The maximum number of results that the system will display when reporting
	 * more than one search result.
	 */
	public static final int MAX_RESULTS_DISPLAYED = 10;
   
	//------------PRIVATE DATA MEMBERS--------------------------
	/**
	 * Contains information on all courses.
	 */
	private Courses courseArray[];
	
	//---------------CONSTRUCTOR---------------------------------
	/**
	 * Initializes all private data members to appropriate values.
	 */
	public CourseListingSystem()  {
		// Create the Array
		courseArray = new Courses[12];
		// Create the Course Objects in the Array
		for (int i = 0; i <= 11; i++) {
			courseArray[i] = new Courses();
		}
		loadData();
	}  // end constructor
	
	//-------------OTHER METHODS---------------------------
	/**
	 * This method asks the user for search terms and matches them with
	 * individual courses.  It asks for new or more precise searches
	 * until it comes up with a single unique entry, which it returns.
	 */
	public Courses findCourse(){
		
		String inputString, results;
		int numberOfMatches = 0;
		Courses foundCourse = new Courses();

		// 1. Get value from the user
		try {
			inputString = JOptionPane.showInputDialog(null,
					"Please enter all or part of the course name, course number,"
					+ " or instructor name to select a course.", null);
		
			// 2. Determine if you can find a specific course, if not, ask the 
			//    user for more information to help determine the course.
		
			do {
				
				numberOfMatches = 0;
				results = "";
				
				/* Search through courseArray for anything matching the search string.
				 * Matches are recorded in the 'results' String for the user's benefit,
				 * to be listed off in an input dialog.
				 */
				for (int i = 0; i <= 11; i++) {
					if (matchesInput(courseArray[i], inputString)) {
						numberOfMatches++;
						foundCourse = courseArray[i];
						if (numberOfMatches < MAX_RESULTS_DISPLAYED)
							results = results.concat(
								courseArray[i].getCourseName() + ", " +
								courseArray[i].getcourseId() + " taught by "
								+ courseArray[i].getInstructorName() + "\n");
						else if (numberOfMatches == MAX_RESULTS_DISPLAYED)
							results = results.concat("\nThe system found too many results to fully display.\n");
					}// end if
				}// end for

				if (numberOfMatches > 1)
				{
					inputString = (JOptionPane.showInputDialog(null,
							"The system found " + numberOfMatches + " results that matched \""
							+ inputString + "\".\n\n"
							+ results
							+ "\nPlease enter at least one more character from the course name,"
							+ " course number, or instructor name to narrow your results:", inputString));
				}// end if
				else if (numberOfMatches < 1)
				{
					inputString = JOptionPane.showInputDialog(null,
							"The system could not find any matches for \""
							+ inputString + "\".\n\nPlease enter a new statement:", inputString);
				}// end if
			// The loop exits when exactly one match is found.
			}while (numberOfMatches != 1);

		// 3. Once determined as unique, return the Courses object to the user.
		} catch (NullPointerException e){
			// Alternately, if the user cancels out of an input dialog, simply return
			// a blank course.
			return null;
		}
		
		return foundCourse;
		
    }//end findCourse
    
	/**
	 * This method returns true if the user's complete input is found
	 * anywhere in the course name, course number, or instructor name.
	 * @param courseValue The Courses object being examined.
	 * @param inputString The search string entered by the user so far.
	 * @return <code>boolean</code> The result of the comparison.
	 */
	public boolean matchesInput(Courses courseValue, String inputString){
        
	    	boolean matches = false;
		
			inputString = inputString.toLowerCase();
		
			// Determine if the specific course passed in matches the input
			// from the user that is also passed into the method.  If so, pass
			// true back to the caller.  If not, return false back to the caller.
		
			if (courseValue.getCourseName().toLowerCase().contains(inputString)
					|| courseValue.getcourseId().toLowerCase().contains(inputString)
					|| courseValue.getInstructorName().toLowerCase().contains(inputString))
				matches = true;

			return matches;

	}//end of runListing

	/**
	 * This method loads the course information.  
	 */
	public void loadData()  {
		courseArray[0].setCourseName("Software Engineering");
		courseArray[0].setcourseId("18CS51");
		courseArray[0].setCreditHours(3);
		courseArray[0].setScheduledTime("4:00 -5:00 pm");
		courseArray[0].setScheduledDays("MWF");
		courseArray[0].setScheduledRoom("S501");
		courseArray[0].setInstructorName("Prof. Praveena M.V");
		
		courseArray[1].setCourseName("Java Programming");
		courseArray[1].setcourseId("18CS52");
		courseArray[1].setCreditHours(4);
		courseArray[1].setScheduledTime("1:30pm - 2:20pm");
		courseArray[1].setScheduledDays("MWS");
		courseArray[1].setScheduledRoom("S501");
		courseArray[1].setInstructorName("Prof. Smitha Shekar");
		
		courseArray[2].setCourseName("Computer Network & Internet Protocol");
		courseArray[2].setcourseId("18CS54");
		courseArray[2].setCreditHours(3);
		courseArray[2].setScheduledTime("11:30am - 12:20pm");
		courseArray[2].setScheduledDays("TWS");
		courseArray[2].setScheduledRoom("S501");
		courseArray[2].setInstructorName("Prof. Mary Cheran");
		
		courseArray[3].setCourseName("Database Management System");
		courseArray[3].setcourseId("18CS53");
		courseArray[3].setCreditHours(3);
		courseArray[3].setScheduledTime("9:00 - 10:00 am");
		courseArray[3].setScheduledDays("TThS");
		courseArray[3].setScheduledRoom("S105");
		courseArray[3].setInstructorName("Prof. Asha Ramesh");
		
		courseArray[4].setCourseName("Intellectual Property Rights");
		courseArray[4].setcourseId("18HS51");
		courseArray[4].setCreditHours(3);
		courseArray[4].setScheduledTime("2:30pm - 3:20pm");
		courseArray[4].setScheduledDays("MWF");
		courseArray[4].setScheduledRoom("S105");
		courseArray[4].setInstructorName("Prof. Sujatha");
		
		courseArray[5].setCourseName("Personality Development");
		courseArray[5].setcourseId("18MBAE02");
		courseArray[5].setCreditHours(3);
		courseArray[5].setScheduledTime("10:00am - 11:15am");
		courseArray[5].setScheduledDays("MTS");
		courseArray[5].setScheduledRoom("S105");
		courseArray[5].setInstructorName("Prof. Rajeshwari");
		
		courseArray[6].setCourseName("Artificial Intelligence");
		courseArray[6].setcourseId("18CS553");
		courseArray[6].setCreditHours(3);
		courseArray[6].setScheduledTime("9:30am - 10:20am");
		courseArray[6].setScheduledDays("MWF");
		courseArray[6].setScheduledRoom("S105");
		courseArray[6].setInstructorName("Prof. Aarathi P");
		

	}  // end loadData
	
}  // end Class CourseListingSystem
