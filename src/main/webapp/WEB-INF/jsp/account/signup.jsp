<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
<link type="text/css" rel="stylesheet" href="../../assets/css/theme-1/bootstrap.css?1422792965" />
<link type="text/css" rel="stylesheet" href="../../assets/css/theme-1/materialadmin.css?1425466319" />
<link type="text/css" rel="stylesheet" href="../../assets/css/theme-1/font-awesome.min.css?1422529194" />
<link type="text/css" rel="stylesheet" href="../../assets/css/theme-1/material-design-iconic-font.min.css?1421434286" />

<title>LENDIT</title>
<style>
	.error{
		color:red;
		font-size:10pt;
	}
</style>

</head>

<body class="menubar-hoverable header-fixed ">

	<!-- BEGIN LOGIN SECTION -->
	<section class="section-account" style="padding-bottom:0px;">
	<div class="img-backdrop"
		style="background-image: url('../../assets/img/img16.jpg')"></div>
	<div class="spacer"></div>
	<!--end .card --> 
</section>
	<!-- END LOGIN SECTION -->

  <!-- BEGIN CONTENT-->
  <div id="content"  style="padding-top:0px;">
    <section>
      <div class="section-body contain-lg" style="max-width:850px!important; min-width:600px!important;">

        <!-- BEGIN INTRO -->
        <div class="row">
          <div class="col-lg-12" style="padding-top:0px;">
            <h1 class="text-primary">회원가입</h1>
          </div><!--end .col -->
          <div class="col-lg-12">
            <article class="margin-bottom-xxl">
              <p class="lead">
                회원가입을 위해 아래의 고객 정보를 입력해 주십시오<br>
              </p>
            </article>
          </div><!--end .col -->
        </div><!--end .row -->
        <!-- END INTRO -->

        <!-- BEGIN VALIDATION FORM WIZARD -->
        <div class="row">
          <div class="col-lg-12">
            <div class="card">
              <div class="card-body" >
                <div id="rootwizard2" class="form-wizard form-wizard-horizontal">
                    <div class="tab-content clearfix" style="font-size:14pt; padding:30px;">
                      <form:form commandName="userForm"  >
                      <div class="tab-pane active" id="step1">
                        <div class ="row">
                          <div class="col-sm-3">
                            <span>이메일</span>
                          </div>
                          <div class="col-sm-6" >
                            <form:input path="email" id="email" class="form-control" />
                            <form:errors path="email" cssClass="error"/>
                          </div>
                        </div>
                        <div class ="row">
                          <div class="col-sm-3">
                            <span>패스워드</span>
                          </div>
                          <div class="col-sm-6" >
                            <form:password path="password1" id="password1" class="form-control" />
                            <form:errors path="password2" cssClass="error"/>
                          </div>
                        </div>
                        <div class ="row">
                          <div class="col-sm-3">
                            <span>패스워드 재입력</span>
                          </div>
                          <div class="col-sm-6" >
                            <form:password path="password2" id="password2" class="form-control" />
                            <form:errors path="password2" cssClass="error"/>
                          </div>
                        </div>
                        <div class ="row">
                          <div class="col-sm-3">
                            <span>닉네임</span>
                          </div>
                          <div class="col-sm-6" >
                            <form:input path="name" id="name" class="form-control" />
                            <form:errors path="name" cssClass="error"/>
                          </div>
                        </div>
                        </div>
                        <br>
                        <font style="color:#888888;">* 이메일 주소가 정확하지 않으면 회원가입이 불가능 합니다.<br></font>

                      </div><!--end #step1 -->
                      <div class = "row" style="text-align:center; padding:10px; margin:10px; font-size:13px;">
                        <input type ="submit" class="btn ink-reaction btn-primary" value="회원가입"  />
                      </div>
                      </form:form>
                    </div><!--end .tab-content -->

                </div><!--end #rootwizard -->
              </div><!--end .card-body -->
            </div><!--end .card -->
          </div><!--end .col -->
        </div><!--end .row -->
        <!-- END VALIDATION FORM WIZARD -->

      </div><!--end .section-body -->
    </section>
  </div><!--end #content-->
  <!-- END CONTENT -->


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
