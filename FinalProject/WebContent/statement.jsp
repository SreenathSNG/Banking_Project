<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Statement</title>
<link rel="stylesheet" href="css/styles.css">
<link href="https://fonts.googleapis.com/css2?family=Merriweather&family=Montserrat&family=Sacramento&display=swap" rel="stylesheet">

</head>
<body>
	<div class="top_cont">
	<h2 class="home_h2"><strong>MY BANK</strong></h2><br>
	<h3 class="home_h3">Your Complete Banking Partner</h3><br>
	<img class="icon" alt="bank-icon" src="images/banking.png">
	<img class="user" alt="user-icon" src="images/profile-user.png">
	<a href="homepage.jsp" class="home_a1">home</a>
	<a href="logout" class="home_a">signout</a>
	</div>
	<hr class="hr">
	<div class="statement">
		<h2>Account Statement</h2>
		<form action="stmt.jsp" method="get">
			<p  class="s_label1">From</p>
			<input class="s_date1" type="date" name="from_date" required>
			<p class="s_label2">To</p>
			<input class="s_date2" type="date" name="to_date" required>
			<input class="s_but1" type="submit" value="Show Statement"><br><br><br><br>
		</form>
	</div>
	
</body>
</html>