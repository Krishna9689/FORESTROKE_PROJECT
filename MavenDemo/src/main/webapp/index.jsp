<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
 pageEncoding="ISO-8859-1"%>
<html>
<head>

</head>
<body>
<div id="order_id" > 

</div>



<center>
<h1>Enter Name<input type="text" name="pname" id="pname"></h1>
<h1>Enter Amount<input type="number" name="pamt" id="pamt"></h1>
<button id="payButton" onclick="CreateOrderId()">PayNow</button>
</center>
<script>

  var xhttp=new XMLHttpRequest();
  var RazorpayOrderId;

  function CreateOrderId()
  {
  console.log("yes")
     xhttp.open("GET","http://localhost:8081/MavenDemo/ordercreation",false);
     xhttp.send();
     RazorpayOrderId=xhttp.responseText;

     OpenCheckout();
  }
 </script>

<script src="https://checkout.razorpay.com/v1/checkout.js"></script>
<script>
 function OpenCheckout(amt){
 var options={
      "key" : "rzp_live_dWf2eNRMls5hcR",
      "amount":"40000",
      "currency":"INR",
      "name":"New Hi-Tech Services",
      "description":"Pay Your Bill",
      "image":"https://cdn.pixabay.com/photo/2020/06/24/05/23/tree-5334773_960_720.png",
      "order_id":RazorpayOrderId,
      "callback_url":"http://localhost:8081/MavenDemo/ordercreation",
      "prefill":{
             "name":"Krishna Sinnarkar",
             "email":"krishnasinnarkar001@gmail.com",
             "contact":"9689828145"
          },
          "notes":{
              "address":"Razorpay Corporation Ofiice"
              },
              "theme":{
                 "color":"#3399cc"
                  }
          
     };

    var rzp1=new Razorpay(options);
    rzp1.on('payment.failed',function(response){
         alert(response.error.code);
         alert(response.error.description);
         alert(response.error.source);
         alert(response.error.step);
         alert(response.error.reason);
         alert(response.error.metadata.order_id);
         alert(response.error.metadata.payment_id);
    	
        });

       rzp1.open();
       e.preventDefault();
  }
</script>

</body>
</html>
