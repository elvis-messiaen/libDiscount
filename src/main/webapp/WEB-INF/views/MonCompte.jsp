<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false" isELIgnored="false"%>
<!-- Actor Elvis -->
<html>
<head>
<title>Mon compte</title>
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
<link href="<c:url value="/resources/css/style.css"/>" rel="stylesheet">
</head>
<body>
	<!------------------------------- navbar --------------------------------->
		<div class="container">
		<div class="row">
		<div class=" col-4 d-flex pt-3">
			<a class="navbar-brand" href="${pageContext.request.contextPath}/"> <img
			src="${pageContext.request.contextPath}/resources/img/libDiscountLogo.svg"
			width="" height="30" alt=""></a>
		</div>
		<div class=" col-4 d-flex pt-3">
			 <a class="centerObjects" href=""> <img
			src="${pageContext.request.contextPath}/resources/img/libDiscountTitre.svg"
			width="" height="30" alt=""></a>
		</div>

		<div class=" col-1 offset-3 pt-3">
		<ul class="navbar-nav ">
			<li class="nav-item dropdown "><a
				class="nav-link dropdown-toggle " href="#" class="navbardrop px-3"
				data-toggle="dropdown"> Comptes </a>		
		<div class="dropdown-menu dropdown-menu-right">
		
		<c:choose>			
 		 <c:when test="${ !empty user.nom}">
    		<a class="dropdown-item " href="${pageContext.request.contextPath }/logout">Logout</a> 
  		</c:when>
  			<c:otherwise>
   			<a class="dropdown-item " href="${pageContext.request.contextPath }/login">Login</a>
  		</c:otherwise>
	</c:choose>

					<a class="dropdown-item " href="Creation">Cr?ation de compte</a>
					<a class="dropdown-item " href="CreationCompteVendeur">Devenir
						vendeur
					 </a>
				</div>
			</li>
		</ul>	
	</div>
	</div>
</div>

	<hr>
	
		<div class="container">
		<div class="row">
		<div class=" col-4 d-flex h3">
				
		<c:if test="${ !empty user.nom}"> 
		<div><c:out value="bonjour ${user.nom}" default=""/> 
		</div>
		</c:if>	
		</div>
		<div class=" col-4 d-flex">
			<form id="search" class="form-inline ">
				<input class="form-control " type="text" placeholder="Chercher" aria-label="Chercher">
				<button class="btn btn-outline  " type="submit">Recherche</button>
			</form>
		</div>
		<div class=" col-1 offset-3 text-right">
				<a href="Panier/" class="fas fa-cart-plus fa-2x "></a>	
		</div>
		</div>
	</div>


	<hr>

<!----------------------------------fin----------------------------------------------------------->

<div class="container">
	<div class="row">
		<div class="col-md-3">
			<div class="d-flex justify-content-around flex-wrap">
				<a class="BoxMonCompte" href="${pageContext.request.contextPath}/adressesClient">Mes adresses</a>
			</div>
		</div>
		<div class="col-md-3">
			<div class="d-flex justify-content-around flex-wrap">
				<a class="BoxMonCompte" href="">Paiements</a>
			</div>
		</div>
		<div class="col-md-3">
			<div class="d-flex justify-content-around flex-wrap">
				<a class="BoxMonCompte" href="${pageContext.request.contextPath}/mesInformations">Mes Informations</a>
			</div>
		</div>
	</div>
	
	
	<div class="row">
		<div class="col-md-3"></div>
		<div class="col-md-3">
			<div class="d-flex justify-content-around flex-wrap">
				<a class="BoxMonCompte" href="">Commandes</a>
			</div>
		</div>
		<div class="col-md-3">
			<div class="d-flex justify-content-around flex-wrap">
				<a class="BoxMonCompte" href="">Message</a>
			</div>
		</div>
	</div>
</div>	
	

<!----------------------------------fin----------------------------------------------------------->
<!-- Footer -->
<footer class="page-footer font-small special-color-dark pt-4">

  <!-- Footer Elements -->
  <div class="container">

    <!-- Social buttons -->
    <ul class="list-unstyled list-inline text-center">
      <li class="list-inline-item">
        <a class="btn-floating btn-fb mx-1">
          <i class="fab fa-facebook-f"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-tw mx-1">
          <i class="fab fa-twitter"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-gplus mx-1">
          <i class="fab fa-google-plus-g"> </i>
        </a>
      </li>
      <li class="list-inline-item">
        <a class="btn-floating btn-li mx-1">
          <i class="fab fa-linkedin-in"> </i>
        </a>
      </li>
    </ul>
  </div>
  <div class="footer-copyright text-center py-3">? 2020 Copyright:
    <a href="https://libDiscount.com"> libDiscount.com</a>
  </div>


</footer>


</body>
</html>