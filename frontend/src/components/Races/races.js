import React, {Component} from "react";
import RacesService from "../../service/racesAxios";
import Table from "../Table/table";
import {Switch, Route, Link, Redirect} from "react-router-dom";
import EditRace from "./EditRace/editRace";
import DetailsRace from "./DetailsRace/detailsRace";
import AddRace from "./AddRace/addRace";
import ShowRaces from "./ShowRaces/showRaces";

class Races extends Component{

    constructor(props) {
        super(props);

        this.state = {
            races: []
        };

    }

    render() {
        return (
            <div className={"container"}>
                <Switch>
                    <Route path={`${this.props.match.path}`} exact>
                        <ShowRaces races={this.state.races}
                                      deleteAction={this.deleteRace}
                                      {...this.props}/>
                    </Route>
                    <Route path={`${this.props.match.path}/:id/edit`} exact>
                        <EditRace updateRace={this.updateRace}/>
                    </Route>
                    <Route path={`${this.props.match.path}/:id/details`} exact>
                        <DetailsRace/>
                    </Route>
                    <Route path={`${this.props.match.path}/new`} exact>
                        <AddRace addRaces={this.addRace}/>
                    </Route>
                    <Redirect to={"/"}/>
                </Switch>
            </div>
        );
    }

    componentDidMount() {
        RacesService.getAllRaces()
            .then((response) => {
                let data = response.data;
                this.setState({
                    races: data
                });
            });
    }

    updateRace = (race) => {
        RacesService.updateRace(race)
            .then((response) => {
                let data = response.data;
                this.setState(oldState => {
                    let newRaces = oldState.races.map((item) => {
                        if(item.id === race.id)
                            return data;
                        return item;
                    });
                    return {
                        races: newRaces
                    }
                }, () => this.props.history.push("/races"));
            })
            .catch((error) => {
                this.props.handleError(error, this.props.history);
            });
    };

    deleteRace = (id) => {
        RacesService.deleteRace(id)
            .then(() => {
                this.setState((oldState) => {
                    let newRaces = oldState.races.filter((item) => {
                        return item.id !== id;
                    });
                    return {
                        races: newRaces
                    }
                });
            })
            .catch((error) => {
                this.props.handleError(error, this.props.history);
            });
    };

    addRace = (race) => {
        RacesService.addRace(race)
            .then((response) => {
                debugger;
                let item = response.data;
                this.setState((oldState) => {
                    return {
                        races: [...oldState.races, item]
                    }
                }, () => this.props.history.push("/races"));
            })
            .catch((error) => {
                this.props.handleError(error, this.props.history);
            });
    };

}

export default Races;