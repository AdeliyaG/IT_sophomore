import {combineReducers, createStore} from "redux";
import registerReducer from "./register-reducer";
import authReducer from "./auth-reducer";

let reducers = combineReducers({
    signUp: registerReducer,
    signIn: authReducer,
});

let store = createStore(reducers);

export default store;