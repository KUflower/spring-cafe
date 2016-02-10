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
				<section>
					<div class="section-header">
						<ol class="breadcrumb">
							<li><a href="../../../html/pages/blog/masonry.html">Blog masonry</a></li>
							<li class="active">Blog post</li>
						</ol>
					</div>

					<div class="section-body contain-lg">
						<div class="row">
							<div class="col-lg-12">
								<div class="card card-tiles style-default-light">

									<!-- BEGIN BLOG POST HEADER -->
									<div class="row style-primary">
										<div class="col-sm-9">
											<div class="card-body style-default-dark">
												<h2>${post.title}</h2>
												<div class="text-default-light">Posted by <a href="#">${post.userEmail}</a></div>
											</div>
										</div><!--end .col -->
										<div class="col-sm-3">
											<div class="card-body">
												<div class="hidden-xs">
													<h3 class="text-light">${post.createdAt}</h3>
													<a href="#">2 comments <i class="fa fa-comment-o"></i></a>
													<div class="stick-top-right">
														<a class="btn btn-icon-toggle" data-toggle="tooltip" data-placement="top" data-original-title="Contact me"><i class="fa fa-envelope"></i></a><br/>
														<a class="btn btn-icon-toggle" data-toggle="tooltip" data-placement="top" data-original-title="Follow me"><i class="fa fa-twitter"></i></a><br/>
														<a class="btn btn-icon-toggle" data-toggle="tooltip" data-placement="top" data-original-title="Personal info"><i class="fa fa-facebook"></i></a>
													</div>
												</div>
												<div class="visible-xs">
													<strong>15</strong> Jan <a href="#">2 comments <i class="fa fa-comment-o"></i></a>
												</div>
											</div>
										</div><!--end .col -->
									</div><!--end .row -->
									<!-- END BLOG POST HEADER -->

									<div class="row">

										<!-- BEGIN BLOG POST TEXT -->
										<div class="col-md-9">
											<article class="style-default-bright">
												<div class="card-body" style="min-height:600px;">
													${post.content}
													<br/>
												</div><!--end .card-body -->
											</article>
										</div><!--end .col -->
										<!-- END BLOG POST TEXT -->

										<!-- BEGIN BLOG POST MENUBAR -->
										<div class="col-md-3" style="min-height:600px;">
											<div class="card-body"  style="min-height:600px;">
												<h3 class="text-light">Categories</h3>
												<ul class="nav nav-pills nav-stacked nav-transparent">
													<li><a href="#"><span class="badge pull-right">42</span>Design</a></li>
													<li><a href="#"><span class="badge pull-right">32</span>Technology</a></li>
												</ul>
												<h3 class="text-light" >Tags</h3>
												<div class="list-tags" style="min-height:300px;">
													<a class="btn btn-xs btn-primary">Wordpress</a>
												</div>
												<div style="vertical-align:text-bottom;">
													<a href="/board/${post.id}/delete" class="btn ink-reaction btn-primary" style="float:right; margin:5px;">삭제</a>												
													<a href="/board/${post.id}/edit" class="btn ink-reaction btn-primary" style=" float:right;margin:5px;">수정</a>												
												</div>
											</div><!--end .card-body -->
										</div><!--end .col -->
										<!-- END BLOG POST MENUBAR -->

									</div><!--end .row -->
								</div><!--end .card -->
							</div><!--end .col -->
						</div><!--end .row -->

						<!-- BEGIN COMMENTS -->
						<div class="row">
							<div class="col-md-9">
								<h4>5 Comments</h4>
								<ul class="list-comments">
									<li>
										<div class="card">
											<div class="comment-avatar"><i class="glyphicon glyphicon-user opacity-50"></i></div>
											<div class="card-body">
												<h4 class="comment-title">Jim Peters <small>20/06/2013 at 4:02 pm</small></h4>
												<a class="btn btn-default-dark stick-top-right" href="#respond">Reply</a>
												<p>Etiam dui libero, tempor quis congue in, interdum eget tortor. Vivamus aliquam dictum lacus quis tincidunt. Phasellus rhoncus ante sollicitudin nisl consectetur ultricies. Sed rhoncus ullamcorper mauris, ac condimentum metus egestas ut. Nam et urna ante, vitae pretium lacus.</p>
											</div>
										</div><!--end .card -->
									</li><!-- end comment -->
									<li>
										<div class="card">
											<div class="comment-avatar"><span class="glyphicon glyphicon-user opacity-50"></span></div>
											<div class="card-body">
												<h4 class="comment-title">CarolSharp <small>20/06/2013 at 4:14 pm</small></h4>
												<a class="btn btn-default-dark stick-top-right" href="#respond">Reply</a>
												<p>Integer ac magna lacinia velit bibendum ornare. Morbi eget dui lectus, eget eleifend mi. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus.</p>
											</div>
										</div><!--end .card -->
										<ul>
											<li>
												<div class="card style-default-dark">
													<div class="comment-avatar"><img class="img-circle" src="../../../assets/img/avatar1.jpg?1403934956" alt="" /></div>
													<div class="card-body">
														<h4 class="comment-title">Daniel Johnson <small>20/06/2013 at 4:38 pm</small></h4>
														<a class="btn btn-default-dark stick-top-right" href="#respond">Reply</a>
														<p>Sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Integer ac magna lacinia velit bibendum ornare. Morbi eget dui lectus, eget eleifend mi.</p>
													</div>
												</div><!--end .card -->
											</li><!-- end sub-comment -->
											<li>
												<div class="card">
													<div class="comment-avatar"><span class="glyphicon glyphicon-user opacity-50"></span></div>
													<div class="card-body">
														<h4 class="comment-title">Amber Page <small>20/06/2013 at 4:41 pm</small></h4>
														<a class="btn btn-default-dark stick-top-right" href="#respond">Reply</a>
														<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in tempus lorem. Vivamus ullamcorper leo risus, non vehicula odio.</p>
													</div>
												</div><!--end .card -->
												<ul>
													<li>
														<div class="card">
															<div class="comment-avatar"><img class="img-circle" src="../../../assets/img/avatar2.jpg?1404026449" alt="" /></div>
															<div class="card-body">
																<h4 class="comment-title">Janie Ward <small>20/06/2013 at 4:56 pm</small></h4>
																<a class="btn btn-default-dark stick-top-right" href="#respond">Reply</a>
																<p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Vestibulum in tempus lorem. Vivamus ullamcorper leo risus, non vehicula odio.</p>
															</div>
														</div><!--end .card -->
													</li><!-- end sub-sub-comment -->
												</ul>
											</li><!-- end sub-comment -->
										</ul>
									</li><!-- end comment -->
									<li>
										<div class="card">
											<div class="comment-avatar"><img class="img-circle" src="../../../assets/img/avatar3.jpg?1404026799" alt="" /></div>
											<div class="card-body">
												<h4 class="comment-title">Marshall Buchanan <small>21/06/2013 at 3:32 am</small></h4>
												<a class="btn btn-default-dark stick-top-right" href="#respond">Reply</a>
												<p>Vestibulum in tempus lorem. Vivamus ullamcorper leo risus, non vehicula odio. Lorem ipsum dolor sit amet, consectetur adipiscing elit.</p>
											</div>
										</div><!--end .card -->
									</li><!-- end comment -->
								</ul>
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END COMMENTS -->

						<!-- BEGIN LEAVE COMMENT -->
						<div class="row">
							<div class="col-md-9">
								<h4>Leave a comment</h4>
								<form class="form-horizontal" role="form">
									<div class="form-group">
										<div class="col-md-2">
											<label for="name" class="control-label">Name</label>
										</div>
										<div class="col-md-10">
											<input type="email" id="name" class="form-control control-width-normal" placeholder="Name">
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-2">
											<label for="email" class="control-label">Email</label>
										</div>
										<div class="col-md-10">
											<input type="text" id="email" class="form-control control-width-normal" placeholder="Email">
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-2">
											<label for="website" class="control-label">Website</label>
										</div>
										<div class="col-md-10">
											<input type="text" id="website" class="form-control control-width-normal" placeholder="Website">
										</div>
									</div>
									<div class="form-group">
										<div class="col-md-2">
											<label for="textarea1" class="control-label">Comment</label>
										</div>
										<div class="col-md-10">
											<textarea name="textarea1" id="textarea1" class="form-control autosize" rows="1" placeholder="Leave a comment"></textarea>
										</div>
									</div>
									<div class="form-footer col-md-offset-2">
										<button type="submit" class="btn btn-primary">Post comment</button>
									</div>
								</form>
							</div><!--end .col -->
						</div><!--end .row -->
						<!-- END LEAVE COMMENT -->

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
