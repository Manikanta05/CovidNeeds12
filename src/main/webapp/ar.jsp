<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ page import="java.util.List" %>
<%@ page import="entity.*" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Login</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="assets/img/favicon.png" rel="icon">
  <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Jost:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="assets/vendor/aos/aos.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  <link rel="icon" href="{{ url_for('static', filename='/images/p5.ico') }}">
  <link href='http://fonts.googleapis.com/css?family=Ropa+Sans' rel='stylesheet' type='text/css'>
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
  <link rel="stylesheet" href="css/responsiveslides.css">

  <!-- Template Main CSS File -->
  <link href="assets/css/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Arsha - v4.3.0
  * Template URL: https://bootstrapmade.com/arsha-free-bootstrap-html-template-corporate/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Header ======= -->
  <header id="header" class="fixed-top header-inner-pages">
    <div class="container d-flex align-items-center">

      <h1 class="logo me-auto"><a href="${pageContext.request.contextPath}/">Covid Needs</a></h1>
      <!-- Uncomment below if you prefer to use an image logo -->
      <!-- <a href="index.html" class="logo me-auto"><img src="assets/img/logo.png" alt="" class="img-fluid"></a>

      <nav id="navbar" class="navbar">
        <ul>
          <li><a class="nav-link scrollto " href="#hero">Home</a></li>
          <li><a class="nav-link scrollto" href="#about">About</a></li>
          <li><a class="nav-link scrollto" href="#services">Services</a></li>
          <li><a class="nav-link   scrollto" href="#portfolio">Portfolio</a></li>
          <li><a class="nav-link scrollto" href="#team">Team</a></li>
          <li class="dropdown"><a href="#"><span>Drop Down</span> <i class="bi bi-chevron-down"></i></a>
            <ul>
              <li><a href="#">Drop Down 1</a></li>
              <li class="dropdown"><a href="#"><span>Deep Drop Down</span> <i class="bi bi-chevron-right"></i></a>
                <ul>
                  <li><a href="#">Deep Drop Down 1</a></li>
                  <li><a href="#">Deep Drop Down 2</a></li>
                  <li><a href="#">Deep Drop Down 3</a></li>
                  <li><a href="#">Deep Drop Down 4</a></li>
                  <li><a href="#">Deep Drop Down 5</a></li>
                </ul>
              </li>
              <li><a href="#">Drop Down 2</a></li>
              <li><a href="#">Drop Down 3</a></li>
              <li><a href="#">Drop Down 4</a></li>
            </ul>
          </li>
          <li><a class="nav-link scrollto" href="#contact">Contact</a></li>
          <li><a class="getstarted scrollto" href="#about">Get Started</a></li>
        </ul>
        <i class="bi bi-list mobile-nav-toggle"></i>
      </nav><!-- .navbar -->

    </div>
  </header><!-- End Header -->

  <main id="main">

    <!-- ======= Breadcrumbs ======= -->
    <section id="breadcrumbs" class="breadcrumbs">
      <div class="container">

        <ol>
          <li><a href="${pageContext.request.contextPath}/">Home</a></li>
          <li>Organization</li>
          <li>List of Requirements</li>
        </ol>
        <h2>List of Requirements</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <% String name = (String)request.getAttribute("name");String email = (String)request.getAttribute("email");String type = (String)request.getAttribute("type"); %>
    <div class="table responsive mt-5 ml-5">
    <table >
			<thead>
			<th>Name</th>
			<th>Requirement</th>
			<th>Remarks</th>
			<th>Organization name</th>
			<th>Status</th>
			<th>Accept</th>
			</thead>
			<!-- List<Login> listUsers = (List) request.getAttribute("listUsers");
							String updateURL;
							for (int i = 0; i < listUsers.size(); i++) {
								out.print("<tr>");
								out.print("<td>" + listUsers.get(i).getUsers_id() + "</td>");
								out.print("<td>" + listUsers.get(i).getUsername() + "</td>");
								out.print("<td>" + listUsers.get(i).getEmail() + "</td>");
								updateURL = request.getContextPath() + "/operation?page=updateUser" + "&usersId="
										+ listUsers.get(i).getUsers_id() + "&username=" + listUsers.get(i).getUsername() + "&email="
										+ listUsers.get(i).getEmail();
								deleteURL = request.getContextPath() + "/operation?page=deleteUser" + "&usersId="
										+ listUsers.get(i).getUsers_id();
								out.print("<td><a href=" + updateURL + ">Update</a>|");
				%>
				<a href="%=deleteURL%"
					onclick="if(!confirm('Are you sure to delete the user?')) return false">Delete</a>
				</td>
				out.print(listUsers.size()); -->
			<%
			List<Requirements> listUsers = (List)request.getAttribute("listUsers");
			String updateURL;
			
			if(listUsers!=null){
			for(Requirements i:listUsers){
				
				out.print("<tr>");
				out.print("<td>"+i.getName()+"</td>");
				out.print("<td>"+i.getRtype()+"</td>");
				out.print("<td>"+i.getComment()+"</td>");
				out.print("<td>"+i.getOgname()+"</td>");
				out.print("<td>"+i.getStatus()+"</td>");
				updateURL = request.getContextPath() + "/operation?page=updateReq" + 
				"&name="+ i.getName() + "&email=" + i.getEmail() + "&type=user&rtype="
								+ i.getRtype() + 
								"&ogname="+ name + "&ogemail=" + email+"&status=" + i.getStatus();
				
				out.print("<td><a href=" + updateURL + ">Accept</a></td>");
				out.print("</tr>");
			}
			}
			%>
			</table>
    </div>

  </main><!-- End #main -->

  

  <!-- Vendor JS Files -->
  <script src="assets/vendor/aos/aos.js"></script>
  <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
  <script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
  <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
  <script src="assets/vendor/php-email-form/validate.js"></script>
  <script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
  <script src="assets/vendor/waypoints/noframework.waypoints.js"></script>

  <!-- Template Main JS File -->
  <script src="assets/js/main.js"></script>

</body>

</html>