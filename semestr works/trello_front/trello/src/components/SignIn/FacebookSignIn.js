import React, {Component, useState} from 'react';
import FacebookLogin from 'react-facebook-login';
import api from "../../axios/api-anon";

export default function FacebookSignIn({handleFacebook}) {
    const [user, setUser] = useState('');

    function responseFacebook(response) {
        console.log(response);
        if (response.status !== 'unknown') {
            let username =  response.name;

            api.post("/signInWithFacebook", {
                username: response.name,
                email: response.email,
                password: response.id
            }).then((response) => {
                localStorage.setItem("token", response.data.token);
                localStorage.setItem("currentUser", username);
                window.location = "/"
            });
        }
    }

    return (
        <FacebookLogin
            appId="276528506815326"
            autoLoad={false}
            fields="name,email,picture"
            callback={responseFacebook}
        />
    )
}
