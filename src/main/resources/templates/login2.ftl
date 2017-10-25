<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="http://localhost:8080/">
    <title>欢迎登录</title>
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
<div id="loginWin" class="easyui-window" title="登录" style="width:350px;height:188px;padding:5px;"
     minimizable="false" maximizable="false" resizable="false" collapsible="false">
    <div class="easyui-layout" fit="true">
        <div region="center" border="false" style="padding:5px;background:#fff;border:1px solid #ccc;">
            <form id="loginForm" method="post">
                <div style="padding:5px 0;">
                    <label for="login">帐号:</label>
                    <input type="text" name="code" style="width:260px;"></input>
                </div>
                <div style="padding:5px 0;">
                    <label for="password">密码:</label>
                    <input type="password" name="password" style="width:260px;"></input>
                    <input type="hidden" name="registSource" value="1" style="width:260px;"></input>
                </div>
                <div style="padding:5px 0;text-align: center;color: red;" id="showMsg"></div>
            </form>
        </div>
        <div region="south" border="false" style="text-align:right;padding:5px 0;">
            <a class="easyui-linkbutton" iconCls="icon-ok" href="javascript:void(0)" onclick="login()">登录</a>
            <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="regist()">注册</a>
        </div>
        <div id="dlg" class="easyui-dialog" title="注册" data-options="iconCls:'icon-save',closed:'true'" style="width:400px;height:200px;padding:10px">
            <form id="registForm" method="post">
                <div style="padding:5px 0;">
                    <label for="login">手机号码:</label>
                    <input type="text" name="mobile" style="width:260px;"></input>
                </div>
                <div style="padding:5px 0;">
                    <label for="password">密码:</label>
                    <input type="text" name="password2" style="width:260px;"></input>
                    <input type="hidden" name="registSource" value="1" style="width:260px;"></input>
                </div>
                <div style="padding:5px 0;text-align: center;color: red;" id="showMsg2"></div>
                <div region="south" border="false" style="text-align:right;padding:5px 0;">
                    <a class="easyui-linkbutton" iconCls="icon-cancel" href="javascript:void(0)" onclick="sureRegist()">注册</a>
                </div>
            </form>
        </div>
    </div>
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
                    location.href = "indexView";
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