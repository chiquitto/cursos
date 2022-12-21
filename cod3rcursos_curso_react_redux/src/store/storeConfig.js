import { createStore, combineReducers } from 'redux'

import numerosReducer from './reducers/numeros'

const reducers = combineReducers({
    numeros: numerosReducer
})

const storeConfig = () => {
    return createStore(reducers)
}

export default storeConfig