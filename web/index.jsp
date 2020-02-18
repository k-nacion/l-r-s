<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="resources/css/bulma.min.css"/>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>LeWards | Login</title>
</head>
<body>


<div class="left">
    <form action="login" method="POST">
        <caption><h3>Login</h3></caption>
        <table align="center">
            <tr>
                <td>Username:</td>
                <td><input type="text" name="login_username"></td>
            </tr>
            <tr>
                <td>Password:</td>
                <td><input type="password" name="login_password"></td>
            </tr>
            <tr>
                <td colspan="2">
                    <div>
                        <input type="submit" value="Login" name="login_button">
                    </div>
                </td>
            </tr>
        </table>
    </form>
</div>


</body>
</html>