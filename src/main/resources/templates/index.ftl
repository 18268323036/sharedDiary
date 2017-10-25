<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>日记首页</title>
    <base href="http://localhost:8080/">
    <link href="css/jquery.autocomplete.css" rel="stylesheet"/>
    <link href="css/style.css" rel="stylesheet"/>
    <link href="css/icon.css" rel="stylesheet"/>
    <link href="css/easyui.css" rel="stylesheet"/>
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/default/easyui.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/icon.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/themes/color.css">
    <link rel="stylesheet" type="text/css" href="https://www.jeasyui.com/easyui/demo/demo.css">
    <script type="text/javascript" src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/jquery.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/jquery.easyui.mobile.js"></script>
</head>
<body>
<h1>欢迎${user.username}光临!请选择你的操作:</h1><br>
<ul>
        <@shiro.hasPermission name="add"><li>增加</li></@shiro.hasPermission>
        <@shiro.hasPermission name="delete"><li>删除</li></@shiro.hasPermission>
        <@shiro.hasPermission name="update"><li>修改</li></@shiro.hasPermission>
        <@shiro.hasPermission name="query"><li>查询</li></@shiro.hasPermission>
</ul>
<a href="http://localhost:8080/logOut">点我注销</a>
</body>