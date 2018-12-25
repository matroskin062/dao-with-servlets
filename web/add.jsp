<%--
  Created by IntelliJ IDEA.
  User: matroskin
  Date: 26.12.2018
  Time: 00:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
</head>
<body>
<div class="container">
    <div class="mx-auto mt-3">
        <form action="/add" method="post">
            <div class="form-group">
                <input type="text" name="name"class="form-control" placeholder="Name" aria-label="Name"/>
            </div>
            <div class="form-group">
                <input type="text" name="age"class="form-control"placeholder="Age" aria-label="Age"/>
            </div>
            <div class="mx-auto" style="width:250px">
                <button class="btn btn-success" style="width: 100px;">Add</button>
            </div>
        </form>
        <div class="mx-auto" style="width: 250px;">
            <button onclick="location.href='../'" class="btn btn-info" style="width: 100px;" >To Index</button>
        </div>
    </div>
</div>
</body>
</html>