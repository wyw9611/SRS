<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html lang="en" class="no-js">
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8"/>
<title>选课系统</title>
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta content="width=device-width, initial-scale=1.0" name="viewport"/>
<meta content="" name="description"/>
<meta content="" name="author"/>
<meta name="MobileOptimized" content="320">
<!-- BEGIN GLOBAL MANDATORY STYLES -->
<link href="plugins/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css"/>
<link href="plugins/bootstrap/css/bootstrap.min.css" rel="stylesheet" type="text/css"/>
<link href="plugins/uniform/css/uniform.default.css" rel="stylesheet" type="text/css"/>
<!-- END GLOBAL MANDATORY STYLES -->
<!-- BEGIN PAGE LEVEL STYLES -->
<link rel="stylesheet" type="text/css" href="plugins/select2/select2_metro.css"/>
<link rel="stylesheet" href="plugins/data-tables/DT_bootstrap.css"/>
<!-- END PAGE LEVEL STYLES -->
<!-- BEGIN THEME STYLES -->
<link href="css/style-metronic.css" rel="stylesheet" type="text/css"/>
<link href="css/style.css" rel="stylesheet" type="text/css"/>
<link href="css/style-responsive.css" rel="stylesheet" type="text/css"/>
<link href="css/plugins.css" rel="stylesheet" type="text/css"/>
<link href="css/themes/blue.css" rel="stylesheet" type="text/css" id="style_color"/>
<link href="css/custom.css" rel="stylesheet" type="text/css"/>
<!-- END THEME STYLES -->

<!-- sweetalert弹出框的css样式 -->
<link href="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.css" rel="stylesheet">

<link href="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.css" rel="stylesheet">

<link rel="shortcut icon" href="img/favicon.ico"/>
</head>
<!-- END HEAD -->
<!-- BEGIN BODY -->
<body class="page-header-fixed">
<!-- BEGIN HEADER -->
<div class="header navbar navbar-inverse navbar-fixed-top">
	<!-- BEGIN TOP NAVIGATION BAR -->
	<div class="header-inner">
		<!-- BEGIN LOGO -->
		<a class="navbar-brand" href="/index">
		<img src="img/logo1.png" alt="logo" class="img-responsive"/>
		</a>
		<!-- END LOGO -->
		<!-- BEGIN RESPONSIVE MENU TOGGLER -->
		<a href="javascript:;" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
		<img src="img/menu-toggler.png" alt=""/>
		</a>
		<!-- END RESPONSIVE MENU TOGGLER -->
		<!-- BEGIN TOP NAVIGATION MENU -->
		<ul class="nav navbar-nav pull-right">
		<!-- BEGIN USER LOGIN DROPDOWN -->
			<li class="dropdown user">
				<a href="#" class="dropdown-toggle" data-toggle="dropdown" data-hover="dropdown" data-close-others="true">
					<img alt="" src="img/user.jpg"/>
					<span class="username">
						${ sessionScope.student.name }
					</span>
					<i class="fa fa-angle-down"></i>
				</a>
				<ul class="dropdown-menu">
					<li>
						<a href="#"><i class="fa fa-user"></i> 个人信息</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-envelope"></i> 我的消息
						<span class="badge badge-danger">
							3
						</span>
						</a>
					</li>
					<li>
						<a href="#"><i class="fa fa-tasks"></i> 我的任务
						<span class="badge badge-success">
							7
						</span>
						</a>
					</li>
					<li class="divider">
					</li>
					<li>
						<a href="login"><i class="fa fa-key"></i> 安全退出</a>
					</li>
				</ul>
			</li>
			<!-- END USER LOGIN DROPDOWN -->
		</ul>
		<!-- END TOP NAVIGATION MENU -->
	</div>
	<!-- END TOP NAVIGATION BAR -->
