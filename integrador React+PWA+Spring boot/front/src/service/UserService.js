import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class UserService {
    async getAllUsers() {
        return await axios.get(API_URL + '/users');
    }

    async createUser(userCreate) {
        return await axios.post(API_URL + '/user', userCreate);
    }

    async updateUser(id) {
        return await axios.put(API_URL + '/user/' + id);
    }

    async deleteUser(id) {
        return await axios.delete(API_URL + '/user/' + id);
    }

    async searchUser(name) {
        return await axios.get(API_URL + '/user/' + name);
    }
}

export default new UserService();


