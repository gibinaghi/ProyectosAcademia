import axios from "axios";
import {
  GET_CHARACTERS_ERROR,
  GET_CHARACTERS_SUCCESS, 
  LOGIN, 
} from "../types/actionType";

export const getCharactersSuccess = (characters) => {
  return {
    type: GET_CHARACTERS_SUCCESS,
    payload: characters,
  };
};

export const getCharactersError = (error) => {
  return {
    type: GET_CHARACTERS_ERROR,
    payload: error,
  };
};

export function login () {
  return function (dispatch){
  return dispatch({
      type: LOGIN,
      payload: true
  })
}
}

export const getCharacters = () => async (dispatch) => {
  try {
    const response = await axios.get(process.env.REACT_APP_BASEURL); //llama al env
    dispatch({
      type: GET_CHARACTERS_SUCCESS,
      payload: response.data.results,
    });
  } catch (error) {
    dispatch({
      type: GET_CHARACTERS_ERROR,
      payload: error,
    });
  }

};