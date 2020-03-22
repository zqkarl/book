<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <script src="<%=basePath%>js/echarts.min.js"></script>
</head>
<body>
<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
<div id="main" style="width: 1200px;height:800px;"></div>
<script type="text/javascript">
    var myChart = echarts.init(document.getElementById('main'));
    var option = {
        tooltip: {
            trigger: 'axis',
            axisPointer: {
                type: 'cross',
                crossStyle: {
                    color: '#999'
                }
            }
        },
        toolbox: {
            feature: {
                dataView: {show: true, readOnly: false},
                magicType: {show: true, type: ['line', 'bar']},
                restore: {show: true},
                saveAsImage: {show: true}
            }
        },
        legend: {
            data: ['借书数', '还书数', '库存数']
        },
        xAxis: [
            {
                type: 'category',
                data: ['1月', '2月', '3月', '4月', '5月', '6月', '7月', '8月', '9月', '10月', '11月', '12月'],
                axisPointer: {
                    type: 'shadow'
                }
            }
        ],
        yAxis: [
            {
                type: 'value',
                name: '数量',
                min: 0,
                max: 2500,
                interval: 500,
                axisLabel: {
                    formatter: '{value} 本'
                }
            },
            {
                type: 'value',
                name: '数量',
                min: 0,
                max: 25000,
                interval: 5000,
                axisLabel: {
                    formatter: '{value} 本'
                }
            }
        ],
        series: [
            {
                name: '借书数',
                type: 'bar',
                data: [2435, 1596, 1814, 751, 1724, 453, 727, 1622, 326, 245, 624, 758]
            },
            {
                name: '还书数',
                type: 'bar',
                data: [437, 646, 642, 257, 1435, 1278, 1756, 1822, 1487, 1887, 881, 274]
            },
            {
                name: '库存数',
                type: 'line',
                yAxisIndex: 1,
                data: [22378, 21244, 20687, 20035, 19742, 20576, 21599, 22357, 23457, 24587, 24685, 24203]
            }
        ]
    };
    myChart.setOption(option);
</script>

</body>
</html>