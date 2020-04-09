import React from 'react';
import {Link} from "react-router-dom";
import Table from "../../Table/table";

const ShowFeatures = (props) => {
    let tableItems = props.features.length === 0 ?
        <h1>There are no features!</h1> :
        <Table items={props.features} {...props}/>;
    return (
        <div className={"container"}>
            <div className="row">
                <h4 className="text-upper text-left">Features</h4>
                <div>
                    <b>
                        <i>
                            <br />
                            <br />
                    On this page you can see all the possible features of the trail races

                            <br />
                    You can change something if you don't think it's right

                            <br />
                    You can delete a feature if you don't think it's a trail race feature

                            <br />
                            In the field "Motivation" you have a message to motivate yourself!
                            <br />
                            Also you can add some new feature in the next table of trail race features.

                        </i>
                        </b>

                </div>
                <br />
                <br />
                <div className="table-responsive">
                    <br />
                    <br />
                    {tableItems}
                </div>
                <Link className="btn btn-outline-secondary" to={`${props.match.url}/new`}>
                    <span><strong>Add new feature</strong></span>
                </Link>
                <br />
            </div>
            <br />
        </div>
    );
};

export default ShowFeatures;