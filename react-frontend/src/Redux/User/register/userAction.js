import {
  FETCH_USER_REQUEST,
  FETCH_USER_FAILURE,
  USER_SAVED_SUCCESS,
} from "./userTypes";
import axios from "axios";

const REGISTER_URL = "http://localhost:8080/user/register";

export const registerUser = (userObject) => async (dispatch) => {
  dispatch(fetchUserRequest());
  try {
    const response = await axios.post(REGISTER_URL, userObject);
    dispatch(userSavedSuccess(response.data));
    return Promise.resolve(response.data);
  } catch (error) {
    dispatch(fetchUserFailure(error.message));
    return Promise.reject(error);
  }
};

const userSavedSuccess = (user) => {
  return {
    type: USER_SAVED_SUCCESS,
    payload: user,
  };
};

const fetchUserRequest = () => {
  return {
    type: FETCH_USER_REQUEST,
  };
};

const fetchUserFailure = (error) => {
  return {
    type: FETCH_USER_FAILURE,
    payload: error,
  };
};
