<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">

    <title>oitsme | Dashboard</title>

    <link href="../Templ/css/bootstrap.min.css" rel="stylesheet">
    <link href="../Templ/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="../Templ/css/plugins/dataTables/datatables.min.css" rel="stylesheet">


    <link href="../Templ/css/animate.css" rel="stylesheet">
    <link href="../Templ/css/style.css" rel="stylesheet">


</head>

<body>
<div id="wrapper">
<jsp:include page="../frame/menu.jsp"/>
    <div id="page-wrapper" class="gray-bg dashbard-1">

<jsp:include page="../frame/nav.jsp"/>

        <div id="main" class="row border-bottom white-bg dashboard-header">
            <div class="row  ">

                <div class="col-sm-3">
                    <h2>Welcome Amelia</h2>
                    <small>You have 42 messages and 6 notifications.</small>
                    <ul class="list-group clear-list m-t">
                        <li class="list-group-item fist-item">
                                <span class="pull-right">
                                    09:00 pm
                                </span>
                            <span class="label label-success">1</span> Please contact me
                        </li>
                        <li class="list-group-item">
                                <span class="pull-right">
                                    10:16 am
                                </span>
                            <span class="label label-info">2</span> Sign a contract
                        </li>
                        <li class="list-group-item">
                                <span class="pull-right">
                                    08:22 pm
                                </span>
                            <span class="label label-primary">3</span> Open new shop
                        </li>
                        <li class="list-group-item">
                                <span class="pull-right">
                                    11:06 pm
                                </span>
                            <span class="label label-default">4</span> Call back to Sylvia
                        </li>
                        <li class="list-group-item">
                                <span class="pull-right">
                                    12:00 am
                                </span>
                            <span class="label label-primary">5</span> Write a letter to Sandra
                        </li>
                    </ul>
                </div>
                <div class="col-sm-6">
                    <div class="flot-chart dashboard-chart">
                        <div class="flot-chart-content" id="flot-dashboard-chart"></div>
                    </div>
                    <div class="row text-left">
                        <div class="col-xs-4">
                            <div class=" m-l-md">
                                <span class="h4 font-bold m-t block">$ 406,100</span>
                                <small class="text-muted m-b block">Sales marketing report</small>
                            </div>
                        </div>
                        <div class="col-xs-4">
                            <span class="h4 font-bold m-t block">$ 150,401</span>
                            <small class="text-muted m-b block">Annual sales revenue</small>
                        </div>
                        <div class="col-xs-4">
                            <span class="h4 font-bold m-t block">$ 16,822</span>
                            <small class="text-muted m-b block">Half-year revenue margin</small>
                        </div>

                    </div>
                </div>
                <div class="col-sm-3">
                    <div class="statistic-box">
                        <h4>
                            Project Beta progress
                        </h4>
                        <p>
                            You have two project with not compleated task.
                        </p>
                        <div class="row text-center">
                            <div class="col-lg-6">
                                <canvas id="polarChart" width="80" height="80"></canvas>
                                <h5 >Kolter</h5>
                            </div>
                            <div class="col-lg-6">
                                <canvas id="doughnutChart" width="78" height="78"></canvas>
                                <h5 >Maxtor</h5>
                            </div>
                        </div>
                        <div class="m-t">
                            <small>Lorem Ipsum is simply dummy text of the printing and typesetting industry.</small>
                        </div>

                    </div>
                </div>

            </div>


        </div>




<jsp:include page="../frame/foot.jsp"/>

    </div>


    <jsp:include page="../frame/setting.jsp"/>
</div>

<!-- Mainly scripts -->
<script src="../Templ/js/jquery-2.1.1.js"></script>
<script src="../Templ/js/bootstrap.min.js"></script>
<script src="../Templ/js/plugins/metisMenu/jquery.metisMenu.js"></script>
<script src="../Templ/js/plugins/slimscroll/jquery.slimscroll.min.js"></script>

<script src="../Templ/js/plugins/jeditable/jquery.jeditable.js"></script>
<script src="../Templ/js/plugins/dataTables/datatables.min.js"></script>

