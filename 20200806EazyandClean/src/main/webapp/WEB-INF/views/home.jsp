<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<P>  The time on the server is ${serverTime}. </P>

	<form action="fileTest" method="post" enctype="multipart/form-data">
		<input type="file" name="uploadFile">
		<input type="submit" value="upload">
	</form>

	<a href="downloadFile">downloadfile</a>



</body>
</html>
