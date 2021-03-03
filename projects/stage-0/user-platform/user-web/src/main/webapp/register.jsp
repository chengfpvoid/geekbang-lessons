<head>
    <jsp:directive.include file="/WEB-INF/jsp/prelude/include-head-meta.jspf" />
    <title>注册</title>
    <style>
        .bd-placeholder-img {
            font-size: 1.125rem;
            text-anchor: middle;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
            user-select: none;
        }

        @media (min-width: 768px) {
            .bd-placeholder-img-lg {
                font-size: 3.5rem;
            }
        }
    </style>
</head>

    <script type="text/javascript" src="static/js/jquery-3.5.1.slim.min.js"></script>
    <script type="text/javascript">
        $(document).ready(function(){
            //alert("测试jQuery是否能用");
            $("#form1").submit(function(){
                var name=$("#name").val();//获取提交的值
                if(name.length==0){//进行判断，如果获取的值为0那么提示账号不能为空
                    //alert("aa");//测试使用
                    $("#nameError").html("账号不能为空");
                    return false;
                }

                //密码进行验证不能为空
                var password=$("#password").val();//获取提交的密码的值
                if(password.length==0){
                    $("#passwordError").html("密码不能为空");
                    return false;
                }

                //确认密码进行验证
                var relpassword=$("#relpassword").val();//获取提交的确认密码的值
                if(relpassword.length==0){
                    $("#relpasswordError").html("确认密码不能为空哦");
                    return false;
                }

                if(password!=relpassword){
                    $("#relpasswordError").html("确认密码输入不正确，请重新输入");
                    return false;
                }
            });

        });
    </script>
</head>
<body>
<form action="register" method="post" id="form1">
    <h1>用户注册</h1>
    <hr/>
    <table align="center">
        <tr>
            <td>用    户     名：</td>
            <td>
                <input type="text" name="name" id="name"/>
                <div id="nameError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>密      码：</td>
            <td>
                <input type="password" name="password" id="password">
                <div id="passwordError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>确认密码：</td>
            <td>
                <input type="password" name="relpassword" id="relpassword">
                <div id="relpasswordError" style="display:inline;color:red;"></div>
            </td>
        </tr>
        <tr>
            <td>电话号码：</td>
            <td><input type="text" name="phone" id="phone"></td>
        </tr>
        <tr>
            <td>电子邮件：</td>
            <td><input type="text" name="email" id="email"></td>
        </tr>
        <tr>
            <td colspan="1">
            </td>
            <td>
                <input type="submit" value="注册"/>
                <input type="reset" value="重置"/>
                <a href="login-form.jsp" target="_blank">登陆</a>
            </td>
        </tr>
    </table>
</form>
</body>

