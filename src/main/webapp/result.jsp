<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number Guessing Game - Result</title>
<style>
*{
box-sizing:border-box;
margin:0;
padding:0;
}
/* index.css */
body {
    font-family: 'Arial', sans-serif;
    background: linear-gradient(to right, #00c6ff, #0072ff);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    margin: 0;
}

.loader {
    background: rgba(255, 255, 255, 0.9);
    padding: 20px 40px;
    border-radius: 10px;
    box-shadow: 0 0 20px rgba(0, 0, 0, 0.2);
    text-align: center;
    animation: fadeIn 1s ease-in-out, scaleIn 0.5s ease-in-out;
}

h1 {
    color: #0072ff;
    font-size: 2.5em;
    margin-bottom: 10px;
    text-shadow: 2px 2px 4px #aaa;
}

hr {
    width: 100%;
    border: 1px solid #0072ff;
    margin: 20px 0;
}

span {
    font-size: 1.2em;
    color: #333;
    display: block;
    margin: 10px 0;
    animation: fadeIn 2s ease-in-out;
}

@keyframes fadeIn {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}

@keyframes scaleIn {
    from {
        transform: scale(0.8);
    }
    to {
        transform: scale(1);
    }
}

</style>
</head>

<body>
<div class="loader">
	<h1>Result</h1>
	<hr>
	
	<br>
	<span>Congratulations! You guessed the number in <%= session.getAttribute("attempts") %> attempts.</span>
	<br>
	<span>Your score is <%= request.getAttribute("score") %>.</span>
	</div>
</body>
</html>

