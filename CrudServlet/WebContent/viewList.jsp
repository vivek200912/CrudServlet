<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="styles/bootstrap-3.3.7-dist/css/bootstrap.min.css" />
<script src="styles/jQuery/jquery-3.2.1.min.js"></script>
<script src="styles/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
<title>DV Technologies</title>
<style>
/* Remove the navbar's default margin-bottom and rounded borders */
.navbar {
	margin-bottom: 0;
	border-radius: 0;
}

/* Set height of the grid so .sidenav can be 100% (adjust as needed) */
.row.content {
	height: 450px
}

/* Set gray background color and 100% height */
.sidenav {
	padding-top: 20px;
	background-color: #f1f1f1;
	height: 100%;
}

/* Set black background color, white text and some padding */
footer {
	background-color: #555;
	color: white;
	padding: 15px;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

/*Float contents to right*/
.float-right {
	float: right !important;
}

/*Bottom Padding of 10px*/
.padding-b-10px {
	padding-bottom: 10px;
}

select {
	-webkit-appearance: menulist;
	background-color: white;
	-webkit-rtl-ordering: logical;
	user-select: text;
	cursor: auto;
	padding: 1px;
	width: 174px !important;
	height: 26px;
	border-width: 2px;
	border-top-width: 2px;
	border-right-width: 2px;
	border-bottom-width: 2px;
	border-left-width: 2px;
	border-style: inset;
	border-color: initial;
	border-image: initial;
}
</style>
</head>
<body>
	<nav class="navbar navbar-inverse">
		<div class="container-fluid">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle" data-toggle="collapse"
					data-target="#myNavbar">
					<span class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="#"><img
					src="images/DVTech_Logo.png" alt="DV Technologies" width="50"
					height="20"></a>
			</div>
			<div class="collapse navbar-collapse" id="myNavbar">
				<ul class="nav navbar-nav">
					<li class="active"><a href="HomeServlet">Home</a></li>
					<li><a href="#">About</a></li>
					<li><a href="#">Projects</a></li>
					<li><a href="#">Contact</a></li>
				</ul>
				<ul class="nav navbar-nav navbar-right">
					<li><a href="LogOutServlet"><span class="glyphicon glyphicon-log-out"></span>
							Log out</a></li>
				</ul>
			</div>
		</div>
	</nav>
	<div class="container-fluid text-center">
		<div class="row content">
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
			<form action="SaveServlet" method="post">
				<div class="col-sm-8 text-left">
					<h1>View All Employees</h1>
					<p>This page shows all Employees from the DV Technologies system.</p>
					<hr>
					<div class="row padding-b-10px">
						<div class="col-sm-12">
							<h3>Following is the list of employees.</h3>
						</div>
					</div>
					<table border="1" style="width:100%;">
						<tr>
							<th>Id</th>
							<th>Name</th>
							<th>Password</th>
							<th>Email</th>
							<th>Country</th>
							<th>Edit</th>
							<th>Delete</th>
						</tr>
						<c:if test="${not empty allList}">
							<c:forEach items="${allList}" var="item">
								<tr>
									<td><c:out value = "${item.id}"/></td>
									<td><c:out value = "${item.name}"/></td>
									<td><c:out value = "${item.password}"/></td>
									<td><c:out value = "${item.email}"/></td>
									<td><c:out value = "${item.country}"/></td>
									<td><a href='EditServlet?id=<c:out value = "${item.id}"/>'>edit</a></td>
									<td><a href='DeleteServlet?id=<c:out value = "${item.id}"/>'>delete</a></td>
								</tr>
							</c:forEach>
						</c:if>
					</table>
					<div class="row padding-b-10px">
						<div class="col-sm-12">
							<h3>Go ahead and choose from the below available options.</h3>
						</div>
					</div>
					<div>
						<p>
							<a href="addEmployee.jsp">Add New Employee</a>
						</p>
						<p>
							<a href="#">Delete Employee</a>
						</p>
					</div>
				</div>
			</form>
			<div class="col-sm-2 sidenav">
				<div class="well">
					<p>ADS</p>
				</div>
				<div class="well">
					<p>ADS</p>
				</div>
			</div>
		</div>
	</div>

	<footer class="container-fluid text-center">
		<p>DV Technologies</p>
	</footer>
</body>
</html>