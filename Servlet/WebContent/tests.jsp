<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>B�ntestet</title>
</head>
<body>
	<p>
		H�r kan du skriva in ditt TestCase eller TestSuite:<br>
	</p>
	<form action="TestServlet" method="get" name="youTypeItForm">
		<input type="text" name="suite" size=60 value= /> <input type="submit"
			value="Run" />
	</form>
	<hr>
	<p>
		H�r kan du v�lja en eller flera av f�ljande test:<br>
	</p>
	<form action="TestServlet" method="get" name="youPickItForm">
		<select name="suite" size="2" multiple>
			<option value="ics.junit.ejb.TentaKillerBeanTest">ics.junit.ejb.TentaKillerBeanTest</option>
			<option value="ics.junit...">ett.annat.TestCase</option>
		</select> <input type="submit" value="Run" />
	</form>
</body>
</html>