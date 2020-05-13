import React, {useContext, useState} from 'react';
import Context from "../../../context";


const styles = {
    input: {
        marginRight: "5px",
    }

};

export default function BoardParticipantAdd() {
    const {addParticipants} = useContext(Context);
    const [username, setUsername] = useState('');

    function submitHandler(event) {
        if (username.trim()) {
            addParticipants(username);
        }
        event.preventDefault();
        setUsername('')
    }

    return (
        <div className="row form-inline justify-content-center pb-3">
                <form onSubmit={submitHandler}>
                    <input onChange={event => setUsername(event.target.value)} value={username}
                           className="form-control" placeholder="Username"
                           style={styles.input}/>
                    <button className="btn btn-primary" type="submit">Добавить</button>
                </form>
        </div>
    )
}