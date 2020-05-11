import React, {useState} from 'react';


const styles = {
    input: {
        marginRight: "5px",
    }

};

export default function BoardParticipantAdd({addParticipants}) {

    const [email, setEmail] = useState('');

    function submitHandler(event) {
        if (email.trim()) {
            addParticipants(email);
        }
        event.preventDefault();
        setEmail('')
    }

    return (
        <div className="row form-inline justify-content-center pb-3">
                <form onSubmit={submitHandler}>
                    <input onChange={event => setEmail(event.target.value)} value={email} className="form-control" name="email" type="email" placeholder="Email" style={styles.input}/>
                    <button className="btn btn-primary" type="submit">Добавить</button>
                </form>
        </div>
    )
}