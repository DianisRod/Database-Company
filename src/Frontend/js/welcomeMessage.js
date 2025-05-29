document.addEventListener("DOMContentLoaded", function () {
  const fname = localStorage.getItem("fname");
  const lname = localStorage.getItem("lname");
  const birthdateFromStorage = localStorage.getItem("birthdate");


  if (fname) {
      document.getElementById("welcomeMessage").innerText = `Welcome, ${fname} ${lname}! we are happy you start with us`;
  } else {
      document.getElementById("welcomeMessage").innerText = "Welcome!";
    }

    const ageCalculate = calculateAge(birthdateFromStorage);
    console.log("age:" + ageCalculate);
      const data = {
        fname: fname,
        lname: lname,
        lemail: localStorage.getItem("lemail"),
        lage: ageCalculate,
      };

  for (const key in data) {
    const cell = document.getElementById(key);
    if (cell) {
      cell.innerText = data[key] || "—";
    }
  }
});

function calculateAge(birthdate) {
  if (!birthdate) return "";

  const birthDateObj = new Date(birthdate);
  const today = new Date();

  let age = today.getFullYear() - birthDateObj.getFullYear();
  const monthDiff = today.getMonth() - birthDateObj.getMonth();
  const dayDiff = today.getDate() - birthDateObj.getDate();

  if (monthDiff < 0 || (monthDiff === 0 && dayDiff < 0)) {
    age--;
  }

  return age;
}
