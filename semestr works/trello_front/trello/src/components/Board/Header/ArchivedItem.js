import React from 'react';

export default function ArchivedItem({item, deleteButtonHandler}) {
    return (
        <tr>
            <td>{item.itemTitle}</td>
            <td className="text-info">Карточка: {item.card}</td>
            <td>
                <button className="btn btn-outline-primary btn-sm" type="submit" onClick={() => deleteButtonHandler(item.id)}>Разархивировать</button>
            </td>
        </tr>
    )
}