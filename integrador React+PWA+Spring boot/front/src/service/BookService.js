import axios from 'axios';

const API_URL = process.env.REACT_APP_APPIS_DEFAULT_URL;

class BookService {
    getAllBooks() {
        return axios.get(API_URL + '/books');
    }

    createBook(bookCreate) {
        return axios.post(API_URL + '/book', bookCreate);
    }

    updateBook(id) {
        return axios.put(API_URL + '/book/' + id);
    }

    deleteBook(id) {
        return axios.delete(API_URL + '/book/' + id);
    }

    searchBook(title) {
        return axios.get(API_URL + '/book/' + title);
    }
}

export default new BookService();
