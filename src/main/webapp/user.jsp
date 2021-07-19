<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>User</title>
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
  <!--  <link rel="icon" href="{{ url_for('static', filename='/images/p5.ico') }}">-->
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
          <li>User</li>
        </ol>
        <h2>User</h2>

      </div>
    </section><!-- End Breadcrumbs -->

    <section class="inner-page">
      <div class="container">
      <% String name = (String)request.getAttribute("name");String email = (String)request.getAttribute("email");String type = (String)request.getAttribute("type"); %> 

        <div class="row">
          <div class="card col col-lg-4 "> 
          <h5 class="card-title mt-2">Requirement Form</h5>
            <div class=" form-group">
              <form action="${pageContext.request.contextPath}/operation" method="POST" >
                Name : <%=name %><br>
                Email : <%=email%><br>
                <label for="rtype">Choose Requirements:</label>

<select name="rtype" id="rtype">
  <option value="bed">Bed</option>
  <option value="oxy">Oxygen</option>
  <option value="pls">Plasma</option>
  <option value="med">Isolation Kit</option>
  <option value="oth">Others</option>
</select>
<br>
<label for="comment">Remark:</label><br>

<textarea id="comment" name="comment" rows="4" cols="30" placeholder="Specify your Requirements here..."></textarea>
<br>
<input type="hidden" name="name" value=<%=name %>>
<input type="hidden" name="email" value=<%=email%>>
<input type="hidden" name="type" value=<%=type%>>
<input type="hidden" name="form" value="reqUserOperation">
<button type="submit" class="btn btn-info text-center"><a href="#"></a>GO</a></button>

              </form>
            </div>

          </div>
            
        
        <div class="col col-lg-8">
          <h2 class="ml-4 display-4">Welcome <b><%=name.toUpperCase() %></b> <br></h2><h4 class="ml-5"> Track your Requests here...</h4>
          <form action="${pageContext.request.contextPath}/operation?page=home" method="POST">
          <input type="hidden" name="name" value=<%=name %>>
			<input type="hidden" name="email" value=<%=email%>>
			<input type="hidden" name="type" value=<%=type%>>
			<input type="hidden" name="form" value="listreqoperation">
          <button  type="submit" class="ml-5 mt-2 btn btn-lg btn-info" ><a href="#"></a>Track Requests</button>
          </form>
          <div class="mt-4 ml-4 col-lg-3 order-1 order-lg-2 hero-img" data-aos="zoom-in" data-aos-delay="100">
          <img src="https://cdn1.iconfinder.com/data/icons/happy-doctor/238/happy-doctor-007-512.png" class="img-fluid animated" alt="">
        </div>
      </div>
      </div>
      
      
    </section>

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