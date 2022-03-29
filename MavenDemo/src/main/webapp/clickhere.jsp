<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form action="./VerifyOTP" method="post">
  Your Mobile No: <input type="text" name="mono" placeholder="<%= request.getParameter("q") %>" disabled><br>

   <br>Enter Your OTP:<input type="text" name="otp" class="form-control form-control-lg" />
   <input type="submit">


</form>
</body>
</html>