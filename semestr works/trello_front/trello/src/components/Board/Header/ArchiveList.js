import React from 'react';
import ArchivedItem from "./ArchivedItem";

export default function ArchiveList({archive, deleteArchivedItem}) {

    return (
        <div>
            <div className="text-center">
                <table className="table table-borderless">
                    <tbody>
                    {archive.map(item => {
                        return <ArchivedItem item={item} key={item.id} />
                    })}
                    </tbody>
                </table>
            </div>
        </div>
    )
}