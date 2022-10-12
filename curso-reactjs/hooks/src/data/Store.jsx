import React, { useState } from 'react'

const initialState = {
    number: 1,
    text: 'Context API + Hooks'
}

export const AppContext = React.createContext(null)

const Store = props => {

    const [state, setState] = useState(initialState)

    function updateState(k, v) {
        setState({
            ...state,
            [k]: v
        })
    }

    return (
        <AppContext.Provider value={{
            number: state.number,
            text: state.text,
            setNumber: n => updateState('number', n),
            setText: n => updateState('text', n)
        }}>
            {props.children}
        </AppContext.Provider>
    )

}

export default Store