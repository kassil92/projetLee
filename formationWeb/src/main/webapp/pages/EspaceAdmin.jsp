<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title> Bienvenue dans l'espace Admin !</title>
</head>
<body>
	<s:form action="enregistrerFormateur">

		<s:textfield name="formateur.nom" value="%{formation.nom}"
			label="Nom Formateur" />

		<s:textfield name="formation.prenom" value="%{formation.prenom}"
			label="Prenom Formation" />
			
		<s:textfield name="formation.Formation" value="%{formation.prenom}"
			label="Prenom Formation" />
			
		<s:hidden name="formateur.id" value="%{formateur.id}" />
		
		<s:submit value="Enregistrer" style="float:right;"/>

		<table>
			<thead>
				<th>Nom</th>
				<th>Prenom</th>
				<th>Formation</th>
				<th>Actions</th>
			</thead>
			<s:iterator value="listFomateur" status="formateurStatus">
				<tr>
					<td><s:property value="Nom" /></td>
					<td><s:property value="Prenom" /></td>
					<td><s:property value="Formation" /></td>
					<td>
						<s:property value="formateur.nom" /> 
						<s:property value="formateur.prenom" />
						<s:property value="formateur.formtation" />
					</td>
					<td>
						<!-- Lien supprimer -->
						<s:url var="deleteURL" action="supprimerFormateur">
							<s:param name="id" value="%{id}"></s:param>
							<s:param name="index" value="#formateurStatus.index"></s:param>
						</s:url> 
						<s:a href="%{deleteURL}" onclick="return confirm('Êtes vous sûr ?')">Supprimer</s:a> 
						
						<!-- Lien modifier -->
						<s:url var="editURL" action="modifierFormateur">
							<s:param name="id" value="%{id}"></s:param>
						</s:url> 
						<s:a href="%{editURL}">Modifier</s:a>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:form>

</body>
</html>
