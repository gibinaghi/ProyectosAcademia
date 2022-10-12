import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class UserService {
    getAllUsers() {
        return axios.get(API_URL + '/users').then(response => {
            console.log(response);
        });
    }

    createUser() {
        return axios.post(API_URL + '/user');
    }

    updateUser(id) {
        return axios.put(API_URL + '/user/' + id);
    }

    deleteUser(id) {
        return axios.delete(API_URL + '/user/' + id);
    }

    searchUser(name) {
        return axios.get(API_URL + '/user/' + name);
    }
}

export default new UserService();


