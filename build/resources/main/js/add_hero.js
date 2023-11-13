const apiUrl = 'http://localhost:8080/api/heroes';

$(document).ready(function () {

  function addNewHero() {
    const heroData = {
      name: $('#name').val(),
      picturePath: $('#picturePath').val(),
      description: $('#description').val(),
      strength: parseInt($('#strength').val()),
      dexterity: parseInt($('#dexterity').val()),
      constitution: parseInt($('#constitution').val()),
      intelligence: parseInt($('#intelligence').val()),
      wisdom: parseInt($('#wisdom').val()),
      speed: parseInt($('#speed').val()),
      charisma: parseInt($('#charisma').val()),
      hp: parseInt($('#hp').val()),
      baseAttack: parseInt($('#baseAttack').val()),
      baseDefense: parseInt($('#baseDefense').val()),
      weight: parseInt($('#weight').val()),
      height: parseInt($('#height').val()),
      race: $('#race').val(),
      skills: $('#skills').val(),
      weapons: $('#weapons').val(),
      items: $('#items').val(),
    };

    $.ajax({
      url: apiUrl,
      type: 'POST',
      contentType: 'application/json',
      data: JSON.stringify(heroData),
      success: function () {
        alert('Hero created successfully!');
      },
      error: function (xhr) {
        if (xhr.status === 409) {
          alert('Error: Hero name already exists. Please choose a different name.');
        } else {
          alert('Error: Unable to create hero. Please try again later.');
        }
      }
    });
  }

  $('form').submit(function (event) {
    event.preventDefault();
    addNewHero();
  });
});
