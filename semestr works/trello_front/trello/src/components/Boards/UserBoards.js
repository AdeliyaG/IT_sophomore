import React, {useState, useEffect} from 'react';
import Navbar from "../NavbarAuth/Navbar";
import BoardListItem from "./BoardListItem";
import api from "../../axios/api-auth";

const style = {
    bg: {
        backgroundImage: "url(" + "https://images.pexels.com/photos/3773413/pexels-photo-3773413.jpeg?auto=compress&cs=tinysrgb&dpr=2&h=650&w=940" + ")",
        backgroundPosition: 'center',
        backgroundSize: 'cover',
        backgroundRepeat: 'no-repeat',
        height: 509,
        // height: 100+"%"
    },
};

export default function UserList() {
    const [boards, setBoards] = useState([]);

    useEffect(() =>{
        api.get("/").then((response) => {
            setBoards(response.data)
        });


    }, []);


    function deleteBoard(id) {
        setBoards(boards.filter(board => board.id !== id));
    }

    return (
        <div>
            <Navbar/>
            <div className="text-center" style={style.bg}>
                <table className="table table-hover table-borderless container">
                    <thead className="thead-dark">
                    <tr>
                        <th scope="col">Доска</th>
                        <th scope="col">Удалить</th>
                    </tr>
                    </thead>
                    <tbody>
                    {boards.map(board => {
                        return <BoardListItem board={board} key={board.id} deleteButtonHandler={deleteBoard}/>
                    })}
                    </tbody>
                </table>
            </div>
        </div>

    )
}