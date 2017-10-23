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
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyDiary()">删除</a>
</div>

<div id="timeSelection">
    <div style="padding:10px">
        <input type="radio" name="deadTime" value="1"><span>1小时以后</span><br/>
        <input type="radio" name="deadTime" value="2"><span>2小时以后</span><br/>
        <input type="radio" name="deadTime" value="5"><span>5小时以后</span><br/>
        <input type="radio" name="deadTime" value="12"><span>12小时以后</span><br/>
        <input type="radio" name="deadTime" value="24"><span>24小时以后</span>
    </div>
</div>

<div id="isAnonymitySelection">
    <div style="padding:10px">
        <input type="radio" name="deadTime" value="0"><span>否</span><br/>
        <input type="radio" name="deadTime" value="1"><span>是</span><br/>
    </div>
</div>

<div id="publishDiary" class="easyui-dialog" style="width:400px"
     closed="true" buttons="#dlg-buttons2">
    <form id="publishDiaryForm" method="post" novalidate style="margin:0;padding:20px 50px">
        <div style="margin-bottom:20px;font-size:14px;border-bottom:1px solid #ccc">发布日记</div>
        <div style="margin-bottom:10px">
            <input id="deadTime" name="deadTime" style="width:100%;">
        </div>
        <div style="margin-bottom:10px">
            <input id="isAnonymity" name="isAnonymity" style="width:100%;">
        </div>
        <input type="hidden" id="selectedDiaryId" value="" name="diaryTextId">
    </form>
</div>
<div id="dlg-buttons2">
    <a href="javascript:void(0)" class="easyui-linkbutton c6" iconCls="icon-ok" onclick="publish()" style="width:90px">Save</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#publishDiary').dialog('close')" style="width:90px">Cancel</a>
</div>

<div id="diary_text" class="easyui-panel" title="我的日记" style="width:700px;height:200px;padding:10px;">
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="saveDiary()">保存</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="publishDiary()">发布</a>
    <input id="diary_title_input" class="easyui-textbox" data-options="prompt:'日记标题在这儿'" style="width:650px;height:32px">
    <input id="diary_text_input" class="easyui-textbox" data-options="multiline:true"
           value="" style="width:650px;height:180px">
</div>

<div style="float: right;position:absolute; right:20px; top:20px;">
    <table id="dg" title="小酒馆" class="easyui-datagrid" style="width:400px;height:250px;display: inline"
           url="queryPublishedDiaryDetail"
           toolbar="#toolbar" pagination="false"
           rownumbers="false" fitColumns="true" singleSelect="true">
        <thead>
        <tr>
            <th field="title" width="50">标题</th>
            <th field="userId" width="50">作者</th>
            <th field="content" width="50">内容摘要</th>
        </tr>
        </thead>
    </table>
</div>


<script type="text/javascript">
    var url;

    $(function(){
        $('#deadTime').combo({
            required:true,
            editable:false,
            label:'销毁时间',
            labelPosition:'top'
        });
        $('#timeSelection').appendTo($('#deadTime').combo('panel'));
        $('#timeSelection input').click(function(){
            var v = $(this).val();
            var s = $(this).next('span').text();
            $('#deadTime').combo('setValue', v).combo('setText', s).combo('hidePanel');
        });
    });
    $(function(){
        $('#isAnonymity').combo({
            required:true,
            editable:false,
            label:'是否匿名',
            labelPosition:'top'
        });
        $('#isAnonymitySelection').appendTo($('#isAnonymity').combo('panel'));
        $('#isAnonymitySelection input').click(function(){
            var v = $(this).val();
            var s = $(this).next('span').text();
            $('#isAnonymity').combo('setValue', v).combo('setText', s).combo('hidePanel');
        });
    });

    $("#dg").datagrid({
        onClickRow:function(index,row){
            var row = $('#dg').datagrid('getSelected');
            $("#diary_text_input").textbox("setValue", "");
            $("#diary_title_input").textbox("setValue", "");
            if(row){
                $('#diary').datagrid({
                    url:'queryDiary',
                    queryParams :
                        {folderId:row.id},
                    columns:[[
                        {field:'diaryTitle',title:'标题',width:100},
                        {field:'createTime',title:'时间',width:100},
                        {field:'diaryContent',title:'内容摘要',width:100}
                    ]],
                    onDblClickCell : function(rowIndex, rowData){

                    }
                });
            }
        }
    });

    $("#diary").datagrid({
        onClickRow:function(index,row){
            $("#diary_text_input").textbox("setValue", "");
            var row = $('#diary').datagrid('getSelected');
            if(row){
                $.post('diaryDetail',{diaryTextId:row.id},function(result){
                    if (result.code==1){
                        var content = result.t.diaryContent;
                        var title = result.t.diaryTitle;
                        $("#diary_text_input").textbox("setValue", content);
                        $("#diary_title_input").textbox("setValue",title);
                        url = "updateDiary";
                    } else {
                        $.messager.show({    // show error message
                            title: 'Error',
                            msg: result.message
                        });
                    }
                },'json');
            }
        }
    });

    function newDiary(){
        url = "addDiary";
        $("#diary_text_input").textbox("setValue", "");
        $("#diary_title_input").textbox("setValue", "");
    }

    function publish(){
        var data = $("#publishDiaryForm").serialize();
        $.post("publishDiary",data,function(result){
            if (result.code!=1){
                $.messager.show({
                    title: 'Error',
                    msg: result.message
                });
            } else {
                location.reload();
            }
        });
    }

    function saveDiary(){
        var text = $("#diary_text_input").textbox("getText");
        if(url=="addDiary"){
            $.post(url,
                    {diaryTitle:$("#diary_title_input").val(),diaryContent:text,folderId:$('#dg').datagrid('getSelected').id},
            function(result){
                if (result.code!=1){
                    $.messager.show({
                        title: 'Error',
                        msg: result.message
                    });
                } else {
                    location.reload();
                }
            });
        }else{
            $.post(url,
                    {diaryTitle:$("#diary_title_input").val(),diaryContent:text,id:$('#diary').datagrid('getSelected').id
                        ,folderId:$('#dg').datagrid('getSelected').id},
            function(result){
                if (result.code!=1){
                    $.messager.show({
                        title: 'Error',
                        msg: result.message
                    });
                } else {
                    location.reload();
                }
            });
        }
    }

    function publishDiary(){
        $('#publishDiary').dialog('open').dialog('center').dialog('setTitle','发布日记');
        $("#selectedDiaryId").val($('#diary').datagrid('getSelected').id);
    }

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
                        msg: result.message
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