<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Bienvenue aux formateurs ou reponsable de formation "Gestion des formations"</title>
</head>
<body>
	<s:form action="enregistrerFormation">

		<s:textfield name="formation.nom" value="%{formation.nom}"
			label="Nom Formation" />

		<s:textfield name="formation.code" value="%{formation.code}"
			label="Code Formation" />
			
		<s:hidden name="formation.id" value="%{formation.id}" />
		
		<s:submit value="Enregistrer" style="float:right;"/>

		<table>
			<thead>
				<th>Code</th>
				<th>Nom</th>
				<th>Formateur</th>
				<th>Actions</th>
			</thead>
			<s:iterator value="listFomartions" status="formationStatus">
				<tr>
					<td><s:property value="code" /></td>
					<td><s:property value="nom" /></td>
					<td>
						<s:property value="formateur.nom" /> 
						<s:property value="formateur.prenom" />
					</td>
					<td>
						<!-- Lien supprimer -->
						<s:url var="deleteURL" action="supprimerFormation">
							<s:param name="id" value="%{id}"></s:param>
							<s:param name="index" value="#formationStatus.index"></s:param>
						</s:url> 
						<s:a href="%{deleteURL}" onclick="return confirm('Êtes vous sûr ?')">Supprimer</s:a> 
						
						<!-- Lien modifier -->
						<s:url var="editURL" action="modifierFormation">
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