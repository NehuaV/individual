import { LOGIN_REQUEST,LOGOUT_REQUEST,SUCCESS,FAILURE } from "./authTypes";
import axios from "axios";

const AUTH_URL = "http://localhost:8080/user/authenticate";

export const authenticateUser = (email, password) => async (dispatch) => {
  dispatch(loginRequest());
  try {
    const response = await axios.post(AUTH_URL, {
      email: email,
      password: password,
    });
    localStorage.setItem("jwtToken", response.data.token);
    dispatch(success({ username: response.data.name, isLoggedIn: true }));
    return Promise.resolve(response.data);
  } catch (error) {
    dispatch(failure());
    return Promise.reject(error);
  }
};

export const logoutUser = () => {
  return (dispatch) => {
    dispatch(logoutRequest());
    localStorage.removeItem("jwtToken");
    dispatch(success({ username: "", isLoggedIn: false }));
  };
};

const loginRequest = () => {
  return {
    type: LOGIN_REQUEST,
  };
};

const logoutRequest = () => {
  return {
    type: LOGOUT_REQUEST,
  };
};

const success = (isLoggedIn) => {
  return {
    type: SUCCESS,
    payload: isLoggedIn,
  };
};

const failure = () => {
  return {
    type: FAILURE,
    payload: false,
  };
};