import axios from "axios";

export default axios.create({
    baseURL: "/api/trello",
    responseType: "json",
    headers: {
        Authorization: localStorage.getItem("token") !== null
            ? localStorage.getItem("token")
            : "",
    },
});