import React from 'react';
import ReactDOM from 'react-dom/client';
import './css/index.css';
import App from './js/App';
import reportWebVitals from './js/reportWebVitals';
//Bootstrap css file
import "./css/bootstrap.min.css";
//font awesome icons
import "./css/all.min.css";
//Magnific Popup css file
import "./vendor/Magnific-Popup/dist/magnific-popup.css";
//Owl-carousel css file
//import "./vendor/owl-carousel/css/owl.carousel.min.css"
//import "./vendor/owl-carousel/css/owl.theme.default.min.css";
//custom css file
import "./css/style.css";
//Responsive css file  -->
import "./css/responsive.css"

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <App />
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
