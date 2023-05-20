<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="seats.css">
    <title>Available Bus</title>
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
    </div>
    <div class="bg-bus">

        <div class="login-box">
            
            
            <div class="form">
            	<h2>
                    Ticket Booked Successfully !!!!!
                </h2>
               <p>
                Your Bus Number - <%=request.getAttribute("Bus") %>
                <br>
                Your Seat Number - <%=request.getAttribute("seat") %>
                <br>
                Thank You !!!
               </p> 
            </div>
            
        </div>

    </div>
    
</body>
</html>