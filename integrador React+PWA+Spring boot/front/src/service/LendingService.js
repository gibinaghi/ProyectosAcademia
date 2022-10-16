import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class LendingService {
    async createLending(userId, bookId) {
        return await axios({
            method: 'POST',
            url: `http://localhost:8080/api/lending/${userId}/${bookId}`
        });;
    }

    async getAllLendings() {
        return await axios({
            method: 'GET',
            url: API_URL + '/reports' 
        });
    }

    async returnLending(id) {
        return await axios.delete(API_URL + '/return/' + id);
    }

    async downloadReport() {
        return await axios({
            method: 'GET',
            url: 'http://localhost:8080/api/downloadReports', 
            responseType: 'blob'
        });
    }

}

export default new LendingService();