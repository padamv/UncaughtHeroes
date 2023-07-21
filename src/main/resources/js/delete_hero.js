var heroesData = [
  {
    id: 1,
    name: "Hero 1",
  },
  {
    id: 2,
    name: "Hero 2",
  },
];

function deleteHeroById(heroId) {
  var heroIndex = heroesData.findIndex(function (hero) {
    return hero.id === heroId;
  });

  if (heroIndex !== -1) {
    heroesData.splice(heroIndex, 1);
    return true;
  } else {
    return false;
  }
}

function showSuccessModal() {
  var successModal = document.getElementById("successModal");
  $(successModal).modal("show");
}

function showErrorModal() {
  var errorModal = document.getElementById("errorModal");
  $(errorModal).modal("show");
}

function handleDelete() {
  var heroId = parseInt(document.getElementById("heroId").value);

  var deletionSuccessful = deleteHeroById(heroId);

  if (deletionSuccessful) {
    showSuccessModal();
  } else {
    showErrorModal();
  }

  document.getElementById("deleteForm").reset();
}

document.getElementById("deleteForm").addEventListener("submit", function (event) {
  event.preventDefault();
  handleDelete();
});