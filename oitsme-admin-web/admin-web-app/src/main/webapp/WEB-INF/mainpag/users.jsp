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

            <div class="row">
                <div class="col-lg-12">
                    <div class="ibox float-e-margins">
                        <div class="ibox-title">
                            <h5>Editable Table in- combination with jEditable</h5>
                            <div class="ibox-tools">
                                <a class="collapse-link">
                                    <i class="fa fa-chevron-up"></i>
                                </a>
                                <a class="dropdown-toggle" data-toggle="dropdown" href="table_data_tables.html#">
                                    <i class="fa fa-wrench"></i>
                                </a>
                                <ul class="dropdown-menu dropdown-user">
                                    <li><a href="table_data_tables.html#">Config option 1</a>
                                    </li>
                                    <li><a href="table_data_tables.html#">Config option 2</a>
                                    </li>
                                </ul>
                                <a class="close-link">
                                    <i class="fa fa-times"></i>
                                </a>
                            </div>
                        </div>
                        <div class="ibox-content">
                            <div class="">
                                <a onclick="fnClickAddRow();" href="javascript:void(0);" class="btn btn-primary ">Add a new row</a>
                            </div>
                            <table id="users" class="table table-striped table-bordered table-hover " id="editable" >
                                <thead>
                                <tr>
                                    <th data-loading="id">id</th>
                                    <th data-loading="userName">userName</th>
                                    <th data-loading="password">password</th>
                                    <th data-loading="phoneNumber">phoneNumber</th>
                                    <th data-loading="employeeCode">employeeCode</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr class="gradeX">
                                    <td>Trident</td>
                                    <td>Internet
                                        Explorer 4.0
                                    </td>
                                    <td>Win 95+</td>
                                    <td class="center">4</td>
                                    <td class="center">X</td>
                                </tr>
                                <tr class="gradeC">
                                    <td>Trident</td>
                                    <td>Internet
                                        Explorer 5.0
                                    </td>
                                    <td>Win 95+</td>
                                    <td class="center">5</td>
                                    <td class="center">C</td>
                                </tr>
                                <tr class="gradeA">
                                    <td>Trident</td>
                                    <td>Internet
                                        Explorer 5.5
                                    </td>
                                    <td>Win 95+</td>
                                    <td class="center">5.5</td>
                                    <td class="center">A</td>
                                </tr>

                                </tbody>
                                <tfoot>
                                <tr>
                                    <th data-loading="id">id</th>
                                    <th data-loading="userName">userName</th>
                                    <th data-loading="password">password</th>
                                    <th data-loading="phoneNumber">phoneNumber</th>
                                    <th data-loading="employeeCode">employeeCode</th>
                                </tr>
                                </tfoot>
                            </table>

                        </div>
                    </div>
                </div>
            </div>

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
    function showUser(){
        $.get("/hello/showUser",function (data) {
            var len=data.length;
            var child= $("#users").find("tbody");
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
        oTable.$('td').editable( '../example_ajax.php', {
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
        showUser();


    });

    function fnClickAddRow() {
        $('#editable').dataTable().fnAddData( [
            "Custom row",
            "New row",
            "New row",
            "New row",
            "New row" ] );

    }
</script>
</body>
</html>
