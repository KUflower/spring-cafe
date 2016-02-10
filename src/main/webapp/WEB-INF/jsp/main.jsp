<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<!-- BEGIN META -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="keywords" content="your,keywords">
<meta name="description" content="Short explanation about this website">
<!-- END META -->

<!-- BEGIN STYLESHEETS -->
<link href='http://fonts.googleapis.com/css?family=Roboto:300italic,400italic,300,400,500,700,900' rel='stylesheet' type='text/css'/>
<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/bootstrap.css?1422792965" />
<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/materialadmin.css?1425466319" />
<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/font-awesome.min.css?1422529194" />
<link type="text/css" rel="stylesheet" href="../../assets/css/theme-default/material-design-iconic-font.min.css?1421434286" />
	
<title>LENDIT</title>

</head>

<body class="menubar-hoverable header-fixed ">

	<!-- BEGIN LOGIN SECTION -->
	<section class="section-account">
	<div class="img-backdrop"
		style="background-image: url('../../assets/img/img16.jpg')"></div>
	<div class="spacer"></div>
	<div class="card contain-sm style-transparent">
		<div class="card-body">
			<div class="row">
				<div class="col-sm-6">
					<br /> <span class="text-lg text-bold text-primary">LOGIN</span> <br />
					<br />
					<form class="form floating-label"
						action="../../html/dashboards/dashboard.html"
						accept-charset="utf-8" method="post">
						<div class="form-group">
							<input type="text" class="form-control" id="username"
								name="username"> <label for="username">Username</label>
						</div>
						<div class="form-group">
							<input type="password" class="form-control" id="password"
								name="password"> <label for="password">Password</label>
							<p class="help-block">
								<a href="#">Forgotten?</a>
							</p>
						</div>
						<br />
						<div class="row">
							<div class="col-xs-6 text-left">
								<div class="checkbox checkbox-inline checkbox-styled">
									<label> <input type="checkbox"> <span>Remember
											me</span>
									</label>
								</div>
							</div>
							<!--end .col -->
<!-- 							<div class="col-xs-6 text-right"> -->
<!-- 								<button class="btn btn-primary btn-raised" type="submit">Login</button> -->
<!-- 							</div> -->
							<div class="col-xs-6 text-right">
								<a class="btn btn-block btn-raised btn-primary" href="http://localhost:8080/loanapp/precheck">Login</a>
							</div>
							<!--end .col -->
						</div>
						<!--end .row -->
					</form>
				</div>
				<!--end .col -->
				<div class="col-sm-5 col-sm-offset-1 text-center">
					<br>
					<br>
					<h3 class="text-light">No account yet?</h3>
					<a class="btn btn-block btn-raised btn-primary" href="http://localhost:8080/loanapp/precheck">Sign
						up here</a> <br>
					<br>
					<h3 class="text-light">or</h3>
					<p>
						<a href="#" class="btn btn-block btn-raised btn-info"><i
							class="fa fa-facebook pull-left"></i>Login with Facebook</a>
					</p>
					<p>
						<a href="#" class="btn btn-block btn-raised btn-info"><i
							class="fa fa-twitter pull-left"></i>Login with Twitter</a>
					</p>
				</div>
				<!--end .col -->
			</div>
			<!--end .row -->
		</div>
		<!--end .card-body -->
	</div>
	<!--end .card --> </section>
	<!-- END LOGIN SECTION -->

	<!-- BEGIN JAVASCRIPT -->
	<script src="../../assets/js/libs/jquery/jquery-1.11.2.min.js"></script>
	<script src="../../assets/js/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
	<script src="../../assets/js/libs/bootstrap/bootstrap.min.js"></script>
	<script src="../../assets/js/libs/spin.js/spin.min.js"></script>
	<script src="../../assets/js/libs/autosize/jquery.autosize.min.js"></script>
	<script
		src="../../assets/js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
	<script src="../../assets/js/core/source/App.js"></script>
	<script src="../../assets/js/core/source/AppNavigation.js"></script>
	<script src="../../assets/js/core/source/AppOffcanvas.js"></script>
	<script src="../../assets/js/core/source/AppCard.js"></script>
	<script src="../../assets/js/core/source/AppForm.js"></script>
	<script src="../../assets/js/core/source/AppNavSearch.js"></script>
	<script src="../../assets/js/core/source/AppVendor.js"></script>
	<script src="../../assets/js/core/demo/Demo.js"></script>
	<!-- END JAVASCRIPT -->

</body>


</html>