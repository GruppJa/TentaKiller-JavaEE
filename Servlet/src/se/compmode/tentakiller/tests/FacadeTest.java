package se.compmode.tentakiller.tests;

import javax.naming.Context;
import javax.naming.InitialContext;

import se.compmode.tentakiller.facade.StudentsLocal;
import se.compmode.tentakiller.models.Student;
import junit.framework.TestCase;

public class FacadeTest extends TestCase {
	
	StudentsLocal student;

	public FacadeTest(String name) {
		super(name);
	}

	protected void setUp() throws Exception {
		super.setUp();
		
		Context context = new InitialContext();
		student=(StudentsLocal)context.lookup("java:app/TentaKiller-Bean/Students!se.compmode.tentakiller.facade.StudentsLocal");	
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		student = null;
	}
	public void testCreateAndGetStudent () throws Exception {
		
		Student s = student.createStudent("hej@hej.com", "hej", "hej");
		Student s2 = student.get(s.getId());
		assertEquals(s.getId(), s2.getId());
	}
}
