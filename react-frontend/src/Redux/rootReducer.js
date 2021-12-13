import userReducer from "./User/register/userReducer";
import authReducer from "./User/auth/authReducer";
import { combineReducers } from "redux";
import storage from "redux-persist/lib/storage";
import { persistReducer } from "redux-persist";

const persistConfig = {
  key: "root",
  storage,
  whitelist: ["auth"],
};

const rootReducer = combineReducers({
  user: userReducer,
  auth: authReducer,
});

export default persistReducer(persistConfig, rootReducer);
