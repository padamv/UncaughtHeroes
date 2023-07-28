const apiUrl = `http://localhost:8080/api/heroes?strengthGreaterThan=`;

function createHeroCard(hero) {
  var card = `
    <div class="col-md-4 mb-4">
      <a href="../html/view_hero.html?id=${hero.id}" class="card-link">
        <div class="card">
          <img src="${hero.picturePath}" onerror="this.src='../images/hero_placeholder.png'" class="card-img-top" alt="${hero.name}">
          <div class="card-body">
            <h5 class="card-title">${hero.name}</h5>
            <p class="card-text">${hero.description}</p>
          </div>
        </div>
      </a>
    </div>
  `;
  return card;
}

function renderHeroesList(heroesData) {
  const heroesList = $("#heroesList"); 
  heroesList.empty(); 

  heroesData.forEach(function (hero) {
    const heroCard = createHeroCard(hero);
    heroesList.append(heroCard); 
  });
}

function fetchHeroesData(apiUrl) {
  $.ajax({
    url: apiUrl,
    method: "GET",
    dataType: "json",
    success: function (data) {
      renderHeroesList(data);
    },
    error: function (error) {
      console.error("Error fetching heroes data:", error);
    },
  });
}

function findHeroesByStrength() {
  var strengthValue = parseInt(document.getElementById("strengthValue").value);
  var updatedApiUrl = apiUrl + strengthValue;
  fetchHeroesData(updatedApiUrl);
}


document.getElementById("strengthForm").addEventListener("submit", function (event) {
    event.preventDefault();
    findHeroesByStrength();
});