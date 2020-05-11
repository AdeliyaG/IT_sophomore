import React, {useState} from 'react';
import UserItem from "./UserItem";
import NavbarAdmin from "./NavbarAdmin";

const style = {};

export default function UserList() {
    const [users, setUsers] = useState([
        {id: 1, username: "user1", email: "user1@mail.ru"},
        {id: 2, username: "user2", email: "user2@mail.ru"}
    ]);

    function deleteUser(id) {
        setUsers(users.filter(user => user.id !== id));
    }

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