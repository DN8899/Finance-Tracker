import logo from './logo.svg';
import './App.css';

function App() {
  console.log("Hello");

  const reqBody = {
    "userName": "derrick",
    "password": "password"
  }

  fetch("http://localhost:8080/auth/register", {
  headers: {
    "Content-Type": "application/json"
  },
    method: "post",
    body: JSON.stringify(reqBody)
  })
  .then((response) => {
   const headers = response.headers;
   console.log(headers.keys);
   return response.json();
  })
  .then((data) => console.log(data));

  return (
    <div className="App">
      <h1>Hello World</h1>
    </div>
  );
}

export default App;
