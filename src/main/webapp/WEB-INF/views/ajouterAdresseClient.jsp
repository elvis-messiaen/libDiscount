<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AjouterAdresse</title>

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
				<a class="navbar-brand" href=""><img
					src="${pageContext.request.contextPath}/resources/img/libDiscountLogo.svg"
					width="" height="" alt=""></a>
			</div>
		</div>
		<div class="row">
			<div class=" col-12 conteneurFormulaire">
					<form action="ajouterAdresseClient" method="post">
						
						<div class= "divTitle">
						<h5>Ajouter une Adresse :</h5>
						</div>
						
						<div class="col-12 divId">
						<label for="nom">Id :</label>
						<input type="text" name = "idUser" value="${user.idUser}"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="numVoie">Numéro de voie :</label>
						<input type="text" name = "numVoie"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="nomVoie">Nom de voie :</label>
						<input type="text" name = "nomVoie"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="codePostal">Code postal :</label>
						<input type="text" name = "codePostal"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="ville">Ville :</label>
						<input type="text" name = "ville"/>
						</div>
						
						
						<div class="col-12 divButton">
							
								<a href = ""><button class="btn">Valider</button></a>
							
						</div>
	
	
	
					</form>
			</div>
		</div>
		
	</div>
</body>
</html>