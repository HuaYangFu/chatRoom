function formSubmit() {
  document.getElementById("myForm").submit();
}
window.onload = function() {

    document.getElementById('toggleProfile').addEventListener('click', function () {
        [].map.call(document.querySelectorAll('.profile'), function(el) {
          el.classList.toggle('profile--open');
        });
    });

};