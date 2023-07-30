import logo from './logo.svg';
import './App.css';

function App() {
  console.log("Hello");

  const reqBody = {
    "userName": "derrick",
    "password": "password"
  };


  // fetch("http://localhost:8080/auth/register", {
  // headers: {
  //   "Content-Type": "application/json"
  // },
  //   method: "post",
  //   body: JSON.stringify(reqBody)
  // })
  // .then((response) => Promise.all([response.json(), response.headers]))
  // .then(([body, headers]) => 
  //     headers.forEach(element => {
  //     console.log(element);
  //   })
  //   );


    fetch("http://localhost:8080/auth/login", {
      headers: {
        "Content-Type": "application/json"
      },
        method: "post",
        body: JSON.stringify(reqBody)
    })
    .then((response) => Promise.all([response.json(), response.headers]))
    .then(([body, headers]) => 
    headers.forEach(element => {
        console.log(element);
      })
    );

  return (
    <div className="App">
      <h1>Hello World</h1>
    </div>
  );
}

export default App;
