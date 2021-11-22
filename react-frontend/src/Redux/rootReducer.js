
import userReducer from './User/userReducer'
import authReducer from './User/auth/authReducer'
import { combineReducers } from "redux";

const rootReducer = combineReducers({
    user:userReducer,
    auth:authReducer
});

export default rootReducer;