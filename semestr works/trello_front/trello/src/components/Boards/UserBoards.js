import React, {useState, useEffect} from 'react';
import Navbar from "../NavbarAuth/Navbar";
import BoardListItem from "./BoardListItem";
import api from "../../axios/api-auth";
import {Redirect} from "react-router-dom";

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

    useEffect(() => {
        api.get("/").then((response) => {
            setBoards(response.data);
        });
    }, [boards]);


    function deleteBoard(id) {
        api.delete("/board=" + id + "/delete")
            .then((response) => {
            if (response.status !== 200) {
                alert("Bad response")
            }
        })
    }

    if (localStorage.getItem("token") === null) {
        return <Redirect from="/" to="/signIn"/>
    } else if (localStorage.getItem("token") !== null) {
        return (
            <div>
                <Navbar user={localStorage.getItem("currentUser")} boards={boards}/>
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
}