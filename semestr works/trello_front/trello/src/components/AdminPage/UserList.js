import React, {useEffect, useState} from 'react';
import UserItem from "./UserItem";
import NavbarAdmin from "./NavbarAdmin";
import api from "../../axios/api-auth";
import {Redirect} from "react-router-dom";

const style = {};

export default function UserList() {
    const [users, setUsers] = useState([]);

    useEffect(() => {  //todo why doesnt work?
        api.get("/admin")
            .then((response) => {
                if (response.status === 200) {
                    setUsers(response.data)
                } else {
                    window.location = "/"
                }
            })
    }, []);

    function deleteUser(id) {
        setUsers(users.filter(user => user.id !== id));
    }

    if (localStorage.getItem("role") === null) {
        return <Redirect from="/admin" to="/"/>
    } else if (localStorage.getItem("role") === "ADMIN" && localStorage.getItem("token") !== null) {
        return (
            <div>
                <NavbarAdmin/>
                <div className="text-center">
                    <table className="table table-hover">
                        <thead className="thead-light">
                        <tr>
                            <th scope="col">ID</th>
                            <th scope="col">Username</th>
                            <th scope="col">Email</th>
                            <th scope="col">Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        {users.map(user => {
                            return <UserItem user={user} key={user.id} deleteButtonHandler={deleteUser}/>
                        })}
                        </tbody>
                    </table>
                </div>
            </div>
        )
    }
}