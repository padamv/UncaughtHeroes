var heroesData = [
    {
        id: 1,
        name: "Hero 1",
        picturePath: "images/hero_1.png",
        description: "This is Hero 1. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        strength: 20,
    },
    {
        id: 2,
        name: "Hero 2",
        picturePath: "images/hero_2.png",
        description: "This is Hero 2. Ut tristique, augue vel auctor posuere, lorem odio placerat metus.",
        strength: 18,
    },
];


function createHeroCard(hero) {
    var card = `
      <div class="col-md-3 mb-4">
        <div class="card" onclick="redirectToHero(${hero.id})">
          <img src="${hero.picturePath}" onerror="this.src='default_hero_picture.jpg'" class="card-img-top" alt="${hero.name}">
          <div class="card-body">
            <h5 class="card-title">${hero.name}</h5>
            <p class="card-text">${hero.description}</p>
          </div>
        </div>
      </div>
    `;
    return card;
  }

function redirectToHero(heroId) {
    window.location.href = `view_hero.html?id=${heroId}`;
}

function renderHeroesByStrength(strengthValue) {
    var heroesList = document.getElementById("heroesList");
    heroesList.innerHTML = "";

    heroesData.forEach(function (hero) {
        if (hero.strength > strengthValue) {
          var heroCard = createHeroCard(hero);
          heroesList.innerHTML += heroCard;
        }
    });
}

function findHeroesByStrength() {
    var strengthValue = parseInt(document.getElementById("strengthValue").value);
    renderHeroesByStrength(strengthValue);
}

document.getElementById("strengthForm").addEventListener("submit", function (event) {
    event.preventDefault();
    findHeroesByStrength();
});