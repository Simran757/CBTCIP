<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Number Guessing Game</title>
<link rel="stylesheet" type="text/css" href="index.css">
<style>
/* index.css */
body {
    font-family: 'Arial', sans-serif;
    background: linear-gradient(to right, #ffecd2 0%, #fcb69f 100%);
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    height: 100vh;
    margin: 0;
}

h1 {
    color: #ff6f61;
    font-size: 3em;
    text-shadow: 2px 2px 4px #aaa;
    animation: fadeIn 1s ease-in-out;
}

form {
    background: rgba(255, 255, 255, 0.9);
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
    animation: slideIn 1s ease-out;
}

label {
    font-size: 1.2em;
    color: #333;
}

input[type="number"] {
    padding: 10px;
    border-radius: 5px;
    border: 1px solid #ccc;
    width: 60%;
    margin-top: 10px;
    margin-bottom: 20px;
    font-size: 1em;
    transition: transform 0.3s ease;
}

input[type="number"]:focus {
    transform: scale(1.1);
    border-color: #ff6f61;
    outline: none;
}

button {
    padding: 10px 20px;
    background-color: #ff6f61;
    color: white;
    border: none;
    border-radius: 5px;
    font-size: 1em;
    cursor: pointer;
    transition: background-color 0.3s ease, transform 0.3s ease;
}

button:hover {
    background-color: #ff3b2e;
    transform: scale(1.1);
}

p {
    font-size: 1.2em;
    color: #333;
    animation: fadeIn 1s ease-in-out;
}

@keyframes fadeIn {
    from {
        opacity: 0;
    }
    to {
        opacity: 1;
    }
}

@keyframes slideIn {
    from {
        transform: translateY(-100px);
        opacity: 0;
    }
    to {
        transform: translateY(0);
        opacity: 1;
    }
}

</style>
</head>

<body>
	<h1>Guess the Number</h1>
	<form action="game" method="post">
	<label for="guess">Enter your guess (1 to 100) : </label>
	<input type="number" id="guess" name="guess" required min="1" max="100">
	<button type="submit">Submit</button>
	</form>
	
	<p>Attempts: <%= session.getAttribute("attempts") %></p>
	
	<% if (request.getAttribute("message") != null) { %>
	<p><%= request.getAttribute("message") %></p>
	<% } %>
</body>
</html>