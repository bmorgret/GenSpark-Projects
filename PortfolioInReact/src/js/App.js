import '../css/App.css';
import Banner from './Banner'
import About from './About'
import Brand from './Brand'
import AboutMe from './AboutMe'
import Subscribe from './Subscribe'
import Footer from './Footer'


function App() {
  return (
    <div className="App">
      <header className="App-header">
          <main class="site-main">
            <Banner />
            <About />
            <Brand />
            <AboutMe />
            <Subscribe />
          </main>
          <Footer /> 
      </header>
    </div>
  );
}

export default App;
