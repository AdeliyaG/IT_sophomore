import React, {useContext, useState} from 'react';
import Context from '../context';


const styles = {
    button: {
        // marginBottom: "0px"
    },

    td: {
        textAlignLast: "end"
    },

    input: {
        margin: 0,
    }
}

export default function EditNote({note}) {

    const { saveEditNote } = useContext(Context);
    const [name, setName] = useState(note.name);
    const [number, setNumber] = useState(note.number);

    return (
        <tr>
            <td><input type="text" value={name} style={styles.input} onChange={event => setName(event.target.value)}/></td>
            <td><input type="text" pattern="[0-9]*" value={number} style={styles.input} onChange={event => setNumber(event.target.value)}/></td>
            <td style={styles.td} >
               <button className="button-primary" style={styles.button} onClick={() => saveEditNote(note.id, name, number)}>save</button>
            </td>
        </tr>
    )
}