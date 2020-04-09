import React, {useState} from 'react';
import {useHistory} from "react-router-dom";

const AddFeature = (props) => {

    let history = useHistory();
    let [feature, setFeature] = useState({
        name: '',
        amount: '',
        trail: false,
        trailRace: false
    });

    let handleInputChange = (e) => {
        let prop = e.target.name;
        let value;
        if(e.target.type === 'text')
            value = e.target.value;
        else
            value = e.target.checked;

        setFeature({
            ...feature,
            [prop]: value
        });
    };

    let resetValues = (e) => {
        e.preventDefault();
        setFeature({
            name: '',
            amount: '',
            trail: false,
            trailRace: false
        });
    };

    let cancelEdit = () => {
        history.push("/features");
    };

    let submitHandle = (e) => {
        e.preventDefault();
        props.addFeatures(feature);
    };

    return (
        <div className="row">
            <form className="card" onSubmit={submitHandle}>
                <h4 className="text-left">Add Feature</h4>
                <div className="form-group row">
                    <label htmlFor="feature" className="col-sm-4 offset-sm-1 text-left">Feature name</label>
                    <div className="col-sm-6">
                        <input type="text"
                               className="form-control"
                               name="name"
                               placeholder="Name"
                               value={feature.name}
                               onChange={handleInputChange}
                        />
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="amount" className="col-sm-4 offset-sm-1 text-left">Amount</label>
                    <div className="col-sm-6">
                        <input type="text"
                               className="form-control"
                               name="amount"
                               placeholder="Amount"
                               value={feature.amount}
                               onChange={handleInputChange}
                        />
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="trailRace" className="col-sm-4 offset-sm-1 text-left">TrailRace</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="checkbox"
                               className="form-control"
                               name="trailRace"
                               checked={feature.trailRace}
                               onChange={handleInputChange}
                        />
                    </div>
                </div>

                <div className="form-group row">
                    <label htmlFor="trail" className="col-sm-4 offset-sm-1 text-left">Trail</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="checkbox"
                               className="form-control"
                               name="trail"
                               checked={feature.trail}
                               onChange={handleInputChange}
                        />
                    </div>
                </div>

                <div className="form-group row">
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button
                            type="submit"
                            className="btn btn-primary text-upper"
                            disabled={feature.name === '' || feature.amount === '' ||  feature.name.length > 50 || feature.amount.length > 50}
                        >
                            Save
                        </button>
                    </div>
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button
                            className="btn btn-warning text-upper"
                            onClick={resetValues}>
                            Reset
                        </button>
                    </div>
                    <div
                        className="offset-sm-1 col-sm-3  text-center">
                        <button
                            className="btn btn-danger text-upper"
                            onClick={cancelEdit}
                        >
                            Cancel
                        </button>
                    </div>
                </div>
            </form>
        </div>
    );
};

export default AddFeature;