<!DOCTYPE html>
<html>
<head>
	<title>登录表单</title>
	<!-- Meta-Tags -->
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<link href="css/jquery.autocomplete.css" rel="stylesheet"/>
		<link href="css/style.css" rel="stylesheet"/>
		<link href="css/icon.css" rel="stylesheet"/>
		<link href="css/easyui.css" rel="stylesheet"/>
		<script type="text/javascript" src="js/jquery.min.js"></script>
		<script type="text/javascript" src="js/jquery.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/jquery.easyui.mobile.js"></script>
</head>
<body>
	<h1>登录表单</h1>
	<div class="container w3layouts agileits">
		<div class="login w3layouts agileits">
			<h2>登 录</h2>
            <form id="loginForm" method="post">
				<input type="text" name="code" placeholder="用户名" required="">
				<input type="password" name="password" placeholder="密码" required="">
                <input type="hidden" name="registSource" value="1" style="width:260px;"></input>
			</form>
			<ul class="tick w3layouts agileits">
				<li>
					<input type="checkbox" id="brand1" value="">
					<label for="brand1"><span></span>记住我</label>
				</li>
			</ul>
			<div class="send-button w3layouts agileits">
				<form>
					<input type="submit" value="登 录" onclick="login()">
				</form>
			</div>
			<a href="#">记住密码?</a>
			<div class="social-icons w3layouts agileits">
				<p>- 其他方式登录 -</p>
				<ul>
					<li class="qq"><a href="#">
					<span class="icons w3layouts agileits"></span>
					<span class="text w3layouts agileits">QQ</span></a></li>
					<li class="weixin w3ls"><a href="#">
					<span class="icons w3layouts"></span>
					<span class="text w3layouts agileits">微信</span></a></li>
					<li class="weibo aits"><a href="#">
					<span class="icons agileits"></span>
					<span class="text w3layouts agileits">微博</span></a></li>
					<div class="clear"> </div>
				</ul>
			</div>
			<div class="clear"></div>
		</div>
		

		<div class="register w3layouts agileits">
			<h2>注 册</h2>
            <form id="registForm" method="post">
				<input type="text" Name="name" placeholder="用户名" required="">
				<input type="text" Name="email" placeholder="邮箱" required="">
				<input type="password" Name="password2" placeholder="密码" required="">
				<input type="text" Name="mobile" placeholder="手机号码" required="">
                <input type="hidden" name="registSource" value="1" style="width:260px;"></input>
			</form>
			<div class="send-button w3layouts agileits">
				<form>
					<input type="submit" value="注册" onclick="sureRegist()">
				</form>
			</div>
			<div class="clear"></div>
		</div>
		<div class="clear"></div>
	</div>

	<div class="footer w3layouts agileits">
		<p>Copyright &copy; More Templates</p>
	</div>

</body>
<script type="text/javascript">
    document.onkeydown = function(e){
        var event = e || window.event;
        var code = event.keyCode || event.which || event.charCode;
        if (code == 13) {
            login();
        }
    }
    $(function(){
        $("input[name='login']").focus();
    });
    function regist(){
        $('#dlg').dialog('open');
    }
    function login(){
        if($("input[name='code']").val()=="" || $("input[name='password']").val()==""){
            $("#showMsg").html("用户名或密码为空，请输入");
            $("input[name='code']").focus();
        }else{
            //ajax异步提交
            $.ajax({
                type:"POST",   //post提交方式默认是get
                url:"login",
                data:$("#loginForm").serialize(),   //序列化
                success:function(data) {
					if(data.code==1){
                        location.href = "indexView";
					}else{
                        $("#showMsg").html("密码错误");
					}
                }
            });
        }
    }
    function sureRegist(){
        if($("input[name='mobile']").val()=="" || $("input[name='password2']").val()==""){
            $("#showMsg2").html("请将信息填写完整");
            $("input[name='mobile']").focus();
        }else{
            //ajax异步提交
            $.ajax({
                type:"POST",   //post提交方式默认是get
                url:"register",
                data:$("#registForm").serialize(),   //序列化
                success:function(data) {
                    if(data.code!=1){
                        $.messager.alert('',data.message);
                    }else{
                        $.messager.alert('',"注册成功");
                    }
                }
            });
        }
    }
</script>
</html>