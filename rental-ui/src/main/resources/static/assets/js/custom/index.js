$(document).ready(function() {
  charts.initDashboardPageCharts();
});

charts = {
initDashboardPageCharts: function() {

  // Global color and configuration for the charts with Line gradientStroke
  chartColor = "#FFFFFF";
  gradientChartOptionsConfiguration = {
      maintainAspectRatio: false,
      legend: {
        display: false
      },
      tooltips: {
        bodySpacing: 4,
        mode: "nearest",
        intersect: 0,
        position: "nearest",
        xPadding: 10,
        yPadding: 10,
        caretPadding: 10
      },
      responsive: 1,
      scales: {
        yAxes: [{
          display: 0,
          gridLines: 0,
          ticks: {
            display: false
          },
          gridLines: {
            zeroLineColor: "transparent",
            drawTicks: false,
            display: false,
            drawBorder: false
          }
        }],
        xAxes: [{
          display: 0,
          gridLines: 0,
          ticks: {
            display: false
          },
          gridLines: {
            zeroLineColor: "transparent",
            drawTicks: false,
            display: false,
            drawBorder: false
          }
        }]
      },
      layout: {
        padding: {
          left: 0,
          right: 0,
          top: 15,
          bottom: 15
        }
      }
    };
  gradientChartOptionsConfigurationWithNumbersAndGrid = {
    maintainAspectRatio: false,
    legend: {
      display: false
    },
    tooltips: {
      bodySpacing: 4,
      mode: "nearest",
      intersect: 0,
      position: "nearest",
      xPadding: 10,
      yPadding: 10,
      caretPadding: 10
    },
    responsive: true,
    scales: {
      yAxes: [{
        gridLines: 0,
        gridLines: {
          zeroLineColor: "transparent",
          drawBorder: false
        }
      }],
      xAxes: [{
        display: 0,
        gridLines: 0,
        ticks: {
          display: false
        },
        gridLines: {
          zeroLineColor: "transparent",
          drawTicks: false,
          display: false,
          drawBorder: false
        }
      }]
    },
    layout: {
      padding: {
        left: 0,
        right: 0,
        top: 15,
        bottom: 15
      }
    }
  };

  //Top Row Line chart to display city data
  $.ajax({
    url: 'http://localhost:7979/cityData',
//    url: 'http://192.168.99.101:7979/cityData',
    dataType: 'json',
    success: function (data) {

      var city;
      var arr = [];
      var nyData = [];
      var sfData = [];
      var laData = [];
      var miamiData = [];

      $.each(data, function(index) {
        city = data[index].location;
        selectMonth(city, index);
      });

      function selectMonth(city, index) {
        switch (city) {
          case "New York":
            arr = [];
            addMonthData(index);
            nyData = arr;
            break;
          case "Los Angeles":
            arr = [];
            addMonthData(index);
            laData = arr;
            break;
          case "San Francisco":
            arr = [];
            addMonthData(index);
            sfData = arr;
            break;
          case "Miami":
            arr = [];
            addMonthData(index);
            miamiData = arr;
            break;
        }
      }

      function addMonthData(index) {
        arr.push(data[index].Jan, data[index].Feb, data[index].Mar, data[index].Apr,
        data[index].May, data[index].Jun, data[index].Jul, data[index].Aug,
        data[index].Sep, data[index].Oct, data[index].Nov, data[index].Dec);
      }

      var ctx = document.getElementById('bigDashboardChart').getContext("2d");
      var gradientStroke = ctx.createLinearGradient(500, 0, 100, 0);
      gradientStroke.addColorStop(0, '#80b6f4');
      gradientStroke.addColorStop(1, chartColor);

      var gradientFill = ctx.createLinearGradient(0, 200, 0, 50);
      gradientFill.addColorStop(0, "rgba(128, 182, 244, 0)");
      gradientFill.addColorStop(1, "rgba(255, 255, 255, 0.24)");

      var myChart = new Chart(ctx, {
        type: 'line',
        data: {
          labels: ["JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"],
          datasets: [{
            label: "New York",
            borderColor: "#FF6384",
            pointBorderColor: "#1e3d60",
            pointBackgroundColor: "#FF6384",
            pointHoverBackgroundColor: "#FF6384",
            pointHoverBorderColor: chartColor,
            pointBorderWidth: 1,
            pointHoverRadius: 7,
            pointHoverBorderWidth: 2,
            pointRadius: 5,
            fill: true,
            backgroundColor: gradientFill,
            borderWidth: 2,
  //                data: [50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
            data: nyData
  //                data: [data.jan, data.feb, data.march, data.april, data.may, data.june, data.july, data.aug, data.sep, data.oct, data.nov, data.dec]
          },
          {
            label: "San Francisco",
            borderColor: "#4BC0C0",
            pointBorderColor: "#1e3d60",
            pointBackgroundColor: "#4BC0C0",
            pointHoverBackgroundColor: "#4BC0C0",
            pointHoverBorderColor: chartColor,
            pointBorderWidth: 1,
            pointHoverRadius: 7,
            pointHoverBorderWidth: 2,
            pointRadius: 5,
            fill: true,
            backgroundColor: gradientFill,
            borderWidth: 2,
  //                data: [50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
            data: sfData
  //                data: [data.jan, data.feb, data.march, data.april, data.may, data.june, data.july, data.aug, data.sep, data.oct, data.nov, data.dec]
          },
          {
            label: "Los Angeles",
            borderColor: "#FFCD56",
            pointBorderColor: "#1e3d60",
            pointBackgroundColor: "#FFCD56",
            pointHoverBackgroundColor: "#FFCD56",
            pointHoverBorderColor: chartColor,
            pointBorderWidth: 1,
            pointHoverRadius: 7,
            pointHoverBorderWidth: 2,
            pointRadius: 5,
            fill: true,
            backgroundColor: gradientFill,
            borderWidth: 2,
  //                data: [50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
            data: laData
  //                data: [data.jan, data.feb, data.march, data.april, data.may, data.june, data.july, data.aug, data.sep, data.oct, data.nov, data.dec]
                        },
          {
            label: "Miami",
            borderColor: "#36A2EB",
            pointBorderColor: "#1e3d60",
            pointBackgroundColor: "#36A2EB",
            pointHoverBackgroundColor: "#36A2EB",
            pointHoverBorderColor: chartColor,
            pointBorderWidth: 1,
            pointHoverRadius: 7,
            pointHoverBorderWidth: 2,
            pointRadius: 5,
            fill: true,
            backgroundColor: gradientFill,
            borderWidth: 2,
  //                data: [50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
            data: miamiData
  //                data: [data.jan, data.feb, data.march, data.april, data.may, data.june, data.july, data.aug, data.sep, data.oct, data.nov, data.dec]
            }]
        },
        options: {
          layout: {
            padding: {
              left: 20,
              right: 20,
              top: 0,
              bottom: 0
            }
          },
          maintainAspectRatio: false,
          tooltips: {
            backgroundColor: '#fff',
            titleFontColor: '#333',
            bodyFontColor: '#666',
            bodySpacing: 4,
            xPadding: 12,
            mode: "nearest",
            intersect: 0,
            position: "nearest"
          },
          legend: {
            position: "bottom",
            fillStyle: "#FFF",
            display: true,
            labels: {
              fontColor: "rgba(255,255,255,0.4)",
              fontStyle: "bold"
            }
          },
          scales: {
            yAxes: [{
              ticks: {
                fontColor: "rgba(255,255,255,0.4)",
                fontStyle: "bold",
                beginAtZero: true,
                maxTicksLimit: 5,
                padding: 10
              },
              gridLines: {
                drawTicks: true,
                drawBorder: false,
                display: true,
                color: "rgba(255,255,255,0.1)",
                zeroLineColor: "transparent"
              }

            }],
            xAxes: [{
              gridLines: {
                zeroLineColor: "transparent",
                display: false,

              },
              ticks: {
                padding: 10,
                fontColor: "rgba(255,255,255,0.4)",
                fontStyle: "bold"
              }
            }]
          }
        }
      });
    }
  });

  //Middle Row pie and doughnut charts to display top products
  $.ajax({
    url: 'http://localhost:7979/productData',
//    url: 'http://192.168.99.101:7979/productData',
    dataType: 'json',
    success: function (data) {
      var lensLabelData = [];
      var lensCountData = [];
      var cameraLabelData = [];
      var cameraCountData = [];

      $.each(data, function(index) {
        if (data[index].category == "Camera Lenses") {
          lensLabelData.push(data[index].model);
          lensCountData.push(data[index].count);
        } else if (data[index].category == "Digital Cameras") {
          cameraLabelData.push(data[index].model);
          cameraCountData.push(data[index].count);
        }
      });

        var cardStatsMiniLineColor = "#fff",
          cardStatsMiniDotColor = "#fff";
        var c = document.getElementById('lineChartExample').getContext("2d");

        function getColors(length){
          let pallet = ["#FF6384", "#4BC0C0", "#FFCD56", "#36A2EB", "#FF9F40", "#9966FF", "#E7E9ED"];
          let colors = [];
          for(let i = 0; i < length; i++) {
            colors.push(pallet[i % pallet.length]);
          }
          return colors;
        }

        var pieChart = new Chart(c, {
          type: 'pie',
          responsive: true,
          data: {
            labels: lensLabelData,
            datasets: [{
              backgroundColor: getColors(lensCountData.length),
              data: lensCountData
            }]
          },
          options: {
            maintainAspectRatio: false,
              legend: {
                display: true
              },
              title: {
                display: false,
                text: 'Top Rented Lens models'
              }
          }
        });

        var context = document.getElementById('lineChartExampleWithNumbersAndGrid').getContext("2d");
        var lineChart = new Chart(context, {
          type: 'doughnut',
          responsive: true,
          data: {
          //              labels: ["12pm,", "3pm", "6pm", "9pm", "12am", "3am", "6am", "9am"],
            labels: cameraLabelData,
            datasets: [{
              backgroundColor: getColors(cameraCountData.length),
              data: cameraCountData
            }]
          },
          options: {
            maintainAspectRatio: false,
            legend: {
              display: true
            },
            title: {
              display: false,
              text: 'Top Rented Camera models'
            }
          }
        });
      }
  });

  //Middle Row Bar chart to display yearly data month wise
  $.ajax({
    url: 'http://localhost:7979/monthData',
//    url: 'http://192.168.99.101:7979/monthData',
    dataType: 'json',
    success: function (data) {
      var e = document.getElementById("barChartSimpleGradientsNumbers").getContext("2d");

      function getColors(length){
          let pallet = ["#FF6384", "#4BC0C0", "#FFCD56", "#36A2EB", "#FF9F40", "#9966FF", "#E7E9ED"];
          let colors = [];
          for(let i = 0; i < length; i++) {
            colors.push(pallet[i % pallet.length]);
          }
          return colors;
      }

      var barChart = new Chart(e, {
        type: "horizontalBar",
        responsive: true,
        data: {
          labels: ["January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"],
          datasets: [{
            backgroundColor: getColors(12),
//                data: [50, 150, 100, 190, 130, 90, 150, 160, 120, 140, 190, 95]
//            data: [data.jan, data.feb, data.march, data.april, data.may, data.june, data.july, data.aug, data.sep, data.oct, data.nov, data.dec]
              data: [data.JANUARY, data.FEBRUARY, data.MARCH, data.APRIL, data.MAY, data.JUNE, data.JULY, data.AUGUST, data.SEPTEMBER, data.OCTOBER, data.NOVEMBER, data.DECEMBER]
          }]
        },
        options: {
          maintainAspectRatio: false,
            legend: {
              display: false
            },
            title: {
              display: false,
              text: 'Rented products by Location'
            }
        }
      });
    }
  });
}
};