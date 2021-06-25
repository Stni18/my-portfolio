
//Testing out a chart

google.charts.load('current', { 'packages': ['bar'] });
google.charts.setOnLoadCallback(drawChart);

function drawChart() {
    var data = new google.visualization.arrayToDataTable([
        ['Languages', 'Percentage'],
        ["Java", 73],
        ["C++", 60],
        ["Python", 42],
        ['Other', 10]
    ]);

    var options = {
        title: 'Programming skills',
        width: 900,
        height:500,
        legend: { position: 'none' },
        chart: {
            title: 'Programming Language Skills',
            subtitle: 'Percentage of skill'
        },
        bars: 'horizontal', // Required for Material Bar Charts.
        axes: {
            x: {
                0: { side: 'top', label: 'Percentage' } // Top x-axis.
            }
        },
        bar: { groupWidth: "90%" }

    };

    var chart = new google.charts.Bar(document.getElementById('chart-container'));
    chart.draw(data, options);
};