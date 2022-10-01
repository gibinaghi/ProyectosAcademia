import {
    GET_CHARACTERS_ERROR,    
    GET_CHARACTERS_SUCCESS,
} from '../types/actionType';


const initialState = {
    characters: [],
    error: null,
};

const charactersData = (state = initialState, action) => {
        switch (action.type) {
        case GET_CHARACTERS_SUCCESS:
            return {
            ...state,
            characters: action.payload,
            };      
        case GET_CHARACTERS_ERROR:
            return {
            ...state,
            error: action.payload,
            };
        default:
            return state;
        }
    };
export default charactersData;