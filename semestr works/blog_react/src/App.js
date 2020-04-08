import React, {useState} from 'react';
import './normalize.css';
import './skeleton.css';
import './index.css';

import NotebookList from './components/NotebookList';
import NoteAdd from './components/NoteAdd';
import SearchNote from "./components/SearchNote";

import Context from './context';


function App() {

    const [notes, setNotes] = useState([
        {id: 1, name: "Ma dude", number: 123, editStatus: false},
        {id: 2, name: "Just dude", number: 333, editStatus: false},
        {id: 3, name: "Some cool dude", number: 777, editStatus: false}
    ]);

    function addNote(name, number) {
        let id = Date.now();
        let elem = {
            id: id,
            name: name,
            number: number,
            editStatus: false
        };
        setNotes(notes.concat([elem]));
        setIsUserSearching(false)
    }

    const [searchedNotes, setSearchedNotes] = useState(notes);
    const [isUserSearching, setIsUserSearching] = useState(false);

    function searchNote(searchName) {
        if (searchName.trim()) {
            setSearchedNotes(notes);
            setSearchedNotes(notes.filter(note => note.name.toLowerCase().includes(searchName)));
            setIsUserSearching(true)
        } else {
            setIsUserSearching(false)
        }
    }

    function deleteNote(id) {
        setNotes(notes.filter(note => note.id !== id));
        setSearchedNotes(searchedNotes.filter(note => note.id !== id));
    }

    function editNote(id) {
        setNotes(notes.map(note => {
            if (note.id === id) {
                note.editStatus = !note.editStatus;
            }
            return note;
        }))
    }
    
    function saveEditNote(id, newName, newNumber) {
        setNotes(notes.map(note => {
            if (note.id === id) {
                note.editStatus = !note.editStatus;
                note.name = newName;
                note.number = newNumber;
            }
            return note;
        }))
    }

    return (
        <Context.Provider value={{ editNote, saveEditNote }}>
        <div>
            <div className="row block">
                <div className="six column">
                    <NoteAdd addNote={addNote}/>
                </div>
                <div className="six column">
                    <SearchNote searchNote={searchNote}/>
                </div>
            </div>
            <div className='container'>
                {isUserSearching ? (
                    <NotebookList notes={searchedNotes} deleteNoteReq={deleteNote}/>
                ) : (
                    <NotebookList notes={notes} deleteNoteReq={deleteNote}/>
                )
                }
            </div>
        </div>
        </Context.Provider>
    );
}

export default App;
