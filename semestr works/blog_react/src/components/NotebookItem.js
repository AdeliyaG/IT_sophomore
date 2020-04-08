import React, {useContext} from 'react';
import EditNote from "./EditNote";
import Context from '../context';

const styles = {
    button: {
        marginRight: "10px"
    },

    td: {
        textAlignLast: "end"

    }
}

export default function NotebookItem({note, deleteButtonHandler}) {
    const { editNote } = useContext(Context);

    if (note.editStatus) {
        return <EditNote note={note}/>
    } else {
        return (
            <tr>
                <td>{note.name}</td>
                <td>{note.number}</td>
                <td style={styles.td}>
                    <button className="button-primary" style={styles.button} onClick={() => editNote(note.id)}>edit</button>
                    <button className="button-primary" onClick={() => deleteButtonHandler(note.id)}>&times;</button>
                </td>
            </tr>
        )
    }
}