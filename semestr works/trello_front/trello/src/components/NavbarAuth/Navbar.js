import React, {useState} from 'react';
import BoardListButton from "./BoardListButton";
import AddBoardButton from "./AddBoardButton";
import BoardsButton from "./BoardsButton";

const style = {
    nav: {
        backgroundColor: "rgba(37,35,37,0.95)"
    }
};

export default function Navbar(props) {
    return (
        <div>
            <nav className="navbar navbar-light" style={style.nav}>
                <div className="row">
                    <BoardsButton/>

                    <div className="dropdown-menu p-2 ml-3 w-25">
                        <div className="list-group">
                            <h6 className="text-center">Доступные доски</h6>

                            <BoardListButton name={"Board #1"}/>
                            <BoardListButton name={"Board #2"}/>

                        </div>
                    </div>

                    <AddBoardButton/>

                </div>
                <div className="dropdown">
                    <button className="btn btn-primary" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        props.username
                    </button>
                    <div className="dropdown-menu dropdown-menu-right mt-2" aria-labelledby="navbarDropdown">
                        <a className="dropdown-item" href="/profile">Профиль</a>
                        <a className="dropdown-item" href="/myBoards">Список досок</a>
                        <div className="dropdown-divider"></div>
                        <a className="dropdown-item" href="/logout">Выйти</a>
                    </div>
                </div>
            </nav>
        </div>
    )
}