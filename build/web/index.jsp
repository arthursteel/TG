<%-- 
    Document   : index
    Created on : 28/07/2015, 15:42:04
    Author     : arthurtakashi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*" %> 

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pagina Login</title>
    </head>
    <body>
        <h1>Login</h1>
                    
        <form action="logincheck.jsp" method="post">
            <table>
                <tr>
                    <td>login</td>
                    <td><input type="text" name="login"></td>
                </tr>
                <tr>
                    <td>senha</td>
                    <td><input type="password" name="senha"></td>
                </tr>
            </table>
        </form>
        <a href="localhost:8081/TG/" action="logincheck">login</a>
    </body>
</html>
