import "./App.css";
import { useEffect } from "react";
import { useLocalState } from "./util/UseLocalStorage";
import { Route } from "react-router-dom";
import { Routes } from "react-router-dom";
import Dashboard from "./Dashboard";
import Homepage from "./Homepage";
import Login from "./Login";
import PrivateRoute from "./PrivateRoute";

function App() {
  //   useEffect(() => {

  //     let reqBody = {
  //       "userName": "derrick",
  //       "password": "password"
  //     };

  //     fetch("http://localhost:8080/auth/register", {
  //        headers: {
  //         "Content-Type": "application/json"
  //       },
  //         method: "post",
  //         body: JSON.stringify(reqBody)
  //       })
  //       .then((response) => Promise.all([response.text(), response.headers]))
  //       .then(([body, headers]) =>
  //        headers.forEach(element => {
  //        console.log(element);
  //       })
  //     );
  //   });

  //   const [ jwt, setJwt ] = useLocalState("", "jwt");

  //     useEffect(() => {
  //       console.log(jwt);
  //     }, [jwt]);

  return (
    <Routes>
      <Route
        path="/dashboard"
        element={
          <PrivateRoute>
            <Dashboard />
          </PrivateRoute>
        }
      />
      <Route path="/login" element={<Login />} />
      <Route path="/" element={<Homepage />} />
    </Routes>
  );
}

export default App;
