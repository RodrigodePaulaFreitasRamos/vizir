<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
<body onload="javascript:recarregarDestinos();">

	<div class="container">

		<h1 class="page-header">Calcule a Tarifa</h1>
		
		<div class="div-form-consulta">
		
			<c:url value="/consultar" var="url" />
			<form:form action="${url}" method="POST" modelAttribute="consultaBeanModel">
				<div class="form-group">
					<form:label path="origem" for="origem">Origem</form:label>
					<form:select id="origem" path="origem" items="${comboOrigem}" onchange="javascript:recarregarDestinos()" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="destino" for="destino">Destino</form:label>
					<form:select id="destino" path="destino" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="minutosPlano" for="minutosPlano">FaleMais</form:label>
					<form:select id="minutosPlano" path="minutosPlano" items="${minutosPlanoFaleMais}" cssClass="form-control"/>
				</div>
				<div class="form-group">
					<form:label path="tempo" for="tempo">Tempo da Ligação</form:label>
					<form:input id="tempo" path="tempo" type="number" min="1" step="1" value="1" cssClass="form-control"/>
				</div>
				<form:button class="btn btn-success">Consultar</form:button>
			</form:form>
		
		</div>
		
		<script type="text/javascript">
			
			function recarregarDestinos() {
				$("#destino").html('');
				$.ajax({
					url : '<c:url value="/json/destinos/"/>' + $("#origem").val(),
					type: 'GET',
					dataType: 'json',
					success : function(data) {
						$.each(data, function(index, obj) {
							$("#destino").append(new Option(obj.ddd, obj.ddd));
						});
					}
				});
			};
			
		</script>
	
	</div>
	
</body>
</html>