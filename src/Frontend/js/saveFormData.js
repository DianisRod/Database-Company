document.getElementById("userForm").addEventListener("submit", function(e) {
  e.preventDefault();

  localStorage.setItem("fname", document.getElementById("fname").value);
  localStorage.setItem("lname", document.getElementById("lname").value);
  localStorage.setItem("birthdate", document.getElementById("birthdate").value);
  localStorage.setItem("lemail", document.getElementById("lemail").value);

  window.location.href = "formularPosition.html";
});
