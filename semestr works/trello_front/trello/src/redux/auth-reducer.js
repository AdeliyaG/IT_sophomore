const SET_USER_DATA = "SET_USER_DATA",
    SET_LOGIN_USERNAME = "SET_LOGIN_USERNAME",
    SET_LOGIN_PASSWORD = "SET_LOGIN_PASSWORD";

const initialState = {
    id: null,
    username: null,
    email: null,
    role: null,
    loginUsername: "",
    loginPassword: "",
    isError: false,
    error: null,
    successMessage: null,
};

const authReducer = (state = initialState, action) => {
    switch (action.type) {
        case SET_USER_DATA: {
            return {
                ...state,
                ...action.userData,
            };
        }
        case SET_LOGIN_USERNAME: {
            return {
                ...state,
                loginUsername: action.loginUsername,
            };
        }
        case SET_LOGIN_PASSWORD: {
            return {
                ...state,
                loginPassword: action.loginPassword,
            };
        }
        default: {
            return {
                ...state,
            };
        }
    }
};

export const setUserData = (id, username, email, role) => ({
    type: SET_USER_DATA,
    userData: {
        id,
        username,
        email,
        role,
    },
});
export const setLoginUsername = (username) => ({
    type: SET_LOGIN_USERNAME,
    username,
});
export const setLoginPassword = (password) => ({
    type: SET_LOGIN_PASSWORD,
    password,
});

export default authReducer;