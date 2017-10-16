<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <base href="http://localhost:8080/">
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
<table id="dg" title="My Diary Folder" class="easyui-datagrid" style="width:400px;height:250px;display: inline"
       url="queryFolderList"
       toolbar="#toolbar" pagination="false"
       rownumbers="false" fitColumns="true" singleSelect="true">
    <thead>
    <tr>
        <th field="name" width="50">日记本</th>
        <th field="diaryAmount" width="50">日记数</th>
    </tr>
    </thead>
</table>
<div id="toolbar">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newDiaryFolder()">新建</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDiaryFolder()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyDiaryFolder()">删除</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px"
     closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">新建日记本</div>
        <div style="margin-bottom:10px">
            <input name="name" class="easyui-textbox" required="true" label="日记本姓名:" style="width:100%">
        </div>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveDiaryFolder()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>

<table id="diary" title="My Diary" class="easyui-datagrid" style="width:400px;height:250px;display: inline"
    toolbar="#toolbarDiary" pagination="false"
    rownumbers="false" fitColumns="true" singleSelect="true">
    <thead>
        <tr>
            <th field="diaryTitle" width="100">标题</th>
            <th field="createTime" width="100">时间</th>
            <th field="diaryContent" width="100">内容摘要</th>
        </tr>
    </thead>
</table>
<div id="toolbarDiary">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newDiary()">新建</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editDiary()">编辑</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyDiary()">删除</a>
</div>

<div id="dlg" class="easyui-dialog" style="width:400px"
    closed="true" buttons="#dlg-buttons">
    <form id="fm" method="post" novalidate style="margin:0;padding:20px 50px">
        <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">新建日记本</div>
            <div style="margin-bottom:10px">
                <input name="name" class="easyui-textbox" required="true" label="日记本姓名:" style="width:100%">
            </div>
    </form>
</div>

<div id="dlg-buttons">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="saveDiary()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')" style="width:90px">Cancel</a>
</div>

<script type="text/javascript">

    $("#dg").datagrid({
        onClickRow:function(index,row){
            var row = $('#dg').datagrid('getSelected');
            if(row){
                $('#diary').datagrid({
                    url:'queryDiary',
                    queryParams :
                        {folderId:row.id},
                    columns:[[
                        {field:'diaryTitle',title:'标题',width:100},
                        {field:'createTime',title:'时间',width:100,
                        formatter:function(value,row,index){

                        }},
                        {field:'diaryContent',title:'内容摘要',width:100}
                    ]],
                    onDblClickCell : function(rowIndex, rowData){

                    }
                });
            }
        }
    });


    var url;
    function newDiaryFolder(){
        $('#dlg').dialog('open').dialog('center').dialog('setTitle','New Diary');
        $('#fm').form('clear');
        url = 'addFolder';
    }
    function editDiaryFolder(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $('#dlg').dialog('open').dialog('center').dialog('setTitle','Edit Diary');
            $('#fm').form('load',row);
            url = "updateFolder?id="+row.id;
        }
    }
    function saveDiaryFolder(){
        $('#fm').form('submit',{
            url: url,
            onSubmit: function(){
                return $(this).form('validate');
            },
            success: function(result){
                var result = eval('('+result+')');
                if (result.errorMsg){
                    $.messager.show({
                        title: 'Error',
                        msg: result.errorMsg
                    });
                } else {
                    $('#dlg').dialog('close');        // close the dialog
                    $('#dg').datagrid('reload');    // reload the Diary data
                }
            }
        });
    }
    function destroyDiaryFolder(){
        var row = $('#dg').datagrid('getSelected');
        if (row){
            $.messager.confirm('Confirm','确定要删除该日记本,删除日记本的同时日记本下的日记也会删除?',function(r){
                if (r){
                    $.post('deleteFolder',{folderId:row.id},function(result){
                        if (result.code==1){
                            $('#dg').datagrid('reload');    // reload the Diary data
                        } else {
                            $.messager.show({    // show error message
                                title: 'Error',
                                msg: result.message
                            });
                        }
                    },'json');
                }
            });
        }
    }


</script>


</body>
</html>