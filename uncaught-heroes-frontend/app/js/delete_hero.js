const apiUrl = `http://localhost:8765/api/heroes/`;

function showSuccessModal() {
  var successModal = document.getElementById("successModal");
  $(successModal).modal("show");
}

function showErrorModal() {
  var errorModal = document.getElementById("errorModal");
  $(errorModal).modal("show");
}

function handleDelete() {
  var heroId = document.getElementById("heroId").value;

  $.ajax({
    url: apiUrl + heroId,
    method: "DELETE",
    success: function () {
      showSuccessModal();
    },
    error: function (error) {
      if (error.status === 404) {
        showErrorModal();
      } else {
        console.error("Failed to delete hero:", error.status);
      }
    },
  });

  document.getElementById("deleteForm").reset();
}

document.getElementById("deleteForm").addEventListener("submit", function (event) {
  event.preventDefault();
  handleDelete();
});