var heroData = {
    name: "Hero 1",
    picturePath: "images/hero_1.png",
    description: "This is Hero 1. Lorem ipsum dolor sit amet, consectetur adipiscing elit.",
    strength: 350,
    dexterity: 12,
    constitution: 14,
    intelligence: 12,
    wisdom: 13,
    speed: 16,
    charisma: 15,
    xp: 1000,
    mp: 200,
    hp: 500,
    baseAttack: 25,
    baseDefense: 20,
    maxSpells: 5,
    carryingCapacity: 150,
    weight: 180,
    height: "6'0\"",
    skills: ["Skill 1", "Skill 2", "Skill 3"],
    weapons: ["Sword", "Bow", "Axe"],
    spellList: ["Fireball", "Heal", "Lightning"],
    items: ["Potion", "Amulet", "Ring"],
};

function populateHeroDetails() {
    var heroImageElement = document.getElementById("heroImage");
        heroImageElement.src = heroData.picturePath;
        heroImageElement.onerror = function () {
            this.src = "../images/hero_placeholder.png";
    };

    document.getElementById("heroImage").src = heroData.picturePath;
    document.getElementById("heroName").textContent = "Name: " + heroData.name;
    document.getElementById("heroDescription").textContent = "Description: " + heroData.description;
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
    document.getElementById("skills").textContent = heroData.skills.join(", ");
    document.getElementById("weapons").textContent = heroData.weapons.join(", ");
    document.getElementById("spells").textContent = heroData.spellList.join(", ");
    document.getElementById("items").textContent = heroData.items.join(", ");
}

populateHeroDetails();
