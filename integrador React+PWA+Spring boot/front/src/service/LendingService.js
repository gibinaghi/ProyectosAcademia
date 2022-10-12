import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class LendingService {
    getAllLendings() {
        return axios.get(API_URL + '/lendings');
    }

    createLending() {
        return axios.post(API_URL + '/lending');
    }

}

export default new LendingService();