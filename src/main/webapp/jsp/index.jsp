<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Accueil – Smart Bee House</title>
    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            background-color: #f2f6fa;
            padding: 40px;
            text-align: center;
        }
        h1 {
            color: #2c3e50;
            margin-bottom: 10px;
        }
        p {
            color: #666;
            font-size: 16px;
        }
        .menu {
            display: grid;
            grid-template-columns: repeat(auto-fit, minmax(220px, 1fr));
            gap: 20px;
            max-width: 900px;
            margin: 40px auto;
        }
        .card {
            background-color: white;
            border-radius: 12px;
            padding: 20px;
            box-shadow: 0 2px 8px rgba(0,0,0,0.1);
            transition: 0.3s;
            text-decoration: none;
            color: #2c3e50;
        }
        .card:hover {
            transform: translateY(-5px);
            box-shadow: 0 4px 12px rgba(0,0,0,0.2);
        }
        .card h2 {
            margin-bottom: 10px;
            font-size: 18px;
        }
        .emoji {
            font-size: 30px;
        }
    </style>
</head>
<body>

<h1>Smart Bee House</h1>
<p>Application de gestion apicole intelligente</p>

<div class="menu">
    <!-- Fermiers -->
    <a class="card" href="<%= request.getContextPath() %>/fermier">
        <div class="emoji"></div>
        <h2>Gestion des Fermiers</h2>
    </a>

    <!-- Fermes -->
    <a class="card" href="<%= request.getContextPath() %>/ferme">
        <div class="emoji"></div>
        <h2>Gestion des Fermes</h2>
    </a>

    <!-- Sites apicoles -->
    <a class="card" href="<%= request.getContextPath() %>/site">
        <div class="emoji"></div>
        <h2>Sites d'apiculture</h2>
    </a>

    <!-- Dashboard 1 -->
    <a class="card" href="<%= request.getContextPath() %>/jsp/dashboard1.jsp">
        <div class="emoji"></div>
        <h2>Planning des visites</h2>
    </a>

    <!-- Dashboard 2 -->
    <a class="card" href="<%= request.getContextPath() %>/jsp/dashboard2.jsp">
        <div class="emoji"></div>
        <h2>Production de miel</h2>
    </a>
</div>

</body>
</html>
