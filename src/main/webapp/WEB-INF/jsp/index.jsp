
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <link rel="apple-touch-icon" sizes="76x76" href="../../assets/img/apple-icon.png">
    <link rel="icon" type="image/png" href="../../assets/img/favicon.png">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1" />
    <title>实验室预约系统</title>
    <meta content='width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=0, shrink-to-fit=no' name='viewport' />
    <!--     Fonts and icons     -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700,200" rel="stylesheet" />
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
    <link rel='stylesheet' href='https://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>
    <!-- CSS Files -->
    <link href="../../assets/css/bootstrap.min.css" rel="stylesheet" />
    <link href="../../assets/css/now-ui-dashboard.css?v=1.0.1" rel="stylesheet" />
    <!-- CSS Just for demo purpose, don't include it in your project -->
    <link href="../../assets/demo/demo.css" rel="stylesheet" />
    <style type="text/css">
        body {
            background: #e9e9e9;
            color: #666666;
            font-family: 'RobotoDraft', 'Roboto', sans-serif;
            font-size: 14px;
            -webkit-font-smoothing: antialiased;
            -moz-osx-font-smoothing: grayscale;
        }

        /* Pen Title */
        .pen-title {
            padding: 50px 0;
            text-align: center;
            letter-spacing: 2px;
        }
        .pen-title h1 {
            margin: 0 0 20px;
            font-size: 48px;
            font-weight: 300;
        }
        .pen-title span {
            font-size: 12px;
        }
        .pen-title span .fa {
            color: #33b5e5;
        }
        .pen-title span a {
            color: #33b5e5;
            font-weight: 600;
            text-decoration: none;
        }

        /* Form Module */
        .form-module {
            position: relative;
            background: #ffffff;
            max-width: 320px;
            width: 100%;
            border-top: 5px solid #FF6347;
            box-shadow: 0 0 3px rgba(0, 0, 0, 0.1);
            margin: 0 auto;
        }
        .form-module .toggle {
            cursor: pointer;
            position: absolute;
            top: -0;
            right: -0;
            background: #FF6347;
            width: 30px;
            height: 30px;
            margin: -5px 0 0;
            color: #ffffff;
            font-size: 12px;
            line-height: 30px;
            text-align: center;
        }
        .form-module .toggle .tooltip {
            position: absolute;
            top: 5px;
            right: -65px;
            display: block;
            background: rgba(0, 0, 0, 0.6);
            width: auto;
            padding: 5px;
            font-size: 10px;
            line-height: 1;
            text-transform: uppercase;
        }
        .form-module .toggle .tooltip:before {
            content: '';
            position: absolute;
            top: 5px;
            left: -5px;
            display: block;
            border-top: 5px solid transparent;
            border-bottom: 5px solid transparent;
            border-right: 5px solid rgba(0, 0, 0, 0.6);
        }
        .form-module .form {
            display: none;
            padding: 40px;
        }
        .form-module .form:nth-child(2) {
            display: block;
        }
        .form-module h2 {
            margin: 0 0 20px;
            color: #FF6347;
            font-size: 18px;
            font-weight: 400;
            line-height: 1;
        }
        .form-module input {
            outline: none;
            display: block;
            width: 100%;
            border: 1px solid #d9d9d9;
            margin: 0 0 20px;
            padding: 10px 15px;
            box-sizing: border-box;
            font-wieght: 400;
            transition: 0.3s ease;
        }
        .form-module input:focus {
            border: 1px solid #33b5e5;
            color: #333333;
        }
        .form-module button {
            cursor: pointer;
            background: #FF6347;
            width: 100%;
            border: 0;
            padding: 10px 15px;
            color: #ffffff;
            transition: 0.3s ease;
        }
        .form-module button:hover {
            background: #178ab4;
        }
        .form-module .cta {
            background: #f2f2f2;
            width: 100%;
            padding: 15px 40px;
            box-sizing: border-box;
            color: #666666;
            font-size: 12px;
            text-align: center;
        }
        .form-module .cta a {
            color: #333333;
            text-decoration: none;
        }

    </style>
