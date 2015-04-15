var emailRegex = /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i

var registration = {
  createStyleValidator : function(field) {
    return function() {
      var valid = registration.validators[field](this.value)
      if (valid) {
        this.classList.add('valid')
        this.classList.remove('invalid') }
      else {
        this.classList.add('invalid')
        this.classList.remove('valid') }
      return valid } },

  validators : {
    email : function(value) {
      // thanks http://www.regular-expressions.info/email.html
      return /^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,4}$/i.test(value) },

    name : function(value) {
      return /^[A-Z0-9._%+-]+$/i.test(value) },

    password : function(value) {
      return (value.length > 0 && value.length < 256) } } }

document.addEventListener('readystatechange', function(ev) {
  if (document.readyState === 'interactive') {
    registration.form = document.querySelector('form[name="authenticate"]');
    registration.emailInput = registration.form.querySelector('input[name="email"]')
    registration.nameInput = registration.form.querySelector('input[name="name"]')
    registration.passwordInput = registration.form.querySelector('input[name="password"]')
    registration.loginInput = registration.form.querySelector('input[name="login"]')
    registration.registerInput = registration.form.querySelector('input[name="register"]')

    var validateAndStyleEmail = registration.createStyleValidator('email')
    var validateAndStyleName = registration.createStyleValidator('name')
    var validateAndStylePassword = registration.createStyleValidator('password')

    registration.emailInput.addEventListener('input', validateAndStyleEmail)
    registration.nameInput.addEventListener('input', validateAndStyleName)
    registration.passwordInput.addEventListener('input', validateAndStylePassword)

    registration.registerInput.addEventListener('click', function(e) {
      var valid = true
      if (!validateAndStyleEmail.call(registration.emailInput, e)) valid = false
      if (!validateAndStyleName.call(registration.nameInput, e)) valid = false
      if (!validateAndStylePassword.call(registration.passwordInput, e)) valid = false
      if (!valid) {
        e.stopPropagation()
        e.preventDefault() } })

    registration.loginInput.addEventListener('click', function(e) {
      console.log('should we send login?')
      var valid = true
      if (!validateAndStyleEmail.call(registration.emailInput, e)) valid = false
      if (!validateAndStylePassword.call(registration.passwordInput, e)) valid = false
      console.log('valid is', valid)
      if (!valid) {
        console.log('no!')
        e.stopPropagation()
        e.preventDefault() } }) } } )