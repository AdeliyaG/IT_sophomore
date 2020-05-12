import React from 'react';

export default function ArchivedItem({item, deleteButtonHandler}) {
    return (
        <tr>
            <td className="text-info">Карточка:</td>
            <td>{item.title}</td>
            <td>
                <button className="btn btn-outline-primary btn-sm" type="submit" onClick={() => deleteButtonHandler(item.id)}>Разархивировать</button>
            </td>
        </tr>
    )
}