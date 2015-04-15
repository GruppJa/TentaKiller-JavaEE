var emailRegex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i

var registration = {
  createStyleValidator : function(field) {
    return function() {
      if (registration.validators[field](this.value)) {
        this.classList.add('valid')
        this.classList.remove('invalid') }
      else {
        this.classList.add('invalid')
        this.classList.remove('valid') } } },
  validators : {
    email : function(value) {
      // thanks http://www.regular-expressions.info/email.html
      return /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value) },
    name : function(value) {
      return /^[A-Z0-9._%+-]+$/i.test(value) },
    password : function(value) {
      return (value.length > 0 && value.length < 256) } } }

document.addEventListener('readystatechange', function(ev) {
  console.log('ready state changed', document.readyState, ev, this)
  if (document.readyState === 'interactive') {
    registration.form = document.querySelector('form[name="authenticate"]');
    registration.emailInput = registration.form.querySelector('input[name="email"]')
    registration.nameInput = registration.form.querySelector('input[name="name"]')
    registration.passwordInput = registration.form.querySelector('input[name="password"]')
    registration.loginInput = registration.form.querySelector('input[name="login"]')
    registration.registerInput = registration.form.querySelector('input[name="register"]')

    registration.emailInput.addEventListener('input', registration.createStyleValidator('email'))
    registration.nameInput.addEventListener('input', registration.createStyleValidator('name'))
    registration.passwordInput.addEventListener('input', registration.createStyleValidator('password'))

    /* registration.registerInput.addEventListener('click', function() {
      // TODO registration.validate()
      // registration.register(registration.loginInput.value, registration.passwordInput.value)
      console.log('register..', this, event) })

    registration.loginInput.addEventListener('click', function() {
      registration.form.action = 'login'
      console.log('login..', this, event) }) */ } } )