import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class LendingService {
    async createLending(userId, bookId) {
        return await axios.post(API_URL + '/lending/' + userId + '/' + bookId);
    }

    async getAllLendings() {
        return await axios.get(API_URL + '/reports');
    }

    async returnLending(id) {
        return await axios.delete(API_URL + '/return/' + id);
    }

    async downloadReport() {
        return await axios.get(API_URL + '/downloadReports');
    }

}

export default new LendingService();