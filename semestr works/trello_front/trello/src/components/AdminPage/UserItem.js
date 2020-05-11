import React from 'react';

export default function UserItem({user, deleteButtonHandler}) {
    return (
        <tr>
            <td><b>{user.id}</b></td>
            <td>{user.username}</td>
            <td>{user.email}</td>
            <td>
                <button className="btn btn-outline-danger btn-sm" type="submit" onClick={() => deleteButtonHandler(user.id)}>Удалить</button>
            </td>
        </tr>
    )
}