import React, {useState} from 'react';
import BoardListButton from "./BoardListButton";
import AddBoardButton from "./AddBoardButton";
import BoardsButton from "./BoardsButton";

const style = {
    nav: {
        backgroundColor: "rgba(37,35,37,0.95)"
    }
};

export default function Navbar({user, boards}) {

    return (
        <div>
            <nav className="navbar navbar-light" style={style.nav}>
                <div className="row">
                    <BoardsButton/>

                    <div className="dropdown-menu p-2 ml-3 w-25">
                        <div className="list-group">
                            <h6 className="text-center">Доступные доски</h6>

                            {boards.map((board) =>
                                <BoardListButton board={board} key={board.id}/>)}

                        </div>
                    </div>

                    <AddBoardButton/>

                </div>
                <div className="dropdown">
                    <button className="btn btn-primary" type="button" id="dropdownMenuButton"
                            data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                        {user}
                    </button>
                    <div className="dropdown-menu dropdown-menu-right mt-2" aria-labelledby="navbarDropdown">
                        <a className="dropdown-item" href="/">Список досок</a>
                        <div className="dropdown-divider"></div>
                        <a className="dropdown-item" href="/logout" onClick={()=> localStorage.clear()}>Выйти</a>
                    </div>
                </div>
            </nav>
        </div>
    )
}