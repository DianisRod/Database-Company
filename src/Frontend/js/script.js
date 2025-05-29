document.addEventListener("DOMContentLoaded", function () {
  const fname = localStorage.getItem("fname");
  const lname = localStorage.getItem("lname");

  if (fname) {
    document.getElementById("welcomeMessage").innerText = `Welcome, ${fname} ${lname}!`;
  } else {
    document.getElementById("welcomeMessage").innerText = "Welcome!";
  }

});

document.getElementById("userForm").addEventListener("submit", function(e) {
  e.preventDefault();

  localStorage.setItem("position", document.getElementById("position").value);
  localStorage.setItem("Begin_DatetimeLocal", document.getElementById("Begin_DatetimeLocal").value);
  localStorage.setItem("End_DatetimeLocal", document.getElementById("End_DatetimeLocal").value);
  localStorage.setItem("WorkTime", document.getElementById("WorkTime").value);

  window.location.href = "welcome.html";
});
