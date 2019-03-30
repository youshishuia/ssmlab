<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 12:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%
        String path = request.getContextPath();
        String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
    %>
    <base href="<%=basePath%>">

    <meta http-equiv="Content-Type" content="text/html; charset=utf-8">
    <link rel="apple-touch-icon" sizes="76x76" href="assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>实验室预约系统</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <!-- CSS Files -->
    <link href="assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="assets/demo/demo.css" rel="stylesheet" />
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.js"></script>>
</head>
<body class="">
<div class="wrapper ">
    <div class="sidebar" data-color="orange">
        <!--
    Tip 1: You can change the color of the sidebar using: data-color="blue | green | orange | red | yellow"
-->
        <div class="logo">
            <a href="LRSindex" class="simple-text logo-mini">
                LRS
            </a>
            <a href="LRSindex" class="simple-text logo-normal">
                实验室预约系统
            </a>
        </div>
        <div class="sidebar-wrapper">
            <ul class="nav">
                <li>
                    <a href="BackLRSuserList">
                        <i class="now-ui-icons design_app"></i>
                        <p>用户信息</p>
                    </a>
                </li>
                <li class="active">
                    <a href="BackLRSFormEdit">
                        <i class="now-ui-icons location_map-big"></i>
                        <p>预约详情</p>
                    </a>
                </li>
                <li>
                    <a href="BackLRSuserEdit">
                        <i class="now-ui-icons users_single-02"></i>
                        <p>修改用户</p>
                    </a>
                </li>
                <li >
                    <a href="BackLRSForm">
                        <i class="now-ui-icons design_bullet-list-67"></i>
                        <p>预约列表</p>
                    </a>
                </li>
                <li>
                    <a href="BackLRSHelp">
                        <i class="now-ui-icons ui-2_favourite-28"></i>
                        <p>帮助预约</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="LRSindex">
                        <i class="now-ui-icons ui-1_settings-gear-63"></i>
                        <p>前台操作(管理员模式)</p>
                    </a>
                </li>
            </ul>
        </div>
    </div>
    <div class="main-panel">
        <!-- Navbar -->
        <nav class="navbar navbar-expand-lg navbar-transparent  navbar-absolute bg-primary fixed-top">
            <div class="container-fluid">
                <div class="navbar-wrapper">
                    <div class="navbar-toggle">
                        <button type="button" class="navbar-toggler">
                            <span class="navbar-toggler-bar bar1"></span>
                            <span class="navbar-toggler-bar bar2"></span>
                            <span class="navbar-toggler-bar bar3"></span>
                        </button>
                    </div>
                    <a class="navbar-brand" href="#">My Reservation</a>
                </div>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navigation" aria-controls="navigation-index" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                    <span class="navbar-toggler-bar navbar-kebab"></span>
                </button>
                <div class="collapse navbar-collapse justify-content-end" id="navigation">
                    <ul class="navbar-nav">
                        <li class="nav-item">
                            <a class="nav-link" href="index">
                                <i class="now-ui-icons users_single-02"></i>
                                <p>
                                    <span class="d-lg-none d-md-block">Account</span>
                                </p>
                            </a>
                        </li>
                    </ul>
                </div>
            </div>
        </nav>
        <!-- End Navbar -->
        <div class="panel-header panel-header-sm">
        </div>
        <div class="content">
            <div class="row">
                <div class="col-md-8">
                    <div class="card">
                        <div class="card-header">
                            <h5 class="title">修改信息</h5>
                        </div>
                        <div class="card-body">
                            <form action = "Edit" method = "post">
                                <div class="row">
                                    <div class="col-md-5 pr-1">
                                        <div class="form-group">
                                            <label>表单ID (查找预约表/不可修改)</label>
                                            <c:if test="${formView.formid!=null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="ID" value="${formView.formid}" name ="id">
                                            </c:if>
                                            <c:if test="${formView.formid==null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="ID" value="" name ="id">
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-5 pr-1">
                                        <div class="form-group">
                                            <label>用户名</label>
                                            <c:if test="${formView.username!=null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="Username" value="${formView.username}" name ="username">
                                            </c:if>
                                            <c:if test="${formView.username==null}" >
                                                <input type="text" class="form-control"  disabled="" placeholder="Username" value="" name ="username">
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-5 pr-1">
                                        <div class="form-group">
                                            <label>实验室名</label>
                                            <c:if test="${formView.labname!=null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="Labname" value="${formView.labname}" name="name">
                                            </c:if>
                                            <c:if test="${formView.labname==null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="Labname" value="" name="name">
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-5 pr-1">
                                        <div class="form-group">
                                            <label>实验室地址</label>
                                            <c:if test="${formView.address!=null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="Lab address" value="${formView.address}" name="address">
                                            </c:if>
                                            <c:if test="${formView.address==null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="Lab address" value="" name="address">
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 pr-1">
                                        <div class="form-group">
                                            <label>预约开始时间</label>
                                            <c:if test="${formView.appointment!=null}" >
                                                <input type="text" class="form-control" disabled=""  placeholder="请输入具体 年 月 日 小时 xxxx-xx-xx xx:00:00" value="${formView.appointment}" name="appointment">
                                            </c:if>
                                            <c:if test="${formView.appointment==null}" >
                                                <input type="text" class="form-control" disabled=""  placeholder="请输入具体 年 月 日 小时 xxxx-xx-xx xx:00:00" value="" name="appointment">
                                            </c:if>
                                        </div>
                                    </div>
                                    <div class="col-md-6 pr-1">
                                        <div class="form-group">
                                            <label>预约结束时间</label>
                                            <c:if test="${formView.appointmentend!=null}" >
                                                <input type="text" class="form-control"  disabled="" placeholder="请输入具体 年 月 日 小时 xxxx-xx-xx xx:00:00" value="${formView.appointmentend}" name="appointmentend">
                                            </c:if>
                                            <c:if test="${formView.appointmentend==null}" >
                                                <input type="text" class="form-control"  disabled="" placeholder="请输入具体 年 月 日 小时 xxxx-xx-xx xx:00:00" value="" name="appointmentend">
                                            </c:if>
                                        </div>
                                    </div>
                                </div>

                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>预约申请时间</label>
                                            <c:if test="${formView.applicationtime!=null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="Phone Num" value="${formView.applicationtime}" name ="phonenum">
                                            </c:if>
                                            <c:if test="${formView.applicationtime==null}" >
                                                <input type="text" class="form-control"  disabled="" placeholder="Phone Num" value="" name ="phonenum">
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 pr-1">
                                        <div class="form-group">
                                            <label>预约情况</label>
                                            <c:if test="${formView.pass!=null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="name" value="${formView.pass}" name ="name">
                                            </c:if>
                                            <c:if test="${formView.pass==null}" >
                                                <input type="text" class="form-control" disabled="" placeholder="name" value="" name ="name">
                                            </c:if>
                                        </div>
                                    </div>
                                </div>
                            </form>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <footer class="footer">
            <div class="container-fluid">
                <nav>
                    <ul>
                        <li>
                            <a href="#">
                                LRS
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                About Us
                            </a>
                        </li>
                        <li>
                            <a href="#">
                                Blog
                            </a>
                        </li>
                    </ul>
                </nav>
                <div class="copyright">
                    &copy;
                    LRS
                </div>
            </div>
        </footer>
    </div>
</div>
</body>
<!--   Core JS Files   -->
<script src="<%=basePath%>assets/js/core/jquery.min.js"></script>
<script src="<%=basePath%>assets/js/core/popper.min.js"></script>
<script src="<%=basePath%>assets/js/core/bootstrap.min.js"></script>
<script src="<%=basePath%>assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  Google Maps Plugin    -->

<!-- Chart JS -->
<script src="<%=basePath%>assets/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="<%=basePath%>assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script src="<%=basePath%>assets/js/now-ui-dashboard.js?v=1.0.1"></script>
<!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
<script src="<%=basePath%>assets/demo/demo.js"></script>

</html>
