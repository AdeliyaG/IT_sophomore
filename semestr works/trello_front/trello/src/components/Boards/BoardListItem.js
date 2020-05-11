import React from 'react';

export default function BoardListItem({board, deleteButtonHandler}) {
    return (
        <tr className="">
            <td className=""><a className="text-dark text-uppercase font-weight-bolder" href="/board/:boardID">{board.name}</a></td>
            <td>
                <button className="btn btn-outline-danger" type="submit" onClick={() => deleteButtonHandler(board.id)}>Удалить</button>
            </td>
        </tr>
    )
}