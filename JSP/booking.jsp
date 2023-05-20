<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="booking.css">
    <title>Booked</title>
</head>
<body>


    <div class="header">
        <img src="logo.jpg" alt="logo" class="sk" height="100" >
        <div class="header-right">
        <a class="active" href="index.jsp">Home</a>
        <a  href="#contact">Contact</a>
        <a  href="#about">About</a>
        <a href="#login">Login</a>
    </div>

    <div class="bus">

        <div class="final">
            <h1>
                Tickets Available !!!
           </h1>
           <div class="form">
               <form action="update" method="get">
                   <br>
                   <br><br>
                   <label for="name">Name</label>
                   <input type="text" name="name" id="name">
                   <br>
                   <label for="phone">Phone Number</label>
                   <input type="number" name="phone" id="phone">
                   <br>
                   <label for="age">Age</label>
                   <input type="text" id="age" name="age">
                   <br>
                   <label for="gender">Gender</label>
                   <input type="text" id="gender" name="gender">
                   <br>
                   <label for="tickets">No of Tickets</label>
                   <input type="number" id="tickets" name="tickets">                    
                   <br>
                   
                   <input type="hidden" name="from" value="<%=(String) request.getAttribute("from")%>"> 
                   <input type="hidden" name="to" value="<%=(String) request.getAttribute("to")%>">
                   <input type="hidden" name="bus" value="<%=(String) request.getAttribute("busno")%>">  
                   <input type="hidden" name="date" value="<%=(String) request.getAttribute("date")%>">  
                   
                   
                   
                   <input type="submit" name="submit" value="Book Here">
               </form>
           </div>

        </div>
    </div>
    
    </div>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script>
	<link rel="stylesheet" href="alert/dist/sweetalert.css">
	
	<script type="text/javascript">
	
	var status= document.getElementById("status").value;
	if(status=="true"){
		swal("Congrats","Account Created Successfully","success");
	}
	
	</script>
</body>
</html>