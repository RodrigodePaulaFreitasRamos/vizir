<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Telzir Telefonia</title>
<script src="<c:url value="/resources/jquery/jquery-3.1.0.min.js" />" type="text/javascript"></script>
<script src="<c:url value="/resources/bootstrap/js/bootstrap.min.js" />" type="text/javascript"></script>
<link href="<c:url value="/resources/bootstrap/css/bootstrap.min.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>
<body>

	<div class="container">

		<h1 class="page-header">Resultado da Consulta</h1>
		
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>Origem</th>
					<th>Destino</th>
					<th>FaleMais</th>
					<th>Tempo da Ligação</th>
					<th>Custo com o Plano</th>
					<th>Custo sem o Plano</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<td><c:out value="${bean.consultaBean.origem}"/></td>
					<td><c:out value="${bean.consultaBean.destino}"/></td>
					<td><c:out value="${bean.consultaBean.minutosPlano}"/></td>
					<td><c:out value="${bean.consultaBean.tempo}"/></td>
					<td><c:out value="${bean.custoComPlano}"/></td>
					<td><c:out value="${bean.custoSemPlano}"/></td>
				</tr>
			</tbody>
		</table>
		
		<a href="<c:url value="/" />" class="btn btn-primary padding-top">Consultar Novamente</a>
			
	</div>
	
</body>
</html>