/** @type {import('tailwindcss').Config} */
module.exports = {
  darkMode: ['selector'],
  content: ["./templates/*.html"],
  theme: {
    extend: {
     fontFamily: {
        parkinsans: ['Parkinsans', 'sans-serif'],
        poppins: ['Poppins', 'sans-serif'],
      },
    },
  },
  plugins: [],
}