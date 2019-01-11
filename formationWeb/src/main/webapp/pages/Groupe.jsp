<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
<title>Bienvenue aux responsables des formations "Gestion des groupes"</title>
</head>
<body>
	<s:form action="enregistrerGroupe">

		<s:textfield name="Groupe.nom" value="%{Groupe.nom}"
			label="Nom Groupe" />

		<s:textfield name="Groupe.code" value="%{Groupe.code}"
			label="Code Groupe" />
			
		<s:hidden name="Groupe.id" value="%{Groupe.id}" />
		
		<s:submit value="Enregistrer" style="float:right;"/>

		<table>
			<thead>
				<th>Code</th>
				<th>Nom</th>
				<th>Formateur</th>
				<th>Actions</th>
			</thead>
			<s:iterator value="listGroupe" status="GroupeStatus">
				<tr>
					<td><s:property value="code" /></td>
					<td><s:property value="nom" /></td>
					<td>
						<s:property value="formateur.nom" /> 
						<s:property value="formateur.prenom" />
					</td>
					<td>
						<!-- Lien supprimer -->
						<s:url var="deleteURL" action="supprimerGroupe">
							<s:param name="id" value="%{id}"></s:param>
							<s:param name="index" value="#GroupeStatus.index"></s:param>
						</s:url> 
						<s:a href="%{deleteURL}" onclick="return confirm('Êtes vous sûr ?')">Supprimer</s:a> 
						
						<!-- Lien modifier -->
						<s:url var="editURL" action="modifierGroupe">
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