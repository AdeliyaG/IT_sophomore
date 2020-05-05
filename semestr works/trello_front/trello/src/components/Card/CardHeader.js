import React, {useState} from 'react';

export default function CardHeader({name}) {
    return (
        <div className="card-header">
            <button className="btn btn-light w-100">{name}</button>
        </div>
    )
}