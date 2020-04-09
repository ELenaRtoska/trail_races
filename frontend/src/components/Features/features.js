import React, {Component} from "react";
import FeaturesService from "../../service/featuresAxios";
import Table from "../Table/table";
import {Switch, Route, Link, Redirect} from "react-router-dom";
import EditFeature from "./EditFeature/editFeature";
import DetailsFeature from "./DetailsFeature/detailsFeature";
import AddFeature from "./AddFeature/addFeature";
import ShowFeatures from "./ShowFeatures/showFeatures";

class Features extends Component{

    constructor(props) {
        super(props);

        this.state = {
            features: []
        };

    }

    render() {
        return (
            <div className={"container"}>
                <Switch>
                    <Route path={`${this.props.match.path}`} exact>
                        <ShowFeatures features={this.state.features}
                                         deleteAction={this.deleteFeature}
                                         {...this.props}/>
                    </Route>
                    <Route path={`${this.props.match.path}/:id/edit`} exact>
                        <EditFeature updateFeature={this.updateFeature}/>
                    </Route>
                    <Route path={`${this.props.match.path}/:id/details`} exact>
                        <DetailsFeature/>
                    </Route>
                    <Route path={`${this.props.match.path}/new`} exact>
                        <AddFeature addFeatures={this.addFeature}/>
                    </Route>
                    <Redirect to={"/"}/>
                </Switch>
            </div>
        );
    }

    componentDidMount() {
        FeaturesService.getAllFeatures()
            .then((response) => {
                let data = response.data;
                this.setState({
                    features: data
                });
            });
    }

    updateFeature = (feature) => {
        FeaturesService.updateFeature(feature)
            .then((response) => {
                let data = response.data;
                this.setState(oldState => {
                    let newFeatures = oldState.features.map((item) => {
                        if(item.id === feature.id)
                            return data;
                        return item;
                    });
                    return {
                        features: newFeatures
                    }
                }, () => this.props.history.push("/features"));
            })
            .catch((error) => {
                this.props.handleError(error, this.props.history);
            });
    };

    deleteFeature = (id) => {
        FeaturesService.deleteFeature(id)
            .then(() => {
                this.setState((oldState) => {
                    let newFeatures = oldState.features.filter((item) => {
                        return item.id !== id;
                    });
                    return {
                        features: newFeatures
                    }
                });
            })
            .catch((error) => {
                this.props.handleError(error, this.props.history);
            });
    };

    addFeature = (feature) => {
        FeaturesService.addFeature(feature)
            .then((response) => {
                debugger;
                let item = response.data;
                this.setState((oldState) => {
                    return {
                        features: [...oldState.features, item]
                    }
                }, () => this.props.history.push("/features"));
            })
            .catch((error) => {
                this.props.handleError(error, this.props.history);
            });
    };

}

export default Features;