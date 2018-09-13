<!DOCTYPE html>
<html>

<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <title>oitsme | Login</title>

    <link href="../Templ/css/bootstrap.min.css" rel="stylesheet">
    <link href="../Templ/font-awesome/css/font-awesome.css" rel="stylesheet">

    <link href="../Templ/css/animate.css" rel="stylesheet">
    <link href="../Templ/css/style.css" rel="stylesheet">
</head>

<body class="gray-bg">

<div class="middle-box text-center loginscreen animated fadeInDown">
    <div>
        <div>

            <h1 class="logo-name" style="align-content: center;"></h1>

        </div>
        <h3>Welcome to oitsme</h3>

        <p>Login in</p>
        <form class="m-t" role="form" action="/login/online" method="post" style="margin-top: 50px;">
            <div class="form-group">
                <input class="form-control" type="email" placeholder="Username" name="userName">
            </div>
            <div class="form-group">
                <input type="password" class="form-control" placeholder="Password" name="password">
            </div>
            <button type="submit" class="btn btn-primary block full-width m-b">Login</button>

            <a href="/sys/index"><small>Forgot password?</small></a>

        </form>
        <p class="m-t"> <small>Inspinia we app framework base on Bootstrap 3 &copy; 2018</small> </p>
    </div>
</div>

<!-- Mainly scripts -->
<script src="../Templ/js/jquery-2.1.1.js"></script>
<script src="../Templ/js/bootstrap.min.js"></script>

</body>

</html>
