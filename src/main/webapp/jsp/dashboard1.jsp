<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Planning des visites - Dashboard 1</title>
    <style>
        table {
            border-collapse: collapse;
            width: 80%;
            margin: auto;
        }
        th, td {
            border: 1px solid #aaa;
            padding: 8px;
            text-align: center;
        }
        th {
            background-color: #f0f0f0;
        }
        td.clickable {
            cursor: pointer;
            background-color: #e9f5ff;
        }
    </style>
    <script>
        function showVisitDetails(agent, ruche, date, heure, action) {
            alert(
                "Agent : " + agent + "\\n" +
                "Ruche : " + ruche + "\\n" +
                "Date : " + date + "\\n" +
                "Heure : " + heure + "\\n" +
                "Action prévue : " + action
            );
        }
    </script>
</head>
<body>
    <h2 style="text-align: center;">Tableau de bord - Planning Visites</h2>

    <table>
        <tr>
            <th>Agent \\ Ruche</th>
            <th>Ruche 101</th>
            <th>Ruche 102</th>
            <th>Ruche 103</th>
        </tr>
        <tr>
            <td>Agent Ali</td>
            <td class="clickable" onclick="showVisitDetails('Ali', '101', '2025-06-15', '09:00', 'Inspection sanitaire')">Planifiée</td>
            <td></td>
            <td class="clickable" onclick="showVisitDetails('Ali', '103', '2025-06-16', '11:00', 'Collecte de miel')">Planifiée</td>
        </tr>
        <tr>
            <td>Agent Rania</td>
            <td></td>
            <td class="clickable" onclick="showVisitDetails('Rania', '102', '2025-06-15', '10:00', 'Évaluation de production')">Planifiée</td>
            <td></td>
        </tr>
    </table>
</body>
</html>
