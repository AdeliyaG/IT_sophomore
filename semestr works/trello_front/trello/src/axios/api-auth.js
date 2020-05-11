import axios from "axios";

export default axios.create({
    baseURL: "/api/trello",
    responseType: "json",
    headers: {
        Authorization: sessionStorage.getItem("token") !== null
            ? sessionStorage.getItem("token")
            : "",
    },
});