import * as React from 'react';
import '../res/css/App.css';
import SVG_Y from "../res/components/Logo"

function App() {
  return (
      <div className="App">
        <header className="App-header">
          <SVG_Y width={50} height={50} />
        </header>
      </div>
  );
}

export default App;
