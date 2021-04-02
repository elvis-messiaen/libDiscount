<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page session="false" isELIgnored="false"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Gestion Utilisateur</title>
</head>
<body>

<TABLE BORDER="1">
    <CAPTION>Liste des Utilisateurs</CAPTION>
    <TR>
        <TH>id</TH>
        <TH>Actif</TH>
        <TH>Nom</TH>
        <TH>Prénom</TH>
        <TH>Mail</TH>
        <TH>Telephone</TH>
        <TH>Inactif</TH>
        <TH>Supprimer</TH>
    </TR>
    <c:forEach items="${listeUser }" var="user">
            <tr>
                <td><c:out value="${user.idUser}" /></td>
                <td><c:out value="${user.actif}" /></td>
                <td><c:out value="${user.nom}" /></td>
                <td><c:out value="${user.prenom}" /></td>
                <td><c:out value="${user.mail}" /></td>
                <td><c:out value="${user.telephone}" /></td>
                <td><button><a href = "${pageContext.request.contextPath}/ActivatedUser/${user.idUser}">Inactif</a></button></td>
                <td><button><a href = "${pageContext.request.contextPath}/supprimerUser/${user.idUser}">Supprimer</a></button></td>
            </tr>
    </c:forEach>
</TABLE>

</body>
</html>