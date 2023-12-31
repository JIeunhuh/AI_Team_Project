import {useState, useRef} from 'react'
import {LoginInput} from '../../Component'
import axios from 'axios'

export const Login = () => {
  const [user_Id, setUser_Id] = useState('')
  const [pw, setPw] = useState('')

  // 로그인 버튼 클릭 시
  const SignInBtnClicked = () => {
    axios
      .post('http://localhost:8080/login', {
        Username: user_Id,
        Password: pw
      })
      .then(response => response.json())
      .then(data => console.log('data: ', data))
      .catch(error => error.message)
  }
  console.log('id', user_Id)
  console.log('pw', pw)

  return (
    <section className="w-full h-screen bg-gray-100 dark:bg-gray-900">
      <div className="flex flex-col items-center justify-center px-6 py-8 mx-auto h-full lg:py-0">
        <div className="flex items-center mb-6 text-2xl font-semibold text-gray-900 dark:text-white">로그인</div>
        <div className="w-full bg-white rounded-lg shadow dark:border md:mt-0 sm:max-w-md xl:p-0 dark:bg-gray-800 dark:border-gray-700">
          <div className="p-6 space-y-4 md:space-y-6 sm:p-8">
            <h1 className="text-xl font-bold leading-tight tracking-tight text-gray-900 md:text-2xl dark:text-white">
              Sign in to your account
            </h1>
            <LoginInput
              label="Your ID"
              type="text"
              placeholder="Your ID"
              value={user_Id}
              onChange={e => setUser_Id(e.target.value)}
            />
            <LoginInput
              label="Password"
              type="password"
              placeholder="password"
              value={pw}
              onChange={e => setPw(e.target.value)}
            />
            <div className="flex items-center justify-between">
              <div className="flex items-start">
                <div className="flex items-center h-5">
                  <input
                    id="remember"
                    aria-describedby="remember"
                    type="checkbox"
                    className="w-4 h-4 border border-gray-300 rounded bg-gray-50 focus:ring-3 focus:ring-primary-300 dark:bg-gray-700 dark:border-gray-600 dark:focus:ring-primary-600 dark:ring-offset-gray-800"
                    required=""
                  />
                </div>
                <div className="ml-3 text-sm">
                  <label htmlFor="remember" className="text-gray-500 dark:text-gray-300">
                    Remember me
                  </label>
                </div>
              </div>
              <a href="#" className="text-sm font-medium text-primary-600 hover:underline dark:text-primary-500">
                Forgot password?
              </a>
            </div>
            <button
              type="submit"
              className="w-full text-white bg-green-400 hover:bg-green-500 focus:ring-4 focus:outline-none focus:ring-primary-300 font-medium rounded-lg text-sm px-5 py-2.5 text-center dark:bg-primary-600 dark:hover:bg-primary-700 dark:focus:ring-primary-800"
              onClick={SignInBtnClicked}>
              Sign in
            </button>
            <p className="text-sm font-light text-gray-500 dark:text-gray-400">
              Don’t have an account yet?{' '}
              <a href="#" className="font-medium text-primary-600 hover:underline dark:text-primary-500">
                Sign up
              </a>
            </p>
          </div>
        </div>
      </div>
    </section>
  )
}