</div>
<!-- END HEADER -->
<div class="clearfix">
</div>
<!-- BEGIN CONTAINER -->
<div class="page-container">
	<!-- BEGIN SIDEBAR -->
	<div class="page-sidebar-wrapper">
		<div class="page-sidebar navbar-collapse collapse">
			<!-- BEGIN SIDEBAR MENU -->
			<ul class="page-sidebar-menu">
				<li class="sidebar-toggler-wrapper">
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
					<div class="sidebar-toggler hidden-phone">
					</div>
					<!-- BEGIN SIDEBAR TOGGLER BUTTON -->
				</li>
				<li class="start ">
					<a href="/SRSDemo/index">
					<i class="fa fa-home"></i>
					<span class="title">
						学生选课
					</span>
					<span class="selected">
					</span>
					</a>
				</li>
				<li class=" ">
					<a href="/SRSDemo/professorSelectCourse">
					<i class="fa fa-bar-chart-o"></i>
					<span class="title">
						老师选课
					</span>
					</a>
				</li>
				<li class="start active ">
					<a href="/SRSDemo/course">
					<i class="fa fa-bar-chart-o"></i>
					<span class="title">
						我的课程
					</span>
					</a>
				</li>
				<li class="">
					<a href="/SRSDemo/transcript">
					<i class="fa fa-bar-chart-o"></i>
					<span class="title">
						成绩查询
					</span>
					</a>
				</li>
				<li class="">
					<a href="/SRSDemo/planOfStudy">
					<i class="fa fa-table"></i>
					<span class="title">
						教学计划
					</span>
					</a>
				</li>
				<li class="">
					<a href="/SRSDemo/professorManager">
					<i class="fa fa-user"></i>
					<span class="title">
						教师管理
					</span>
					</a>
				</li>
				<li class="last ">
					<a href="/SRSDemo/courseManager">
					<i class="fa fa-file-text"></i>
					<span class="title">
						课程管理
					</span>
					</a>
				</li>
			</ul>
			<!-- END SIDEBAR MENU -->
		</div>
	</div>
	<!-- END SIDEBAR -->
	<!-- BEGIN CONTENT -->
	<div class="page-content-wrapper">
		<div class="page-content">
		
			<!-- BEGIN PAGE HEADER-->
			<div class="row">
				<div class="col-md-12">
					<!-- BEGIN PAGE TITLE & BREADCRUMB-->
					<h3 class="page-title">
					 管理学院电子商务选课系统
					</h3>
					<ul class="page-breadcrumb breadcrumb">
						<li>
							<i class="fa fa-home"></i>
							<a href="/SRSDemo/index">主页</a>
							<i class="fa fa-angle-right"></i>
						</li>
						<li>
							<a href="/SRSDemo/course">我的课程</a>
						</li>
						<li class="pull-right">
							<div id="dashboard-report-range" class="dashboard-date-range tooltips" data-placement="top" data-original-title="Change dashboard date range">
								<i class="fa fa-calendar"></i>
								<span>
								</span>
								<i class="fa fa-angle-down"></i>
							</div>
						</li>
					</ul>
					<!-- END PAGE TITLE & BREADCRUMB-->
				</div>
			</div>
			<!-- END PAGE HEADER-->
			<!-- BEGIN DASHBOARD STATS -->
			<div class="row">
				<div class="col-md-12">
					<table id="table"></table>
				</div>
			</div>
			<!-- END DASHBOARD STATS -->
			<div class="clearfix">
			</div>
			<div id="dialog">
				<table id="showSectionStudent"></table>
			</div>
		</div>
	</div>
	<!-- END CONTENT -->
</div>
<!-- END CONTAINER -->
<!-- BEGIN FOOTER -->
<div class="footer">
	<div class="footer-inner">
		 2018 &copy; 管理学院电子商务选课系统.
	</div>
	<div class="footer-tools">
		<span class="go-top">
			<i class="fa fa-angle-up"></i>
		</span>
	</div>
</div>

