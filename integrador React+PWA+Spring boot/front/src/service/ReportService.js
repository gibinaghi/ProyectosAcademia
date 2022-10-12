import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class ReportService {

    getReport() {
        return axios.get(API_URL + '/reports');
    }

    //exportar excel
}

export default new ReportService();