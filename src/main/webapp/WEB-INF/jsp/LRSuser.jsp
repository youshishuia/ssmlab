<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/2/22
  Time: 12:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page  isELIgnored="false" contentType="text/html;charset=UTF-8" language="java" %>
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
                    <a href="LRSlab">
                        <i class="now-ui-icons design_app"></i>
                        <p>实验室</p>
                    </a>
                </li>
                <li>
                    <a href="LRSreservationinfo">
                        <i class="now-ui-icons location_map-big"></i>
                        <p>预约</p>
                    </a>
                </li>
                <li class="active" >
                    <a href="LRSuser">
                        <i class="now-ui-icons users_single-02"></i>
                        <p>用户中心</p>
                    </a>
                </li>
                <li>
                    <a href="LRSreservation">
                        <i class="now-ui-icons design_bullet-list-67"></i>
                        <p>我的预约</p>
                    </a>
                </li>
                <li class="active-pro">
                    <a href="backstage">
                        <i class="now-ui-icons ui-1_settings-gear-63"></i>
                        <p>后台操作(用户模式)</p>
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
                    <a class="navbar-brand" href="#">User Profile</a>
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
                            <form action = "updateuser" method = "post">
                                <div class="row">
                                    <div class="col-md-5 pr-1">
                                        <div class="form-group">
                                            <label>ID (disabled)</label>
                                            <input type="text" class="form-control" disabled="" placeholder="ID" value="${user.id}">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-5 pr-1">
                                        <div class="form-group">
                                            <label>用户名</label>
                                            <input type="text" class="form-control" disabled="" placeholder="Username" value="${user.username}">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-6 pr-1">
                                        <div class="form-group">
                                            <label>旧密码</label>
                                            <input type="text" class="form-control" placeholder="Old Password" value="" name ="oldpassword">
                                        </div>
                                    </div>
                                    <div class="col-md-6 pl-1">
                                        <div class="form-group">
                                            <label>新密码</label>
                                            <input type="text" class="form-control" placeholder="New Password" value="" name ="newpassword">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <label>电话号码</label>
                                            <input type="text" class="form-control" placeholder="Phone Num" value="${user.phonenum}" name ="phonenum">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-4 pr-1">
                                        <div class="form-group">
                                            <label>姓名</label>
                                            <input type="text" class="form-control" placeholder="name" value="${user.name}" name ="name">
                                        </div>
                                    </div>
                                    <div class="col-md-4 px-1">
                                        <div class="form-group">
                                            <label>年龄</label>
                                            <input type="text" class="form-control" placeholder="age" value="${user.age}" name ="age">
                                        </div>
                                    </div>
                                    <div class="col-md-4 pl-1">
                                        <div class="form-group">
                                            <label>身份</label>
                                            <input type="text" class="form-control" disabled="" placeholder="学生" value="${user.permission}">
                                        </div>
                                    </div>
                                </div>
                                <div class="row">
                                    <div class="col-md-12">
                                        <div class="form-group">
                                            <div class="row">
                                                <div class="col-md-11">
                                                </div>
                                                <div class="col-md-1">
                                                    <button href="#" class="btn btn-neutral btn-icon btn-round btn-lg text-right">
                                                        <i class="now-ui-icons ui-1_check"></i>
                                                    </button>
                                                </div>
                                            </div>
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
