import React, {Suspense} from "react";
import { Route, Routes } from "react-router-dom";

import "./index.scss";
import MainPage from "./components/MainPage";
import Loader from "./components/Loader";
const RemoteAddProductApp = React.lazy(() => import("add_product/AddProductApp"));

const App = () => {
    return <div>
        <Suspense fallback={<Loader />}>
            <Routes>
                <Route path="/" element={<MainPage />}/>
                <Route path="/add" element={<RemoteAddProductApp />}/>
            </Routes>
        </Suspense>
    </div>
};

export default App;