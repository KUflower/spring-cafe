<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/jspf/head.jspf" %>
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

				<!-- BEGIN LIST SAMPLES -->
				<section>
					<div class="section-header">
						<ol class="breadcrumb">
							<li class="active">Layouts</li>
						</ol>
					</div>
					<div class="section-body contain-lg">

						<!-- BEGIN INTRO -->
						<div class="row">
							<div class="col-lg-12">
								<h1 class="text-primary">Layouts</h1>
							</div><!--end .col -->
							<div class="col-lg-8">
								<article class="margin-bottom-xxl">
									<p class="lead">
										Material Admin has several layout options that can be used for different purposes.
										You can either choose between a full-width header or a full-height menubar.
									</p>
								</article>
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END INTRO -->

						<!-- BEGIN TILE CONTENT -->
						<div class="row">
							<div class="col-lg-12">
								<h2 class="text-primary">Content</h2>
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END TILE CONTENT -->



					</div><!--end .section-body -->
				</section>
			</div><!--end #content-->
			<!-- END CONTENT -->

			<!-- BEGIN MENUBAR jspf-->
			<%@ include file="/WEB-INF/jspf/menubar.jspf" %>
			<!-- END MENUBAR jspf-->

		</div><!--end #base-->
		<!-- END BASE -->

		<!-- BEGIN JAVASCRIPT jspf -->
		<%@ include file="/WEB-INF/jspf/foot.jspf" %>
		<!-- END JAVASCRIPT jsfp -->

	</body>
</html>
