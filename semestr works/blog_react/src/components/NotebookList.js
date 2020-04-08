import React from 'react';
import NotebookItem from './NotebookItem';

const styles = {
    th: {
        textAlignLast: "end"
    }
};

export default function NotebookList({notes, deleteNoteReq}) {

    return(
        <table className="u-full-width">
            <thead>
            <tr>
                <th>Name</th>
                <th>Number</th>
                <th style={styles.th}>Edit / Delete</th>
            </tr>
            </thead>
            <tbody>

            {notes.map(note => {
                    return <NotebookItem note={note} key={note.id} deleteButtonHandler={deleteNoteReq}/>
                })}
            </tbody>
        </table>
    )
}