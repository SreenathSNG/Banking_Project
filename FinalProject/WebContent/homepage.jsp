<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home</title>
<link rel="stylesheet" href="css/styles.css">
<link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Montserrat&family=Sacramento&display=swap" rel="stylesheet">
<%
String uid = request.getParameter("uname");
HttpSession s1 = request.getSession(false);
if (s1 == null){
	request.getRequestDispatcher("index.html").include(request, response);
}
%>
</head>
<body>
	<div class="top_cont">
	<h2 class="home_h2"><strong>MY BANK</strong></h2><br>
	<h3 class="home_h3">Your Complete Banking Partner</h3><br>
	<img class="icon" alt="bank-icon" src="images/banking.png">
	<img class="user" alt="user-icon" src="images/profile-user.png">
	
	<a href="logout" class="home_a">signout</a>
	</div>
	<hr class="hr">
	<div class="home">
		<p class="home_para"><strong>MENU</strong></p>
		<a href="transaction.html" class="home_heading"><strong>1. Make Transaction</strong></a><br><br>
		<!--  <a href="statement.html" class="home_heading"><strong>2. Generate Statement</strong></a><br><br>-->
		<a href="statement.jsp" class="home_heading"><strong>2. Generate Statement</strong></a><br><br>
		<a href="authorize.html" class="home_heading"><strong>3. Authorize Credit Card</strong></a>
	</div>
</body>
</html>