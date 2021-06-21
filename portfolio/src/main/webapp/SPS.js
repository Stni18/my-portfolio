
//Testing out a chart

google.charts.load('current', {'packages':['corechart']});
google.charts.setOnLoadCallback(drawChart);

/** Creates a chart and adds it to the page. */
function drawChart() {
  const data = new google.visualization.DataTable();
  data.addColumn('string', 'Language');
  data.addColumn('number', 'Count');
        data.addRows([
          ['C++', 20],
          ['Python', 10],
          ['Java', 30]
        ]);

  const options = {
    'title': 'Programming languages used',
    'width':500,
    'height':400
  };

  const chart = new google.visualization.PieChart(
      document.getElementById('chart-container'));
  chart.draw(data, options);
}