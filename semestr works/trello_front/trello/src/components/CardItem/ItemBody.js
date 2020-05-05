import React, {useState} from 'react';
import ItemDescription from "./ItemDescription";
import ItemFileAdd from "./ItemFileAdd";
import ItemDeadline from "./ItemDeadline";
import CommentBlock from "../Comments/CommentBlock";
import ItemButtonList from "./ItemButtonList";
import Context from "../../context";

export default function ItemBody() {

    const [showFileAdd, setShowFileAdd] = React.useState(false);


    return (
        <Context.Provider value={{showFileAdd ,setShowFileAdd}}>
            <div className="modal-body">
                <div className="container-fluid row">
                    <div className="col-10">
                        <ItemDescription/>
                        <ItemDeadline/>
                        {showFileAdd ? <ItemFileAdd/> : null}
                        <CommentBlock/>
                    </div>
                    <div className="col-2">
                        <ItemButtonList/>
                    </div>
                </div>
            </div>
        </Context.Provider>
    )
}