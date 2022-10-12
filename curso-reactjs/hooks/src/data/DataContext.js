import React from 'react'

export const data = {
    number: 123,
    text: 'Meu texto de contexto'
}

const DataContext = React.createContext(null)

export default DataContext