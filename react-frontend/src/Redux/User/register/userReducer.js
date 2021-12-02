import {
  FETCH_USER_REQUEST,
  FETCH_USER_SUCCESS,
  FETCH_USER_FAILURE,
  USER_SAVED_SUCCESS,
} from "./userTypes";

const initialState = {
  users: [],
  error: "",
};

const reducer = (state = initialState, action) => {
  switch (action.type) {
    case FETCH_USER_REQUEST:
      return {
        // Return copied state
        ...state,
      };
    case FETCH_USER_SUCCESS:
      return {
        users: action.payload,
        error: "",
      };
    case FETCH_USER_FAILURE:
      return {
        users: [],
        error: action.payload,
      };
    case USER_SAVED_SUCCESS:
      return {
        message: action.payload,
        error: "",
      };
    default:
      return state;
  }
};

export default reducer;
