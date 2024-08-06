
<%@page import="com.cbt.digital_library_management.admin.dao.Writersdao"%>
<%@page import="com.cbt.digital_library_management.dto.Writers"%>
<%@page import="java.util.List"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Writer-Display</title>
<!-- Font Awesome -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
	rel="stylesheet" />
<!-- Google Fonts -->
<link
	href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700&display=swap"
	rel="stylesheet" />
<!-- MDB -->
<link
	href="https://cdnjs.cloudflare.com/ajax/libs/mdb-ui-kit/7.3.2/mdb.min.css"
	rel="stylesheet" />
	
</head>
<body>

	<%
		List<Writers> writers=new Writersdao().getAllWritersDao();
	%>
	
<table class="table align-middle mb-0 bg-white">
  <thead class="bg-light">
    <tr>
      <th>ID:</th>
      <th>Name:</th>
      <th>Email:</th>
      <th>Status:</th>
      <th>Actions:</th>
    </tr>
  </thead>
  <%for(Writers write:writers){ %>
  <tbody>
    <tr>
      <td>
        <div class="d-flex align-items-center">
          <div class="ms-3">
            <p class="fw-bold mb-1"><%=write.getId()%></p>
          </div>
        </div>
      </td>
      <td>
        <p class="fw-normal mb-1"><%=write.getName()%></p>
      </td>
      <td><%=write.getEmail()%></td>
      <td>
      <a href="verifyController?email=<%= write.getEmail()%>&&verify=<%=write.getVerify() %>"class="btn btn-link btn-sm btn-rounded">
       		<%if(write.getVerify().equalsIgnoreCase("yes")){%> 
       		 <span class="badge rounded-pill d-inline btn btn-success">Yes</span>
       		<%}else{%>
       		 <span class="badge rounded-pill d-inline btn btn-danger">No</span>
       		<%}%>
       		</a>
      </td>
      <td>
      <a href="verifyController?email=<%= write.getEmail()%>&&verify=<%=write.getVerify() %>"class="btn btn-link btn-sm btn-rounded">
       		<%if(write.getVerify().equalsIgnoreCase("yes")){%> 
       		 <span class="badge rounded-pill d-inline btn btn-success">Verified</span>
       		<%}else{%>
       		 <span class="badge rounded-pill d-inline btn btn-danger">Verify</span>
       		<%}%>
       		</a>
      </td>
    </tr>
  </tbody>
  <%}%>
</table>
</body>
</html>