<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form action="<%= request.getContextPath() %>/ferme" method="post">
    <label>Nom :</label>
    <input type="text" name="nom" required>

    <label>Localisation :</label>
    <input type="text" name="localisation" required>

    <label>ID Fermier :</label>
    <input type="number" name="idFermier" required>

    <input type="submit" value="Ajouter">
</form>



</body>
</html>