var heroesExtendedData = [
  {
    id: 1,
    name: "Hero 1",
    picturePath: "hero1.jpg",
    description: "This is Hero 1. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
  },
  {
    id: 2,
    name: "Hero 2",
    picturePath: "hero2.jpg",
    description: "This is Hero 2. Ut tristique, augue vel auctor posuere, lorem odio placerat metus.",
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
        </div>
      </div>
    </div>
  `;
  return card;
}

function renderHeroesList() {
  var heroesList = document.getElementById("heroesList");
  heroesExtendedData.forEach(function (hero) {
    var heroCard = createHeroCard(hero);
    heroesList.innerHTML += heroCard;
  });
}

renderHeroesList();

