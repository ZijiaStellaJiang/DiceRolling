import logo from './logo.svg';
import './App.css';
import {Component} from "react";
import Welcome from "./components/Welcome";

function App(){
  return(
      <div className={"App"}>
        <Welcome></Welcome>
      </div>
  )
}

export default App;
