var heroesData = [
    {
        id: 1,
        name: "Hero 1",
        picturePath: "hero1.jpg",
        description: "This is Hero 1. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
        strength: 20,
    },
    {
        id: 2,
        name: "Hero 2",
        picturePath: "hero2.jpg",
        description: "This is Hero 2. Ut tristique, augue vel auctor posuere, lorem odio placerat metus.",
        strength: 18,
    },
];


function createHeroCard(hero) {
    var card = `
        <div class="col-md-4 mb-4">
          <div class="card">
            <img src="${hero.picturePath}" class="card-img-top" alt="${hero.name}">
            <div class="card-body">
              <h5 class="card-title">${hero.name}</h5>
              <p class="card-text">${hero.description}</p>
              <p class="card-text">Strength: ${hero.strength}</p>
            </div>
          </div>
        </div>
        `;
    return card;
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