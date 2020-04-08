import React, {useState} from 'react';

const styles = {
    input: {
        marginRight: "5px",
    }
}

export default function SearchNote({searchNote}) {

    const [searchName, setSearchName] = useState('');

    function submitHandler(event) {
        searchNote(searchName);
        event.preventDefault();
    }

    return (
        <div className="row inputBlock">
            <div className="nine column">
                <form onSubmit={submitHandler}>
                    <input value={searchName} type="text" placeholder="Search" style={styles.input}
                           onChange={event => setSearchName(event.target.value)}/>
                    <button className="button-primary" type="submit">search</button>
                </form>
            </div>
        </div>
    )
}