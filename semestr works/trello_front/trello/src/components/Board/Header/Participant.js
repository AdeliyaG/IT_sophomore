import React, {useContext} from 'react';
import Context from "../../../context";

export default function Participant({participant}) {
    const {deleteParticipants} = useContext(Context);

    function deleteButtonHandler(username) {
        deleteParticipants(username)
    }

    return (
        <tr>
            <td>{participant.username}</td>
            <td>{participant.email}</td>
            <td>
                <button className="btn btn-outline-primary btn-sm" type="submit"
                        onClick={() => deleteButtonHandler(participant.username)}>
                    Удалить
                </button>
            </td>
        </tr>
    )
}