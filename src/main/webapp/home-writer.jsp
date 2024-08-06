<%@page import="com.cbt.digital_library_management.dto.Writers"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Writer- Home</title>
</head>
<body>

<jsp:include page="writer-navbar.jsp" />
<h1>Welcome Writer</h1>
<jsp:include page="book-display-writer.jsp"></jsp:include>
</body>
</html>