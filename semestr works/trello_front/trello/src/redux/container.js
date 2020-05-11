import React from "react";
import SignUp from "../components/SignUp/SignUp";
import SignIn from "../components/SignIn/SignIn";
import UserList from "../components/AdminPage/UserList";
import Board from "../components/Board/Board";
import Route from "react-router-dom/es/Route";
import {Redirect} from "react-router-dom";



//хз, нужно ли
const Container = (props) => {
    const privateRoutesData = [
        {
            path: "/admin",
            isExact: true,
            render: () => <UserList/>,
        },
        {
            path: "/board/:boardId",
            isExact: true,
            render: () => <Board/>,
        },
    ];

    const privateRoutesComponents = () => {
        return (
            (sessionStorage.getItem("token") !== null) ?
                privateRoutesData.map((elem) => (
                    <Route
                        key={elem.path}
                        path={elem.path}
                        exact={elem.isExact}
                        component={elem.component || elem.render}
                    />)
                ) : (
                    <Redirect to="/signIn"/>)
        )
    }

};


export default Container;