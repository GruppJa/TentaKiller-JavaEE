var registration = { }

document.addEventListener('readystatechange', function(ev) {
  console.log('ready state changed', document.readyState, ev, this)
  if (document.readyState === 'interactive') {
    registration.form = document.querySelector('form[name="authenticate"]');
    registration.emailInput = registration.form.querySelector('input[name="email"]')
    registration.nameInput = registration.form.querySelector('input[name="name"]')
    registration.passwordInput = registration.form.querySelector('input[name="password"]')
    registration.loginInput = registration.form.querySelector('input[name="login"]')
    registration.registerInput = registration.form.querySelector('input[name="register"]')

    registration.nameInput.addEventListener('input', function() {
      // TODO search and display names
      console.log('name input', this.value) })

    /* registration.registerInput.addEventListener('click', function() {
      // TODO registration.validate()
      // registration.register(registration.loginInput.value, registration.passwordInput.value)
      console.log('register..', this, event) })

    registration.loginInput.addEventListener('click', function() {
      registration.form.action = 'login'
      console.log('login..', this, event) }) */ } } )