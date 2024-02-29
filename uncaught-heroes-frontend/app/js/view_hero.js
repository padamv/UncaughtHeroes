const queryParams = new URLSearchParams(window.location.search);
const heroId = queryParams.get("id");
const apiUrl = `http://localhost:8765/api/heroes/${heroId}`;

function fetchHeroesData() {
	$.ajax({
		url: apiUrl,
		method: "GET",
		dataType: "json",
		success: function (data) {
			populateHeroDetails(data);
		},
		error: function () {
			showErrorAndNavigateBack();
		},
	});
}

function populateHeroDetails(heroData) {
	var heroImageElement = document.getElementById("heroImage");
	heroImageElement.src = "../" + heroData.picturePath;
	heroImageElement.onerror = function () {
		this.src = "../images/hero_placeholder.png";
	};

	document.getElementById("heroName").textContent = heroData.name;
	document.getElementById("heroDescription").textContent = heroData.description;
	document.getElementById("strength").textContent = heroData.strength;
	document.getElementById("dexterity").textContent = heroData.dexterity;
	document.getElementById("constitution").textContent = heroData.constitution;
	document.getElementById("intelligence").textContent = heroData.intelligence;
	document.getElementById("wisdom").textContent = heroData.wisdom;
	document.getElementById("speed").textContent = heroData.speed;
	document.getElementById("charisma").textContent = heroData.charisma;
	document.getElementById("xp").textContent = heroData.xp;
	document.getElementById("mp").textContent = heroData.mp;
	document.getElementById("hp").textContent = heroData.hp;
	document.getElementById("baseAttack").textContent = heroData.baseAttack;
	document.getElementById("baseDefense").textContent = heroData.baseDefense;
	document.getElementById("maxSpells").textContent = heroData.maxSpells;
	document.getElementById("carryingCapacity").textContent = heroData.carryingCapacity;
	document.getElementById("weight").textContent = heroData.weight;
	document.getElementById("height").textContent = heroData.height;
	document.getElementById("race").textContent = heroData.race;
	document.getElementById("skills").textContent = heroData.skills.join(", ");
	document.getElementById("weapons").textContent = heroData.weapons.join(", ");
	document.getElementById("spells").textContent = heroData.spellList.join(", ");
	document.getElementById("items").textContent = heroData.items.join(", ");
}

function showErrorAndNavigateBack() {
	alert("Error: Hero not found!");
	window.history.back();
}

fetchHeroesData();
