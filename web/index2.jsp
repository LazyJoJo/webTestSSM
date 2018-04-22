<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/4/21
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>
<head>
    <title>Title</title>

    <script src="bootstrap/js/jquery.min.js"></script>
    <!-- 最新版本的 Bootstrap 核心 CSS 文件 -->
   <%-- <link rel="stylesheet" href="bootstrap/bootstrap.min.css" />
    <link rel="stylesheet" href="bootstrap/bootstrap-theme.min.css" />--%>
    <link rel="stylesheet" href="bootstrap/css/bootstrap.css" />
    <link rel="stylesheet" href="bootstrap/css/bootstrap-theme.css" />
    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="bootstrap/js/bootstrap.js"></script>

    <link rel="stylesheet" type="text/css" href="easyui/lib_jquery-easyui-1.5.2/themes/default/easyui.css"></link>
    <link rel="stylesheet" type="text/css" href="easyui/lib_jquery-easyui-1.5.2/themes/icon.css"></link>
    <link rel="stylesheet" type="text/css" href="easyui/lib_jquery-easyui-1.5.2/demo/common.css"></link>
    <script type="text/javascript" src="easyui/lib_jquery-easyui-1.5.2/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="easyui/lib_jquery-easyui-1.5.2/locale/easyui-lang-zh_CN.js"></script>
    <link rel="stylesheet" type="text/css" href="easyui/view/css/icon.css"></link>

</head>
<body>
<%--<ul class="nav nav-tabs">
    ...
    <li role="presentation" class="dropdown">
        <a class="dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
            Dropdown <span class="caret"></span>
        </a>
        <ul class="dropdown-menu">
            ...
        </ul>
    </li>
    ...
</ul>
<div class="dropdown" id="test">
    <button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">
        Dropdown
        <span class="caret"></span>
    </button>
    <ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
        <li><a href="#">Action</a></li>
        <li><a href="#">Another action</a></li>
        <li><a href="#">Something else here</a></li>
        <li role="separator" class="divider"></li>
        <li><a href="#">Separated link</a></li>
    </ul>
</div>
<div class="btn-group" role="group" aria-label="...">
    <button type="button" class="btn btn-default">Left</button>
    <button type="button" class="btn btn-default">Middle</button>
    <button type="button" class="btn btn-default">Right</button>
</div>--%>
<div region="north" split="true" border="false" style="overflow: hidden; height:8%;background: #7f99be repeat-x center 100%; line-height: 5.0em;color: #fff; font-family: Verdana, 微软雅黑,黑体">
    <span style="float:right; padding-right:20px;" class="head" id="login_name" value=""></span>
    <span style="padding-left:15px; font-weight:bold; font-size:25px; color:#FF8000; font-family:楷体; float:left;">
        	<b>SRS系统</b>
        </span>
</div>
</div>

<div region="west" hide="true" split="true" title="SRS系统菜单导航" style="width:250px; font-size:20px;" id="west" iconCls="myicon-home" >
    <div id="accordions" class="easyui-accordion" data-options="multiple:true,selected:false,collapsed:false,collapsible:false">
        <div title="总视图" style="padding:10px;"  data-options="iconCls:'myicon-accodion_view',collapsed:false">
            <ul id="totalTree">
            </ul>
        </div>
        <div title="组件包视图" style="padding:10px" data-options="iconCls:'myicon-accodion_view',collapsed:false,tools:'#menu1'">
            <ul id="treeId">
            </ul>
        </div>
        <div title="系统管理视图" style="padding:10px" data-options="iconCls:'myicon-accodion_view',collapsed:false">
            <ul id="manageTree">
            </ul>
        </div>
    </div>
</div>
<div region="west" hide="true" split="true" title="SRS系统菜单导航" style="width:250px; font-size:20px;" id="west">
    <div class="panel panel-default">
        <div class="panel-heading" style="padding:10px;">
            <h3 class="panel-title">Panel title</h3>
        </div>
        <div class="panel-body">
            Panel content
        </div>
    </div>

    <div class="panel panel-default ">
        <div class="panel-heading" style="padding:10px;">
            <h3 class="panel-title">Panel title</h3>
        </div>
        <div class="panel-body">
            Panel content
        </div>
    </div>
