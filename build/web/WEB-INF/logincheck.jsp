<%-- 
    Document   : logincheck
    Created on : 30/07/2015, 20:50:54
    Author     : arthurtakashi
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charser=ISO-8859-1">
        <title> verificando login </title>
    </head>
    <form action="login.jsp">

            <h1>Login Form</h1>
            <%
            String msg_perfil=(String)request.getAttribute("msg_perfil");
            if (msg_perfil!=null){
                out.print(msg_perfil);
            }
            String msg_login=(String)request.getAttribute("msg_login");
            if(msg_login!=null){
                out.print(msg_login);
            }
            %>
        </form>
    <body>
        <%Usuario us = new Usuario();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean status = us.verificarUsuario(login, senha);
        if(us.result==true){
            out.println("Login feito com sucesso" + us.nome);
        }else{
            out.println("login ou senha invalidos");
        } %>
    </body>
</html>
