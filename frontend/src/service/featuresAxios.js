import axios from '../custom-axios/axios';
import qs from 'qs';

const FeaturesService = {

    getAllFeatures: () => {
        return axios.get("/features/all");
    },

    updateFeature: (feature) => {
        let id = feature.id;
        let formParams = qs.stringify(feature);
        return axios.patch(`/features/${id}`, formParams);
    },

    getFeature: (id) => {
        return axios.get(`/features/${id}`);
    },

    deleteFeature: (id) => {
        return axios.delete(`/features/${id}`);
    },

    addFeature: (feature) => {
        let formParams = qs.stringify(feature);
        return axios.post("/features", formParams);
    }

};

export default FeaturesService;