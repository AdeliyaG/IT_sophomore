import React, {useContext, useState} from 'react';
import Context from "../../context";

export default function AddItem({setClick}) {
    const { saveItem } = useContext(Context);
    const [name, setName] = useState("");

    function clickHandler(name) {
        setClick();
        saveItem(name);
        setName("")
    }

    return (
        <div className="card-footer">
            <div className="row pt-0">
                <div className="col-9">
                    <input type="text" className="form-control pr-0" value={name}
                           onChange={event => setName(event.target.value)} placeholder="Название"/>
                </div>
                <div className="col-3 pl-0">
                    <button className="btn btn-light w-100 text-muted pl-0 pr-0" onClick={() => clickHandler(name)}>✓
                    </button>
                </div>
            </div>
        </div>
    )
}