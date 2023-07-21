function viewHeroDetails() {
    var heroId = document.getElementById("heroId").value;
    window.location.href = "view_hero.html?id=" + encodeURIComponent(heroId);
}

document.getElementById("heroForm").addEventListener("submit", function (event) {
    event.preventDefault();
    viewHeroDetails();
});