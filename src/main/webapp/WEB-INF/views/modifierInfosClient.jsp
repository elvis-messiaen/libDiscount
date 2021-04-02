<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Modification Information</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
	integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://use.fontawesome.com/releases/v5.7.0/css/all.css"
	integrity="sha384-lZN37f5QGtY3VHgisS14W3ExzMWZxybE1SJSEsQp9S+oqd12jhcu+A56Ebc1zFSJ"
	crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
	integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
	crossorigin="anonymous"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
	integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
	crossorigin="anonymous"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
	integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
	crossorigin="anonymous"></script>
	
	
<link href="${pageContext.request.contextPath}/resources/css/formulaires.css" rel="stylesheet">
</head>
<body>
<div class="container">
		<div class="row">
			<div class="divLogo">
				<a class="navbar-brand" href="${pageContext.request.contextPath}/"><img
					src="${pageContext.request.contextPath}/resources/img/libDiscountLogo.svg"
					width="" height="" alt=""></a>
			</div>
		</div>
		<div class="row">
			<div class=" col-12 conteneurFormulaire">
				<h1>Modification Information</h1>
					<form action="modifierInfosClient" method="post">
						<div class= "divTitle">
						<h5>Vous :</h5>
						</div>
						<div class="col-12 divId">
						<label for="nom">Id :</label>
						<input type="text" name = "idUser" value="${user.idUser}"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="nom">Nom :</label>
						<input type="text" name = "nom" value="${user.nom}"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="prenom">Prénom :</label>
						<input type="text" name = "prenom" value="${user.prenom}"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="mail">Email :</label>
						<input type="text" name = "mail" value="${user.mail}"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="phone">Telephone :</label>
						<input type="text" name = "phone" value="${user.telephone}"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="pwd">Mot de passe :</label>
						<input type="text" name = "pwd" value="${user.password}"/>
						</div>
						
						<div class = "divCheckbox">				
						<input type="checkbox" name="actif" checked="checked">
						</div>
						
						<div class="col-12 divButton">							
								<button class="btn" name="btn" value="sauvegarder" >  Sauvegarder</button></a>							
						</div>
				</form>
			</div>
		</div>		
	</div>
</body>
</html>