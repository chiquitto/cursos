import React, { useState, useMemo } from 'react'
import PageTitle from '../../components/layout/PageTitle'

function sum(n1, n2) {
    console.log(...arguments)

    const future = Date.now() + 2000
    // sleep 2s
    while (Date.now() < future) {}

    const r = n1 + n2
    console.log(r)
    return r
}

const UseMemo = (props) => {
    const [n1, setN1] = useState(0)
    const [n2, setN2] = useState(0)
    const [n3, setN3] = useState(0)

    const result = useMemo(() => sum(n1, n2), [n1, n2])

    return (
        <div className="UseMemo">
            <PageTitle
                title="Hook UseMemo"
                subtitle="Retorna um valor memoizado!"
            />

            <div className="center">
                <input type="number" className="input"
                    value={n1}
                    onChange={e => setN1(parseInt(e.target.value))} />
                <input type="number" className="input"
                    value={n2}
                    onChange={e => setN2(parseInt(e.target.value))} />
                <input type="number" className="input"
                    value={n3}
                    onChange={e => setN3(parseInt(e.target.value))} />

                <span className="text">{result}</span>
            </div>
        </div>
    )
}

export default UseMemo