<!-- Custom and plugin javascript -->
<script src="../Templ/js/inspinia.js"></script>
<script src="../Templ/js/plugins/pace/pace.min.js"></script>

<!-- Page-Level Scripts -->
<script>
    $(document).ready(function(){
        $('.dataTables-example').DataTable({
            dom: '<"html5buttons"B>lTfgitp',
            buttons: [
                { extend: 'copy'},
                {extend: 'csv'},
                {extend: 'excel', title: 'ExampleFile'},
                {extend: 'pdf', title: 'ExampleFile'},

                {extend: 'print',
                    customize: function (win){
                        $(win.document.body).addClass('white-bg');
                        $(win.document.body).css('font-size', '10px');

                        $(win.document.body).find('table')
                            .addClass('compact')
                            .css('font-size', 'inherit');
                    }
                }
            ]

        });

        /* Init DataTables */
        var oTable = $('#editable').DataTable();

        /* Apply the jEditable handlers to the table */
        oTable.$('td').editable( '/hello/showUser', {
            "callback": function( sValue, y ) {
                var aPos = oTable.fnGetPosition( this );
                oTable.fnUpdate( sValue, aPos[0], aPos[1] );
            },
            "submitdata": function ( value, settings ) {
                return {
                    "row_id": this.parentNode.getAttribute('id'),
                    "column": oTable.fnGetPosition( this )[2]
                };
            },

            "width": "90%",
            "height": "100%"
        } );


    });

    function fnClickAddRow() {
        showUser2();

    }
</script>

<script>
    function showUser2(){
        $.get("/hello/showUser",function (data) {
            var len=data.length;
            var child= $("#editable").find("tbody");
            var val;
            for(var i=0;i<len;i++){
                $('#editable').dataTable().fnAddData( [
                    data[i].id,
                    data[i].userName,
                    data[i].password,
                    data[i].phoneNumber,
                    data[i].employeeCode ] );
            }
            $("tbody").html(val);

            console.log(data);
        });
    }
    function showUser3(){
        $.get("/hello/showUser",function (data) {
            var len=data.length;
            var child= $("#editable").find("tbody");
            var val;
            for(var i=0;i<len;i++){
                val+=  "      <tr class=\"gradeX\">\n" +
                    "                <td >"+data[i].id+"</td>\n" +
                    "                    <td >"+data[i].userName+"</td>\n" +
                    "                    <td >"+data[i].password+"</td>\n" +
                    "                    <td >"+data[i].phoneNumber+"</td>\n" +
                    "                    <td >"+data[i].employeeCode+"</td>\n" +
                    "                    </tr>";

                console.log($("tbody").html());
            }
            $("tbody").html(val);

            console.log(data);
        });
    }
    function showUser(){
        $.get("/hello/showUser",function (data) {
            var len=data.length;
           var child= $("#UserTable").find("tbody");
           var val;
            for(var i=0;i<len;i++){
             val+=  "      <tr>\n" +
                    "                <td >"+data[i].id+"</td>\n" +
                    "                    <td >"+data[i].userName+"</td>\n" +
                    "                    <td >"+data[i].password+"</td>\n" +
                    "                    <td >"+data[i].phoneNumber+"</td>\n" +
                    "                    <td >"+data[i].employeeCode+"</td>\n" +
                    "                    </tr>";

                console.log($("tbody").html());
            }
    $("tbody").html(val);

            console.log(data);
        });
    }

    function logout(){
        $.ajax({
            url:"/index/showUser",
            type:"get",
            data:"",
            processData:false,
            contentType:false,
            success:function(data){
                $("#UserTable").bootstrapTable("load",data);
                console.log(data);
            },
            error:function(e){
                alert("错误！！");
                window.clearInterval(timer);
            }
        });
    }
    function  logout1() {
        $.get(
            "hello/index",
            function(){
        });

    }

    function hello(){
        $.ajax({
            url:"http://localhost:8080/hello/index",
            type:"get",
            data:"",
            dataType:'html',
            processData:false,
            contentType:false,
            success:function(data){
              $("#main").html(data);
            },
            error:function(e){
                alert("错误！！");
                window.clearInterval(timer);
            }
        });
    }
</script>
</body>
</html>
