import React, {useContext, useState} from "react";
import Context from "../../context";

const style = {
    btn: {
        minWidth: 300 + "px"
    }
};

export default function AddCard({setClick}) {
    const {addNewCard} = useContext(Context);
    const [name, setName] = useState("");

    function clickHandler(name) {
        setClick();
        addNewCard(name);
        setName("")
    }

    return (
        <div className="row pt-1" style={style.btn}>
            <div className="col-9">
                <input type="text" className="form-control pr-0" value={name}
                       onChange={event => setName(event.target.value)} placeholder="Название"/>
            </div>
            <div className="col-3 pl-0">
                <button className="btn btn-outline-primary w-100 pl-0 pr-0"
                        onClick={() => clickHandler(name)}>
                    ✓
                </button>
            </div>
        </div>
    )
}