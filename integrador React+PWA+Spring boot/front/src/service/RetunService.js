import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class ReturnService {

    getReturn() {
        return axios.get(API_URL + '/returns');
    }

    createReturn() {
        return axios.post(API_URL + '/return');
    }
}

export default new ReturnService();