<%@page import="com.cbt.digital_library_management.admin.dao.BookDao"%>
<%@page import="com.cbt.digital_library_management.dto.Books"%>
<%@page import="java.util.Base64"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>book-edit-writer</title>
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

<style type="text/css">
.gradient-custom-3 {
	/* fallback for old browsers */
	background: #84fab0;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 0.5),
		rgba(143, 211, 244, 0.5));
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, rgba(132, 250, 176, 0.5),
		rgba(143, 211, 244, 0.5))
}

.gradient-custom-4 {
	/* fallback for old browsers */
	background: #84fab0;
	/* Chrome 10-25, Safari 5.1-6 */
	background: -webkit-linear-gradient(to right, rgba(132, 250, 176, 1),
		rgba(143, 211, 244, 1));
	/* W3C, IE 10+/ Edge, Firefox 16+, Chrome 26+, Opera 12+, Safari 7+ */
	background: linear-gradient(to right, rgba(132, 250, 176, 1),
		rgba(143, 211, 244, 1))
}
</style>
</head>
<body>


	<%
		String msg = (String)request.getAttribute("msg");
	
		int id = Integer.parseInt(request.getParameter("id"));
		
		Books book=new BookDao().fetchBookByIdDao(id);
		
		byte[] image = book.getImage();
		
		String encodeImage = Base64.getEncoder().encodeToString(image);
	%>

	<jsp:include page="writer-navbar.jsp"></jsp:include>
	<section class="vh-100 bg-image"
		style="background-image: url('https://mdbcdn.b-cdn.net/img/Photos/new-templates/search-box/img4.webp');">
		<div class="mask d-flex align-items-center h-100 gradient-custom-3">
			<div class="container h-100">
				<div
					class="row d-flex justify-content-center align-items-center h-100">
					<div class="col-12 col-md-9 col-lg-7 col-xl-6">
						<div class="card" style="border-radius: 15px;">
							<div class="card-body p-5">
								<h2 class="text-uppercase text-center mb-5">UPDATE-BOOK-DETAILS</h2>

								<%if(msg!=null) {%> <h3><%=msg%></h3><%}%>
								<form action="bookUpdate" method="post"  enctype="multipart/form-data">
									
									<div data-mdb-input-init class="form-outline mb-4">
									
										<input type="text" id="form3Example1cg"
											class="form-control form-control-lg"  name="id" value="<%=book.getId()%>" hidden="true"/> <label
											class="form-label" for="form3Example1cg">Book Id</label>
									
										<input type="text" id="form3Example1cg"
											class="form-control form-control-lg" value="<%=book.getName()%>" name="name"/> <label
											class="form-label" for="form3Example1cg">Book Name</label>
									</div>

									


									<div data-mdb-input-init class="form-outline mb-4">
										<input type="tel" id="form3Example4cdg"
											class="form-control form-control-lg" name="price" value="<%=book.getPrice()%>"/> <label
											class="form-label" for="form3Example4cdg">Book Price</label>
									</div>
									
									<div data-mdb-input-init class="form-outline mb-4">
										<input type="file" id="form3Example4cdg"
											class="form-control form-control-lg" name="image"/>
									</div>

									<div class="form-check d-flex justify-content-center mb-5">
										<input class="form-check-input me-2" type="checkbox" value=""
											id="form2Example3cg" /> <label class="form-check-label"
											for="form2Example3g"> I agree all statements in <a
											href="#!" class="text-body"><u>Terms of service</u></a>
										</label>
									</div>

									<div class="d-flex justify-content-center">
										<button type="submit" data-mdb-button-init
											data-mdb-ripple-init
											class="btn btn-success btn-block btn-lg gradient-custom-4 text-body">UPDATE</button>
									</div>

								</form>

							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
</html>