</div>


        <nav class="col-md-2 d-none d-md-block bg-light sidebar">
            <div class="sidebar-sticky">
                <ul class="nav flex-column">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">
                            <span data-feather="home"></span>
                            Dashboard <span class="sr-only">(current)</span>
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file"></span>
                            Orders
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="shopping-cart"></span>
                            Products
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="users"></span>
                            Customers
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="bar-chart-2"></span>
                            Reports
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="layers"></span>
                            Integrations
                        </a>
                    </li>
                </ul>

                <h6 class="sidebar-heading d-flex justify-content-between align-items-center px-3 mt-4 mb-1 text-muted">
                    <span>Saved reports</span>
                    <a class="d-flex align-items-center text-muted" href="#">
                        <span data-feather="plus-circle"></span>
                    </a>
                </h6>
                <ul class="nav flex-column mb-2">
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            Current month
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            Last quarter
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            Social engagement
                        </a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">
                            <span data-feather="file-text"></span>
                            Year-end sale
                        </a>
                    </li>
                </ul>
            </div>
        </nav>
<!-- center -->
<div id="mainPanle" region="center" style="background: #eee; overflow-y:hidden">
    <div id="tabs" class="easyui-tabs"  fit="true" border="false" >
        <div title="SRS主页" style="padding:20px;overflow:hidden;" id="home">
            <div id="idCenterTabs" class="easyui-tabs" fit="true" border="false">
                <iframe id="idCenterTabsIframe" src="hellotest.jsp" style="border: 0; width: 100%; height: 99%">
                </iframe>
            </div>
        </div>
    </div>
</div>

<div id="dd" hidden >
    <div class="fg-item">
        <label class="ui-label" style="text-align: right; width: 80px;">组件包:</label>
        <input id="compack" class="easyui-textbox"  style="width:300px"></input>
        <div id="bb" style="margin-top:40px;margin-left:40px;">
            <a href="javascript:saveCompack()" id="btn_save" class="easyui-linkbutton" width="20" style="margin-left:40px;padding-left:15px;padding-right:15px;">保存</a>
            <a href="javascript:cancelCompack()" id="btn_cancel" class="easyui-linkbutton" width="20" style="margin-left:30px;padding-left:15px;padding-right:15px;">取消</a>
        </div>
    </div>
</div>
<div id="dd1" hidden >
    <div class="fg-item">
        <label class="ui-label" style="text-align: right; width: 80px;">组件:</label>
        <input id="com" class="easyui-textbox"  style="width:300px"></input>
        <div id="bb" style="margin-top:40px;margin-left:40px;">
            <a href="javascript:saveCom()" id="btn_save" class="easyui-linkbutton" width="20" style="margin-left:40px;padding-left:15px;padding-right:15px;">保存</a>
            <a href="javascript:cancelCom()" id="btn_cancel" class="easyui-linkbutton" width="20" style="margin-left:30px;padding-left:15px;padding-right:15px;">取消</a>
        </div>
    </div>
</div>

<div id="menu1" hidden>
    <a href="javascript:void(0)" class="icon-add" onclick="addCompack()"></a>
</div>
<div id="mm" class="easyui-menu" style="width:120px;" hidden>
    <div onclick="append()" data-options="iconCls:'icon-add'" >新增</div>
    <!--<div onclick="treeEdit()" data-options="iconCls:'icon-add'" >编辑</div>-->
    <div onclick="remove()" data-options="iconCls:'icon-remove'" >删除</div>
</div>
<div id="menu" class="easyui-menu" style="width: 150px;" hidden>
    <div id="m-refresh" data-options="iconCls:'icon-reload'">
        刷新</div>
    <div class="menu-sep" data-options="iconCls:''">
    </div>
    <div id="m-closeall" data-options="iconCls:''">
        全部关闭</div>
    <div id="m-closeother" data-options="iconCls:''">
        关闭其他</div>
    <div class="menu-sep">
    </div>
    <div id="m-close" data-options="iconCls:'icon-no'">
        关闭</div>
</div>

<script>

</script>
</body>
</html>
