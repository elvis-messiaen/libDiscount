<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>CreationVendeur</title>

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
				<h1>Création de compte Vendeur</h1>
					<form action="CreationCptVendeur" method="post">
						<div class= "divTitle">
						<h5>Vous :</h5>
						</div>
						<div class="col-12 divInput">
						<label for="nom">Nom :</label>
						<input type="text" name = "nom"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="prenom">Prénom :</label>
						<input type="text" name = "prenom"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="mail">Email :</label>
						<input type="text" name = "mail"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="phone">Telephone :</label>
						<input type="text" name = "phone"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="mdp">Mot de passe :</label>
						<input type="password" name = "mdp"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="comfirmmdp">Confirmation mot de passe :</label>
						<input type="password" name = "comfirmmdp"/>
						</div>
						
						<div class= "divTitle">
						<h5>Votre Adresse :</h5>
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
						
						<div class= "divTitle">
						<h5>Votre Librairie :</h5>
						</div>
						
						<div class="col-12 divInput">
						<label for="nomLibrairie">Nom librairie:</label>
						<input type="text" name = "nomLibrairie"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="numVoie">Numéro de voie :</label>
						<input type="text" name = "numVoieLibrairie"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="nomVoie">Nom de voie :</label>
						<input type="text" name = "nomVoieLibrairie"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="codePostal">Code postal :</label>
						<input type="text" name = "codePostalLibrairie"/>
						</div>
						
						<div class="col-12 divInput">
						<label for="ville">Ville :</label>
						<input type="text" name = "villeLibrairie"/>
						</div>
						
						<div class = "divCheckbox">
						<input type="checkbox" name="role" value="Vendeur" checked>
						<input type="checkbox" name="actif"  checked="checked">
						</div>
						
						<div class="col-12 divButton">
							
								<a href = ""><button class="btn">Valider</button></a>
							
						</div>
	
	
	
					</form>
			</div>
		</div>
		
	</div>
<footer class = "col-12 footer"></footer>
</body>
</html>