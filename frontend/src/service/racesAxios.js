import axios from '../custom-axios/axios';
import qs from 'qs';

const RacesService = {

    getAllRaces: () => {
        return axios.get("/races/all");
    },

    updateRace: (race) => {
        let id = race.id;
        let formParams = qs.stringify(race);
        return axios.patch(`/races/${id}`, formParams);
    },

    getRace: (id) => {
        return axios.get(`/races/${id}`);
    },

    deleteRace: (id) => {
        return axios.delete(`/races/${id}`);
    },

    addRace: (race) => {
        let formParams = qs.stringify(race);
        return axios.post("/races", formParams);
    }

};

export default RacesService;