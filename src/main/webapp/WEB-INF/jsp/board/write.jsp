<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
		<title>S CAFE</title>

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
		<link type="text/css" rel="stylesheet" href="../../assets/css/theme-1/libs/summernote/summernote.css?1425218701" />
  </head>
	<body class="menubar-hoverable  menubar-pin ">

		<!-- BEGIN HEADER jspf-->
		<%@ include file="/WEB-INF/jspf/headerbar.jspf" %>
		<!-- END HEADER jspf-->

		<!-- BEGIN BASE-->
		<div id="base">

			<!-- BEGIN OFFCANVAS LEFT -->
			<div class="offcanvas">
			</div><!--end .offcanvas-->
			<!-- END OFFCANVAS LEFT -->

      <!-- BEGIN CONTENT-->
			<div id="content">
				<section>
					<div class="section-header">
						<ol class="breadcrumb">
							<li class="active">카테고리</li>
						</ol>
					</div>
					<div class="section-body contain-lg">
						<form:form commandName="postForm">
						<!-- BEGIN SUMMERNOTE -->
						<div class="row">
							<div class="col-lg-12">
								<h2 class="text-primary">글쓰기</h2>
							</div><!--end .col -->
							<div class="col-lg-8">
								<p class="lead">
									제목&nbsp;
									<form:input path="title"/>
								</p>
							</div><!--end .col -->
						</div><!--end .row -->
						<div class="card" >
							<div class="card-body no-padding" >
								<form:textarea path="content" id="summernote" />
							</div><!--end .card-body -->
						</div><!--end .card -->
						<!-- END SUMMERNOTE -->
<!-- 						<hr class="ruler-xxl"/> -->
						<div class ="row" style="text-align:center;font-size:13px;">
							<input type ="submit" class="btn ink-reaction btn-primary" value="작성"  />
						</div>
						</form:form>

					</div><!--end .section-body -->
				</section>
			</div><!--end #content-->
			<!-- END CONTENT -->

			<!-- BEGIN MENUBAR jspf-->
			<%@ include file="/WEB-INF/jspf/menubar.jspf" %>
			<!-- END MENUBAR jspf-->

		</div><!--end #base-->
		<!-- END BASE -->

    <!-- BEGIN JAVASCRIPT -->
    <script>
        window.jQuery = window.$ = require('jquery');
    </script>
    <script src="../../assets/js/libs/jquery/jquery-1.11.2.min.js"></script>
    <script src="../../assets/js/libs/jquery/jquery-migrate-1.2.1.min.js"></script>
    <script src="../../assets/js/libs/bootstrap/bootstrap.min.js"></script>
    <script src="../../assets/js/libs/spin.js/spin.min.js"></script>
    <script src="../../assets/js/libs/autosize/jquery.autosize.min.js"></script>
    <script src="../../assets/js/libs/nanoscroller/jquery.nanoscroller.min.js"></script>
    <script src="../../assets/js/libs/ckeditor/ckeditor.js"></script>
    <script src="../../assets/js/libs/ckeditor/adapters/jquery.js"></script>
    <script src="../../assets/js/libs/summernote/summernote.min.js"></script>
    <script src="../../assets/js/core/source/App.js"></script>
    <script src="../../assets/js/core/source/AppNavigation.js"></script>
    <script src="../../assets/js/core/source/AppOffcanvas.js"></script>
    <script src="../../assets/js/core/source/AppCard.js"></script>
    <script src="../../assets/js/core/source/AppForm.js"></script>
    <script src="../../assets/js/core/source/AppNavSearch.js"></script>
    <script src="../../assets/js/core/source/AppVendor.js"></script>
    <script src="../../assets/js/core/demo/Demo.js"></script>
    <script src="../../assets/js/core/demo/DemoFormEditors.js"></script>
    <!-- END JAVASCRIPT -->

	</body>
</html>
