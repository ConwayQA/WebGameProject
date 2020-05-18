import React from 'react';
import ReactDOM from 'react-dom';
import App from './app.js';

const wrapper = document.getElementById('root');
// eslint-disable-next-line react/jsx-filename-extension
ReactDOM.render(
    <React.StrictMode>
        <App />
    </React.StrictMode>, 
    wrapper
);