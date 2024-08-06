<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>
</title>
<style>
*{
padding:0;
margin:0;
box-sizing:border-box;
}
body{
height:100vh;
width:100vw;
}

/* From Uiverse.io by vk-uiux */ 
main,footer{
display:flex;
align-item:center;
padding:200px;
justify-content:center;
}
footer{
background-color:grey;
padding:70px;
color:black;
}
.loader {
  position: relative;
  width: 33px;
  height: 33px;
  perspective: 67px;
}

.loader div {
  width: 100%;
  height: 100%;
  background: #2f3545;
  position: absolute;
  left: 50%;
  transform-origin: left;
  animation: loader 2s infinite;
}

.loader div:nth-child(1) {
  animation-delay: 0.15s;
}

.loader div:nth-child(2) {
  animation-delay: 0.3s;
}

.loader div:nth-child(3) {
  animation-delay: 0.45s;
}

.loader div:nth-child(4) {
  animation-delay: 0.6s;
}

.loader div:nth-child(5) {
  animation-delay: 0.75s;
}

@keyframes loader {
  0% {
    transform: rotateY(0deg);
  }

  50%, 80% {
    transform: rotateY(-180deg);
  }

  90%, 100% {
    opacity: 0;
    transform: rotateY(-180deg);
  }
}
</style>
</head>
<body>
<jsp:include page="index-navbar.jsp"></jsp:include>
<main>
<div class="loader">
  <div></div>
  <div></div>
  <div></div>
  <div></div>
  <div></div>
</div>
<br><br>
<h1> Library Management System</h1>


</main>
<footer>Copyright 2024 Library Management System</footer>
</body>

</html>