const SET_USERNAME = "SET_USERNAME",
    SET_EMAIL = "SET_EMAIL",
    SET_PASSWORD = "SET_PASSWORD"

const initialState = {
    username: "",
    email: "",
    password: "",
};

const registerReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_USERNAME: {
            return {
                ...state,
                username: action.username,
            };
        }
        case SET_EMAIL: {
            return {
                ...state,
                email: action.email,
            };
        }
        case SET_PASSWORD: {
            return {
                ...state,
                password: action.password,
            };
        }
        default:
            return state;
    }
};

export const setUsername = (username) => ({
    type: SET_USERNAME,
    username,
});

export const setPassword = (password) => ({
    type: SET_PASSWORD,
    password,
});
export const setEmail = (email) => ({
    type: SET_EMAIL,
    email,
});

export default registerReducer;