package se.compmode.tentakiller.tests;

import se.compmode.tentakiller.models.Student;
import junit.framework.TestCase;

public class StudentTest extends TestCase {

	public StudentTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	public void testStudentName () throws Exception {
		Student s = new Student();
		s.setName("Annika");
		assertEquals(s.getName(), "Annika");
	}

}
