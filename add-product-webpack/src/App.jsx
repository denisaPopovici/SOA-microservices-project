import React from "react";

import "./index.scss";
import AddProductPage from "./components/AddProductPage";
import {Route, Routes} from "react-router-dom";

const App = () => {
    return <div>
        <Routes>
            <Route path="/" element={<AddProductPage />}/>
        </Routes>
    </div>
};
export default App;
