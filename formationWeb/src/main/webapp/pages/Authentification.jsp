<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title><b>Bienvenue dans l'application Glc-contact : Authentification</b></title>
</head>
<body>
	<s:form action="AuthentificationRole">

		<s:textfield name="formateur.Login" value="%{formateur.login}"
			label="Entrez votre Login : " />

		<s:textfield name="formateur.Password " value="%{formateur.password}"
			label="Code Formation" />
			
			
		<s:hidden name="formateur.id" value="%{formateur.id}" />
		
		<s:submit value="Se connecter" style="float:right;"/>

	</s:form>

</body>
</html>