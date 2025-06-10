<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard 2 - Production de Miel</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    
    <script type="text/javascript">
        // Charger la librairie Google Charts
        google.charts.load('current', {packages: ['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        // Fonction de dessin du graphique
        function drawChart() {
            var data = google.visualization.arrayToDataTable([
                ['Ferme', 'Production (kg)'],
                ['Ferme A', 120],
                ['Ferme B', 95],
                ['Ferme C', 60],
                ['Ferme D', 135]
            ]);

            var options = {
                title: 'Production de miel par ferme',
                hAxis: {
                    title: 'Ferme'
                },
                vAxis: {
                    title: 'Kg de miel',
                    minValue: 0
                },
                legend: 'none',
                colors: ['#f4b400']
            };

            var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>
</head>
<body>
    <h2 style="text-align:center;">Tableau de bord - Production de miel</h2>
    <div id="chart_div" style="width: 800px; height: 400px; margin: auto;"></div>
</body>
</html>
