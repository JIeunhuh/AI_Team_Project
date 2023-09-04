import { FileUpload } from './Component'
import { Login } from './Page/LoginPage/Login'
import MainPage from './Page/MainPage'
import { RouteMain } from './Page/Routes/RouteMain'


function App() {
  // const data = [25, 45, 60, 30, 10]
  // const label = ['a', 'b', 'c', 'd', 'e']
  // const backgroundColor = ['blue', 'steelblue', 'red', 'pink', 'black']

  return (
    <div className="w-full h-full">
      {/* <Login /> */}
      {/* <FileUpload/> */}
      <MainPage />
    </div>
  )
}


export default App
