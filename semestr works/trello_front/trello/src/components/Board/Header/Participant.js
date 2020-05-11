import React from 'react';

export default function Participant({participant, deleteButtonHandler}) {
    return (
        <tr>
            <td>{participant.username}</td>
            <td>{participant.email}</td>
            <td>
                <button className="btn btn-outline-primary btn-sm" type="submit" onClick={() => deleteButtonHandler(participant.id)}>Удалить</button>
            </td>
        </tr>
    )
}