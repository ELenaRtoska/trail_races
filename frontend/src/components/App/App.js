import React, {Component} from 'react';
import './App.css';
import Header from "../Header/header";
import {BrowserRouter as Router, Switch, Route, Redirect} from "react-router-dom";
import Features from "../Features/features";
import Races from "../Races/races";
import HomePage from "../HomePage/homePage";
import Error from "../Error/error";

class App extends Component{

    constructor(props) {
        super(props);

        this.state = {
            error: {}
        };

    }

    render() {
        return (
            <Router>
                <Header/>
                <Switch>
                    <Route path={"/races"} render={(props) => <Races {...props} handleError={this.handleError}/>}>
                    </Route>
                    <Route path={"/features"} render={(props) => <Features {...props} handleError={this.handleError}/>}>
                    </Route>
                    <Route path={"/error"}>
                        <Error error={this.state.error}/>
                    </Route>
                    <Route path={"/"}>
                        <HomePage handleError={this.handleError}/>
                    </Route>
                    <Redirect to={"/"}/>
                </Switch>
            </Router>
        );
    }

    handleError = (error, history) => {
        this.setState({
            error: error
        }, () => {
            history.push("/error");
        });
    };

}

export default App;
