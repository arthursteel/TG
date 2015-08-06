<%-- 
    Document   : login
    Created on : 28/07/2015, 14:33:58
    Author     : arthurtakashi
--%>

<%@page language="java" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="Model.*" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset = ISO-8859-1">
        <title>Login</title>
    </head>
    <body>
        <%Usuario us = new Usuario();
        String login = request.getParameter("login");
        String senha = request.getParameter("senha");
        boolean status = us.verificarUsuario(login, senha);
        if(us.result==true){
            out.println("login feito com sucesso: "+us.nome);
        }else{
            out.println("falha no login");
            out.println("tente novamente");
        }%>
    </body>
    
</html>