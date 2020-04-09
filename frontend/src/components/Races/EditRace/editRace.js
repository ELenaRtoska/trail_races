import React, {useEffect, useState} from 'react';
import {useParams, useHistory} from "react-router-dom";
import RacesService from "../../../service/racesAxios";

const EditRace = (props) => {

    let {id} = useParams();
    let history = useHistory();
    let [race, setRace] = useState({
        type: '',
        description: '',
        features: [],
        trailRace: false
    });

    useEffect(() => {
        RacesService.getRace(id).then((response) => {
            setRace(response.data);
        });
    }, []);

    let handleInputChange = (e) => {
        let prop = e.target.type;
        let value;
        if(e.target.type === 'text')
            value = e.target.value;
        else
            value = e.target.checked;

        setRace({
            ...race,
            [prop]: value
        });
    };

    let resetValues = (e) => {
        e.preventDefault();
        setRace({
            type: '',
            description: '',
            features: [],
            trailRace: false
        });
    };

    let cancelEdit = () => {
        history.push("/races");
    };

    let submitHandle = (e) => {
        e.preventDefault();
        props.updateRace(race);
    };

    return (
        <div className="row">
            <form className="card" onSubmit={submitHandle}>
                <h4 className="text-left">Edit Race</h4>
                <div className="form-group row">
                    <label htmlFor="race" className="col-sm-4 offset-sm-1 text-left">Race name</label>
                    <div className="col-sm-6">
                        <input type="text"
                               className="form-control"
                               name="type"
                               placeholder="Type"
                               value={race.type}
                               onChange={handleInputChange}
                        />
                    </div>
                </div>
                <div className="form-group row">
                    <label htmlFor="description" className="col-sm-4 offset-sm-1 text-left">Description</label>
                    <div className="col-sm-6">
                        <input type="text"
                               className="form-control"
                               name="description"
                               placeholder="Description"
                               value={race.description}
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
                               checked={race.trailRace}
                               onChange={handleInputChange}
                        />
                    </div>
                </div>

                <div className="form-group row">
                    <label htmlFor="features" className="col-sm-4 offset-sm-1 text-left">Features</label>
                    <div className="col-sm-6 col-xl-4">
                        <input type="text"
                               className="form-control"
                               name="features"
                               placeholder="Features"
                               value={race.features}
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
                            disabled={race.type === '' || race.description === '' ||  race.type.length > 50 || race.description.length > 50}
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

export default EditRace;