<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Dashboard – Production de miel</title>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <script type="text/javascript">
        // Charger Google Charts
        google.charts.load('current', {packages: ['corechart']});
        google.charts.setOnLoadCallback(drawChart);

        function drawChart() {
            // Données simulées (nom ferme, quantité miel)
            var data = google.visualization.arrayToDataTable([
                ['Ferme', 'Kg de miel'],
                ['Ferme A', 120],
                ['Ferme B', 85],
                ['Ferme C', 150],
                ['Ferme D', 60]
            ]);

            var options = {
                title: 'Production de miel par ferme',
                hAxis: {title: 'Ferme'},
                vAxis: {title: 'Quantité (kg)'},
                colors: ['#f1c40f'],
                legend: {position: 'none'},
                animation: {
                    startup: true,
                    duration: 1000,
                    easing: 'out'
                }
            };

            var chart = new google.visualization.ColumnChart(document.getElementById('chart_div'));
            chart.draw(data, options);
        }
    </script>

    <style>
        body {
            font-family: 'Segoe UI', sans-serif;
            text-align: center;
            background-color: #f4f7f9;
            padding: 30px;
        }

        h2 {
            color: #2c3e50;
            margin-bottom: 30px;
        }

        #chart_div {
            width: 90%;
            height: 500px;
            margin: auto;
        }
    </style>
</head>
<body>

<h2>Production de miel par ferme</h2>

<div id="chart_div"></div>

</body>
</html>
