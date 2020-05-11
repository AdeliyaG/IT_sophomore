import axios from "axios";

const setToken = (token) => {
    sessionStorage.setItem("token", token);
};

export default axios.create({
    baseURL: "/api/trello",
    responseType: "json",
});