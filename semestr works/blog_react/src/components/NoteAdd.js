import React, {useState} from 'react';


const styles = {
    input: {
        marginRight: "5px",
    }

};

export default function NoteAdd({addNote}) {

    const [name, setName] = useState('');
    const [number, setNumber] = useState('');

    function submitHandler(event) {
        if (name.trim() && number.trim()) {
            addNote(name, number);
        } else {
            {alert("Some of your data is empty. Try again")}
        }
        event.preventDefault();
        setName('');
        setNumber('')
    }

    return (
        <div className="row inputBlock">
            <div className="nine column">
                <form onSubmit={submitHandler}>
                    <input value={name} name="name" type="text" placeholder="Name" style={styles.input}
                           onChange={event => setName(event.target.value)}/>
                    <input value={number} name="number" type="text" pattern="[0-9]*" placeholder="Number" style={styles.input}
                           onChange={event => setNumber(event.target.value)}/>
                    <button className="button-primary" type="submit">save</button>
                </form>
            </div>
        </div>
    )
}