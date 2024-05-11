const pie_chart = document.querySelector(".pie-chart")
const bar_chart = document.querySelector(".bar-chart")

const total = Number(document.querySelector("#total").innerHTML);
const enrolled = Number(document.querySelector("#enrolled").innerHTML);
const completedCourse = Number(document.querySelector("#completed").innerHTML);

const incomplete = enrolled - completedCourse;

const info = document.querySelector("#details").innerHTML

// Load the Visualization API and the corechart package.
google.charts.load('current', {'packages':['corechart']});

// Set a callback to run when the Google Visualization API is loaded.
google.charts.setOnLoadCallback(drawPieChart);
google.charts.setOnLoadCallback(drawBarChart);

// Callback that creates and populates a data table,instantiates the pie chart,
// passes in the data and draws it.
function drawPieChart() {

    // Create the data table.
    var data = new google.visualization.DataTable();
    data.addColumn('string', info);
    data.addColumn('number', `Number of ${info}`);
    data.addRows([
        ['Completed', completedCourse],
        ['Not Completed', incomplete]
    ]);

    // Set chart options
    var pieOptions = {'title':`${info} Status Information`,
        'width':500,
        'height':400,
        'colors': ['green', 'red']
    };

    // Instantiate and draw our chart, passing in some options.
    var pieChart = new google.visualization.PieChart(pie_chart);
    pieChart.draw(data, pieOptions);
}


function drawBarChart() {
    var barData = google.visualization.arrayToDataTable([
        [info, `Number of ${info}`, { role: "style" } ],
        [`Total ${info}`, total, "blue"],
        [`${info} Enrolled`, enrolled, "red"],
        [`${info} Completed`, completedCourse, "green"],
    ]);

    var view = new google.visualization.DataView(barData);
    view.setColumns([0, 1,
        { calc: "stringify",
            sourceColumn: 1,
            type: "string",
            role: "annotation" },
        2]);

    var barOptions = {
        title: `${info} Status Information`,
        width: 600,
        height: 400,
        bar: {groupWidth: "95%"},
    };
    var barChart = new google.visualization.BarChart(bar_chart);
    barChart.draw(view, barOptions);
}
