<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="AddBook" method = "post">

<input type="text" name = "name" placeholder="name"/>
<input type="text" name = "author" placeholder="author"/>
<input type="number" name = "price" placeholder="price"/>
<input type="text" name = "isbn" placeholder="isbn"/> 

<input type="submit" value="addBook"> 

</form>

<form action=getBook>
<input type="text" name = "name" placeholder="name"/>
<input type="submit" value="search book">

</form>

</body>
</html>