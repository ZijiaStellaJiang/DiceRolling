import React, {Component} from 'react';
import "./App.css"
import {Route, Routes} from "react-router-dom";
import NavigationBeforeLogin from "./assemblies/NavigationBeforeLogin";
import Login from "./assemblies/Login";
import Signup from "./assemblies/Signup";
import NavigationAfterLogin from "./assemblies/NavigationAfterLogin";
import CreateGame from "./assemblies/CreateGame";
import CreateObject from "./assemblies/CreateObject";
import GameCenter from "./assemblies/GameCenter";
import WaitingRoom from "./assemblies/GameRoom";
import JoinGame from "./assemblies/JoinGame";
import LoadGame from "./assemblies/LoadGame";
class App extends Component {
    state={
        isLogin: false
    }
    // login=()=>{
    //     this.setState({isLogin:true});
    // }
    render() {
       console.log(this.state.isLogin);
        return (
                <div className="main_container">
                    <div className="bg_chapel">
                        <Routes>
                            <Route path="/" element={<NavigationBeforeLogin/>}/>
                            <Route path="/login" element={<Login/>}/>
                            <Route path="/signup" element={<Signup/>}/>
                            <Route path="/user/index_after_login" element={<NavigationAfterLogin/>}/>
                            <Route path="/user/createGame" element={<CreateGame/>}/>
                            <Route path="user/joinGame" element={<JoinGame/>}/>
                            <Route path="/user/createObject" element={<CreateObject/>}/>
                            <Route path="/user/gameCenter" element={<GameCenter/>}/>
                            <Route path="/user/waitingRoom" element={<WaitingRoom/>}/>
                            <Route path="/user/LoadGame" element={<LoadGame/>}/>
                        </Routes>
                    </div>
                </div>
        );
    }
}

export default App;
