<%--
  Created by IntelliJ IDEA.
  User: zcb
  Date: 2018/4/18
  Time: 17:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>图表展示</title>
    <meta charset="utf-8">
    <!-- 引入 ECharts 文件 -->
    <script src="bootstrap/js/jquery.min.js"></script>
    <script src="bootstrap/js/echarts.min.js"></script>
</head>
<body>

<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
<div id="main" style="width: 600px;height:400px;"></div>


<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: 'ECharts 动态数据加载测试'
        },
        tooltip: {},
        legend: {
            data:['销量']
        },
        xAxis: {
            data: []
        },
        yAxis: {},
        series: [{
            name: '销量',
            type: 'bar',
            data: []
        }]
    };

    // 异步加载数据
    $.get('api/data/getData?name=销量').done(function (data) {
        // 填入数据
        myChart.setOption({
            xAxis: {
                data: data.categories
            },
            series: [{
                // 根据名字对应到相应的系列
                name: '销量',
                data: data.data
            }]
        });
    });

    myChart.showLoading();
    $.get('api/data/getData').done(function (data) {
        myChart.hideLoading();
        // 使用刚指定的配置项和数据显示图表。
        myChart.setOption(option);
    });



</script>
</body>

</html>
