function calculateBMRmetric() {
  let weight = document.getElementById("weight").value;

  let height = document.getElementById("height").value;

  let age = document.getElementById("age").value;

  let gender = document.getElementById("gender").value;
  
  let activitymultiple = document.querySelector('input[name="radio1"]:checked').value;

  if (gender == "male") {

    var bmrmetric = (66.5 + (13.76 * weight) + (5.003 * height) - (6.755 * age));
    var calintake = bmrmetric* activitymultiple;
  } else {

    var bmrmetric = (655 + (9.563 * weight) + (1.85 * height) - (4.676 * age));
    var calintake = bmrmetric * activitymultiple;
  }

  document.getElementById("bmr").value = bmrmetric;
  document.getElementById("calIntake").value = calintake;
}

function calculateBMRimperial() {
  let weight = document.getElementById("weight").value;


  let height = document.getElementById("height").value;

  let age = document.getElementById("age").value;
  let gender = document.getElementById("gender").value;

  let activitymultiple = document.querySelector('input[name="radio1"]:checked').value;

  if (gender == "male") {

    var bmrimp = (66 + (6.2 * weight) + (12.7 * height) - (6.76 * age));
    var calintake= bmrimp* activitymultiple;
  } else {

    var bmrimp = (655 + (4.35 * weight) + (4.7 * height) - (4.7 * age));
    var calintake = bmrimp * activitymultiple;
  }
  document.getElementById("bmr").value = bmrimp;
  document.getElementById("calIntake").value = calintake;
}
