
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
