<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="ko">
<head>
	<%@ include file="/WEB-INF/jspf/head.jspf" %>
	<style>
		.hd{
			width:80px;
		}
	</style>
</head>
	<body class="menubar-hoverable menubar-pin menubar-first">
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
			<div id="content"  >


				<section>
					<div class="section-body contain-lg" style="max-width:850px!important; min-width:600px!important;">
						<!-- BEGIN INTRO -->
						<div class="row">
							<div class="col-lg-12">
								<h1 class="text-primary">게시판 </h1>
							</div><!--end .col -->
							<div class="col-lg-12">
								<article class="margin-bottom-xxl">
									<p class="lead">
										카페 게시글 목록입니다.
									<a href="/board/write" class="btn ink-reaction btn-primary" style="float:right;">글쓰기</a>
									</p>
				
									
								</article>
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END INTRO -->
						<!-- BEGIN RESPONSIVE TABLE 1 -->
						<div class="row">
							<div class="col-lg-12">
								<div class="card" style="min-height:600px;">
									<div class="card-body">
										<div class="table-responsive">
											<table class="table no-margin table-hover">
												<thead>
													<tr>
														<th class="hd">글 번호</th>
														<th>제목</th>
														<th>글쓴이</th>
														<th>작성일</th>
													</tr>
												</thead>
												<tbody>
												<c:forEach var="post" items="${postPage.content}">
													<tr>
														<td class="hd">${post.id}</td>
														<td><a href="/board/${post.id}">${post.title}</a></td>
														<td>${post.userName }</td>
														<td>${post.createdAt }</td>
													</tr>
												</c:forEach>
												</tbody>
											</table>
										</div><!--end .table-responsive -->
									</div><!--end .card-body -->
								</div><!--end .card -->
							<ul class="pager" >
								<c:if test="${!postPage.first}">
								<li class="previous">
									<a href="?page=${postPage.number-1}">&larr; Newer Posts</a>
								</li>
								</c:if>
								<c:if test="${!postPage.last}">
								<li class="next">
									<a href="?page=${postPage.number+1}">Older Posts &rarr;</a>
								</li>
								</c:if>
							</ul>
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END RESPONSIVE TABLE 1 -->

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