<script src="plugins/jquery-1.10.2.min.js" type="text/javascript"></script>
<script src="plugins/jquery-migrate-1.2.1.min.js" type="text/javascript"></script>
<script src="plugins/bootstrap/js/bootstrap.min.js" type="text/javascript"></script>
<script src="plugins/bootstrap-hover-dropdown/twitter-bootstrap-hover-dropdown.min.js" type="text/javascript"></script>
<script src="plugins/jquery-slimscroll/jquery.slimscroll.min.js" type="text/javascript"></script>
<script src="plugins/jquery.blockui.min.js" type="text/javascript"></script>
<script src="plugins/jquery.cokie.min.js" type="text/javascript"></script>
<script src="plugins/uniform/jquery.uniform.min.js" type="text/javascript"></script>
<!-- END CORE PLUGINS -->
<!-- BEGIN PAGE LEVEL PLUGINS -->
<script type="text/javascript" src="plugins/select2/select2.min.js"></script>
<!-- END PAGE LEVEL PLUGINS -->
<!-- BEGIN PAGE LEVEL SCRIPTS -->
<script src="js/app.js"></script>

<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/bootstrap-table.min.js"></script>

<!-- Latest compiled and minified Locales -->
<script src="//cdnjs.cloudflare.com/ajax/libs/bootstrap-table/1.11.1/locale/bootstrap-table-zh-CN.min.js"></script>

<!-- sweetalert弹出框的js样式 -->
<script src="https://cdn.bootcss.com/sweetalert/1.1.3/sweetalert.min.js"></script>

<script src="https://cdn.bootcss.com/jqueryui/1.12.1/jquery-ui.min.js"></script>

<script>
	jQuery(document).ready(function() {    
	   App.init(); // initlayout and core plugins
	});
	$(function(){
		$( "#dialog" ).dialog({
		    autoOpen: false,
		    width: 400,
		    height: 500,
			title : '已选学生',
		    modal: true
		});
		$('#table').bootstrapTable({
			url:"http://localhost:8090/SRSDemo/showCourse",
			method:'post',
			idField:'sectionSn',
			striped:true,		//隔行变色
			singleSelect:true,	//禁止多选
			clickToSelect:true,	//点击行时，自动选择
			showToggle : true,	//切换试图的图标
// 			undefinedText:"无",	//数据为undefined时显示的字符
			showRefresh:true,	//刷新按钮
			pagination:true,	//显示分页条
			onlyInfoPagination:true,//仅显示总数据数
// 			sidePagination:'server',//在哪里进行分页
// 			showPaginationSwitch:true,//数据条数选择框
// 			pageNumber:1,			//首页页码
// 			pageSize:10,			//页面数据条数
// 			pageList:[10, 25, 50, 100, 'All'],
			dataField : 'rows',
			totalField : 'total',
			columns: [{
				checkbox: true
			}, {
				field: 'sectionNo',
				title: '课程编号'
			}, {
				field: 'name',
				title: '课程'
			}, {
				field: 'teacher',
				title: '教师'
			}, {
				field: 'time',
				title: '时间'
			}, {
				field: 'day',
				title: '周次'
			}, {
				field: 'room',
				title: '教室'
			},{
				field: 'capacity',
				title: '容量'
			},{
				field: 'credits',
				title: '学分'
			}, {
				field: 'select_btn',
				title: '操作',
				align: 'center',
				formatter: function(value, row, index){
					return "<button type='button' class='btn btn-danger' onclick=cancelSection("+row.sectionNo+",'"+row.name+"'"+")>退选</button>";
				}
			}]
		});
		
	})
	function cancelSection(sectionNo,name){
		var textValue="你确定退选"+name+"这门课程吗？"
		swal({
			  title: "系统提示",
			  text: textValue,
			  type: "info",
			  showCancelButton: true,
			  closeOnConfirm: false,
			  confirmButtonText: "确定",
			  cancelButtonText: "取消",
			  showLoaderOnConfirm: true,
			},
			function(){
				$.ajax({
				      url:'http://localhost:8090/SRSDemo/cancelSection',
				      data:{'sectionNo':sectionNo}, 
				      method:'POST',
				      success:function(res){
				    	  $('#table').bootstrapTable('refresh');
				    	  swal("退选成功！");
				      }						    
				})
		});
	};
	function queryEnrolledStudents(sectionNo){
		var url = "http://localhost:8090/SRSDemo/queryEnrolledStudents";
		$('#showSectionStudent').bootstrapTable('refresh',{url: url, query: {sectionNo: sectionNo}});
		$( "#dialog" ).dialog( "open" );
	};
</script>
<!-- END JAVASCRIPTS -->
</body>
<!-- END BODY -->
</html>