</head>
<body>
<!-- Form Mixin-->
<!-- Input Mixin-->
<!-- Button Mixin-->
<!-- Pen Title-->
<div class="pen-title">
    <h2><font color=#FF6347>登录/注册</h2>
</div>
<!-- Form Module-->
<div class="module form-module">
    <div class="toggle"><i class="fa fa-times fa-pencil"></i>
        <h2>↑<br>Click</h2>

    </div>
    <div class="form">
        <h2><font color=#FF6347>用户登录</h2>
        <form action = "login1" method = "post">
            <input type="text" placeholder="Username" name = "username"/>
            <input type="password" placeholder="Password" name = "password"/>
            <button>登录</button>
        </form>
    </div>
    <div class="form">
        <h2>用户注册</h2>
        <form action = "register1" method = "post" onsubmit = "return checkForm();">
            <input type="text" placeholder="Username" name = "username" id = "usernameId" onkeyup = "checkName();"/>
            <span id = "usernameMsg"></span><br/>
            <input type="password" placeholder="Password" name = "password" id = "passwordId" onkeyup = "checkPassword();"/>
            <span id = "passwordMsg"></span><br/>
            <button>注册</button>
        </form>
    </div>
    <div class="cta"><a href="">Forgot your password?</a></div>
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
</body>
<!--   Core JS Files   -->
<script src="../../assets/js/core/jquery.min.js"></script>
<script src="../../assets/js/core/popper.min.js"></script>
<script src="../../assets/js/core/bootstrap.min.js"></script>
<script src="../../assets/js/plugins/perfect-scrollbar.jquery.min.js"></script>
<!--  this page JS    -->
<script>
    // Toggle Function
    $('.toggle').click(function(){
        // Switches the Icon
        $(this).children('i').toggleClass('fa-pencil');
        // Switches the forms
        $('.form').animate({
            height: "toggle",
            'padding-top': 'toggle',
            'padding-bottom': 'toggle',
            opacity: "toggle"
        }, "slow");
    });
</script>

<script type = "text/javascript">
    var usernameObj;
    var passwordObj;
    var phoneObj;
    var usernameMsg;
    var passwordMsg;
    window.onload = function(){
        usernameObj = document.getElementById("usernameId");
        passwordObj = document.getElementById("passwordId");
        phoneObj = document.getElementById("phoneId");
        usernameMsg = document.getElementById("usernameMsg");
        passwordMsg = document.getElementById("passwordMsg");
    }
    function checkName(){
        var value = usernameObj.value;
        var regex = /[a-zA-Z]{3,8}/;
        if(value===""){
            usernameMsg.innerHTML = "用户名必须填写";
            return false;
        }
        else if (!regex.test(value)){
            usernameMsg.innerHTML = "用户名要是3-8个字母组成";
            return false;
        }
        else{
            usernameMsg.innerHTML = "";
            return true;
        }
    }

    function checkPassword(){
        var value = passwordObj.value;
        var regex = /\d{3,8}/;
        if(value===""){
            passwordMsg.innerHTML = "密码必须填写";
            return false;
        }
        else if (!regex.test(value)){
            passwordMsg.innerHTML = "密码要3-8个数字组成";
            return false;
        }
        else{
            passwordMsg.innerHTML = "";
            return true;
        }

    }
    function checkForm(){
        var usernameFlag = checkName();
        var passwordFlag = checkPassword();
        return usernameFlag && passwordFlag;
    }
</script>
<!-- Chart JS -->
<script src="../../assets/js/plugins/chartjs.min.js"></script>
<!--  Notifications Plugin    -->
<script src="../../assets/js/plugins/bootstrap-notify.js"></script>
<!-- Control Center for Now Ui Dashboard: parallax effects, scripts for the example pages etc -->
<script src="../../assets/js/now-ui-dashboard.js?v=1.0.1"></script>
<!-- Now Ui Dashboard DEMO methods, don't include it in your project! -->
<script src="../../assets/demo/demo.js"></script>

</html>
