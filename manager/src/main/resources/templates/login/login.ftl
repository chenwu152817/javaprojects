<!DOCTYPE HTML>
<html>
<head>
<title>成绩管理系统登录</title>
<link href="/manager/css/style1.css" rel="stylesheet" type="text/css" media="all"/>
</head>
<body>
<div class="login-form">
			<div class="top-login">
				<span><img src="/manager/images/group.png" alt=""/></span>
			</div>
			<h1>登录</h1>
			<div class="login-top">
				<div class="login-ic">
                    <i ></i>
					<input type="text" id="teacherId" />
					<div class="clear"> </div>
				</div>
				<div class="login-ic">
                    <i class="icon"></i>
					<input type="password" id="teacherPassword" />
					<div class="clear"> </div>
				</div>
				<div class="log-bwn">
					<input type="submit" value="Login" id="Login" >
				</div>
			</div>
</div>
    <script src="https://apps.bdimg.com/libs/jquery/1.11.1/jquery.js"></script>
	<script>
		$(document).ready(function(){
			$("#Login").click(
					function(){
						login();
					});
		});
		function login(){
			var teacherId =$("#teacherId").val();
			var teacherPassword =$("#teacherPassword").val();
			$.ajax(
					{
						type:"post",
						url:"/manager/user/login",
						dataType: "json",
						data: {
                            teacherId:teacherId,
                            teacherPassword:teacherPassword
                         },
                        success:function (data) {
                            console.log(data)
                            if(data.success){
                                window.location.href = "/manager/course/list";
                            }else{
                                alert("发生错误："+ data.msg);
                            }
                        },
                        error:function (jqXHR) {
                            alert("发生错误：" +jqXHR.status);
                        }
					}
			)}



	</script>

</body>
</html>