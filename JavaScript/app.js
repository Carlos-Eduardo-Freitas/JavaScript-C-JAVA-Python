'use strict'
const switcher = document.querySelector('#theme-switcher');

switcher.addEventListener('click', function(){
    // Toggle da classe
    document.body.classList.toggle('dark-theme');
    document.body.classList.toggle('light-theme');
    
   
    const className = document.body.className;
    
    if(className.includes('light-theme')){
        this.textContent = "🌙 Dark Mode";
    } else {
        this.textContent = "☀️ Light Mode";
    }
    
    console.log('current class name: ' + className);
});