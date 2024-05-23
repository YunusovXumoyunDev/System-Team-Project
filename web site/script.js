
// Navigatsiya tugmasiga effektlar qo'shish
const navBtn = document.querySelector('.nav-btn');
navBtn.addEventListener('mouseenter', () => {
  navBtn.style.transform = 'scale(1.1)';
});
navBtn.addEventListener('mouseleave', () => {
  navBtn.style.transform = 'scale(1)';
});

// Foydalanuvchi tugmasiga effektlar qo'shish
const userBtn = document.querySelector('.user-btn');
userBtn.addEventListener('mouseenter', () => {
  userBtn.style.transform = 'scale(1.1)';
});
userBtn.addEventListener('mouseleave', () => {
  userBtn.style.transform = 'scale(1)';
});

// kirish.html fali uchun

const loginBtn = document.querySelector('.login-btn-kirish');
const registerBtn = document.querySelector('.register-btn-kirish');

loginBtn.addEventListener('click', () => {
  const usernameInput = document.querySelector('.user-box-kirish input[name="username"]');
  const passwordInput = document.querySelector('.user-box-kirish input[name="password"]');

  // Kirish logikasi
  console.log('Username:', usernameInput.value);
  console.log('Password:', passwordInput.value);
});

registerBtn.addEventListener('click', () => {
  // Ro'yhatdan o'tish logikasi
  window.location.href = 'register.html';
});
