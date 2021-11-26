import thunk from "redux-thunk";
import rootReducer from "./rootReducer";
import { createStore, applyMiddleware } from "redux";
import { composeWithDevTools } from "redux-devtools-extension";
import authToken from "./authToken";

import { persistStore } from "redux-persist";

// const store = createStore(rootReducer, applyMiddleware(thunk));

// Store plus dev tools for debugging
export const store = createStore(
  rootReducer,
  composeWithDevTools(
    applyMiddleware(thunk)
    // other store enhancers if any
  )
);
// sets default axios header if  jwt token available
if (localStorage.jwtToken) {
  authToken(localStorage.jwtToken);
}
// "Reapplies" the state after the applcation refreshes
export const persistor = persistStore(store);

export default { store, persistor };
