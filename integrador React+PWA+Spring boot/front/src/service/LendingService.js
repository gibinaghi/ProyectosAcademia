import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class LendingService {
    async createLendingNew(userId, bookId) {
        return await axios({
            method: 'POST',
            url: API_URL + '/lending',
            params: {
                userId: `${userId}`,	
                bookId: `${bookId}`
            },
            headers: {
                'Content-Type': 'application/json'
            }
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