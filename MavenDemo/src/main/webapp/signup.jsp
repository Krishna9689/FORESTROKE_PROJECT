<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>


<style><%@include file="/css/c1.css"%></style>
<style><%@include file="/css/bootstrap.min.css"%></style>
</head>
<body>
 <div class="container">

  <div class="card">
   <div class="card-body">
    <form action="./ad" method="post">
    <section class="vh-100 gradient-custom">
  <div class="container py-5 h-100">
    <div class="row d-flex justify-content-center align-items-center h-100">
      <div class="col-12 col-md-8 col-lg-6 col-xl-5">
        <div class="card bg-dark text-white" style="border-radius: 1rem;">
          <div class="card-body p-5 text-center">

            <div class="mb-md-5 mt-md-4 pb-5">

              <h2 class="fw-bold mb-2 text-uppercase">Admin Login</h2>
              <p class="text-white-50 mb-5"></p>

              <div class="form-outline form-white mb-4">
                <input type="text" id="auser" name="auser" class="form-control form-control-lg" />
                <label class="form-label">Enter Username</label>
              </div>

              <div class="form-outline form-white mb-4">
                <input type="password" id="apass" name="apass" class="form-control form-control-lg" />
                <label class="form-label" >Password</label>
              </div>

     
              <button class="btn btn-outline-light btn-lg px-5" type="submit">Login</button>
          
             

            </div>

            
          </div>
        </div>
      </div>
    </div>
  </div>
</section>
   </form>
</div>
</div>
</div>

</body>
</html>