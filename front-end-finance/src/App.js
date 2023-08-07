import logo from './logo.svg';
import './App.css';
import { useEffect, useState } from 'react';
import { useLocalState } from './util/UseLocalStorage';

function App() {
  console.log("Hello");

  
  // useEffect(() => {

  //   const reqBody = {
  //     "userName": "vik",
  //     "password": "password"
  //   };

  //   fetch("http://localhost:8080/auth/register", {
  //      headers: {
  //       "Content-Type": "application/json"
  //     },
  //       method: "post",
  //       body: JSON.stringify(reqBody)
  //     })
  //     .then((response) => Promise.all([response.json(), response.headers]))
  //     .then(([body, headers]) => 
  //      headers.forEach(element => {
  //      console.log(element);
  //     })
  //   );
  // });


  // const [ jwt, setJwt ] = useLocalState("", "jwt");
  const [ jwt, setJwt ] = useState("");

   useEffect(() => {

      const reqBody = {
        "userName": "morgan",
        "password": "password"
      };

    fetch("http://localhost:8080/auth/login", {
      headers: {
        "Content-Type": "application/json"
      },
      method: "post",
      body: JSON.stringify(reqBody),
    })
    .then((response) => Promise.all([response.json(), response.headers]))
    .then(([body, headers]) => {
      
      setJwt(headers.get("Cache-Control"));
      
      // setJwt(headers.get("Cache-Control"));
      }); 
}, [])

    
    useEffect(() => {
      console.log(jwt);

    }, [jwt]);


  return (
    <div className="App">
      <h1>Hello World</h1>
      <div>JWT Value is { jwt }</div>
    </div>
  );
}

export default App;
